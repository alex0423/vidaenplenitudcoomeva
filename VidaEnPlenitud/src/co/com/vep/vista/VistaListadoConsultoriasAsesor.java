package co.com.vep.vista;

import javax.faces.event.ActionEvent;

import co.com.coomeva.modelo.AutenticacionAutorizacion;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.vista.excepciones.VepException;

public class VistaListadoConsultoriasAsesor extends VistaConsultoriasAsesor {

	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	public VistaListadoConsultoriasAsesor() {
		super();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ConsultarAsesoria")) {

				System.out.println("Cargo: "
						+ ((AutenticacionAutorizacion) Session
								.getSessionAttribute("autenticacion"))
								.getCargoEmpleado());

				String id = String.valueOf(Session
						.getSessionAttribute("userId"));
				if (id != null && !id.equals("null")) {
					try {
						mostrarConsultoriasAsesor(new Long(id));
					} catch (Exception ex) {
						messageTittle = "Error refrescando la consulta";
						message = ex.getMessage();
						toggleModal();
						VepException.displayError(ex);
					}
				} else {
					messageTittle = "Error refrescando la consulta";
					message = "Usuario no existente";
					toggleModal();
				}
			}
		}
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
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

}
