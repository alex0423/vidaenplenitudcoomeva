package co.com.vep.vista;

import java.util.Date;
import java.util.EventObject;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.icesoft.faces.component.inputfile.InputFile;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.vep.logica.ConsultoriaLogica;
import co.com.vep.logica.IConsultoria;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.vista.excepciones.VepException;

public class VistaSeguimientoConsultoria extends VistaConsultoriasAsesor {

	private String estadoSeguimiento;
	private Date fechaIniSeguimiento;
	private String observacionSeguimiento;
	private String observacionAnulacion;
	private String fileAnexo;
	private String fileAnexoPath;

	private boolean disabledBtnSeguimiento = true;
	private boolean disabledBtnTerminar = true;
	private boolean disabledBtnAnular = true;
	private boolean disabledAnular = true;

	private boolean renderPanelInicio = false;
	private boolean renderSeguimiento = false;
	private boolean renderAnulacion = false;

	private TimeZone timeZone;
	private int fileProgress;

	private String componentStatus;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	public VistaSeguimientoConsultoria() {
		super();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("SeguimientoAsesoria")) {
				hideAll();
				refrescarSeguimiento();
				try {
					String roleUsuario = ((Role) Session
							.getSessionAttribute("Role")).getName();
					if (roleUsuario.toLowerCase().equalsIgnoreCase("coordinador")){
						disabledAnular = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	private void cleanAll() {
		observacionAnulacion = null;
		observacionSeguimiento = null;
		estadoSeguimiento = null;
		fileProgress = 0;
		// message = "";
		// messageTittle = "";
	}

	private void refrescarSeguimiento() {
		try {
			mostrarTodasConsultorias();
		} catch (Exception ex) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepciontitulo");
			message = ex.getMessage();
			toggleModal();
			VepException.displayError(ex);
		}
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	private void hideAll() {
		setRenderInfo(false);
		hideActions();
		disabledAllButtons();
	}

	private void hideActions() {
		renderPanelInicio = false;
		renderSeguimiento = false;

		renderAnulacion = false;

		cleanAll();
	}

	public void action_imprimirPdf(ActionEvent actionEvent) {
		try {
			Integer idConsultoria = getSelectedConsultoria();
			Session.setSessionAttribute("CONSULTORIAACTIVA", idConsultoria);

			FacesContext.getCurrentInstance().getApplication()
					.getNavigationHandler().handleNavigation(
							FacesContext.getCurrentInstance(), null,
							"ConsultoriaPDF");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_imprimirXls(ActionEvent actionEvent) {
		try {
			Integer idConsultoria = getSelectedConsultoria();
			Session.setSessionAttribute("CONSULTORIAACTIVA", idConsultoria);

			FacesContext.getCurrentInstance().getExternalContext().redirect(
					FacesContext.getCurrentInstance().getExternalContext()
							.getRequestContextPath()
							+ "/servlet/DetalleExcelServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_uploadfile(ActionEvent event) {
		InputFile inputFile = (InputFile) event.getSource();
		
		// file has been saved
		String subio = inputFile.getValidatedSubmitOnUpload();
		if (subio.equals(InputFile.SUBMIT_POST_UPLOAD)) {
			fileAnexo = inputFile.getFile().getPath();
			componentStatus = MessageBundleLoader
					.getMessage("labels.uploadfile.exito");
			fileAnexoPath = fileAnexo;
		}
		// invalid file, happens when clicking on upload without selecting a
		// file, or a file with no contents.
		if (inputFile.getStatus() == InputFile.INVALID) {
			VepException.displayError(new Exception(MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion5")));
			componentStatus = MessageBundleLoader
					.getMessage("labels.uploadfile.invalido");
		}
		// file size exceeded the limit
		if (inputFile.getStatus() == InputFile.SIZE_LIMIT_EXCEEDED) {
			VepException.displayError(new Exception(MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion6")));
			componentStatus = MessageBundleLoader
					.getMessage("labels.uploadfile.sizeLimit");
		}
		// indicate that the request size is not specified.
		if (inputFile.getStatus() == InputFile.UNKNOWN_SIZE) {
			VepException.displayError(new Exception(MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion7")));
			componentStatus = MessageBundleLoader
					.getMessage("labels.uploadfile.tamanoDesconocido");
		}

		messageTittle = MessageBundleLoader.getMessage("labels.titulo");
		message = componentStatus;
		toggleModal(event);
		
//		// file has been saved
//		if (inputFile.getStatus() == InputFile.SAVED) {
//			fileAnexo = inputFile.getFile().getPath();
//			componentStatus = MessageBundleLoader
//					.getMessage("labels.uploadfile.exito");
//			fileAnexoPath = fileAnexo;
//		}
//		// invalid file, happens when clicking on upload without selecting a
//		// file, or a file with no contents.
//		if (inputFile.getStatus() == InputFile.INVALID) {
//			VepException.displayError(new Exception(MessageBundleLoader
//					.getMessage("labels.seguimientoBE.excepcion5")));
//			componentStatus = MessageBundleLoader
//					.getMessage("labels.uploadfile.invalido");
//		}
//		// file size exceeded the limit
//		if (inputFile.getStatus() == InputFile.SIZE_LIMIT_EXCEEDED) {
//			VepException.displayError(new Exception(MessageBundleLoader
//					.getMessage("labels.seguimientoBE.excepcion6")));
//			componentStatus = MessageBundleLoader
//					.getMessage("labels.uploadfile.sizeLimit");
//		}
//		// indicate that the request size is not specified.
//		if (inputFile.getStatus() == InputFile.UNKNOWN_SIZE) {
//			VepException.displayError(new Exception(MessageBundleLoader
//					.getMessage("labels.seguimientoBE.excepcion7")));
//			componentStatus = MessageBundleLoader
//					.getMessage("labels.uploadfile.tamanoDesconocido");
//		}
//
//		messageTittle = MessageBundleLoader.getMessage("labels.titulo");
//		message = componentStatus;
//		toggleModal(event);

	}

	public void action_refrescar(ActionEvent actionEvent) {
		try {
			refrescarSeguimiento();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_terminarConsultoria(ActionEvent actionEvent) {
		try {
			Integer idConsultoria = getSelectedConsultoria();
			if (idConsultoria == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion2"));

			IConsultoria consultoria = new ConsultoriaLogica();
			if (consultoria.validarEstadoAsActivo(idConsultoria)) {
				consultoria.finalizarConsultoria(idConsultoria);
			} else {
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion3"));
			}

			refrescarSeguimiento();
			displayButtonDependsOnState();
			hideActions();

			message = MessageBundleLoader
					.getMessage("labels.seguimientoBE.exito");
			messageTittle = "Resultado de la transaccion";
			toggleModal(actionEvent);

			Session.setSessionAttribute("CONSULTORIAACTIVA", idConsultoria);
			FacesContext.getCurrentInstance().getApplication()
					.getNavigationHandler().handleNavigation(
							FacesContext.getCurrentInstance(), null,
							"irEncuesta");
		} catch (Exception ex) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion10");
			message = ex.getMessage();
			toggleModal(actionEvent);
			VepException.displayError(ex);
		}
	}

	public void action_mostrarSeguimientoConsultoria(ActionEvent actionEvent) {
		hideActions();
		renderSeguimiento = true;
		if (getFechaInicioConsultoria() == null
				&& getEstadoId().equals(
						LocalApplicationConfiguration.Util.getInstance()
								.getProperty(
										"tipo_estadoconsultoria_planeacion"))) {
			estadoSeguimiento = getEstado();
			renderPanelInicio = true;
		}
	}

	public void action_mostrarAnularConsultoria(ActionEvent actionEvent) {
		hideActions();
		renderAnulacion = true;
	}

	public void action_anularConsultoria(ActionEvent actionEvent) {
		try {
			Integer idConsultoria = getSelectedConsultoria();
			if (idConsultoria == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion2"));
			if(observacionAnulacion == null || observacionAnulacion.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion12"));
			
			IConsultoria consultoria = new ConsultoriaLogica();
			if (consultoria.validarEstadoAsActivo(idConsultoria)) {
				consultoria.anularConsultoria(idConsultoria,
						observacionAnulacion, fileAnexo);
			} else {
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion3"));
			}

			refrescarSeguimiento();
			displayButtonDependsOnState();
			hideAll();

			message = MessageBundleLoader
					.getMessage("labels.seguimientoBE.anulada");
			messageTittle = "";
			toggleModal(actionEvent);
		} catch (Exception ex) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion11");
			message = ex.getMessage();
			toggleModal(actionEvent);
			VepException.displayError(ex);
		}
	}

	public void action_cancelar(ActionEvent actionEvent) {
		hideActions();
		cleanAll();
	}

	public void action_guardarSeguimiento(ActionEvent actionEvent) {
		try {
			Integer idConsultoria = getSelectedConsultoria();
			if (idConsultoria == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion2"));

			if (observacionSeguimiento == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion9"));

			IConsultoria consultoria = new ConsultoriaLogica();
			if (consultoria.validarEstadoAsActivo(idConsultoria)) {

				if (getEstadoId().equals(
						LocalApplicationConfiguration.Util.getInstance()
								.getProperty(
										"tipo_estadoconsultoria_planeacion"))) {
					if (fechaIniSeguimiento != null) {
						String observacion = "";
						if (observacionSeguimiento.length() >= 1000) {
							observacion = observacionSeguimiento.substring(0,
									999);
						} else {
							observacion = observacionSeguimiento;
						}

						consultoria.iniciarConsultoria(idConsultoria,
								fechaIniSeguimiento, observacion, fileAnexo);
						message = MessageBundleLoader
								.getMessage("labels.seguimientoBE.inicio");
					} else
						throw new Exception(MessageBundleLoader
								.getMessage("labels.seguimientoBE.excepcion8"));
				} else {
					if (observacionSeguimiento != null
							&& observacionSeguimiento.trim().length() > 0) {
						String observacion = "";
						if (observacionSeguimiento.length() >= 1000) {
							observacion = observacionSeguimiento.substring(0,
									999);
						} else {
							observacion = observacionSeguimiento;
						}

						consultoria.guardarSeguimiento(new Integer(
								idConsultoria), observacion, fileAnexo);

						message = MessageBundleLoader
								.getMessage("labels.seguimientoBE.seguimiento");
						fileAnexo = null;
					} else {
						throw new Exception(MessageBundleLoader
								.getMessage("labels.seguimientoBE.excepcion9"));
					}
				}

				refrescarSeguimiento();
				mostrarConsultoria(idConsultoria);
				displayButtonDependsOnState();
				message = (message.trim().length() > 0) ? message
						: "Error no identificado dentro del sistema";
				messageTittle = "Resultado de la transaccion";
				toggleModal(actionEvent);
				hideActions();
			} else {
				throw new Exception(MessageBundleLoader
						.getMessage("labels.seguimientoBE.excepcion3"));
			}
		} catch (Exception ex) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.seguimientoBE.excepcion10");
			message = ex.getMessage();
			toggleModal(actionEvent);
			VepException.displayError(ex);
		}

	}

	/**
	 * @return the estadoSeguimiento
	 */
	public String getEstadoSeguimiento() {
		return estadoSeguimiento;
	}

	/**
	 * @param estadoSeguimiento
	 *            the estadoSeguimiento to set
	 */
	public void setEstadoSeguimiento(String estadoSeguimiento) {
		this.estadoSeguimiento = estadoSeguimiento;
	}

	/**
	 * @return the fechaIniSeguimiento
	 */
	public Date getFechaIniSeguimiento() {
		if (fechaIniSeguimiento == null)
			fechaIniSeguimiento = new Date();
		return fechaIniSeguimiento;
	}

	/**
	 * @param fechaIniSeguimiento
	 *            the fechaIniSeguimiento to set
	 */
	public void setFechaIniSeguimiento(Date fechaIniSeguimiento) {
		this.fechaIniSeguimiento = fechaIniSeguimiento;
	}

	/**
	 * @return the observacionSeguimiento
	 */
	public String getObservacionSeguimiento() {
		return observacionSeguimiento;
	}

	/**
	 * @param observacionSeguimiento
	 *            the observacionSeguimiento to set
	 */
	public void setObservacionSeguimiento(String observacionSeguimiento) {
		this.observacionSeguimiento = observacionSeguimiento;
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

	@Override
	public void rowSelection(ActionEvent e) {
		hideAll();
		super.rowSelection(e);
		displayButtonDependsOnState();
	}

	private void displayButtonDependsOnState() {
		if (ConsultoriaLogica.validarEstadoAsPlaneacion(getEstadoId())) {
			disabledBtnSeguimiento = false;
		} else if (ConsultoriaLogica.validarEstadoAsEjecucion(getEstadoId())) {
			disabledBtnSeguimiento = false;
			disabledBtnAnular = false;
			disabledBtnTerminar = false;
		}
	}

	private void disabledAllButtons() {
		disabledBtnSeguimiento = true;
		disabledBtnAnular = true;
		disabledBtnTerminar = true;
	}

	/**
	 * @return the renderPanelInicio
	 */
	public boolean isRenderPanelInicio() {
		return renderPanelInicio;
	}

	/**
	 * @param renderPanelInicio
	 *            the renderPanelInicio to set
	 */
	public void setRenderPanelInicio(boolean renderPanelInicio) {
		this.renderPanelInicio = renderPanelInicio;
	}

	/**
	 * @return the renderSeguimiento
	 */
	public boolean isRenderSeguimiento() {
		return renderSeguimiento;
	}

	/**
	 * @param renderSeguimiento
	 *            the renderSeguimiento to set
	 */
	public void setRenderSeguimiento(boolean renderSeguimiento) {
		this.renderSeguimiento = renderSeguimiento;
	}

	/**
	 * @return the renderAnulacion
	 */
	public boolean isRenderAnulacion() {
		return renderAnulacion;
	}

	/**
	 * @param renderAnulacion
	 *            the renderAnulacion to set
	 */
	public void setRenderAnulacion(boolean renderAnulacion) {
		this.renderAnulacion = renderAnulacion;
	}

	/**
	 * @return the observacionAnulacion
	 */
	public String getObservacionAnulacion() {
		return observacionAnulacion;
	}

	/**
	 * @param observacionAnulacion
	 *            the observacionAnulacion to set
	 */
	public void setObservacionAnulacion(String observacionAnulacion) {
		this.observacionAnulacion = observacionAnulacion;
	}

	/**
	 * @return the disabledBtnSeguimiento
	 */
	public boolean isDisabledBtnSeguimiento() {
		return disabledBtnSeguimiento;
	}

	/**
	 * @param disabledBtnSeguimiento
	 *            the disabledBtnSeguimiento to set
	 */
	public void setDisabledBtnSeguimiento(boolean disabledBtnSeguimiento) {
		this.disabledBtnSeguimiento = disabledBtnSeguimiento;
	}

	/**
	 * @return the disabledBtnTerminar
	 */
	public boolean isDisabledBtnTerminar() {
		return disabledBtnTerminar;
	}

	/**
	 * @param disabledBtnTerminar
	 *            the disabledBtnTerminar to set
	 */
	public void setDisabledBtnTerminar(boolean disabledBtnTerminar) {
		this.disabledBtnTerminar = disabledBtnTerminar;
	}

	/**
	 * @return the disabledBtnAnular
	 */
	public boolean isDisabledBtnAnular() {
		return disabledBtnAnular;
	}

	/**
	 * @param disabledBtnAnular
	 *            the disabledBtnAnular to set
	 */
	public void setDisabledBtnAnular(boolean disabledBtnAnular) {
		this.disabledBtnAnular = disabledBtnAnular;
	}

	/**
	 * @return the componentStatus
	 */
	public String getComponentStatus() {
		return componentStatus;
	}

	/**
	 * @param componentStatus
	 *            the componentStatus to set
	 */
	public void setComponentStatus(String componentStatus) {
		this.componentStatus = componentStatus;
	}

	/**
	 * @return the fileAnexo
	 */
	public String getFileAnexo() {
		return fileAnexo;
	}

	/**
	 * @param fileAnexo
	 *            the fileAnexo to set
	 */
	public void setFileAnexo(String fileAnexo) {
		this.fileAnexo = fileAnexo;
	}

	public void fileUploadProgress(EventObject event) {
		InputFile ifile = (InputFile) event.getSource();
		fileProgress = ifile.getFileInfo().getPercent();
	}

	/**
	 * @return the timeZone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public int getFileProgress() {
		return fileProgress;
	}

	/**
	 * @return the fileAnexoPath
	 */
	public String getFileAnexoPath() {
		return fileAnexoPath;
	}

	/**
	 * @param fileAnexoPath
	 *            the fileAnexoPath to set
	 */
	public void setFileAnexoPath(String fileAnexoPath) {
		this.fileAnexoPath = fileAnexoPath;
	}

	public boolean isDisabledAnular() {
		return disabledAnular;
	}

	public void setDisabledAnular(boolean disabledAnular) {
		this.disabledAnular = disabledAnular;
	}

}
