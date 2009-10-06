package co.com.vep.vista;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;

import co.com.coomeva.profile.ws.client.CaasStub.Role;
import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.logica.IProgramacionActividad;
import co.com.vep.logica.ProgramacionActividadesLogica;
import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorPlusBuc;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSitio;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.StringUtils;
import co.com.vep.util.validadorHora;
import co.com.vep.util.validadorMinutos;
import co.com.vep.util.validadorNumerico;

public class VistaProgramacionActividad {

	private Integer codigoActividad;
	private String nombreActividad;
	private String codigoGrupo;
	private Date fechaInicio;
	private Date fechaFinal;
	private String horaInicio;
	private String minutoInicio;
	private String horaTermina;
	private String minutoTermina;
	private String identificacionProfesor;
	private String nombreProfesor;
	private Integer codigoLugar;
	private String nombreLugar;
	private String nombreSitio;
	private String direccion;
	private String ciudad;
	private TimeZone timeZone;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;
	private String nivel;
	private String selectedEstado;
	private String cupoMinimo;
	private String cupoMaximo;
	private Long regional;
	private Long tipoId;

	private List<VepProgramacion> listProgramacion = new ArrayList<VepProgramacion>();
	private List<VepProgramacion> listProgramacion1 = new ArrayList<VepProgramacion>();

	private List<VepSipParametro> listaEstados;
	private List<VepLugar> listaLugares;
	private List<VepParametroActividad> listaActividades;

	private SelectItem[] tipoEstados;
	private SelectItem[] tipoLugares;
	private SelectItem[] tipoActividad;

	private HtmlInputText txtCupoMinimo;
	private HtmlInputText txtCupoMaximo;
	private HtmlInputText txtNivel;
	private HtmlInputText txtIdentificacionProfesor;
	private HtmlInputText txtHoraInicio;
	private HtmlInputText txtMinutoInicio;
	private HtmlInputText txtHoraTermina;
	private HtmlInputText txtMinutoTermina;

	private IProgramacionActividad programacion;
	private List<VepParametroActividad> parametro = new ArrayList<VepParametroActividad>();
	private List<VepProgramacion> listProfesorProgramado;
	AsociadoVida asociado;
	VepProfesor profesorPlus;

