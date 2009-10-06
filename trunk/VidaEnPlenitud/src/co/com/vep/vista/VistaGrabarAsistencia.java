package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import co.com.vep.logica.GrabarAsistenciaLogica;
import co.com.vep.logica.IGrabarAsistencia;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.extension.DataRecordAsistente;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;

public class VistaGrabarAsistencia extends VistaRegistroProgramacion {

	private HtmlDataTable dataTable;

	private Integer codigoActividad;
	private Date date1;
	private TimeZone timeZone;
	private String selectedGrupo;
	Integer codigoAct;
	private Integer idProgramacion;

	private String messageTittle;
	private String message;
	private boolean modalRendered = false;
	private boolean autoCentre = false;

	private List<VepProgramacion> listaGrupos;
	private List<DataRecordAsistente> listaAsistencia;
	private List<SelectItem> tipoGrupo;

	IGrabarAsistencia grabarAsistencia;

	public VistaGrabarAsistencia() {
		initializeComponent();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance(LocalApplicationConfiguration.Util
					.getInstance().getProperty("ConsultarAsistencia"))) {

			}
		}
	}

	/**
	 * @return the codigoActividad
	 */
	public Integer getCodigoActividad() {
		return codigoActividad;
	}

	/**
	 * @param codigoActividad
	 *            the codigoActividad to set
	 */
	public void setCodigoActividad(Integer codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	private void initializeComponent() {
		date1 = new GregorianCalendar().getTime();
	}

	/**
	 * @return the messageTittle
	 */
	public String getMessageTittle() {
		return messageTittle;
	}

	/**
	 * @param messageTittle
	 *            the messageTittle to set
	 */
	public void setMessageTittle(String messageTittle) {
		this.messageTittle = messageTittle;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the modalRendered
	 */
	public boolean isModalRendered() {
		return modalRendered;
	}

	/**
	 * @param modalRendered
	 *            the modalRendered to set
	 */
	public void setModalRendered(boolean modalRendered) {
		this.modalRendered = modalRendered;
	}

	/**
	 * @return the autoCentre
	 */
	public boolean isAutoCentre() {
		return autoCentre;
	}

	/**
	 * @param autoCentre
	 *            the autoCentre to set
	 */
	public void setAutoCentre(boolean autoCentre) {
		this.autoCentre = autoCentre;
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
	 * @return the selectedGrupo
	 */
	public String getSelectedGrupo() {
		return selectedGrupo;
	}

	/**
	 * @param selectedGrupo
	 *            the selectedGrupo to set
	 */
	public void setSelectedGrupo(String selectedGrupo) {
		this.selectedGrupo = selectedGrupo;
	}

	/**
	 * @return the tipoGrupo
	 */
	public List<SelectItem> getTipoGrupo() {
		return tipoGrupo;
	}

	/**
	 * @param tipoGrupo
	 *            the tipoGrupo to set
	 */
	public void setTipoGrupo(List<SelectItem> tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}

	/**
	 * @return the listaAsistencia
	 */
	public List<DataRecordAsistente> getListaAsistencia() {
		return listaAsistencia;
	}

	/**
	 * @param listaAsistencia
	 *            the listaAsistencia to set
	 */
	public void setListaAsistencia(List<DataRecordAsistente> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void action_onChangeActividad(ValueChangeEvent vce) {
		grabarAsistencia = new GrabarAsistenciaLogica();
		codigoAct = (Integer) vce.getNewValue();
		if (!codigoAct.equals(0) && !codigoAct.equals(-1)) {
			try {
				listaGrupos = grabarAsistencia.findProgramacionGrupo(
						"vepParametroActividad.idActividadpar", codigoAct);
				tipoGrupo = new ArrayList<SelectItem>();
				tipoGrupo.add(new SelectItem("-1", "-- Seleccionar --"));
				if (listaGrupos != null) {
					for (VepProgramacion programacion : listaGrupos) {
						tipoGrupo.add(new SelectItem(programacion.getGrupo(),
								programacion.getGrupo()));
					}
				}

			} catch (Exception e) {
				showException(e);
			}
		}
	}

	public void action_buscarListado(ActionEvent ae) {
		grabarAsistencia = new GrabarAsistenciaLogica();
		try {
			if (codigoAct == null || codigoAct.equals(-1))
				throw new Exception("Debe seleccionar la actividad");

			if (selectedGrupo == null || selectedGrupo.equals("-1"))
				throw new Exception("Debe seleccionar un grupo");

			if (date1 == null)
				throw new Exception("Debe ingresar la fecha");

			mostrarRegistro(codigoAct, selectedGrupo);

			List<VepPlusBuc> rs = grabarAsistencia.findListadoAsistencia(
					codigoActividad, selectedGrupo);

			listaAsistencia = new ArrayList<DataRecordAsistente>();
			for (VepPlusBuc vepPlusBuc : rs)
				listaAsistencia.add(new DataRecordAsistente(vepPlusBuc));

		} catch (Exception e) {
			showException(e);
		}
	}

	public void action_registrarAsistencia(ActionEvent ae) {
		grabarAsistencia = new GrabarAsistenciaLogica();

		if (codigoActividad == null) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.grabarAsistencia.excepcion1");
			toggleModal(ae);
		}
		if (selectedGrupo.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.grabarAsistencia.excepcion2");
			toggleModal(ae);
		}
		try {
			grabarAsistencia.saveListadoAsistencia(idProgramacion,
					getSelectedAsistencias(), getNONSelectedAsistencias(),
					date1);
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.grabarAsistencia.grabar");
			toggleModal(ae);
		} catch (Exception e) {
			showException(e);
		}
	}

	private void showException(Exception e) {
		showException(e.getMessage());
		e.printStackTrace();
	}

	private void showException(String e) {
		FacesMessage msg = new FacesMessage(e);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	public void setDataTable(HtmlDataTable value) {
		this.dataTable = value;
	}

	public HtmlDataTable getDataTable() {
		return this.dataTable;
	}

	public List<Long> getSelectedAsistencias() throws Exception {
		try {
			List<Long> rs = new ArrayList<Long>();
			for (DataRecordAsistente record : listaAsistencia) {
				if (record.isSelected()) {
					rs.add(record.getIdAsociado());
				}
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Long> getNONSelectedAsistencias() throws Exception {
		try {
			List<Long> rs = new ArrayList<Long>();
			for (DataRecordAsistente record : listaAsistencia) {
				if (!record.isSelected()) {
					rs.add(record.getIdAsociado());
				}
			}
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
