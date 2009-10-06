package co.com.vep.vista;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import org.joda.time.DateTime;

import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.AsociadoLogica;
import co.com.vep.logica.RealizarConsultas;
import co.com.vep.logica.RealizarInscripcion;
import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepUbicacionAcudiente;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.StringUtils;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;

/*En esta vista se obtiene principalmente la información de BUC para los Asosciados y los Acudiente,
 * tambien se obtienen los datos de Atributo Asociado
 *  
 */

public class VistaInscripcion extends VistaAgregarAsociado {

	private long numint = 0;
	private long numintacu = 0;

	/**
	 * Selectores
	 */
	private Integer[] selectedPAMS;
	private Integer[] selectedPatologias;
	private Integer[] selectedHobbies;
	private Integer[] selectedServMedico;
	private Integer[] selectedServOfrecer;
	private Integer[] selectedConocimientos;

	// esta es una bandera que me establece si hay que almacenar al Asociado o
	// no
	private boolean grabarEnBUC = true;
	private boolean grabarACUBUC = true;

	// Declaración del objeto Asociado que proviene del webservice

	// Variable para los mensajes de error...!
	private String mensajes;
	private String mensajes3;

	// componentes para los InputText
	private HtmlSelectOneMenu txtGenero;

	private HtmlSelectOneMenu txtTituloProfesional;
	private HtmlSelectOneMenu txtOcupacion;
	private HtmlSelectOneMenu txtEstadoCivil;

	private SelectInputDate txtFechaNace;
	private SelectInputDate txtFechaEstado;
	private SelectInputDate txtFechaIngreso;
	private HtmlSelectOneMenu txtcodigoCorte;
	private SelectInputDate txtFechaIngVEP;

	// Componentes para los InputText de consulta Acudientes
	private HtmlInputText txtCedulaAcudiente;
	private HtmlInputText txtNombre1Acudiente;
	private HtmlInputText txtNombre2Acudiente;
	private HtmlInputText txtApellido1Acudiente;
	private HtmlInputText txtApellido2Acudiente;
	private HtmlInputText txtTelefonoResidenciaAcudiente;
	private HtmlInputText txtTelefonoComercialAcudiente;
	private HtmlInputText txtTelefonoCelularAcudiente;

	// Botón de Validar la Edad
	private HtmlCommandButton btnValidarEdad;

	// Botones para validar la Ciudad
	private HtmlCommandButton btnCiuRes;
	private HtmlCommandButton btnCiuCom;

	// Texto ciudades
	private HtmlInputText txtTextoCiudadesRes;
	private HtmlInputText txtTextoCiudadesCom;

	private HtmlInputText txtNumHorasDisp;

	// Elementos de los Panel Grids
	private boolean pnl2Visible = false;
	private boolean pnl5Visible = false;

	// este elemento almacena los posibles errores generados cuando se hace una
	// transacción
	private HtmlInputTextarea txtOtraPat;
	// private String otraPat;

	private HtmlInputTextarea txtOtroHob;
	// private String otroHob;

	private HtmlInputTextarea txtOtroServicio;
	// private String otroServicio;

	private HtmlInputTextarea txtOtroCon;
	// private String otroCon;

	// Valores para El Panel generado para ciudades
	private boolean visible = false;

	private String pais;
	private List<SelectItem> lista_deptos;
	private Long deptos;
	private List<SelectItem> lista_ciu;

	// private String ciuCom;
	private Long hddCiudadComercial = new Long(0);
	// private String ciuRes;
	private Long hddCiudadResidencia = new Long(0);

	private Long ciu;
	private String labelCiudad;
	private String hdeUsuario;

