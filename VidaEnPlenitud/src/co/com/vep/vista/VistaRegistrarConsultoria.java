package co.com.vep.vista;

import javax.faces.event.ActionEvent;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.logica.AsociadoLogica;
import co.com.vep.logica.ConsultoriaLogica;
import co.com.vep.logica.IAsociado;
import co.com.vep.logica.IConsultoria;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.vista.excepciones.VepException;

public class VistaRegistrarConsultoria {

	private String nombreServicio;
	private String descripcionServicio;
	private String identificacion;
	private String nombreBeneficiario;
	private String numeroPersonas;
	private String objetivos;
	private String observaciones;

	private Integer selectedTipo;

	private IConsultoria registrar;
	private IAsociado consultor;

	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	public void action_consultarAsociado(ActionEvent actionEvent) {
		resetMessages();
		try {
			if (selectedTipo == 0 || selectedTipo == null)
				throw new Exception(
						"Debe seleccionar primero el tipo de identificacion");

			if (identificacion.trim().length() == 0 || identificacion == null)
				throw new Exception(
						"Debe ingresar el numero de documento de identificacion");

			consultor = new AsociadoLogica();
			AsociadoVida av = consultor.obtenerAsAsociado(new Long(
					identificacion), selectedTipo);
			if (av != null)
				nombreBeneficiario = ((av.getNombre1().trim() + " "
						+ av.getNombre2().trim() + " ").trim()
						+ " " + av.getPrimerApellido().trim() + " " + av
						.getSegundoApellido().trim()).trim();
			else
				throw new Exception("Asociado no existe");
		} catch (Exception e) {
			toggleModal(actionEvent);
			VepException.displayError(e);
			limpiar();
		}
	}

	public void action_crearBancoExpertos(ActionEvent actionEvent) {
		resetMessages();
		try {
			if (selectedTipo == 0 || selectedTipo == null)
				throw new Exception(
						"Debe seleccionar primero el tipo de identificacion");

			if (identificacion.trim().length() == 0 || identificacion == null)
				throw new Exception(
						"Debe ingresar el numero de documento de identificacion");

			if (nombreServicio.trim().length() == 0 || nombreServicio == null)
				throw new Exception("Debe ingresar el nombre del servicio");

			if (descripcionServicio.trim().length() == 0
					|| descripcionServicio == null)
				throw new Exception("Debe ingresar la descripcion del servicio");

			if (objetivos.trim().length() == 0 || objetivos == null)
				throw new Exception("Debe ingresar el objetivo");

			if (observaciones.trim().length() == 0 || observaciones == null)
				throw new Exception("Debe ingresar la observacion");

			if (numeroPersonas.trim().length() == 0
					|| Integer.parseInt(numeroPersonas) < 0)
				throw new Exception(
						"El número de personas beneficiadas debe ser mayor o igual a cero (0).");

		} catch (Exception e) {
			toggleModal(actionEvent);
			VepException.displayError(e);
			limpiar();
			return;
		}

		registrar = new ConsultoriaLogica();
		try {
			registrar.registrar(nombreServicio, descripcionServicio, new Long(
					numeroPersonas), objetivos, observaciones, new Long(
					identificacion), new Integer(identificacion), new Long(1));
			messageTittle = MessageBundleLoader
					.getMessage("labels.message.tittle.informacion");
			message = MessageBundleLoader.getMessage("labels.message.message1");
			toggleModal(actionEvent);
			limpiar();

		} catch (Exception e) {
			toggleModal(actionEvent);
			VepException.displayError(e);
			limpiar();
			return;
		}
	}

	public void limpiar() {
		nombreServicio = null;
		descripcionServicio = null;
		identificacion = null;
		nombreBeneficiario = null;
		numeroPersonas = null;
		objetivos = null;
		observaciones = null;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
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

	/**
	 * @return the nombreServicio
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}

	/**
	 * @param nombreServicio
	 *            the nombreServicio to set
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/**
	 * @return the descripcionServicio
	 */
	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	/**
	 * @param descripcionServicio
	 *            the descripcionServicio to set
	 */
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the nombreBeneficiario
	 */
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	/**
	 * @param nombreBeneficiario
	 *            the nombreBeneficiario to set
	 */
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	/**
	 * @return the numeroPersonas
	 */
	public String getNumeroPersonas() {
		return (numeroPersonas == null || numeroPersonas.trim().length() == 0) ? "0"
				: numeroPersonas;
	}

	/**
	 * @param numeroPersonas
	 *            the numeroPersonas to set
	 */
	public void setNumeroPersonas(String numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	/**
	 * @return the objetivos
	 */
	public String getObjetivos() {
		return objetivos;
	}

	/**
	 * @param objetivos
	 *            the objetivos to set
	 */
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	private void resetMessages() {
		message = "";
		messageTittle = "";
	}

	/**
	 * @return the selectedTipo
	 */
	public Integer getSelectedTipo() {
		return selectedTipo;
	}

	/**
	 * @param selectedTipo
	 *            the selectedTipo to set
	 */
	public void setSelectedTipo(Integer selectedTipo) {
		this.selectedTipo = selectedTipo;
	}

}
