package co.com.vep.vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.vep.logica.IProgramacionActividad;
import co.com.vep.logica.ProgramacionActividadesLogica;
import co.com.vep.modelo.extension.VepAsistenteProgAsociado;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.reportes.ExportarFactory;

public class VistaConsultaActividades {

	private Date date1;
	private Date date2;
	private String titulo = "";
	private boolean readOnlyRegional = false;
	private TimeZone timeZone;
	private IProgramacionActividad progActividad;
	private List<VepAsistenteProgAsociado> listaActividades;

	private String exportNameHtml;
	private boolean visibleExportHtml;

	public VistaConsultaActividades() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ConsultarActividadesPeriodo")) {
				initializeComponent();
				try {
					String roleUsuario = ((Role) Session
							.getSessionAttribute("Role")).getName();
					titulo = MessageBundleLoader
							.getMessage("labels.consultabe.titulo");
					readOnlyRegional = false;
					if (roleUsuario.toLowerCase().equalsIgnoreCase(
							"coordinador")
							|| roleUsuario.toLowerCase().equalsIgnoreCase(
									"analista")) {

						Long idRegional = (Long) Session
								.getSessionAttribute("userRegional");
						if (idRegional != null) {
							// isolateRegional(idRegional);
							// mostrarBancoExpertos(idRegional);
						} else
							throw new Exception("Regional no configurada");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String exportName;
	private boolean visibleExport;

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
	 * @return the listaActividades
	 */
	public List<VepAsistenteProgAsociado> getListaActividades() {
		return listaActividades;
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

	/**
	 * @param listaActividades
	 *            the listaActividades to set
	 */
	public void setListaActividades(
			List<VepAsistenteProgAsociado> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public void action_consultarActividades(ActionEvent ae) {
		visibleExport = false;
		visibleExportHtml = false;
		progActividad = new ProgramacionActividadesLogica();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			listaActividades = progActividad.listaProgActividades(
					"fechaInicio", date1, date2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_generarExcel(ActionEvent ae) {
		visibleExport = true;
		exportName = ExportarFactory.exportar(
				ExportarFactory.types.ASISTENTESPERIODO,
				ExportarFactory.formats.EXCEL, listaActividades);
	}

	public void action_generarHtml(ActionEvent ae) {
		visibleExportHtml = true;
		exportNameHtml = ExportarFactory.exportar(
				ExportarFactory.types.ASISTENTESPERIODO,
				ExportarFactory.formats.HTML, listaActividades);
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
}