	public VistaInscripcion() {
		super();
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("IngresarAsociado")) {
				lista_deptos = new ArrayList<SelectItem>();
				lista_ciu = new ArrayList<SelectItem>();
				initializeComponent();
				setHdeUsuario(((UserVo) Session.getSessionAttribute("userObj"))
						.getUserId());
			}
		}
	}

	private void initializeComponent() {

		txtCedulaAcudiente = new HtmlInputText();
		txtCedulaAcudiente.addValidator(new validadorNumerico(
				MessageBundleLoader.getMessage("labels.numeroid"), true));
		txtCedulaAcudiente.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCedulaAcudiente.validate(FacesContext.getCurrentInstance());
			}
		});

		txtNombre1Acudiente = new HtmlInputText();
		txtNombre1Acudiente
				.addValidator(new validadorAlfabetico(
						MessageBundleLoader.getMessage("labels.nombre1")
								+ " "
								+ MessageBundleLoader
										.getMessage("labels.delacu"), true));
		txtNombre1Acudiente.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNombre1Acudiente.validate(FacesContext.getCurrentInstance());
			}
		});

		txtNombre2Acudiente = new HtmlInputText();
		txtNombre2Acudiente.addValidator(new validadorAlfabetico(
				MessageBundleLoader.getMessage("labels.nombre2") + " "
						+ MessageBundleLoader.getMessage("labels.delacu")));
		txtNombre2Acudiente.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNombre2Acudiente.validate(FacesContext.getCurrentInstance());
			}
		});

		txtApellido1Acudiente = new HtmlInputText();
		txtApellido1Acudiente
				.addValidator(new validadorAlfabetico(
						MessageBundleLoader.getMessage("labels.apellido1")
								+ " "
								+ MessageBundleLoader
										.getMessage("labels.delacu"), true));
		txtApellido1Acudiente.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtApellido1Acudiente.validate(FacesContext
						.getCurrentInstance());
			}
		});

		txtApellido2Acudiente = new HtmlInputText();
		txtApellido2Acudiente.addValidator(new validadorAlfabetico(
				MessageBundleLoader.getMessage("labels.apellido2") + " "
						+ MessageBundleLoader.getMessage("labels.delacu")));
		txtApellido2Acudiente.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtApellido2Acudiente.validate(FacesContext
						.getCurrentInstance());
			}
		});

		txtTelefonoResidenciaAcudiente = new HtmlInputText();
		txtTelefonoResidenciaAcudiente.addValidator(new validadorNumerico(
				MessageBundleLoader.getMessage("labels.telred") + " "
						+ MessageBundleLoader.getMessage("labels.delacu")));
		txtTelefonoResidenciaAcudiente
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtTelefonoResidenciaAcudiente.validate(FacesContext
								.getCurrentInstance());
					}
				});

		txtTelefonoComercialAcudiente = new HtmlInputText();
		txtTelefonoComercialAcudiente.addValidator(new validadorNumerico(
				MessageBundleLoader.getMessage("labels.telcom") + " "
						+ MessageBundleLoader.getMessage("labels.delacu")));
		txtTelefonoComercialAcudiente
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtTelefonoComercialAcudiente.validate(FacesContext
								.getCurrentInstance());
					}
				});

		txtTelefonoCelularAcudiente = new HtmlInputText();
		txtTelefonoCelularAcudiente.addValidator(new validadorNumerico(
				MessageBundleLoader.getMessage("labels.telcel") + " "
						+ MessageBundleLoader.getMessage("labels.delacu")));
		txtTelefonoCelularAcudiente
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtTelefonoCelularAcudiente.validate(FacesContext
								.getCurrentInstance());
					}
				});

		txtNumHorasDisp = new HtmlInputText();
		txtNumHorasDisp.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.disponible")));
		txtNumHorasDisp.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNumHorasDisp.validate(FacesContext.getCurrentInstance());
			}
		});
		txtNumHorasDisp.setDisabled(true);

		txtOtroCon = new HtmlInputTextarea();
		txtOtroCon.setVisible(false);
		txtOtroCon.setRendered(false);

		txtOtraPat = new HtmlInputTextarea();
		txtOtraPat.setVisible(false);
		txtOtraPat.setRendered(false);

		txtOtroHob = new HtmlInputTextarea();
		txtOtroHob.setVisible(false);
		txtOtroHob.setRendered(false);

		txtOtroServicio = new HtmlInputTextarea();
		txtOtroServicio.setVisible(false);
		txtOtroServicio.setRendered(false);

		txtFechaEstado = new SelectInputDate();
		txtFechaEstado.setDisabled(true);
		txtFechaIngreso = new SelectInputDate();
		txtFechaIngreso.setDisabled(true);
	}

	public void onSelectPais(ValueChangeEvent event) {
		pais = (String) event.getNewValue();
		if (!pais.equals(new Long("-1"))) {
			try {
				RealizarConsultas rcons = new RealizarConsultas();
				lista_deptos = llenarListaParametrosDeptos(rcons, pais);
			} catch (Exception err) {
				lista_deptos = null;
			}
		}
	}

	public void onSelectDepartamento(ValueChangeEvent event) {
		deptos = (Long) event.getNewValue();
		if (deptos != null) {
			if (!deptos.equals(new Long("-1"))) {
				try {
					RealizarConsultas rcons = new RealizarConsultas();
					lista_ciu = this.llenarListaParametrosCiudades(rcons,
							deptos);
				} catch (Exception err) {
					lista_ciu = null;
				}
			}
		}
	}

	public void onSelectCiudad(ValueChangeEvent event) {
		ciu = (Long) event.getNewValue();
		if (ciu != null) {
			for (SelectItem item : lista_ciu) {
				if (item.getValue().equals(ciu)) {
					labelCiudad = item.getLabel();
					break;
				}
			}
		}
	}

	public void onSelectCompartir(ValueChangeEvent event) {
		String item = (String) event.getNewValue();
		compartir = item;
		pnl5Visible = false;
		txtNumHorasDisp.setDisabled(true);
		if (item.equals(new String("SI"))) {
			pnl5Visible = true;
			txtNumHorasDisp.setDisabled(false);
		}
	}

	public void onSelectedHobbie(ValueChangeEvent event) {
		Integer[] item = (Integer[]) event.getNewValue();
		boolean findit = false;
		for (Integer value : item) {
			if (value.equals(new Integer(35))) {
				findit = true;
				break;
			}
		}
		if (findit) {
			txtOtroHob.setVisible(true);
			txtOtroHob.setRendered(true);
		} else {
			txtOtroHob.setVisible(false);
			txtOtroHob.setRendered(false);
		}
	}

	public void onSelectedPatologia(ValueChangeEvent event) {
		Integer[] item = (Integer[]) event.getNewValue();
		boolean findit = false;
		for (Integer value : item) {
			if (value.equals(new Integer(23))) {
				findit = true;
				break;
			}
		}
		if (findit) {
			txtOtraPat.setVisible(true);
			txtOtraPat.setRendered(true);
		} else {
			txtOtraPat.setVisible(false);
			txtOtraPat.setRendered(false);
		}
	}

	public void onSelectedServOfrecer(ValueChangeEvent event) {
		Integer[] item = (Integer[]) event.getNewValue();
		boolean findit = false;
		for (Integer value : item) {
			if (value.equals(new Integer(49))) {
				findit = true;
				break;
			}
		}
		if (findit) {
			txtOtroServicio.setVisible(true);
			txtOtroServicio.setRendered(true);
		} else {
			txtOtroServicio.setVisible(false);
			txtOtroServicio.setRendered(false);
		}
	}

	public void onSelectedConocimiento(ValueChangeEvent event) {
		Integer[] item = (Integer[]) event.getNewValue();
		boolean findit = false;
		for (Integer value : item) {
			if (value.equals(new Integer(63))) {
				findit = true;
				break;
			}
		}
		if (findit) {
			txtOtroCon.setVisible(true);
			txtOtroCon.setRendered(true);
		} else {
			txtOtroCon.setVisible(false);
			txtOtroCon.setRendered(false);
		}
	}

	// Metodos y funciones del Panel de Ciudades
	private List<SelectItem> llenarListaParametrosDeptos(
			RealizarConsultas rcons, String codPais) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			items.add(new SelectItem(new Long("-1"), "-- Seleccione --"));
			Parametros[] mispar = rcons.mostrarDeptos(codPais);
			if (mispar != null) {
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(new Long(mispar[i]
							.getCodigoParam()), mispar[i].getCodigoParam()
							+ "-" + mispar[i].getDescripcionParam()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	private List<SelectItem> llenarListaParametrosCiudades(
			RealizarConsultas rcons, Long codDepto) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {
			items.add(new SelectItem(new Long("-1"), "-- Seleccione --"));
			Ciudad[] mispar = rcons.mostrarCiudades(pais, codDepto.longValue());
			if (mispar != null) {
				for (int i = 0; i < mispar.length; i++) {
					items.add(new SelectItem(
							new Long(mispar[i].getCodCiudad()), mispar[i]
									.getCodCiudad()
									+ "-" + mispar[i].getNombreCiudad()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	public void closePopup() {
		visible = false;
		if (ciu != null) {
			if (!ciu.equals(new Long("-1"))) {
				if (selectorDestination.equals("RES")) {
					ciuRes = labelCiudad;
					hddCiudadResidencia = ciu;
				} else {
					ciuCom = labelCiudad;
					hddCiudadComercial = ciu;
				}
			}
		}
	}

	private String selectorDestination = "";

	public void popupResidencia() {
		limpiarPopup();
		visible = true;
		selectorDestination = "RES";
	}

	public void popupComercial() {
		limpiarPopup();
		visible = true;
		selectorDestination = "COM";
	}

	private void limpiarPopup() {
		pais = "-1";
		lista_ciu = new ArrayList<SelectItem>();
		ciu = new Long("-1");
		lista_deptos = new ArrayList<SelectItem>();
		deptos = new Long("-1");
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<SelectItem> getLista_deptos() {
		return lista_deptos;
	}

	public void setLista_deptos(List<SelectItem> lista_deptos) {
		this.lista_deptos = lista_deptos;
	}

	public Long getDeptos() {
		return deptos;
	}

	public void setDeptos(Long deptos) {
		this.deptos = deptos;
	}

	public List<SelectItem> getLista_ciu() {
		return lista_ciu;
	}

	public void setLista_ciu(List<SelectItem> lista_ciu) {
		this.lista_ciu = lista_ciu;
	}

	public Long getCiu() {
		return ciu;
	}

	public void setCiu(Long ciu) {
		this.ciu = ciu;
	}

	public String getCiuCom() {
		return ciuCom;
	}

	public void setCiuCom(String ciuCom) {
		this.ciuCom = ciuCom;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getFechaNace() {
		return fechaNace;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
		if (fechaNace != null) {
			try {
				edad = miEdad(fechaNace);
				Integer edadBase = new Integer(
						LocalApplicationConfiguration.Util.getInstance()
								.getProperty("edad_asociado"));
				if (edad < edadBase) {
					throw new Exception(MessageBundleLoader.getMessage(
							"labels.inscripcionaso.err30").replace("$$EDAD$$",
							edad.toString()));
				}
			} catch (Exception err) {
				showException(err);
				ocultarLosFrames();
				err.printStackTrace();
			}
		}
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getCodigoAsociado() {
		return codigoAsociado;
	}

	public void setCodigoAsociado(Long codigoAsociado) {
		this.codigoAsociado = codigoAsociado;
	}

	public String getEstadoAsociado() {
		return estadoAsociado;
	}

	public void setEstadoAsociado(String estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}

	public Date getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(Date fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	public Date getFechaIngresoAsociado() {
		return fechaIngresoAsociado;
	}

	public void setFechaIngresoAsociado(Date fechaIngresoAsociado) {
		this.fechaIngresoAsociado = fechaIngresoAsociado;
	}

	public Date getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(Date fechaCorte) {
		this.fechaCorte = fechaCorte;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public String getDirComercial() {
		return dirComercial;
	}

	public void setDirComercial(String dirComercial) {
		this.dirComercial = dirComercial;
	}

	public String getTelefonoResidencia() {
		return telefonoResidencia;
	}

	public void setTelefonoResidencia(String telefonoResidencia) {
		this.telefonoResidencia = telefonoResidencia;
	}

	public String getTelefonoComercial() {
		return telefonoComercial;
	}

	public void setTelefonoComercial(String telefonoComercial) {
		this.telefonoComercial = telefonoComercial;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getCorreoElectrinico() {
		return correoElectrinico;
	}

	public void setCorreoElectrinico(String correoElectrinico) {
		this.correoElectrinico = correoElectrinico;
	}

	public Long getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(Long tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public Long getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Long ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Long getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Long estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Long getNumCuotasVen() {
		return numCuotasVen;
	}

	public void setNumCuotasVen(Long numCuotasVen) {
		this.numCuotasVen = numCuotasVen;
	}

	public String getCiudadComercial() {
		return ciudadComercial;
	}

	public void setCiudadComercial(String ciudadComercial) {
		this.ciudadComercial = ciudadComercial;
	}

	private void initPanelsAsociado() {
		limpiarMensajes();
		limpiarDatosBucASO();
		vaciarDatosBucACU();
		vaciarOtrosCamposConsulta();
		ocultarLosFrames();
	}

	private void limpiarMensajes() {
		mensajes = "";
		mensajes3 = "";
	}

	private void initPanelsAsociado(AsociadoVida asociado) {
		try {
			initPanelsAsociado();
			mostrarLosFrames();
			llenarDatosBucASO(asociado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action_obtenerDatosBUCASO(ActionEvent actionEvent)
			throws Exception {

		initPanelsAsociado();

		grabarEnBUC = true;
		try {
			if (tipoid == -1)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens8"));

			if (cedula == null || cedula.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens7"));

			if (tipoAsociado == -1)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens6"));

		} catch (Exception err) {
			showException(err);
			err.printStackTrace();
			return;
		}

		AsociadoLogica logica = new AsociadoLogica();
		try {
			if (logica.validar(tipoid, new Long(cedula)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens5"));

			AsociadoVida aso = logica.obtenerAsAsociado(new Long(cedula),
					Integer.parseInt(tipoid.toString()));

			if (aso != null && aso.getCodAsociado() != 0
					&& aso.getFecNacimiento() != 0) {
				if (!String.valueOf(aso.getFecNacimiento()).trim().equals("0")) {

					String miFechaTexto = StringUtils
							.generarFechaCorrecta(new Long(aso
									.getFecNacimiento()).toString());
					Date miFechaNace = StringUtils
							.cambiarFechaTexto_Date(miFechaTexto);

					int edadAso = miEdad(miFechaNace);

					if (edadAso >= Integer
							.parseInt(LocalApplicationConfiguration.Util
									.getInstance().getProperty("edad_asociado"))) {

						if (aso.getEstado() == 10) {
							System.out.println("SI");
							grabarEnBUC = false;
							initPanelsAsociado(aso);
						} else {

							if (aso.getCuotaVencida() < 2) {
								mensajes = MessageBundleLoader
										.getMessage("labels.inscripcionaso.advertencia1");
								grabarEnBUC = false;
								initPanelsAsociado(aso);
							} else {
								throw new Exception(
										MessageBundleLoader
												.getMessage("labels.inscripcionaso.err5"));
							}
						}

					} else
						throw new Exception(MessageBundleLoader
								.getMessage("labels.inscripcionaso.err3"));

				} else
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionaso.err37"));

			} else {
				if (tipoAsociado == 1) {
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionaso.mens9"));
				} else {
					mensajes = MessageBundleLoader
							.getMessage("labels.inscripcionaso.mens2");
					mostrarLosFrames();

					fechaIngVEP = Calendar.getInstance().getTime();
				}
			}

		} catch (Exception err) {
			showException(err);
			err.printStackTrace();
			return;
		}
	}

	public void llenarDatosBucASO(AsociadoVida aso) {

		String miFechaTexto;
		Date miFechaConv = null;

		try {
			if (!aso.getCodCiuComercial().equals("")
					|| aso.getCodCiuComercial().trim().length() != 0)
				setHddCiudadComercial(Long.valueOf(aso.getCodCiuComercial()));
			if (!aso.getCodCiuResidencia().equals("")
					|| aso.getCodCiuResidencia().trim().length() != 0)
				setHddCiudadResidencia(Long.valueOf(aso.getCodCiuResidencia()));
			mostrarRegistroFromBuc(aso);
			numint = aso.getNumInt();
			num_cuotas_vencidas = new Integer(new Long(aso.getCuotaVencida())
					.toString());
			desactivarCamposBucASO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarLosFrames() {
		pnl2Visible = true;
		pnl5Visible = false;
		activarCamposBucASO();
	}

	public void ocultarLosFrames() {
		pnl2Visible = false;
		pnl5Visible = false;
		compartir = "NO";
	}

	public void action_obtenerDatosBUCACU(ActionEvent actionEvent)
			throws Exception {

		grabarACUBUC = true;
		RealizarConsultas rcons = new RealizarConsultas();

		try {
			if (cedulaAcudiente.equals(new Long(0))
					|| cedulaAcudiente < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err17"));

			if (tipoidacu.equals(new Long("-1")))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err16"));

		} catch (Exception e) {
			mensajes3 = MessageBundleLoader
					.getMessage("labels.inscripcionaso.mens1");
			this.vaciarDatosBucACU();
			this.desactivarCamposBucACU();
		}

		try {
			VepAcudiente acu = rcons.consultarDatosAcudiente(tipoidacu,
					cedulaAcudiente);
			List<VepUbicacionAcudiente> listaUbicaciones = new ArrayList<VepUbicacionAcudiente>();

			if (acu.getNombre1() != null) {
				grabarACUBUC = false;
				// numintacu = acu.getNumInt();
				listaUbicaciones = rcons.consultarUbicacionAcudiente(acu
						.getIdAcudiente());
				if (!this.cedula.equals(acu.getNumeroDocumento().toString())
						&& this.tipoid != this.tipoidacu) {
					mensajes3 = "";
					initCamposAcudiente(acu, listaUbicaciones);
				} else {

					mensajes3 = MessageBundleLoader
							.getMessage("labels.inscripcionaso.mens3");
					initCamposAcudiente();
				}
			} else {
				grabarACUBUC = true;
				mensajes3 = MessageBundleLoader
						.getMessage("labels.inscripcionaso.mens3_1");
				initCamposAcudiente();
				activarCamposBucACU();
			}
		} catch (Exception e) {
			showException(e);
		}
	}

	private void initCamposAcudiente() {
		this.vaciarDatosBucACU();
		this.desactivarCamposBucACU();
	}

	private void initCamposAcudiente(VepAcudiente acu,
			List<VepUbicacionAcudiente> lista) {
		initCamposAcudiente();
		llenarDatosBucACU(acu, lista);
	}

	public void llenarDatosBucACU(VepAcudiente acu,
			List<VepUbicacionAcudiente> lista) {
		nombre1Acudiente = acu.getNombre1();
		nombre2Acudiente = acu.getNombre2();
		apellido1Acudiente = acu.getApellido1();
		apellido2Acudiente = acu.getApellido2();
		for (VepUbicacionAcudiente vepUbicacionAcudiente : lista) {
			if (vepUbicacionAcudiente.getId().getTipoUbicacion().equals(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("telefono_residencia"))) {
				telefonoResidenciaAcudiente = vepUbicacionAcudiente
						.getDescripcionUbicacion();
			}
			if (vepUbicacionAcudiente.getId().getTipoUbicacion().equals(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("telefono_comercial"))) {
				telefonoComercialAcudiente = vepUbicacionAcudiente
						.getDescripcionUbicacion();
			}
			if (vepUbicacionAcudiente.getId().getTipoUbicacion().equals(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("telefono_celular"))) {
				telefonoCelularAcudiente = vepUbicacionAcudiente
						.getDescripcionUbicacion();
			}
		}		
		//numintacu = acu.getNumInt();
		desactivarCamposBucACU();
	}

	private Integer miEdad(Date fechaNace) {

		DateTime nacimiento = new DateTime(fechaNace.getTime());
		DateTime hoy = new DateTime();

		int diff_year = hoy.minusYears(nacimiento.getYear()).getYear();
		System.out.println(diff_year);
		int diff_mes = hoy.minusMonths(nacimiento.getMonthOfYear())
				.getMonthOfYear();
		System.out.println(diff_mes);
		if (diff_mes < 0)
			diff_year--;
		System.out.println(diff_year);
		return diff_year;
	}

	public void action_guardarInscripcion(ActionEvent event) {

		RealizarInscripcion rins = new RealizarInscripcion();
		try {
			validar();

			if (fechaNace == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err19"));
			else if (new DateTime().isBefore(new DateTime(fechaNace)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err20"));

			if (edad == null || edad.equals(new Long(0)) || edad < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err8"));

			if (estadoCivil.equals(new Long(0)) || estadoCivil < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err21"));

			if (!tipoid.equals(new Long(1))) {
				if (ocupacion == null || ocupacion.equals(new Long(0))
						|| ocupacion < new Long(0))
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionaso.err22"));

				if (tituloProfesional == null
						|| tituloProfesional.equals(new Long(0))
						|| tituloProfesional < new Long(0))
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionaso.err23"));
			}

//			if (tipoidacu == null || tipoidacu.equals(new Long("-1")))
//				throw new Exception(MessageBundleLoader
//						.getMessage("labels.inscripcionaso.err24"));
//
//			if (cedulaAcudiente == null || cedulaAcudiente.equals(new Long(0))
//					|| cedulaAcudiente < new Long(0))
//				throw new Exception(MessageBundleLoader
//						.getMessage("labels.inscripcionaso.err25"));

			if (nombre1Acudiente.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err26"));

			if (apellido1Acudiente.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err27"));

			if (direccionResidencia.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err28"));

			if (telefonoResidenciaAcudiente.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err34"));

			if (telefonoResidencia.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err38"));

			if (ciuRes == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err39"));

			if (tipoSangre.equals("-1"))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err43"));

			if (compartir != null && compartir.equals("S"))
				if (selectedConocimientos == null
						|| selectedConocimientos.length == 0)
					throw new Exception(MessageBundleLoader
							.getMessage("labels.inscripcionaso.err29"));
			if (generoId.equals(new Long(1)))
				genero = "M";
			else if (generoId.equals(new Long(2))) {
				genero = "F";
			}

			Long lCedula = new Long(cedula);
			if (numHorasDisp == null || numHorasDisp.equals(""))
				numHorasDisp = "0";

			String direccionR = "";
			String direccionC = "";
			if (direccionResidencia.length() >= new Integer(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tamano_direccion")).intValue() + 1) {
				direccionR = direccionResidencia.substring(0, new Integer(
						LocalApplicationConfiguration.Util.getInstance()
								.getProperty("tamano_direccion")).intValue());
			} else {
				direccionR = direccionResidencia;
			}

			if (dirComercial.length() >= new Integer(
					LocalApplicationConfiguration.Util.getInstance()
							.getProperty("tamano_direccion")).intValue() + 1) {
				direccionC = dirComercial.substring(0, new Integer(
						LocalApplicationConfiguration.Util.getInstance()
								.getProperty("tamano_direccion")).intValue());
			} else {
				direccionC = dirComercial;
			}

			rins.guardarAsociado(tipoid, lCedula, nombre1, nombre2, apellido1,
					apellido2, fechaNace, genero, codigoAsociado,
					estadoAsociado, fechaEstado, fechaIngresoAsociado, corte,
					direccionR, hddCiudadResidencia.toString(), dirComercial,
					hddCiudadComercial.toString(), telefonoResidencia,
					telefonoComercial, telefonoCelular, correoElectrinico,
					tituloProfesional, ocupacion, estadoCivil,
					num_cuotas_vencidas, tipoidacu, cedulaAcudiente,
					nombre1Acudiente, nombre2Acudiente, apellido1Acudiente,
					apellido2Acudiente, telefonoResidenciaAcudiente,
					telefonoComercialAcudiente, telefonoCelularAcudiente,
					tipoSangre, new Date(), tipoAsociado, selectedPatologias,
					selectedServMedico, selectedServOfrecer,
					selectedConocimientos, selectedHobbies, selectedPAMS,
					otraPat, otroServicio, otroCon, otroHob, medicamentos, Long
							.valueOf(numHorasDisp), getHdeUsuario());

			this.limpiarMensajes();
			mensajes3 = MessageBundleLoader
					.getMessage("labels.inscripcionaso.mens4");

			this.ocultarLosFrames();
			this.limpiarDatosBucASO();
			this.vaciarDatosBucACU();
			this.vaciarOtrosCampos();

			this.activarCamposBucACU();
			this.activarCamposBucASO();

		} catch (Exception err) {
			err.printStackTrace();
			showException(err);
		}

	}

	public void activarCamposBucACU() {
		// txtCedulaAcudiente.setReadonly(false);
		txtNombre1Acudiente.setReadonly(false);
		txtNombre2Acudiente.setReadonly(false);
		txtApellido1Acudiente.setReadonly(false);
		txtApellido2Acudiente.setReadonly(false);
		txtTelefonoResidenciaAcudiente.setReadonly(false);
		txtTelefonoComercialAcudiente.setReadonly(false);
		txtTelefonoCelularAcudiente.setReadonly(false);

	}

	public void vaciarDatosBucACU() {

		// cedulaAcudiente=null;
		nombre1Acudiente = null;
		nombre2Acudiente = null;
		apellido1Acudiente = null;
		apellido2Acudiente = null;
		telefonoResidenciaAcudiente = null;
		telefonoComercialAcudiente = null;
		telefonoCelularAcudiente = null;
		codigoAcudiente = null;
		numintacu = 0;

	}

	public void desactivarCamposBucACU() {
		// txtCedulaAcudiente.setReadonly(true);
		txtNombre1Acudiente.setReadonly(true);
		txtNombre2Acudiente.setReadonly(true);
		txtApellido1Acudiente.setReadonly(true);
		txtApellido2Acudiente.setReadonly(true);
		txtTelefonoResidenciaAcudiente.setReadonly(false);
		txtTelefonoComercialAcudiente.setReadonly(true);
		txtTelefonoCelularAcudiente.setReadonly(true);

	}

	public void vaciarOtrosCamposConsulta() {

		this.tipoidacu = new Long("-1");
		this.cedulaAcudiente = null;

		this.txtOtraPat.setVisible(false);
		this.txtOtraPat.setRendered(false);
		this.otraPat = null;

		this.txtOtroHob.setVisible(false);
		this.txtOtroHob.setRendered(false);
		this.otroHob = null;

		this.txtOtroServicio.setVisible(false);
		this.txtOtroServicio.setRendered(false);
		this.otroServicio = null;

		this.txtOtroCon.setVisible(false);
		this.txtOtroCon.setRendered(false);
		this.otroCon = null;
		this.numHorasDisp = null;
		medicamentos = null;
		txtNumHorasDisp.setDisabled(true);
	}

	public void vaciarOtrosCampos() {

		tipoid = new Long("-1");
		tipoAsociado = new Long("-1");
		cedula = null;

		this.tipoidacu = new Long("-1");
		this.cedulaAcudiente = null;

		this.txtOtraPat.setVisible(false);
		this.txtOtraPat.setRendered(false);
		this.otraPat = null;

		this.txtOtroHob.setVisible(false);
		this.txtOtroHob.setRendered(false);
		this.otroHob = null;

		this.txtOtroServicio.setVisible(false);
		this.txtOtroServicio.setRendered(false);
		this.otroServicio = null;

		this.txtOtroCon.setVisible(false);
		this.txtOtroCon.setRendered(false);
		this.otroCon = null;
		this.numHorasDisp = null;
		medicamentos = null;
		txtNumHorasDisp.setDisabled(true);
	}

	public void limpiarDatosBucASO() {
		limpiar();
		fechaNace = null;
		genero = "";
		codigoAsociado = null;
		estadoAsociado = null;
		// fechaEstado = null;
		fechaIngresoAsociado = null;

		corte = null;
		fechaIngVEP = null;
		direccionResidencia = null;

		dirComercial = null;
		telefonoResidencia = null;
		telefonoComercial = null;
		telefonoCelular = null;
		correoElectrinico = null;
		tituloProfesional = null;
		ocupacion = null;
		estadoCivil = null;
		numCuotasVen = null;
		edad = null;
		numint = 0;

		ciu = null;
		ciuCom = null;
		ciuRes = null;

		selectedConocimientos = new Integer[] {};
		selectedHobbies = new Integer[] {};
		selectedPAMS = new Integer[] {};
		selectedPatologias = new Integer[] {};
		selectedServMedico = new Integer[] {};
		selectedServOfrecer = new Integer[] {};

		generoId = new Long("-1");
		fechaEstado = null;
		tipoSangre = "-1";
	}

	public void desactivarCamposBucASO() {

		habilitarInput(true);
		txtFechaNace.setDisabled(true);
		txtFechaEstado.setDisabled(true);
		txtFechaIngreso.setDisabled(true);
		txtNumHorasDisp.setDisabled(true);
		txtcodigoCorte.setReadonly(true);
		// txtFechaIngVEP.setDisabled(true);

		txtGenero.setDisabled(true);
		txtTituloProfesional.setDisabled(true);
		txtOcupacion.setDisabled(true);
		txtEstadoCivil.setDisabled(true);
		txtCorreoElectronico.setReadonly(true);

		// btnCiuCom.setDisabled(true);
		// btnCiuRes.setDisabled(true);
	}

	public void activarCamposBucASO() {

		habilitarInput(false);
		txtFechaNace.setDisabled(false);
		// txtFechaEstado.setDisabled(false);
		// txtFechaIngreso.setDisabled(false);
		// txtFechaCorte.setDisabled(false);

		txtFechaIngVEP.setDisabled(false);
		txtcodigoCorte.setDisabled(true);

		txtGenero.setDisabled(false);

		txtCodAsociado.setReadonly(false);

		txtDirResidencia.setReadonly(false);
		txtDirComercial.setReadonly(false);
		txtTelefonoCelular.setReadonly(false);
		txtTelefonoResidencia.setReadonly(false);
		txtTelefonoComercial.setReadonly(false);
		txtCorreoElectronico.setReadonly(false);
		txtTituloProfesional.setReadonly(false);
		txtOcupacion.setReadonly(false);
		txtTituloProfesional.setDisabled(false);
		txtOcupacion.setDisabled(false);
		txtEstadoCivil.setReadonly(false);
		txtEstadoCivil.setDisabled(false);
		txtCorreoElectronico.setReadonly(false);

		btnCiuCom.setDisabled(false);
		btnCiuRes.setDisabled(false);

	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	public HtmlSelectOneMenu getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(HtmlSelectOneMenu txtGenero) {
		this.txtGenero = txtGenero;
	}

	public SelectInputDate getTxtFechaNace() {
		return txtFechaNace;
	}

	public void setTxtFechaNace(SelectInputDate txtFechaNace) {
		this.txtFechaNace = txtFechaNace;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaIngVEP() {
		return fechaIngVEP;
	}

	public void setFechaIngVEP(Date fechaIngVEP) {
		this.fechaIngVEP = fechaIngVEP;
	}

	public SelectInputDate getTxtFechaEstado() {
		return txtFechaEstado;
	}

	public void setTxtFechaEstado(SelectInputDate txtFechaEstado) {
		this.txtFechaEstado = txtFechaEstado;
	}

	public SelectInputDate getTxtFechaIngreso() {
		return txtFechaIngreso;
	}

	public void setTxtFechaIngreso(SelectInputDate txtFechaIngreso) {
		this.txtFechaIngreso = txtFechaIngreso;
	}

	public SelectInputDate getTxtFechaIngVEP() {
		return txtFechaIngVEP;
	}

	public void setTxtFechaIngVEP(SelectInputDate txtFechaIngVEP) {
		this.txtFechaIngVEP = txtFechaIngVEP;
	}

	public Long getCedulaAcudiente() {
		return cedulaAcudiente;
	}

	public void setCedulaAcudiente(Long cedulaAcudiente) {
		this.cedulaAcudiente = cedulaAcudiente;
	}

	public String getNombre1Acudiente() {
		return nombre1Acudiente;
	}

	public void setNombre1Acudiente(String nombre1Acudiente) {
		this.nombre1Acudiente = nombre1Acudiente;
	}

	public String getNombre2Acudiente() {
		return nombre2Acudiente;
	}

	public void setNombre2Acudiente(String nombre2Acudiente) {
		this.nombre2Acudiente = nombre2Acudiente;
	}

	public String getApellido1Acudiente() {
		return apellido1Acudiente;
	}

	public void setApellido1Acudiente(String apellido1Acudiente) {
		this.apellido1Acudiente = apellido1Acudiente;
	}

	public String getApellido2Acudiente() {
		return apellido2Acudiente;
	}

	public void setApellido2Acudiente(String apellido2Acudiente) {
		this.apellido2Acudiente = apellido2Acudiente;
	}

	public String getTelefonoResidenciaAcudiente() {
		return telefonoResidenciaAcudiente;
	}

	public void setTelefonoResidenciaAcudiente(
			String telefonoResidenciaAcudiente) {
		this.telefonoResidenciaAcudiente = telefonoResidenciaAcudiente;
	}

	public String TelefonoComercialAcudiente() {
		return telefonoComercialAcudiente;
	}

	public void setTelefonoComercialAcudiente(String telefonoComercialAcudiente) {
		this.telefonoComercialAcudiente = telefonoComercialAcudiente;
	}

	public String getTelefonoCelularAcudiente() {
		return telefonoCelularAcudiente;
	}

	public void setTelefonoCelularAcudiente(String telefonoCelularAcudiente) {
		this.telefonoCelularAcudiente = telefonoCelularAcudiente;
	}

	public HtmlInputText getTxtCedulaAcudiente() {
		return txtCedulaAcudiente;
	}

	public void setTxtCedulaAcudiente(HtmlInputText txtCedulaAcudiente) {
		this.txtCedulaAcudiente = txtCedulaAcudiente;
	}

	public HtmlInputText getTxtNombre1Acudiente() {
		return txtNombre1Acudiente;
	}

	public void setTxtNombre1Acudiente(HtmlInputText txtNombre1Acudiente) {
		this.txtNombre1Acudiente = txtNombre1Acudiente;
	}

	public HtmlInputText getTxtNombre2Acudiente() {
		return txtNombre2Acudiente;
	}

	public void setTxtNombre2Acudiente(HtmlInputText txtNombre2Acudiente) {
		this.txtNombre2Acudiente = txtNombre2Acudiente;
	}

	public HtmlInputText getTxtApellido1Acudiente() {
		return txtApellido1Acudiente;
	}

	public void setTxtApellido1Acudiente(HtmlInputText txtApellido1Acudiente) {
		this.txtApellido1Acudiente = txtApellido1Acudiente;
	}

	public HtmlInputText getTxtApellido2Acudiente() {
		return txtApellido2Acudiente;
	}

	public void setTxtApellido2Acudiente(HtmlInputText txtApellido2Acudiente) {
		this.txtApellido2Acudiente = txtApellido2Acudiente;
	}

	public HtmlInputText getTxtTelefonoResidenciaAcudiente() {
		return txtTelefonoResidenciaAcudiente;
	}

	public void setTxtTelefonoResidenciaAcudiente(
			HtmlInputText txtTelefonoResidenciaAcudiente) {
		this.txtTelefonoResidenciaAcudiente = txtTelefonoResidenciaAcudiente;
	}

	public HtmlInputText getTxtTelefonoComercialAcudiente() {
		return txtTelefonoComercialAcudiente;
	}

	public void setTxtTelefonoComercialAcudiente(
			HtmlInputText txtTelefonoComercialAcudiente) {
		this.txtTelefonoComercialAcudiente = txtTelefonoComercialAcudiente;
	}

	public HtmlInputText getTxtTelefonoCelularAcudiente() {
		return txtTelefonoCelularAcudiente;
	}

	public void setTxtTelefonoCelularAcudiente(
			HtmlInputText txtTelefonoCelularAcudiente) {
		this.txtTelefonoCelularAcudiente = txtTelefonoCelularAcudiente;
	}

	public String getmensajes3() {
		return mensajes3;
	}

	public void setmensajes3(String mensajes3) {
		this.mensajes3 = mensajes3;
	}

	public HtmlCommandButton getBtnValidarEdad() {
		return btnValidarEdad;
	}

	public void setBtnValidarEdad(HtmlCommandButton btnValidarEdad) {
		this.btnValidarEdad = btnValidarEdad;
	}

	public String getCompartir() {
		return compartir;
	}

	public void setCompartir(String compartir) {
		pnl5Visible = (compartir.equals("SI")) ? true : false;
		this.compartir = compartir;
	}

	public String getTelefonoComercialAcudiente() {
		return telefonoComercialAcudiente;
	}

	public Long getTipoidacu() {
		return tipoidacu;
	}

	public void setTipoidacu(Long tipoidacu) {
		this.tipoidacu = tipoidacu;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public Long getTipoAsociado() {
		return tipoAsociado;
	}

	public void setTipoAsociado(Long tipoAsociado) {
		this.tipoAsociado = tipoAsociado;
	}

	public String getNumHorasDisp() {
		return numHorasDisp;
	}

	public void setNumHorasDisp(String numHorasDisp) {
		this.numHorasDisp = numHorasDisp;
	}

	public Long getCodigoAcudiente() {
		return codigoAcudiente;
	}

	public void setCodigoAcudiente(Long codigoAcudiente) {
		this.codigoAcudiente = codigoAcudiente;
	}

	public HtmlInputTextarea getTxtOtraPat() {
		return txtOtraPat;
	}

	public void setTxtOtraPat(HtmlInputTextarea txtOtraPat) {
		this.txtOtraPat = txtOtraPat;
	}

	public String getOtraPat() {
		return otraPat;
	}

	public void setOtraPat(String otraPat) {
		this.otraPat = otraPat;
	}

	public long getNumint() {
		return numint;
	}

	public void setNumint(long numint) {
		this.numint = numint;
	}

	public long getNumintacu() {
		return numintacu;
	}

	public void setNumintacu(long numintacu) {
		this.numintacu = numintacu;
	}

	public Integer getNum_cuotas_vencidas() {
		return num_cuotas_vencidas;
	}

	public void setNum_cuotas_vencidas(Integer num_cuotas_vencidas) {
		this.num_cuotas_vencidas = num_cuotas_vencidas;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getOtroHob() {
		return otroHob;
	}

	public void setOtroHob(String otroHob) {
		this.otroHob = otroHob;
	}

	public HtmlInputTextarea getTxtOtroHob() {
		return txtOtroHob;
	}

	public void setTxtOtroHob(HtmlInputTextarea txtOtroHob) {
		this.txtOtroHob = txtOtroHob;
	}

	public String getOtroServicio() {
		return otroServicio;
	}

	public void setOtroServicio(String otroServicio) {
		this.otroServicio = otroServicio;
	}

	public HtmlInputTextarea getTxtOtroServicio() {
		return txtOtroServicio;
	}

	public void setTxtOtroServicio(HtmlInputTextarea txtOtroServicio) {
		this.txtOtroServicio = txtOtroServicio;
	}

	public HtmlInputTextarea getTxtOtroCon() {
		return txtOtroCon;
	}

	public void setTxtOtroCon(HtmlInputTextarea txtOtroCon) {
		this.txtOtroCon = txtOtroCon;
	}

	public String getOtroCon() {
		return otroCon;
	}

	public void setOtroCon(String otroCon) {
		this.otroCon = otroCon;
	}

	public Long getCorte() {
		return corte;
	}

	public void setCorte(Long corte) {
		this.corte = corte;
	}

	public void setTxtEstadoCivil(HtmlSelectOneMenu txtEstadoCivil) {
		this.txtEstadoCivil = txtEstadoCivil;
	}

	public HtmlSelectOneMenu getTxtEstadoCivil() {
		return txtEstadoCivil;
	}

	public HtmlInputText getTxtDirResidencia() {
		return txtDirResidencia;
	}

	public void setTxtDirResidencia(HtmlInputText txtDirResidencia) {
		this.txtDirResidencia = txtDirResidencia;
	}

	public HtmlCommandButton getBtnCiuRes() {
		return btnCiuRes;
	}

	public void setBtnCiuRes(HtmlCommandButton btnCiuRes) {
		this.btnCiuRes = btnCiuRes;
	}

	public HtmlCommandButton getBtnCiuCom() {
		return btnCiuCom;
	}

	public void setBtnCiuCom(HtmlCommandButton btnCiuCom) {
		this.btnCiuCom = btnCiuCom;
	}

	public HtmlInputText getTxtTextoCiudadesRes() {
		return txtTextoCiudadesRes;
	}

	public void setTxtTextoCiudadesRes(HtmlInputText txtTextoCiudadesRes) {
		this.txtTextoCiudadesRes = txtTextoCiudadesRes;
	}

	public HtmlInputText getTxtTextoCiudadesCom() {
		return txtTextoCiudadesCom;
	}

	public void setTxtTextoCiudadesCom(HtmlInputText txtTextoCiudadesCom) {
		this.txtTextoCiudadesCom = txtTextoCiudadesCom;
	}

	public HtmlSelectOneMenu getTxtTituloProfesional() {
		return txtTituloProfesional;
	}

	public void setTxtTituloProfesional(HtmlSelectOneMenu txtTituloProfesional) {
		this.txtTituloProfesional = txtTituloProfesional;
	}

	public HtmlSelectOneMenu getTxtOcupacion() {
		return txtOcupacion;
	}

	public void setTxtOcupacion(HtmlSelectOneMenu txtOcupacion) {
		this.txtOcupacion = txtOcupacion;
	}

	public HtmlSelectOneMenu getTxtcodigoCorte() {
		return txtcodigoCorte;
	}

	public void setTxtcodigoCorte(HtmlSelectOneMenu txtcodigoCorte) {
		this.txtcodigoCorte = txtcodigoCorte;
	}

	public boolean isPnl2Visible() {
		return pnl2Visible;
	}

	public void setPnl2Visible(boolean pnl2Visible) {
		this.pnl2Visible = pnl2Visible;
	}

	public boolean isPnl5Visible() {
		return pnl5Visible;
	}

	public void setPnl5Visible(boolean pnl5Visible) {
		this.pnl5Visible = pnl5Visible;
	}

	public String getCiuRes() {
		return ciuRes;
	}

	public void setCiuRes(String ciuRes) {
		this.ciuRes = ciuRes;
	}

	public Integer[] getSelectedPAMS() {
		return selectedPAMS;
	}

	public void setSelectedPAMS(Integer[] selectedPAMS) {
		this.selectedPAMS = selectedPAMS;
	}

	public Integer[] getSelectedPatologias() {
		return selectedPatologias;
	}

	public void setSelectedPatologias(Integer[] selectedPatologias) {
		this.selectedPatologias = selectedPatologias;
	}

	public Integer[] getSelectedHobbies() {
		return selectedHobbies;
	}

	public void setSelectedHobbies(Integer[] selectedHobbies) {
		this.selectedHobbies = selectedHobbies;
	}

	public Integer[] getSelectedServMedico() {
		return selectedServMedico;
	}

	public void setSelectedServMedico(Integer[] selectedServMedico) {
		this.selectedServMedico = selectedServMedico;
	}

	public Integer[] getSelectedServOfrecer() {
		return selectedServOfrecer;
	}

	public void setSelectedServOfrecer(Integer[] selectedServOfrecer) {
		this.selectedServOfrecer = selectedServOfrecer;
	}

	public String getSelectorDestination() {
		return selectorDestination;
	}

	public void setSelectorDestination(String selectorDestination) {
		this.selectorDestination = selectorDestination;
	}

	public Integer[] getSelectedConocimientos() {
		return selectedConocimientos;
	}

	public void setSelectedConocimientos(Integer[] selectedConocimientos) {
		this.selectedConocimientos = selectedConocimientos;
	}

	public HtmlInputText getTxtNumHorasDisp() {
		return txtNumHorasDisp;
	}

	public void setTxtNumHorasDisp(HtmlInputText txtNumHorasDisp) {
		this.txtNumHorasDisp = txtNumHorasDisp;
	}

	public void showException(Exception ex) {
		FacesMessage msg = new FacesMessage(ex.getMessage());
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

	public String getHdeUsuario() {
		return hdeUsuario;
	}

	public void setHdeUsuario(String hdeUsuario) {
		this.hdeUsuario = hdeUsuario;
	}

	public Long getHddCiudadComercial() {
		return hddCiudadComercial;
	}

	public void setHddCiudadComercial(Long hddCiudadComercial) {
		this.hddCiudadComercial = hddCiudadComercial;
	}

	public Long getHddCiudadResidencia() {
		return hddCiudadResidencia;
	}

	public void setHddCiudadResidencia(Long hddCiudadResidencia) {
		this.hddCiudadResidencia = hddCiudadResidencia;
	}

}
