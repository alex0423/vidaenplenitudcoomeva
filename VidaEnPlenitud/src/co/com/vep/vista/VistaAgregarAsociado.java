package co.com.vep.vista;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import co.com.vep.util.EmailValidator;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;

public class VistaAgregarAsociado extends VistaRegistroAsociado {

	public HtmlInputText txtCedula;
	public HtmlInputText txtNombre1;
	public HtmlInputText txtNombre2;
	public HtmlInputText txtApellido1;
	public HtmlInputText txtApellido2;
	public HtmlInputText txtCodAsociado;
	public HtmlSelectOneMenu selTipoIdentificacion;
	public HtmlSelectOneMenu selTipoAsociado;	

	public HtmlInputText txtDirResidencia;
	public HtmlInputText txtDirComercial;
	public HtmlInputText txtTelefonoCelular;
	public HtmlInputText txtTelefonoResidencia;
	public HtmlInputText txtTelefonoComercial;
	public HtmlInputText txtCorreoElectronico;

	public VistaAgregarAsociado() {
		super();
		initializeComponent();
	}

	private void initializeComponent() {
		if (selTipoIdentificacion == null)
			selTipoIdentificacion = new HtmlSelectOneMenu();

		if (txtCedula == null) {
			txtCedula = new HtmlInputText();
			txtCedula.addValidator(new validadorNumerico(MessageBundleLoader
					.getMessage("labels.numeroid"), true));
			txtCedula.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtCedula.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtNombre1 == null) {
			txtNombre1 = new HtmlInputText();
			txtNombre1.addValidator(new validadorAlfabetico(MessageBundleLoader
					.getMessage("labels.nombre1"), true));
			txtNombre1.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent event)
						throws AbortProcessingException {
					txtNombre1.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtNombre2 == null) {
			txtNombre2 = new HtmlInputText();
			txtNombre2.addValidator(new validadorAlfabetico(MessageBundleLoader
					.getMessage("labels.nombre2")));
			txtNombre2.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent event)
						throws AbortProcessingException {
					txtNombre2.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtApellido1 == null) {
			txtApellido1 = new HtmlInputText();
			txtApellido1.addValidator(new validadorAlfabetico(
					MessageBundleLoader.getMessage("labels.apellido1"), true));
			txtApellido1.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent event)
						throws AbortProcessingException {
					txtApellido1.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtApellido2 == null) {
			txtApellido2 = new HtmlInputText();
			txtApellido2.addValidator(new validadorAlfabetico(
					MessageBundleLoader.getMessage("labels.apellido2")));
			txtApellido2.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent event)
						throws AbortProcessingException {
					txtApellido2.validate(FacesContext.getCurrentInstance());
				}
			});
		}
		
		if(selTipoAsociado == null)
			selTipoAsociado = new HtmlSelectOneMenu();

		if (txtCodAsociado == null) {
			txtCodAsociado = new HtmlInputText();
			txtCodAsociado.addValidator(new validadorNumerico(
					MessageBundleLoader.getMessage("labels.codigoaso")));
			txtCodAsociado.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtCodAsociado.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtDirResidencia == null) {
			txtDirResidencia = new HtmlInputText();
			txtDirResidencia.addValidator(new validadorAlfabetico(
					MessageBundleLoader.getMessage("labels.dirres"), true));
			txtDirResidencia.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtDirResidencia
							.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtDirComercial == null) {
			txtDirComercial = new HtmlInputText();
			txtDirComercial.addValidator(new validadorAlfabetico(
					MessageBundleLoader.getMessage("labels.dircom")));
			txtDirComercial.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtDirComercial.validate(FacesContext.getCurrentInstance());
				}
			});
		}

		if (txtTelefonoResidencia == null) {
			txtTelefonoResidencia = new HtmlInputText();
			txtTelefonoResidencia.addValidator(new validadorNumerico(
					MessageBundleLoader.getMessage("labels.telred")));
			txtTelefonoResidencia
					.addValueChangeListener(new ValueChangeListener() {
						public void processValueChange(ValueChangeEvent arg0)
								throws AbortProcessingException {
							txtTelefonoResidencia.validate(FacesContext
									.getCurrentInstance());
						}
					});
		}

		if (txtTelefonoComercial == null) {
			txtTelefonoComercial = new HtmlInputText();
			txtTelefonoComercial.addValidator(new validadorNumerico(
					MessageBundleLoader.getMessage("labels.telcom")));
			txtTelefonoComercial
					.addValueChangeListener(new ValueChangeListener() {
						public void processValueChange(ValueChangeEvent arg0)
								throws AbortProcessingException {
							txtTelefonoComercial.validate(FacesContext
									.getCurrentInstance());
						}
					});
		}

		if (txtTelefonoCelular == null) {
			txtTelefonoCelular = new HtmlInputText();
			txtTelefonoCelular.addValidator(new validadorAlfabetico(
					MessageBundleLoader.getMessage("labels.telcel")));
			txtTelefonoCelular
					.addValueChangeListener(new ValueChangeListener() {
						public void processValueChange(ValueChangeEvent arg0)
								throws AbortProcessingException {
							txtTelefonoCelular.validate(FacesContext
									.getCurrentInstance());
						}
					});
		}

		if (txtCorreoElectronico == null) {
			txtCorreoElectronico = new HtmlInputText();
			txtCorreoElectronico.addValidator(new EmailValidator(
					MessageBundleLoader.getMessage("labels.correoele")));
			txtCorreoElectronico
					.addValueChangeListener(new ValueChangeListener() {
						public void processValueChange(ValueChangeEvent arg0)
								throws AbortProcessingException {
							txtCorreoElectronico.validate(FacesContext
									.getCurrentInstance());
						}
					});
		}

	}

	public void mostrarRegistro() throws Exception {
		try {
			mostrarRegistro(new Long(cedula), new Integer(tipoid.intValue()));
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void habilitarInput(boolean answer) {
		txtNombre1.setReadonly(answer);
		txtNombre2.setReadonly(answer);
		txtApellido1.setReadonly(answer);
		txtApellido2.setReadonly(answer);
		txtCodAsociado.setReadonly(answer);
		txtCorreoElectronico.setReadonly(answer);
	}

	public HtmlInputText getTxtNombre1() {
		return txtNombre1;
	}

	public void setTxtNombre1(HtmlInputText txtNombre1) {
		this.txtNombre1 = txtNombre1;
	}

	public HtmlInputText getTxtNombre2() {
		return txtNombre2;
	}

	public void setTxtNombre2(HtmlInputText txtNombre2) {
		this.txtNombre2 = txtNombre2;
	}

	public HtmlInputText getTxtApellido1() {
		return txtApellido1;
	}

	public void setTxtApellido1(HtmlInputText txtApellido1) {
		this.txtApellido1 = txtApellido1;
	}

	public HtmlInputText getTxtCodAsociado() {
		return txtCodAsociado;
	}

	public void setTxtCodAsociado(HtmlInputText txtCodAsociado) {
		this.txtCodAsociado = txtCodAsociado;
	}

	public HtmlInputText getTxtApellido2() {
		return txtApellido2;
	}

	public void setTxtApellido2(HtmlInputText txtApellido2) {
		this.txtApellido2 = txtApellido2;
	}

	public HtmlInputText getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(HtmlInputText txtCedula) {
		this.txtCedula = txtCedula;
	}

	public void limpiar() {
		nombre1 = null;
		nombre2 = null;
		apellido1 = null;
		apellido2 = null;
		estadoCivil = new Long(-1);
		ocupacion = new Long(-1);
		fechaNace = null;
		tituloProfesional = new Long(-1);
		direccionResidencia = null;
		telefonoResidencia = null;
		ciuRes = null;
		dirComercial = null;
		telefonoComercial = null;
		ciuCom = null;
		telefonoCelular = null;
		correoElectrinico = null;
	}

	public void validar() throws Exception {
		try {
			if (tipoid.equals(new Long("-1"))) 
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err16"));

			if (cedula == null || cedula.trim().length() == 0) 
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err17"));

			if (tipoAsociado.equals(new Long(0)) || tipoAsociado < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err18"));

			if (nombre1.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err14"));

			if (apellido1.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err15"));
		} catch (Exception e) {
			throw e;
		}
	}

	public HtmlInputText getTxtDirResidencia() {
		return txtDirResidencia;
	}

	public void setTxtDirResidencia(HtmlInputText txtDirResidencia) {
		this.txtDirResidencia = txtDirResidencia;
	}

	public HtmlInputText getTxtDirComercial() {
		return txtDirComercial;
	}

	public void setTxtDirComercial(HtmlInputText txtDirComercial) {
		this.txtDirComercial = txtDirComercial;
	}

	public HtmlInputText getTxtTelefonoCelular() {
		return txtTelefonoCelular;
	}

	public void setTxtTelefonoCelular(HtmlInputText txtTelefonoCelular) {
		this.txtTelefonoCelular = txtTelefonoCelular;
	}

	public HtmlInputText getTxtTelefonoResidencia() {
		return txtTelefonoResidencia;
	}

	public void setTxtTelefonoResidencia(HtmlInputText txtTelefonoResidencia) {
		this.txtTelefonoResidencia = txtTelefonoResidencia;
	}

	public HtmlInputText getTxtTelefonoComercial() {
		return txtTelefonoComercial;
	}

	public void setTxtTelefonoComercial(HtmlInputText txtTelefonoComercial) {
		this.txtTelefonoComercial = txtTelefonoComercial;
	}

	public HtmlInputText getTxtCorreoElectronico() {
		return txtCorreoElectronico;
	}

	public void setTxtCorreoElectronico(HtmlInputText txtCorreoElectronico) {
		this.txtCorreoElectronico = txtCorreoElectronico;
	}
}
