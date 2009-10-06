package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.vep.logica.ActividadesFrecuentadasLogica;
import co.com.vep.logica.AsistenteProgramacionLogica;
import co.com.vep.logica.IActividadesFrecuentadas;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.extension.DataRecordAsistenciasActividad;
import co.com.vep.modelo.extension.VepAsistenteProgWithRegional;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.reportes.ExportarFactory;

public class VistaConsultaActividadesFrecuente {

	private Date date1;
	private Date date2;
	private TimeZone timeZone;
	private List<VepAsistenteProg> listaAsistenteProg;
	private List<DataRecordAsistenciasActividad> listaAsistenteRegional = new ArrayList<DataRecordAsistenciasActividad>();
	private Map<Integer, DataRecordAsistenciasActividad> diccionarioConteo;
	private IActividadesFrecuentadas iaf;
	private String titulo = "";
	private boolean readOnlyRegional = false;
	private Long regional;

	private String exportName;
	private boolean visibleExport;

	private String exportNameHtml;
	private boolean visibleExportHtml;

	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	public VistaConsultaActividadesFrecuente() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ConsultarActividadesFrecuentadas")) {
				initializeComponent();
				try {
					String roleUsuario = ((Role) Session
							.getSessionAttribute("Role")).getName();
					titulo = MessageBundleLoader
							.getMessage("labels.consultabe.titulo");
					readOnlyRegional = false;
					if (roleUsuario.toLowerCase()
							.equalsIgnoreCase("coodinador")
							|| roleUsuario.toLowerCase().equalsIgnoreCase(
									"analista")) {

						Long idRegional = (Long) Session
								.getSessionAttribute("userRegional");
						if (idRegional != null) {
							setRegional(idRegional);
						} else
							throw new Exception(MessageBundleLoader
									.getMessage("labels.consexp.exception3"));
					} // else {
					// Long idRegional = (Long) Session
					// .getSessionAttribute("userRegional");
					// if (idRegional != null) {
					// setRegional(idRegional);
					// } else
					// throw new Exception(MessageBundleLoader
					// .getMessage("labels.consexp.exception3"));
					// }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void initializeComponent() {
		visibleExport = false;
		visibleExportHtml = false;
	}

	/**
	 * @return the date1
	 */
	public Date getDate1() {
		return date1;
	}

	/**
	 * @param date1
	 *            the date1 to set
	 */
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	/**
	 * @return the date2
	 */
	public Date getDate2() {
		return date2;
	}

	/**
	 * @param date2
	 *            the date2 to set
	 */
	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	/**
	 * @return the timeZone
	 */
	public TimeZone getTimeZone() {
		this.timeZone = java.util.TimeZone.getDefault();
		return timeZone;
	}

	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the listaAsistenteProg
	 */
	public List<VepAsistenteProg> getListaAsistenteProg() {
		return listaAsistenteProg;
	}

	/**
	 * @param listaAsistenteProg
	 *            the listaAsistenteProg to set
	 */
	public void setListaAsistenteProg(List<VepAsistenteProg> listaAsistenteProg) {
		this.listaAsistenteProg = listaAsistenteProg;
	}

	/**
	 * @return the listaAsistenteRegional
	 */
	public List<DataRecordAsistenciasActividad> getListaAsistenteRegional() {
		return listaAsistenteRegional;
	}

	/**
	 * @param listaAsistenteRegional
	 *            the listaAsistenteRegional to set
	 */
	public void setListaAsistenteRegional(
			List<DataRecordAsistenciasActividad> listaAsistenteRegional) {
		this.listaAsistenteRegional = listaAsistenteRegional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isReadOnlyRegional() {
		return readOnlyRegional;
	}

	public void setReadOnlyRegional(boolean readOnlyRegional) {
		this.readOnlyRegional = readOnlyRegional;
	}

	public Long getRegional() {
		return regional;
	}

	public void setRegional(Long regional) {
		this.regional = regional;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void action_consultarActividadesFrecuentadas(ActionEvent ae) {
		visibleExport = false;
		VepParametroActividad vap;
		Integer regionalParam = null;
		try {
			if (regional != null) {
				regionalParam = new Integer(regional.intValue());
			}
			listaAsistenteProg = new AsistenteProgramacionLogica()
					.obtenerByRango(date1, date2, regionalParam);
			if (listaAsistenteProg.size() != 0) {
				diccionarioConteo = new HashMap<Integer, DataRecordAsistenciasActividad>();
				for (VepAsistenteProg asistente : listaAsistenteProg) {

					vap = new VepParametroActividad();
					vap = new VepParametroActividadDAO().findById(asistente
							.getVepProgramacion().getIdActividadPar());
					if (diccionarioConteo.containsKey(vap.getIdActividadpar())) {
						((DataRecordAsistenciasActividad) diccionarioConteo
								.get(vap.getIdActividadpar()))
								.setInscritos(1 + ((DataRecordAsistenciasActividad) diccionarioConteo
										.get(vap.getIdActividadpar()))
										.getInscritos());
					} else {
						diccionarioConteo.put(vap.getIdActividadpar(),
								new DataRecordAsistenciasActividad(vap
										.getIdActividadpar(), vap.getNombre(),
										new Integer(1), asistente
												.getVepProgramacion()
												.getIdRegional()));
					}
				}

				listaAsistenteRegional = new ArrayList<DataRecordAsistenciasActividad>();
				listaAsistenteRegional.addAll(diccionarioConteo.values());
			} else {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("actividadesFrecuentadas.message.excepcion1");
				toggleModal(ae);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_generarExcel(ActionEvent ae) {
		exportName = ExportarFactory.exportar(
				ExportarFactory.types.ASISTENTESFRECUENTES,
				ExportarFactory.formats.EXCEL, listaAsistenteRegional);
		visibleExport = true;
	}

	public void action_generarHtml(ActionEvent ae) {
		exportNameHtml = ExportarFactory.exportar(
				ExportarFactory.types.ASISTENTESFRECUENTES,
				ExportarFactory.formats.HTML, listaAsistenteRegional);
		visibleExportHtml = true;
	}

	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	public boolean isVisibleExport() {
		return visibleExport;
	}

	public void setVisibleExport(boolean visibleExport) {
		this.visibleExport = visibleExport;
	}

	public String getExportNameHtml() {
		return exportNameHtml;
	}

	public void setExportNameHtml(String exportNameHtml) {
		this.exportNameHtml = exportNameHtml;
	}

	public boolean isVisibleExportHtml() {
		return visibleExportHtml;
	}

	public void setVisibleExportHtml(boolean visibleExportHtml) {
		this.visibleExportHtml = visibleExportHtml;
	}

	public boolean isModalRendered() {
		return modalRendered;
	}

	public void setModalRendered(boolean modalRendered) {
		this.modalRendered = modalRendered;
	}

	public boolean isAutoCentre() {
		return autoCentre;
	}

	public void setAutoCentre(boolean autoCentre) {
		this.autoCentre = autoCentre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageTittle() {
		return messageTittle;
	}

	public void setMessageTittle(String messageTittle) {
		this.messageTittle = messageTittle;
	}
}
