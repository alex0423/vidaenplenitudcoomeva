package co.com.vep.vista;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import co.com.vep.logica.AsociadoLogica;
import co.com.vep.logica.ConsultoriaLogica;
import co.com.vep.logica.IAsociado;
import co.com.vep.logica.IConsultoria;
import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;
import co.com.vep.vista.excepciones.VepException;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

public class VistaInscripcionBancoExpertos extends VistaAreasConocimiento {

	private Long selectedTipo = null;
	private Long selectedRegional = null;
	private boolean disabledRegional = false;

	private HtmlInputText txtNombreConsultoria;
	private HtmlInputText txtDescripcionConsultoria;
	private HtmlInputText txtNumBeneficiados;
	private HtmlInputText txtIdentificacionBeneficiario;

	private String nombreConsultoria = null;
	private String descripcionConsultoria = null;
	private String identificacionBeneficiario = null;
	private String nombreBeneficiario = null;
	private String fechaVinculacion = null;
	private String edadBeneficiario = null;
	private String regionalConsultoria = null;
	private String numBeneficiados = null;
	private String objetivos;
	private String observaciones;
	private String primerApellido;
	private String segundoApellido;
	private boolean btnDisabled = false;
	private boolean modalRendered = false;
	private boolean siNoExiste = true;
	VepPlusBuc av = null;
	VepBeneficiario vb = null;

