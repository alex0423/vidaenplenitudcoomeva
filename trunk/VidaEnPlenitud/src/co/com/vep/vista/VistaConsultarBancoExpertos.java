package co.com.vep.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.vep.logica.DetalleConsultoriaLogica;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.extension.DataRecordConsultoria;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.MessageBundleLoader;

public class VistaConsultarBancoExpertos {

	private Long selectedRegional;
	private List<DataRecordConsultoria> lstConsultorias;
	private boolean readOnlyRegional = false;
	private String titulo = "";

	private boolean btnDisabled = false;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	public VistaConsultarBancoExpertos() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("Consultarexpertos")) {
				btnDisabled = true;
				lstConsultorias = new ArrayList<DataRecordConsultoria>();
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
							isolateRegional(idRegional);
							mostrarBancoExpertos(idRegional);
						} else
							throw new Exception(MessageBundleLoader
									.getMessage("labels.consexp.exception3"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void isolateRegional(Long regional) {

		List<SelectItem> lst = ((LOVsVista) FacesUtils.getManagedBean("LOVs"))
				.getRegionales();
		for (SelectItem item : lst) {
			if (item.getValue().equals(regional)) {
				selectedRegional = regional;
				titulo += " REGIONAL " + item.getLabel().toUpperCase() + " ";
				readOnlyRegional = true;
				break;
			}
		}
	}

	public void action_limpiar(ActionEvent actionEvent) {
		limpiar();
	}

	public void action_imprimirPdf(ActionEvent actionEvent) {
		try {
			// Long idRegional = selectedRegional;
			// Session.setSessionAttribute("REGIONALACTIVA", idRegional);
			//
			// FacesContext.getCurrentInstance().getApplication()
			// .getNavigationHandler().handleNavigation(
			// FacesContext.getCurrentInstance(), null,
			// "BancoExpertosPdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_imprimirXls(ActionEvent actionEvent) {
		try {
			// Long idRegional = selectedRegional;
			// Session.setSessionAttribute("REGIONALACTIVA", idRegional);
			//
			// FacesContext.getCurrentInstance().getExternalContext().redirect(
			// FacesContext.getCurrentInstance().getExternalContext()
			// .getRequestContextPath()
			// + "/servlet/ByRegionExcelServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onSelectRegional(ValueChangeEvent event) {
		selectedRegional = (Long) event.getNewValue();
		try {
			mostrarBancoExpertos(selectedRegional);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarBancoExpertos(Long selectedReg) throws Exception {
		try {
			List<VepDetalleConsultoria> lst = new ArrayList<VepDetalleConsultoria>();
			DetalleConsultoriaLogica consultoria = new DetalleConsultoriaLogica();
			if (selectedReg == -1) {
				lst = consultoria.obtenerTodosAsVep();
			} else {
				lst = consultoria.obtenerByRegional(new Integer(selectedReg
						.intValue()));
			}
			if (lst.size() == 0) {
				lstConsultorias = new ArrayList<DataRecordConsultoria>();
				messageTittle = MessageBundleLoader
						.getMessage("labels.menssagePopup.titulo1");
				message = MessageBundleLoader
						.getMessage("labels.menssagePopup.cuerpo1");
				toggleModal();
			} else {
				lstConsultorias = new ArrayList<DataRecordConsultoria>();
				for (VepDetalleConsultoria vepDetalleConsultoria : lst) {
					lstConsultorias.add(new DataRecordConsultoria(
							vepDetalleConsultoria));
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	private void limpiar() {
		selectedRegional = null;
		lstConsultorias = new ArrayList<DataRecordConsultoria>();
	}

	/**
	 * @return the selectedRegional
	 */
	public Long getSelectedRegional() {
		return selectedRegional;
	}

	/**
	 * @param selectedRegional
	 *            the selectedRegional to set
	 */
	public void setSelectedRegional(Long selectedRegional) {
		this.selectedRegional = selectedRegional;
	}

	/**
	 * @return the lstConsultorias
	 */
	public List<DataRecordConsultoria> getLstConsultorias() {
		return lstConsultorias;
	}

	public void setLstConsultorias(List<DataRecordConsultoria> lstConsultorias) {
		this.lstConsultorias = lstConsultorias;
	}

	/**
	 * @return the btnDisabled
	 */
	public boolean isBtnDisabled() {
		return btnDisabled;
	}

	/**
	 * @param btnDisabled
	 *            the btnDisabled to set
	 */
	public void setBtnDisabled(boolean btnDisabled) {
		this.btnDisabled = btnDisabled;
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

	public boolean isReadOnlyRegional() {
		return readOnlyRegional;
	}

	public void setReadOnlyRegional(boolean readOnlyRegional) {
		this.readOnlyRegional = readOnlyRegional;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