	public VistaProgramacionActividad() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("ProgramarActividad")) {
				try {
					Long idRegional = (Long) Session
							.getSessionAttribute("userRegional");
					if (idRegional != null) {
						setRegional(idRegional);
					} else
						throw new Exception(MessageBundleLoader
								.getMessage("labels.consexp.exception3"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {
		txtCupoMinimo = new HtmlInputText();
		txtCupoMinimo.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.cupoMinimo"), true));
		txtCupoMinimo.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCupoMinimo.validate(FacesContext.getCurrentInstance());
			}
		});

		txtCupoMaximo = new HtmlInputText();
		txtCupoMaximo.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.cupoMaximo"), true));
		txtCupoMaximo.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCupoMaximo.validate(FacesContext.getCurrentInstance());
			}
		});

		txtNivel = new HtmlInputText();
		txtNivel.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.nivel"), true));
		txtNivel.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtNivel.validate(FacesContext.getCurrentInstance());
			}
		});

		txtIdentificacionProfesor = new HtmlInputText();
		txtIdentificacionProfesor
				.addValidator(new validadorNumerico(MessageBundleLoader
						.getMessage("labels.identificacionProfesor"), true));
		txtIdentificacionProfesor
				.addValueChangeListener(new ValueChangeListener() {
					public void processValueChange(ValueChangeEvent arg0)
							throws AbortProcessingException {
						txtIdentificacionProfesor.validate(FacesContext
								.getCurrentInstance());
					}
				});

		txtHoraInicio = new HtmlInputText();
		txtHoraInicio.addValidator(new validadorHora(MessageBundleLoader
				.getMessage("labels.horaInicial"), true));
		txtHoraInicio.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtHoraInicio.validate(FacesContext.getCurrentInstance());
			}
		});

		txtMinutoInicio = new HtmlInputText();
		txtMinutoInicio.addValidator(new validadorMinutos(MessageBundleLoader
				.getMessage("labels.horaInicial"), true));
		txtMinutoInicio.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtMinutoInicio.validate(FacesContext.getCurrentInstance());
			}
		});

		txtHoraTermina = new HtmlInputText();
		txtHoraTermina.addValidator(new validadorHora(MessageBundleLoader
				.getMessage("labels.horaFinal"), true));
		txtHoraTermina.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtHoraTermina.validate(FacesContext.getCurrentInstance());
			}
		});

		txtMinutoTermina = new HtmlInputText();
		txtMinutoTermina.addValidator(new validadorMinutos(MessageBundleLoader
				.getMessage("labels.horaFinal"), true));
		txtMinutoTermina.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtMinutoTermina.validate(FacesContext.getCurrentInstance());
			}
		});
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

	/**
	 * @return the nombreActividad
	 */
	public String getNombreActividad() {
		return nombreActividad;
	}

	/**
	 * @param nombreActividad
	 *            the nombreActividad to set
	 */
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	/**
	 * @return the codigoGrupo
	 */
	public String getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * @param codigoGrupo
	 *            the codigoGrupo to set
	 */
	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal
	 *            the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio
	 *            the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaTermina
	 */
	public String getHoraTermina() {
		return horaTermina;
	}

	/**
	 * @param horaTermina
	 *            the horaTermina to set
	 */
	public void setHoraTermina(String horaTermina) {
		this.horaTermina = horaTermina;
	}

	/**
	 * @return the minutoInicio
	 */
	public String getMinutoInicio() {
		return minutoInicio;
	}

	/**
	 * @param minutoInicio
	 *            the minutoInicio to set
	 */
	public void setMinutoInicio(String minutoInicio) {
		this.minutoInicio = minutoInicio;
	}

	/**
	 * @return the minutoTermina
	 */
	public String getMinutoTermina() {
		return minutoTermina;
	}

	/**
	 * @param minutoTermina
	 *            the minutoTermina to set
	 */
	public void setMinutoTermina(String minutoTermina) {
		this.minutoTermina = minutoTermina;
	}

	/**
	 * @return the identificacionProfesor
	 */
	public String getIdentificacionProfesor() {
		return identificacionProfesor;
	}

	/**
	 * @param identificacionProfesor
	 *            the identificacionProfesor to set
	 */
	public void setIdentificacionProfesor(String identificacionProfesor) {
		this.identificacionProfesor = identificacionProfesor;
	}

	/**
	 * @return the nombreProfesor
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}

	/**
	 * @param nombreProfesor
	 *            the nombreProfesor to set
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	/**
	 * @return the codigoLugar
	 */
	public Integer getCodigoLugar() {
		return codigoLugar;
	}

	/**
	 * @param codigoLugar
	 *            the codigoLugar to set
	 */
	public void setCodigoLugar(Integer codigoLugar) {
		this.codigoLugar = codigoLugar;
	}

	/**
	 * @return the nombreLugar
	 */
	public String getNombreLugar() {
		return nombreLugar;
	}

	/**
	 * @param nombreLugar
	 *            the nombreLugar to set
	 */
	public void setNombreLugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
	}

	/**
	 * @return the nombreSitio
	 */
	public String getNombreSitio() {
		return nombreSitio;
	}

	/**
	 * @param nombreSitio
	 *            the nombreSitio to set
	 */
	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad
	 *            the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
	 * @return the listProgramacion
	 */
	public List<VepProgramacion> getListProgramacion() {
		return listProgramacion;
	}

	/**
	 * @param listProgramacion
	 *            the listProgramacion to set
	 */
	public void setListProgramacion(List<VepProgramacion> listProgramacion) {
		this.listProgramacion = listProgramacion;
	}

	public List<VepProgramacion> getListProgramacion1() {
		return listProgramacion1;
	}

	public void setListProgramacion1(List<VepProgramacion> listProgramacion1) {
		this.listProgramacion1 = listProgramacion1;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel
	 *            the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the selectedEstado
	 */
	public String getSelectedEstado() {
		return selectedEstado;
	}

	/**
	 * @param selectedEstado
	 *            the selectedEstado to set
	 */
	public void setSelectedEstado(String selectedEstado) {
		this.selectedEstado = selectedEstado;
	}

	/**
	 * @return the getListaEstados
	 */
	public List<VepSipParametro> getListaEstados() {
		programacion = new ProgramacionActividadesLogica();
		if (listaEstados == null) {
			try {
				listaEstados = programacion.findListEstados(
						"vepSipparametroTipo.codTipo", 39);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaEstados;
	}

	/**
	 * @param getListaEstados
	 *            the getListaEstados to set
	 */
	public void setListaEstados(List<VepSipParametro> listaEstados) {
		this.listaEstados = listaEstados;
	}

	/**
	 * @return the listaLugares
	 */
	public List<VepLugar> getListaLugares() {
		programacion = new ProgramacionActividadesLogica();
		if (listaLugares == null) {
			try {
				listaLugares = programacion.findLugar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaLugares;
	}

	/**
	 * @param listaLugares
	 *            the listaLugares to set
	 */
	public void setListaLugares(List<VepLugar> listaLugares) {
		this.listaLugares = listaLugares;
	}

	/**
	 * @return the listaActividades
	 */
	public List<VepParametroActividad> getListaActividades() {
		programacion = new ProgramacionActividadesLogica();
		if (listaActividades == null) {
			try {
				listaActividades = programacion.findParametroActividad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaActividades;
	}

	/**
	 * @param listaActividades
	 *            the listaActividades to set
	 */
	public void setListaActividades(List<VepParametroActividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	/**
	 * @return the tipoEstados
	 */
	public SelectItem[] getTipoEstados() {
		if (tipoEstados == null) {
			try {
				listaEstados = getListaEstados();
				tipoEstados = new SelectItem[listaEstados.size() + 1];
				tipoEstados[0] = new SelectItem("-1", "--Seleccionar--");
				int i = 1;
				for (VepSipParametro tipos : listaEstados) {
					tipoEstados[i] = new SelectItem(tipos.getNombre(), tipos
							.getNombre());
					i++;
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return tipoEstados;
	}

	/**
	 * @param tipoEstados
	 *            the tipoEstados to set
	 */
	public void setTipoEstados(SelectItem[] tipoEstados) {
		this.tipoEstados = tipoEstados;
	}

	/**
	 * @return the tipoLugares
	 */
	public SelectItem[] getTipoLugares() {
		if (tipoLugares == null) {
			try {
				listaLugares = getListaLugares();
				tipoLugares = new SelectItem[listaLugares.size() + 1];
				tipoLugares[0] = new SelectItem(new Integer(0),
						"--Seleccionar--");
				int i = 1;
				for (VepLugar lugar : listaLugares) {
					tipoLugares[i] = new SelectItem(lugar.getIdLugar(), lugar
							.getNombre());
					i++;
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return tipoLugares;
	}

	/**
	 * @param tipoLugares
	 *            the tipoLugares to set
	 */
	public void setTipoLugares(SelectItem[] tipoLugares) {
		this.tipoLugares = tipoLugares;
	}

	/**
	 * @return the tipoActividad
	 */
	public SelectItem[] getTipoActividad() {
		if (tipoActividad == null) {
			try {
				listaActividades = getListaActividades();
				tipoActividad = new SelectItem[listaActividades.size() + 1];
				tipoActividad[0] = new SelectItem(new Integer(0),
						"--Seleccionar--");
				int i = 1;
				for (VepParametroActividad actividad : listaActividades) {
					tipoActividad[i] = new SelectItem(actividad
							.getIdActividadpar(), actividad.getNombre());
					i++;
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return tipoActividad;
	}

	/**
	 * @param tipoActividad
	 *            the tipoActividad to set
	 */
	public void setTipoActividad(SelectItem[] tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	/**
	 * @return the cupoMinimo
	 */
	public String getCupoMinimo() {
		return cupoMinimo;
	}

	/**
	 * @param cupoMinimo
	 *            the cupoMinimo to set
	 */
	public void setCupoMinimo(String cupoMinimo) {
		this.cupoMinimo = cupoMinimo;
	}

	/**
	 * @return the cupoMaximo
	 */
	public String getCupoMaximo() {
		return cupoMaximo;
	}

	/**
	 * @param cupoMaximo
	 *            the cupoMaximo to set
	 */
	public void setCupoMaximo(String cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void action_consultarGrupo(ActionEvent ae) {
		programacion = new ProgramacionActividadesLogica();
		try {
			listProgramacion = programacion.findProgramacionGrupo(codigoGrupo
					.toUpperCase());
			if (listProgramacion.size() != 0) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoProgramacion.excepcion2");
				toggleModal(ae);
				codigoGrupo = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_consultarProfesor(ActionEvent ae) {
		programacion = new ProgramacionActividadesLogica();

		try {
			if (identificacionProfesor != null) {
				profesorPlus = programacion.findProfesor(tipoId, Long
						.valueOf(identificacionProfesor));
				if (profesorPlus.getId() == null) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpoProgramacion.excepcion3");
					toggleModal(ae);
				} else {
					setNombreProfesor(profesorPlus.getNombre1().toUpperCase()
							+ " " + profesorPlus.getNombre2().toUpperCase()
							+ " " + profesorPlus.getApellido1().toUpperCase()
							+ " " + profesorPlus.getApellido2().toUpperCase());
					setListProfesorProgramado(programacion.programadasProfesor(
							profesorPlus.getId().getTipoId(), profesorPlus
									.getId().getIdProfesor()));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_onChangeLugar(ValueChangeEvent vce) {
		programacion = new ProgramacionActividadesLogica();
		VepLugar lugar = new VepLugar();
		VepSitio sitio = new VepSitio();
		codigoLugar = (Integer) vce.getNewValue();

		try {
			lugar = programacion.findLugarSitio(codigoLugar);
			if (lugar != null) {
				setNombreLugar(lugar.getNombre());
				sitio = lugar.getVepSitio();
				setNombreSitio(sitio.getNombre());
				setDireccion(sitio.getDireccion());
				setCiudad(programacion.buscarCiudadxCodigo(sitio.getCiudad()));
			} else {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion5");
				limpiarLugar();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings( { "static-access", "deprecation" })
	public void action_registrarProgramacion(ActionEvent ae) {
		programacion = new ProgramacionActividadesLogica();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		List<VepProgramacion> listaProfesorPro = new ArrayList<VepProgramacion>();
		listaProfesorPro = getListProfesorProgramado();
		int flagHoras = 0;

		if (codigoActividad.equals(0)) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion8");
			toggleModal(ae);
			flagHoras = 1;
		} else if (codigoGrupo.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion9");
			toggleModal(ae);
			flagHoras = 1;
		} else if (identificacionProfesor.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion10");
			toggleModal(ae);
			flagHoras = 1;
		} else if (tipoId == null || tipoId.equals(new Long(-1))) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion18");
			toggleModal(ae);
			flagHoras = 1;
		} else if (profesorPlus == null) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion12");
			toggleModal(ae);
			flagHoras = 1;
		} else if (codigoLugar.equals(0)) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion11");
			toggleModal(ae);
			flagHoras = 1;
		} else if (cupoMinimo.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion16");
			toggleModal(ae);
			flagHoras = 1;
		} else if (cupoMaximo.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion17");
			toggleModal(ae);
			flagHoras = 1;
		} else if (fechaInicio == null) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion14");
			toggleModal(ae);
			flagHoras = 1;
		} else if (fechaFinal == null) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion15");
			toggleModal(ae);
			flagHoras = 1;
		} else if (horaInicio.equals("") || minutoInicio.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion6");
			toggleModal(ae);
			flagHoras = 1;
		} else if (horaTermina.equals("") || minutoTermina.equals("")) {
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.excepcion7");
			toggleModal(ae);
			flagHoras = 1;
		} else if (flagHoras == 0) {
			long minimo = Long.parseLong(cupoMinimo);
			long maximo = Long.parseLong(cupoMaximo);

			// try {
			// fechaInicio = formato.parse(formato.format(fechaInicio));
			// fechaFinal = formato.parse(formato.format(fechaFinal));
			// } catch (ParseException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			// message = MessageBundleLoader
			// .getMessage("labels.cuerpoProgramacion.excepcion21");
			// toggleModal(ae);
			// }

			long fechaStart = fechaInicio.getTime();
			long fechaEnd = fechaFinal.getTime();

			long l = Long.parseLong(horaInicio);
			long l2 = Long.parseLong(minutoInicio);
			long re = l * 3600000;
			long re2 = l2 * 60000;
			long re3 = fechaInicio.getTime() + re + re2;
			// Time horaIni = new Time(re3);
			Timestamp horaIni = new Timestamp(re3);

			long m = Long.parseLong(horaTermina);
			long m2 = Long.parseLong(minutoTermina);
			long se = m * 3600000;
			long se2 = m2 * 60000;
			long se3 = fechaInicio.getTime() + se + se2;
			// Time horaFin = new Time(se3);
			Timestamp horaFin = new Timestamp(se3);

			long fechaActual = new Date().getTime();

			try {
				if ((se + se2) <= (re + re2)) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpoProgramacion.excepcion4");
					toggleModal(ae);
				} else if (fechaEnd < fechaStart) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpoProgramacion.excepcion13");
					toggleModal(ae);
				} else if (listProgramacion.size() != 0) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpoProgramacion.excepcion2");
					toggleModal(ae);
					codigoGrupo = null;
				} else if (minimo <= 0) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpo.excepcion3");
					toggleModal(ae);
				} else if (maximo < minimo) {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpo.excepcion4");
					toggleModal(ae);
				} else {
					try {
						listProgramacion1 = programacion
								.findProgramacionGrupo(codigoGrupo
										.toUpperCase());
						if (listProgramacion1.size() != 0) {
							messageTittle = MessageBundleLoader
									.getMessage("labels.titulo");
							message = MessageBundleLoader
									.getMessage("labels.cuerpoProgramacion.excepcion2");
							toggleModal(ae);
							codigoGrupo = null;
							listProgramacion1 = null;
						} else if (listaProfesorPro.size() != 0) {

							try {
								for (VepProgramacion vepProgramacion : listaProfesorPro) {

									StringUtils.validarCruceHorarios(
											fechaInicio, fechaFinal,
											vepProgramacion, horaIni, horaFin,
											"ProgramacionActividades");
								}
								if (fechaInicio.getTime() <= fechaActual
										|| fechaFinal.getTime() <= fechaActual) {
									if (!selectedEstado
											.equals("Estado Terminado (T)")) {
										messageTittle = MessageBundleLoader
												.getMessage("labels.titulo");
										message = MessageBundleLoader
												.getMessage("labels.cuerpoProgramacion.excepcion19");
										toggleModal(ae);
									} else {
										this
												.registrarProgramacion(
														codigoActividad,
														codigoGrupo
																.toUpperCase(),
														fechaInicio,
														fechaFinal,
														horaIni,
														horaFin,
														nivel,
														selectedEstado,
														tipoId,
														Long
																.valueOf(identificacionProfesor),
														codigoLugar,
														Long
																.parseLong(cupoMinimo),
														Long
																.parseLong(cupoMaximo),
														getRegional());
									}
								} else {
									this
											.registrarProgramacion(
													codigoActividad,
													codigoGrupo.toUpperCase(),
													fechaInicio,
													fechaFinal,
													horaIni,
													horaFin,
													nivel,
													selectedEstado,
													tipoId,
													Long
															.valueOf(identificacionProfesor),
													codigoLugar,
													Long.parseLong(cupoMinimo),
													Long.parseLong(cupoMaximo),
													getRegional());
								}
							} catch (Exception e) {
								// TODO: handle exception
								showException(e.getMessage());
							}
						} else if (fechaInicio.getTime() <= fechaActual
								|| fechaFinal.getTime() <= fechaActual) {
							if (!selectedEstado.equals("Estado Terminado (T)")) {
								messageTittle = MessageBundleLoader
										.getMessage("labels.titulo");
								message = MessageBundleLoader
										.getMessage("labels.cuerpoProgramacion.excepcion19");
								toggleModal(ae);
							} else {
								this.registrarProgramacion(codigoActividad,
										codigoGrupo.toUpperCase(), fechaInicio,
										fechaFinal, horaIni, horaFin, nivel,
										selectedEstado, tipoId,
										Long.valueOf(identificacionProfesor),
										codigoLugar,
										Long.parseLong(cupoMinimo), Long
												.parseLong(cupoMaximo),
										getRegional());
							}
						} else {
							this.registrarProgramacion(codigoActividad,
									codigoGrupo.toUpperCase(), fechaInicio,
									fechaFinal, horaIni, horaFin, nivel,
									selectedEstado, tipoId, Long
											.valueOf(identificacionProfesor),
									codigoLugar, Long.parseLong(cupoMinimo),
									Long.parseLong(cupoMaximo), getRegional());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void limpiarLugar() {
		codigoLugar = null;
		nombreLugar = null;
		nombreSitio = null;
		direccion = null;
		ciudad = null;
	}

	public void registrarProgramacion(Integer codigoActividad,
			String codigoGrupo, Date fechaInicio, Date fechaFinal,
			Timestamp horaIni, Timestamp horaFin, String nivel,
			String selectedEstado, Long tipoId, Long identificacionProfesor,
			Integer codigoLugar, long cupoMinimo, long cupoMaximo,
			Long getRegional) {

		programacion = new ProgramacionActividadesLogica();

		try {
			programacion.registrarProgramacion(codigoActividad, codigoGrupo,
					fechaInicio, fechaFinal, horaIni, horaFin, nivel,
					selectedEstado, tipoId, identificacionProfesor,
					codigoLugar, cupoMinimo, cupoMaximo, getRegional);
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoProgramacion.mensajeRegistrado");
			toggleModal();
			this.limpiarCampos();
			this.limpiarLugar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showException(String msg) {
		messageTittle = MessageBundleLoader.getMessage("labels.titulo");
		message = msg;
		toggleModal();
	}

	public void limpiarCampos() {
		codigoActividad = null;
		nombreActividad = null;
		codigoGrupo = null;
		fechaInicio = null;
		fechaFinal = null;
		horaInicio = null;
		minutoInicio = null;
		horaTermina = null;
		minutoTermina = null;
		nivel = null;
		selectedEstado = null;
		cupoMinimo = null;
		cupoMaximo = null;
		identificacionProfesor = null;
		nombreProfesor = null;
		tipoId = new Long(-1);
	}

	public Long getRegional() {
		return regional;
	}

	public void setRegional(Long regional) {
		this.regional = regional;
	}

	public HtmlInputText getTxtCupoMinimo() {
		return txtCupoMinimo;
	}

	public void setTxtCupoMinimo(HtmlInputText txtCupoMinimo) {
		this.txtCupoMinimo = txtCupoMinimo;
	}

	public HtmlInputText getTxtCupoMaximo() {
		return txtCupoMaximo;
	}

	public void setTxtCupoMaximo(HtmlInputText txtCupoMaximo) {
		this.txtCupoMaximo = txtCupoMaximo;
	}

	public HtmlInputText getTxtNivel() {
		return txtNivel;
	}

	public void setTxtNivel(HtmlInputText txtNivel) {
		this.txtNivel = txtNivel;
	}

	public HtmlInputText getTxtIdentificacionProfesor() {
		return txtIdentificacionProfesor;
	}

	public void setTxtIdentificacionProfesor(
			HtmlInputText txtIdentificacionProfesor) {
		this.txtIdentificacionProfesor = txtIdentificacionProfesor;
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	public List<VepProgramacion> getListProfesorProgramado() {
		return listProfesorProgramado;
	}

	public void setListProfesorProgramado(
			List<VepProgramacion> listProfesorProgramado) {
		this.listProfesorProgramado = listProfesorProgramado;
	}

	public HtmlInputText getTxtHoraInicio() {
		return txtHoraInicio;
	}

	public void setTxtHoraInicio(HtmlInputText txtHoraInicio) {
		this.txtHoraInicio = txtHoraInicio;
	}

	public HtmlInputText getTxtMinutoInicio() {
		return txtMinutoInicio;
	}

	public void setTxtMinutoInicio(HtmlInputText txtMinutoInicio) {
		this.txtMinutoInicio = txtMinutoInicio;
	}

	public HtmlInputText getTxtHoraTermina() {
		return txtHoraTermina;
	}

	public void setTxtHoraTermina(HtmlInputText txtHoraTermina) {
		this.txtHoraTermina = txtHoraTermina;
	}

	public HtmlInputText getTxtMinutoTermina() {
		return txtMinutoTermina;
	}

	public void setTxtMinutoTermina(HtmlInputText txtMinutoTermina) {
		this.txtMinutoTermina = txtMinutoTermina;
	}
}
