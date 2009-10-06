package co.com.vep.vista;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;

import co.com.vep.logica.EncuestaLogica;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;

public class VistaEncuestaBancoExpertos {

	private Integer idConsultoria;

	private String sugerencias;
	private String telefonoRef;
	private String nombreRef;
	private String emailRef;
	private String direccionRef;
	private String apellidoRef;
	private String actividadesInteres;

	private String aclaracionCumpProgEst;
	private String aclaracionCumpEsp;
	private String aclaracionMedCon;

	private Integer selectedMedCon;
	private String selectedCumpEsp;
	private String selectedCumpProgEst;
	private Integer selectedAtencion;

	private HtmlInputTextarea txtAclMedCon;
	private HtmlInputTextarea txtAclCumpEsp;
	private HtmlInputTextarea txtAclCumpProgEst;

	private HtmlInputText txtNombre;
	private HtmlInputText txtApellido;
	private HtmlInputText txtDireccion;
	private HtmlInputText txtTelefono;
	private HtmlInputText txtEmail;
	private HtmlInputText txtActividades;
	private HtmlOutputText lblOutput;
	private HtmlOutputText lblOutput2;
	private HtmlOutputText lblOutput3;

	private boolean modalRendered = false;
	private String message;
	private String messageTittle;

	public VistaEncuestaBancoExpertos() {

		if (Session.isSessionAlive()) {
			initializeComponent();
			String consultoria = String.valueOf(Session
					.getSessionAttribute("CONSULTORIAACTIVA"));
			if (consultoria != null && !consultoria.equals(new String("null")))
				idConsultoria = Integer.valueOf(consultoria);
			else {
				showException(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion14"));
			}
		}
	}

	private void initializeComponent() {
		if (txtAclCumpEsp == null) {
			txtAclCumpEsp = new HtmlInputTextarea();
			txtAclCumpEsp.addValidator(new validadorAlfabetico(
					MessageBundleLoader
							.getMessage("labels.encuesta.cumple_esp.aclara")));
			txtAclCumpEsp.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtAclCumpEsp.validate(FacesContext.getCurrentInstance());
				}
			});
			txtAclCumpEsp.setRendered(false);
			txtAclCumpEsp.setVisible(false);
		}

		if (txtAclCumpProgEst == null) {
			txtAclCumpProgEst = new HtmlInputTextarea();
			txtAclCumpProgEst
					.addValidator(new validadorAlfabetico(
							MessageBundleLoader
									.getMessage("labels.encuesta.cumple_prog_est_aclara")));
			txtAclCumpProgEst.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtAclCumpProgEst.validate(FacesContext
							.getCurrentInstance());
				}
			});
			txtAclCumpProgEst.setRendered(false);
			txtAclCumpProgEst.setVisible(false);
		}

		if (txtAclMedCon == null) {
			txtAclMedCon = new HtmlInputTextarea();
			txtAclMedCon.addValidator(new validadorAlfabetico(
					MessageBundleLoader
							.getMessage("labels.encuesta.mediocon.esp")));
			txtAclMedCon.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtAclMedCon.validate(FacesContext.getCurrentInstance());
				}
			});
			txtAclMedCon.setRendered(false);
			txtAclMedCon.setVisible(false);
		}

		if (txtNombre == null) {
			txtNombre = new HtmlInputText();
			txtNombre.addValidator(new validadorAlfabetico(MessageBundleLoader
					.getMessage("labels.encuesta.nombre_ref"), true));
			txtNombre.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtNombre.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtApellido == null) {
			txtApellido = new HtmlInputText();
			txtApellido.addValidator(new validadorAlfabetico(
					MessageBundleLoader
							.getMessage("labels.encuesta.apellido_ref"), true));
			txtApellido.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtApellido.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtDireccion == null) {
			txtDireccion = new HtmlInputText();
			txtDireccion
					.addValidator(new validadorAlfabetico(MessageBundleLoader
							.getMessage("labels.encuesta.direccion_ref"), true));
			txtDireccion.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtDireccion.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtTelefono == null) {
			txtTelefono = new HtmlInputText();
			txtTelefono.addValidator(new validadorNumerico(MessageBundleLoader
					.getMessage("labels.encuesta.telefono_ref"), true));
			txtTelefono.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtTelefono.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtEmail == null) {
			txtEmail = new HtmlInputText();
			txtEmail.addValidator(new validadorAlfabetico(MessageBundleLoader
					.getMessage("labels.encuesta.email_ref"), true));
			txtEmail.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtEmail.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtActividades == null) {
			txtActividades = new HtmlInputText();
			txtActividades.addValidator(new validadorAlfabetico(
					MessageBundleLoader
							.getMessage("labels.encuesta.act_interes")));
			txtActividades.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtActividades.validate(FacesContext.getCurrentInstance());
				}
			});
		}

	}

	public void onSelectMedCon(ValueChangeEvent event) {
		try {
			selectedMedCon = (Integer) event.getNewValue();
			txtAclMedCon.setVisible(false);
			if (selectedMedCon.equals(new Integer(162))) {
				txtAclMedCon.setRendered(true);
				txtAclMedCon.setVisible(true);
				lblOutput.setRendered(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onSelectCumpEsp(ValueChangeEvent event) {
		try {
			selectedCumpEsp = event.getNewValue().toString();
			txtAclCumpEsp.setVisible(false);
			if (selectedCumpEsp.equals("N")) {
				txtAclCumpEsp.setRendered(true);
				txtAclCumpEsp.setVisible(true);
				lblOutput2.setRendered(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onSelectCumpProgEst(ValueChangeEvent event) {
		try {
			selectedCumpProgEst = event.getNewValue().toString();
			txtAclCumpProgEst.setVisible(false);
			if (selectedCumpProgEst.equals("N")) {
				txtAclCumpProgEst.setRendered(true);
				txtAclCumpProgEst.setVisible(true);
				lblOutput3.setRendered(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_guardarEncuesta(ActionEvent actionEvent) {
		try {
			if (idConsultoria == null || idConsultoria.equals(new Integer(0)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion1"));

			if (selectedMedCon == null
					|| selectedMedCon.equals(new Integer(-1)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion2"));
			else if (selectedMedCon.equals(new Integer(162))
					&& (aclaracionMedCon == null || aclaracionMedCon.trim()
							.length() == 0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion11"));

			if (selectedCumpEsp == null || selectedCumpEsp.equals("-1"))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion3"));
			else if (selectedCumpEsp.equals("N")
					&& (aclaracionCumpEsp == null || aclaracionCumpEsp.trim()
							.length() == 0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion12"));

			if (selectedCumpProgEst == null || selectedCumpProgEst.equals("-1"))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion4"));
			else if (selectedCumpProgEst.equals("N")
					&& (aclaracionCumpProgEst == null || aclaracionCumpProgEst
							.trim().length() == 0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion13"));

			if (selectedAtencion == null
					|| selectedAtencion.equals(new Integer(-1)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion5"));

			if (nombreRef.trim().length() == 0 || nombreRef == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion6"));

			if (apellidoRef.trim().length() == 0 || apellidoRef == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion7"));

			if (direccionRef.trim().length() == 0 || direccionRef == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion8"));

			Long telefonoLong = new Long(0);
			if (telefonoRef.trim().length() == 0 || telefonoRef == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion9"));
			else {
				try {
					telefonoLong = Long.valueOf(telefonoRef);
				} catch (Exception e) {
					throw e;
				}
			}

			if (emailRef.trim().length() == 0 || emailRef == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.encuesta.excepcion10"));

			EncuestaLogica encuesta = new EncuestaLogica();
			encuesta.registrarEncuesta(selectedMedCon, aclaracionMedCon,
					selectedCumpEsp, aclaracionCumpEsp, selectedCumpProgEst,
					aclaracionCumpProgEst, selectedAtencion, nombreRef,
					apellidoRef, direccionRef, telefonoLong, emailRef,
					actividadesInteres, sugerencias, idConsultoria);

			showException("Encuesta registrada con exito!");

		} catch (Exception ex) {
			showException(ex);
		}
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void action_limpiar(ActionEvent actionEvent) {
		limpiar();
	}

	private void limpiar() {
		nombreRef = null;
		emailRef = null;
		direccionRef = null;
		apellidoRef = null;
		telefonoRef = null;
		sugerencias = null;
		aclaracionCumpEsp = null;
		aclaracionCumpProgEst = null;
		aclaracionMedCon = null;
		selectedAtencion = new Integer(-1);
		selectedCumpEsp = "-1";
		selectedCumpProgEst = "-1";
		selectedMedCon = new Integer(-1);

		if (txtAclCumpProgEst.getVisible())
			txtAclCumpProgEst.setVisible(false);

		if (txtAclCumpEsp.getVisible())
			txtAclCumpEsp.setVisible(false);

		if (txtAclMedCon.getVisible())
			txtAclMedCon.setVisible(false);

	}

	/**
	 * @return the sugerencias
	 */
	public String getSugerencias() {
		return sugerencias;
	}

	/**
	 * @param sugerencias
	 *            the sugerencias to set
	 */
	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	/**
	 * @return the telefonoRef
	 */
	public String getTelefonoRef() {
		return telefonoRef;
	}

	/**
	 * @param telefonoRef
	 *            the telefonoRef to set
	 */
	public void setTelefonoRef(String telefonoRef) {
		this.telefonoRef = telefonoRef;
	}

	/**
	 * @return the nombreRef
	 */
	public String getNombreRef() {
		return nombreRef;
	}

	/**
	 * @param nombreRef
	 *            the nombreRef to set
	 */
	public void setNombreRef(String nombreRef) {
		this.nombreRef = nombreRef;
	}

	/**
	 * @return the emailRef
	 */
	public String getEmailRef() {
		return emailRef;
	}

	/**
	 * @param emailRef
	 *            the emailRef to set
	 */
	public void setEmailRef(String emailRef) {
		this.emailRef = emailRef;
	}

	/**
	 * @return the direccionRef
	 */
	public String getDireccionRef() {
		return direccionRef;
	}

	/**
	 * @param direccionRef
	 *            the direccionRef to set
	 */
	public void setDireccionRef(String direccionRef) {
		this.direccionRef = direccionRef;
	}

	/**
	 * @return the apellidoRef
	 */
	public String getApellidoRef() {
		return apellidoRef;
	}

	/**
	 * @param apellidoRef
	 *            the apellidoRef to set
	 */
	public void setApellidoRef(String apellidoRef) {
		this.apellidoRef = apellidoRef;
	}

	/**
	 * @return the aclaracionCumpProgEst
	 */
	public String getAclaracionCumpProgEst() {
		return aclaracionCumpProgEst;
	}

	/**
	 * @param aclaracionCumpProgEst
	 *            the aclaracionCumpProgEst to set
	 */
	public void setAclaracionCumpProgEst(String aclaracionCumpProgEst) {
		this.aclaracionCumpProgEst = aclaracionCumpProgEst;
	}

	/**
	 * @return the aclaracionMedCon
	 */
	public String getAclaracionMedCon() {
		return aclaracionMedCon;
	}

	/**
	 * @param aclaracionMedCon
	 *            the aclaracionMedCon to set
	 */
	public void setAclaracionMedCon(String aclaracionMedCon) {
		this.aclaracionMedCon = aclaracionMedCon;
	}

	/**
	 * @return the aclaracionCumpEsp
	 */
	public String getAclaracionCumpEsp() {
		return aclaracionCumpEsp;
	}

	/**
	 * @param aclaracionCumpEsp
	 *            the aclaracionCumpEsp to set
	 */
	public void setAclaracionCumpEsp(String aclaracionCumpEsp) {
		this.aclaracionCumpEsp = aclaracionCumpEsp;
	}

	/**
	 * @return the selectedMedCon
	 */
	public Integer getSelectedMedCon() {
		return selectedMedCon;
	}

	/**
	 * @param selectedMedCon
	 *            the selectedMedCon to set
	 */
	public void setSelectedMedCon(Integer selectedMedCon) {
		this.selectedMedCon = selectedMedCon;
	}

	/**
	 * @return the selectedCumpEsp
	 */
	public String getSelectedCumpEsp() {
		return selectedCumpEsp;
	}

	/**
	 * @param selectedCumpEsp
	 *            the selectedCumpEsp to set
	 */
	public void setSelectedCumpEsp(String selectedCumpEsp) {
		this.selectedCumpEsp = selectedCumpEsp;
	}

	/**
	 * @return the selectedCumpProgEst
	 */
	public String getSelectedCumpProgEst() {
		return selectedCumpProgEst;
	}

	/**
	 * @param selectedCumpProgEst
	 *            the selectedCumpProgEst to set
	 */
	public void setSelectedCumpProgEst(String selectedCumpProgEst) {
		this.selectedCumpProgEst = selectedCumpProgEst;
	}

	/**
	 * @return the selectedAtencion
	 */
	public Integer getSelectedAtencion() {
		return selectedAtencion;
	}

	/**
	 * @param selectedAtencion
	 *            the selectedAtencion to set
	 */
	public void setSelectedAtencion(Integer selectedAtencion) {
		this.selectedAtencion = selectedAtencion;
	}

	/**
	 * @return the actividadesInteres
	 */
	public String getActividadesInteres() {
		return actividadesInteres;
	}

	/**
	 * @param actividadesInteres
	 *            the actividadesInteres to set
	 */
	public void setActividadesInteres(String actividadesInteres) {
		this.actividadesInteres = actividadesInteres;
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

	public HtmlInputTextarea getTxtAclMedCon() {
		return txtAclMedCon;
	}

	public void setTxtAclMedCon(HtmlInputTextarea txtAclMedCon) {
		this.txtAclMedCon = txtAclMedCon;
	}

	public HtmlInputTextarea getTxtAclCumpEsp() {
		return txtAclCumpEsp;
	}

	public void setTxtAclCumpEsp(HtmlInputTextarea txtAclCumpEsp) {
		this.txtAclCumpEsp = txtAclCumpEsp;
	}

	public HtmlInputTextarea getTxtAclCumpProgEst() {
		return txtAclCumpProgEst;
	}

	public void setTxtAclCumpProgEst(HtmlInputTextarea txtAclCumpProgEst) {
		this.txtAclCumpProgEst = txtAclCumpProgEst;
	}

	public HtmlInputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(HtmlInputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public HtmlInputText getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(HtmlInputText txtApellido) {
		this.txtApellido = txtApellido;
	}

	public HtmlInputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(HtmlInputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public HtmlInputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(HtmlInputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public HtmlInputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(HtmlInputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public HtmlInputText getTxtActividades() {
		return txtActividades;
	}

	public void setTxtActividades(HtmlInputText txtActividades) {
		this.txtActividades = txtActividades;
	}

	public void showException(String ex) {
		FacesMessage msg = new FacesMessage(ex);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	public void showException(Exception ex) {
		showException(ex.getMessage());
		ex.printStackTrace();
	}

	public HtmlOutputText getLblOutput() {
		return lblOutput;
	}

	public void setLblOutput(HtmlOutputText lblOutput) {
		this.lblOutput = lblOutput;
	}

	public HtmlOutputText getLblOutput2() {
		return lblOutput2;
	}

	public void setLblOutput2(HtmlOutputText lblOutput2) {
		this.lblOutput2 = lblOutput2;
	}

	public HtmlOutputText getLblOutput3() {
		return lblOutput3;
	}

	public void setLblOutput3(HtmlOutputText lblOutput3) {
		this.lblOutput3 = lblOutput3;
	}

}