	public VistaInscripcionBancoExpertos() {
		super();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("CrearAsesoria")) {

				selectedRegional = (Long) Session
						.getSessionAttribute("userRegional");
				if (selectedRegional != null)
					disabledRegional = true;

				btnDisabled = true;
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {
		txtNombreConsultoria = new HtmlInputText();
		txtNombreConsultoria
				.addValidator(new validadorAlfabetico(MessageBundleLoader
						.getMessage("labels.inscripcionbexp.nombre"), true));
		txtNombreConsultoria.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNombreConsultoria
						.validate(FacesContext.getCurrentInstance());
			}
		});

		txtDescripcionConsultoria = new HtmlInputText();
		txtDescripcionConsultoria
				.addValidator(new validadorAlfabetico(MessageBundleLoader
						.getMessage("labels.inscripcionbexp.descripcion"), true));
		txtDescripcionConsultoria
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtDescripcionConsultoria.validate(FacesContext
								.getCurrentInstance());
					}
				});

		txtNumBeneficiados = new HtmlInputText();
		txtNumBeneficiados.addValidator(new validadorNumerico(
				MessageBundleLoader
						.getMessage("labels.inscripcionbexp.numbeneficiados"),
				true));
		txtNumBeneficiados.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNumBeneficiados.validate(FacesContext.getCurrentInstance());
			}
		});

		txtIdentificacionBeneficiario = new HtmlInputText();
		txtIdentificacionBeneficiario.addValidator(new validadorNumerico(
				MessageBundleLoader
						.getMessage("labels.inscripcionbexp.identificacion"),
				true));
		txtIdentificacionBeneficiario
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtIdentificacionBeneficiario.validate(FacesContext
								.getCurrentInstance());
					}
				});
		siNoExiste = true;
	}

	/**
	 * @return the descripcionConsultoria
	 */
	public String getDescripcionConsultoria() {
		return descripcionConsultoria;
	}

	/**
	 * @param descripcionConsultoria
	 *            the descripcionConsultoria to set
	 */
	public void setDescripcionConsultoria(String descripcionConsultoria) {
		this.descripcionConsultoria = descripcionConsultoria;
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
	 * @return the fechaVinculacion
	 */
	public String getFechaVinculacion() {
		return fechaVinculacion;
	}

	/**
	 * @param fechaVinculacion
	 *            the fechaVinculacion to set
	 */
	public void setFechaVinculacion(String fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	/**
	 * @return the edadBeneficiario
	 */
	public String getEdadBeneficiario() {
		if (edadBeneficiario == null)
			return "0";
		return edadBeneficiario;
	}

	/**
	 * @param edadBeneficiario
	 *            the edadBeneficiario to set
	 */
	public void setEdadBeneficiario(String edadBeneficiario) {
		this.edadBeneficiario = edadBeneficiario;
	}

	/**
	 * @return the selectedTipo
	 */
	public Long getSelectedTipo() {
		return selectedTipo;
	}

	/**
	 * @param selectedTipo
	 *            the selectedTipo to set
	 */
	public void setSelectedTipo(Long selectedTipo) {
		this.selectedTipo = selectedTipo;
	}

	/**
	 * @return the regionalConsultoria
	 */
	public String getRegionalConsultoria() {
		return regionalConsultoria;
	}

	/**
	 * @param regionalConsultoria
	 *            the regionalConsultoria to set
	 */
	public void setRegionalConsultoria(String regionalConsultoria) {
		this.regionalConsultoria = regionalConsultoria;
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
	 * @return the identificacionBeneficiario
	 */
	public String getIdentificacionBeneficiario() {
		return identificacionBeneficiario;
	}

	/**
	 * @param identificacionBeneficiario
	 *            the identificacionBeneficiario to set
	 */
	public void setIdentificacionBeneficiario(String identificacionBeneficiario) {
		this.identificacionBeneficiario = identificacionBeneficiario;
	}

	private void limpiarAsociado() {
		this.identificacionBeneficiario = null;
		this.nombreBeneficiario = null;
		this.primerApellido = null;
		this.segundoApellido = null;
	}

	public void action_consultarAsociado(ActionEvent actionEvent) {
		resetMessages();
		try {
			if (selectedTipo == 0 || selectedTipo == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion2"));

			if (identificacionBeneficiario == null
					|| identificacionBeneficiario.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion3"));

			IAsociado ia = new AsociadoLogica();
			vb = new VepBeneficiario();
			Long beneficiario = Long.valueOf(identificacionBeneficiario);
			vb = ia.obtenerBeneficiario(selectedTipo, beneficiario);

			if (vb != null
					&& !vb.getId().getNumeroDocumento().equals(new Long(0))) {
				nombreBeneficiario = vb.getNombre();
				primerApellido = vb.getApellido1();
				segundoApellido = vb.getApellido2();
				siNoExiste = true;
				btnDisabled = false;
			} else {

				AsociadoLogica aspirante = new AsociadoLogica();
				av = new VepPlusBuc();
				Long beneficiario1 = Long.valueOf(identificacionBeneficiario);
				av = aspirante.obtenerDetalleBUC(beneficiario1, selectedTipo);

				if (av.getIdAsociado() != null && av != null) {
					nombreBeneficiario = obtenerLabelNombre(av);
					primerApellido = av.getApellido1Asociado();
					segundoApellido = av.getApellido2Asociado();

					siNoExiste = false;
					btnDisabled = false;
				} else {
					this.nombreBeneficiario = null;
					this.primerApellido = null;
					this.segundoApellido = null;
					siNoExiste = false;
					btnDisabled = false;
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionBE.excepcion13"));
				}
			}
		} catch (Exception e) {
			// limpiarAsociado();
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessage(e.getMessage());
			toggleModal(actionEvent);
			VepException.displayError(e);
		}
	}

	private String obtenerLabelNombre(VepPlusBuc av) {
		String nombre = "";
		try {
			if (av.getNombre1Asociado() != null)
				nombre += av.getNombre1Asociado().trim();
			if (av.getNombre2Asociado() != null)
				nombre += " " + av.getNombre2Asociado().trim();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public void action_registrarBeneficiario(ActionEvent actionEvent) {
		resetMessages();
		try {
			List<Long> asesores = getSelectedAsesores();
			if (asesores.isEmpty())
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion6"));

			if (nombreConsultoria == null
					|| nombreConsultoria.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion10"));

			if (descripcionConsultoria == null
					|| descripcionConsultoria.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion11"));

			if (numBeneficiados == null
					|| numBeneficiados.equals(new Integer(0)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion12"));

			if (selectedTipo == null || selectedTipo == -1)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion7"));

			if (selectedRegional == null || selectedRegional == -1)
				throw new Exception(MessageBundleLoader
						.getMessage("Debe seleccionar la regional"));

			if (identificacionBeneficiario == null
					|| identificacionBeneficiario.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion8"));

			// if (Integer.parseInt(edadBeneficiario) < 60)
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.inscripcionBE.excepcion4"));

			// if (fechaVinculacion == null)
			// throw new Exception(MessageBundleLoader
			// .getMessage("labels.inscripcionBE.excepcion9"));

			if (siNoExiste) {
				String observacion = "";
				String objetivo = "";
				if (observaciones.length() >= 1000) {
					observacion = observaciones.substring(0, 999);
				} else {
					observacion = observaciones;
				}
				if (objetivos.length() >= 200) {
					objetivo = objetivos.substring(0, 199);
				} else {
					objetivo = objetivos;
				}
				IConsultoria consultoria = new ConsultoriaLogica();
				consultoria.registrar(nombreConsultoria,
						descripcionConsultoria, Long.valueOf(numBeneficiados),
						getSelectedAsesores(), Integer.valueOf(selectedTipo
								.intValue()), Long
								.valueOf(identificacionBeneficiario),
						selectedRegional, objetivo, observacion);

				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessage(MessageBundleLoader
						.getMessage("labels.inscripcionBE.mensaje1"));
				toggleModal(actionEvent);
				limpiar();
				siNoExiste = true;
				btnDisabled = true;
			} else if (!siNoExiste) {
				String observacion = "";
				String objetivo = "";
				if (observaciones.length() >= 1000) {
					observacion = observaciones.substring(0, 999);
				} else {
					observacion = observaciones;
				}
				if (objetivos.length() >= 200) {
					objetivo = objetivos.substring(0, 199);
				} else {
					objetivo = objetivos;
				}
				if (nombreBeneficiario == null
						|| nombreBeneficiario.trim().length() == 0) {
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionBE.excepcion14"));
				} else if (primerApellido == null
						|| primerApellido.trim().length() == 0) {
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionBE.excepcion15"));
				} else {
					IConsultoria consultoria = new ConsultoriaLogica();
					consultoria.registrar(nombreConsultoria,
							descripcionConsultoria, Long
									.valueOf(numBeneficiados),
							getSelectedAsesores(), Integer.valueOf(selectedTipo
									.intValue()), Long
									.valueOf(identificacionBeneficiario),
							nombreBeneficiario, primerApellido,
							segundoApellido, selectedRegional, objetivo,
							observacion);

					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessage(MessageBundleLoader
							.getMessage("labels.inscripcionBE.mensaje1"));
					toggleModal(actionEvent);
					limpiar();
					siNoExiste = true;
					btnDisabled = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessage(e.getMessage());
			toggleModal(actionEvent);
			VepException.displayError(e);
		}
	}

	public void action_limpiar(ActionEvent actionEvent) {
		limpiar();
	}

	private void limpiar() {
		this.descripcionConsultoria = null;
		this.nombreConsultoria = null;
		this.numBeneficiados = "0";
		this.regionalConsultoria = null;
		this.objetivos = null;
		this.observaciones = null;
		setSelectedArea(new Integer("-1"));
		selectedTipo = new Long("-1");
		setLstAsesores(null);

		limpiarAsociado();
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

	private void resetMessages() {
		setMessage("");
		setMessageTittle("");		
	}

	private DateTime extractDate(String date) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		return fmt.parseDateTime(date);
	}

	private int age(DateTime birthday) {
		DateTime now = new DateTime();
		int rs = now.getYear() - birthday.getYear();
		if ((birthday.getMonthOfYear() > now.getMonthOfYear())
				|| (birthday.getMonthOfYear() == now.getMonthOfYear() && birthday
						.getDayOfMonth() > now.getDayOfMonth()))
			rs--;
		return rs;
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
	 * @return the numBeneficiados
	 */
	public String getNumBeneficiados() {
		if (numBeneficiados == null)
			return "0";
		return numBeneficiados;
	}

	/**
	 * @param numBeneficiados
	 *            the numBeneficiados to set
	 */
	public void setNumBeneficiados(String numBeneficiados) {
		this.numBeneficiados = numBeneficiados;
	}

	/**
	 * @return the nombreConsultoria
	 */
	public String getNombreConsultoria() {
		return nombreConsultoria;
	}

	/**
	 * @param nombreConsultoria
	 *            the nombreConsultoria to set
	 */
	public void setNombreConsultoria(String nombreConsultoria) {
		this.nombreConsultoria = nombreConsultoria;
	}

	public HtmlInputText getTxtNombreConsultoria() {
		return txtNombreConsultoria;
	}

	public void setTxtNombreConsultoria(HtmlInputText txtNombreConsultoria) {
		this.txtNombreConsultoria = txtNombreConsultoria;
	}

	public HtmlInputText getTxtDescripcionConsultoria() {
		return txtDescripcionConsultoria;
	}

	public void setTxtDescripcionConsultoria(
			HtmlInputText txtDescripcionConsultoria) {
		this.txtDescripcionConsultoria = txtDescripcionConsultoria;
	}

	public HtmlInputText getTxtNumBeneficiados() {
		return txtNumBeneficiados;
	}

	public void setTxtNumBeneficiados(HtmlInputText txtNumBeneficiados) {
		this.txtNumBeneficiados = txtNumBeneficiados;
	}

	public HtmlInputText getTxtIdentificacionBeneficiario() {
		return txtIdentificacionBeneficiario;
	}

	public void setTxtIdentificacionBeneficiario(
			HtmlInputText txtIdentificacionBeneficiario) {
		this.txtIdentificacionBeneficiario = txtIdentificacionBeneficiario;
	}

	public boolean isDisabledRegional() {
		return disabledRegional;
	}

	public void setDisabledRegional(boolean disabledRegional) {
		this.disabledRegional = disabledRegional;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public boolean isSiNoExiste() {
		return siNoExiste;
	}

	public void setSiNoExiste(boolean siNoExiste) {
		this.siNoExiste = siNoExiste;
	}

	public VepPlusBuc getAv() {
		return av;
	}

	public void setAv(VepPlusBuc av) {
		this.av = av;
	}

	public VepBeneficiario getVb() {
		return vb;
	}

	public void setVb(VepBeneficiario vb) {
		this.vb = vb;
	}

}
