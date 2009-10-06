package co.com.vep.vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.IInscripcionActividades;
import co.com.vep.logica.InscripcionActividadesLogica;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipParametroWork;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.StringUtils;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;

public class VistaInscripcionActividades {

	private String identificacion;
	private String nombreActividad;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String genero;
	private long codigoAsociado;
	private String asociadoCooperativa;
	private String estadoAsociado;
	private String fechaEstado;
	private Integer cuotasVencidas;
	private String fechaIngresoAsociado;
	private String codigoCorte;
	private String fechaIngresoVEP;
	private String tipoInscrito;
	private String estadoCivil;
	private String ocupacion;
	private String tituloProfesional;
	private String codigoGrupo;
	private Integer codigoActividad;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;
	private String estadoActividad;

	private SelectItem[] tipoIdentificacion;

	private long selectedTipoDocumento;
	AsociadoVida asociado = null;

	private Parametros[] parametros;

	private HtmlInputText txtCedula;

	private IInscripcionActividades inscripcion;
	private List<VepSipParametro> listActividades;
	private VepSipParametroWork[] selectedActividades;
	private VepSipParametroWork[] parametroWork;
	private List<VepParametroActividad> listParametroActividad = new ArrayList<VepParametroActividad>();
	private VepProgramacion progra = new VepProgramacion();
	VepAsociado vepAsociado = new VepAsociado();

	public VistaInscripcionActividades() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("InscribirActividad")) {
				// Permitirle ingresar
				initializeComponent();
			}
		}
	}

	private HtmlPanelGrid panel1;
	private HtmlPanelGrid panel2;
	private HtmlPanelGrid panel3;
	private HtmlPanelGrid panel4;
	private HtmlPanelGrid panel5;

	private void initializeComponent() {

		txtCedula = new HtmlInputText();
		txtCedula.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.numero"), true));
		txtCedula.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCedula.validate(FacesContext.getCurrentInstance());
			}
		});
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param nombreActividad
	 *            the nombreActividad to set
	 */
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	/**
	 * @return the nombreActividad
	 */
	public String getNombreActividad() {
		return nombreActividad;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre1() {
		return nombre1;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}

	/**
	 * @param nombre2
	 *            the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1
	 *            the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2
	 *            the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the codigoAsociado
	 */
	public long getCodigoAsociado() {
		return codigoAsociado;
	}

	/**
	 * @param codigoAsociado
	 *            the codigoAsociado to set
	 */
	public void setCodigoAsociado(long codigoAsociado) {
		this.codigoAsociado = codigoAsociado;
	}

	/**
	 * @return the asociadoCooperativa
	 */
	public String getAsociadoCooperativa() {
		return asociadoCooperativa;
	}

	/**
	 * @param asociadoCooperativa
	 *            the asociadoCooperativa to set
	 */
	public void setAsociadoCooperativa(String asociadoCooperativa) {
		this.asociadoCooperativa = asociadoCooperativa;
	}

	/**
	 * @return the estadoAsociado
	 */
	public String getEstadoAsociado() {
		return estadoAsociado;
	}

	/**
	 * @param estadoAsociado
	 *            the estadoAsociado to set
	 */
	public void setEstadoAsociado(String estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}

	/**
	 * @return the fechaEstado
	 */
	public String getFechaEstado() {
		return fechaEstado;
	}

	/**
	 * @param fechaEstado
	 *            the fechaEstado to set
	 */
	public void setFechaEstado(String fechaEstado) {
		this.fechaEstado = fechaEstado;
	}

	/**
	 * @return the cuotasVencidas
	 */
	public Integer getCuotasVencidas() {
		return cuotasVencidas;
	}

	/**
	 * @param cuotasVencidas
	 *            the cuotasVencidas to set
	 */
	public void setCuotasVencidas(Integer cuotasVencidas) {
		this.cuotasVencidas = cuotasVencidas;
	}

	/**
	 * @return the fechaIngresoAsociado
	 */
	public String getFechaIngresoAsociado() {
		return fechaIngresoAsociado;
	}

	/**
	 * @param fechaIngresoAsociado
	 *            the fechaIngresoAsociado to set
	 */
	public void setFechaIngresoAsociado(String fechaIngresoAsociado) {
		this.fechaIngresoAsociado = fechaIngresoAsociado;
	}

	/**
	 * @return the codigoCorte
	 */
	public String getCodigoCorte() {
		return codigoCorte;
	}

	/**
	 * @param codigoCorte
	 *            the codigoCorte to set
	 */
	public void setCodigoCorte(String codigoCorte) {
		this.codigoCorte = codigoCorte;
	}

	/**
	 * @return the fechaIngresoVEP
	 */
	public String getFechaIngresoVEP() {
		return fechaIngresoVEP;
	}

	/**
	 * @param fechaIngresoVEP
	 *            the fechaIngresoVEP to set
	 */
	public void setFechaIngresoVEP(String fechaIngresoVEP) {
		this.fechaIngresoVEP = fechaIngresoVEP;
	}

	/**
	 * @return the tipoInscrito
	 */
	public String getTipoInscrito() {
		return tipoInscrito;
	}

	/**
	 * @param tipoInscrito
	 *            the tipoInscrito to set
	 */
	public void setTipoInscrito(String tipoInscrito) {
		this.tipoInscrito = tipoInscrito;
	}

	/**
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil
	 *            the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion
	 *            the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the tituloProfesional
	 */
	public String getTituloProfesional() {
		return tituloProfesional;
	}

	/**
	 * @param tituloProfesional
	 *            the tituloProfesional to set
	 */
	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	/**
	 * @return the inscripcion
	 */
	public IInscripcionActividades getInscripcion() {
		return inscripcion;
	}

	/**
	 * @param inscripcion
	 *            the inscripcion to set
	 */
	public void setInscripcion(IInscripcionActividades inscripcion) {
		this.inscripcion = inscripcion;
	}

	/**
	 * @return the listActividades
	 */
	public List<VepSipParametro> getListActividades() {
		inscripcion = new InscripcionActividadesLogica();
		if (listActividades == null) {
			try {
				listActividades = inscripcion.findActividad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listActividades;
	}

	/**
	 * @param listActividades
	 *            the listActividades to set
	 */
	public void setListActividades(List<VepSipParametro> listActividades) {
		this.listActividades = listActividades;
	}

	/**
	 * @param selectedActividades
	 *            the selectedActividades to set
	 */
	public void setSelectedActividades(VepSipParametroWork[] selectedActividades) {
		this.selectedActividades = selectedActividades;
	}

	/**
	 * @return the selectedActividades
	 */
	public VepSipParametroWork[] getSelectedActividades() {
		return selectedActividades;
	}

	/**
	 * @param parametroWork
	 *            the parametroWork to set
	 */
	public void setParametroWork(VepSipParametroWork[] parametroWork) {
		this.parametroWork = parametroWork;
	}

	/**
	 * @return the parametroWork
	 */
	public VepSipParametroWork[] getParametroWork() {

		// inscripcion = new InscripcionActividadesLogica();
		// if (parametroWork == null) {
		// try {
		// parametroWork = inscripcion.findActividadSelectedRow();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		return parametroWork;
	}

	/**
	 * @return the tipoIdentificacion
	 */
	public SelectItem[] getTipoIdentificacion() {
		if (tipoIdentificacion == null) {
			try {
				parametros = getParametros();
				tipoIdentificacion = new SelectItem[parametros.length + 1];
				tipoIdentificacion[0] = new SelectItem(Long.parseLong("0"),
						"--Seleccionar--");
				for (int i = 0; i < parametros.length; i++) {
					Parametros parametro = parametros[i];
					tipoIdentificacion[i + 1] = new SelectItem(parametro
							.getCodigoParam(), parametro.getDescripcionParam());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion
	 *            the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(SelectItem[] tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * @return the selectedTipoDocumento
	 */
	public long getSelectedTipoDocumento() {
		return selectedTipoDocumento;
	}

	/**
	 * @param selectedTipoDocumento
	 *            the selectedTipoDocumento to set
	 */
	public void setSelectedTipoDocumento(long selectedTipoDocumento) {
		this.selectedTipoDocumento = selectedTipoDocumento;
	}

	/**
	 * @return the parametros
	 */
	public Parametros[] getParametros() {
		inscripcion = new InscripcionActividadesLogica();
		if (parametros == null) {
			try {
				parametros = inscripcion.getTipoDocumento(20);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return parametros;
	}

	/**
	 * @param parametros
	 *            the parametros to set
	 */
	public void setParametros(Parametros[] parametros) {
		this.parametros = parametros;
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
	 * @return the listParametroActividad
	 */
	public List<VepParametroActividad> getListParametroActividad() {
		return listParametroActividad;
	}

	/**
	 * @param listParametroActividad
	 *            the listParametroActividad to set
	 */
	public void setListParametroActividad(
			List<VepParametroActividad> listParametroActividad) {
		this.listParametroActividad = listParametroActividad;
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
	 * @return the estadoActividad
	 */
	public String getEstadoActividad() {
		return estadoActividad;
	}

	/**
	 * @param estadoActividad
	 *            the estadoActividad to set
	 */
	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}

	/**
	 * @return the panel1
	 */
	public HtmlPanelGrid getPanel1() {
		return panel1;
	}

	/**
	 * @param panel1
	 *            the panel1 to set
	 */
	public void setPanel1(HtmlPanelGrid panel1) {
		this.panel1 = panel1;
	}

	/**
	 * @return the panel2
	 */
	public HtmlPanelGrid getPanel2() {
		return panel2;
	}

	/**
	 * @param panel2
	 *            the panel2 to set
	 */
	public void setPanel2(HtmlPanelGrid panel2) {
		this.panel2 = panel2;
	}

	/**
	 * @return the panel3
	 */
	public HtmlPanelGrid getPanel3() {
		return panel3;
	}

	/**
	 * @param panel3
	 *            the panel3 to set
	 */
	public void setPanel3(HtmlPanelGrid panel3) {
		this.panel3 = panel3;
	}

	/**
	 * @return the panel4
	 */
	public HtmlPanelGrid getPanel4() {
		return panel4;
	}

	/**
	 * @param panel4
	 *            the panel4 to set
	 */
	public void setPanel4(HtmlPanelGrid panel4) {
		this.panel4 = panel4;
	}

	/**
	 * @return the panel5
	 */
	public HtmlPanelGrid getPanel5() {
		return panel5;
	}

	/**
	 * @param panel5
	 *            the panel5 to set
	 */
	public void setPanel5(HtmlPanelGrid panel5) {
		this.panel5 = panel5;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void action_consultarAsociado(ActionEvent actionEvent) {

		inscripcion = new InscripcionActividadesLogica();
		asociado = new AsociadoVida();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		try {
			asociado = inscripcion.consultarAsociado(
					getSelectedTipoDocumento(), Long
							.parseLong(getIdentificacion()));
			vepAsociado = inscripcion.findAsociado(Long.valueOf(asociado
					.getNumInt()));

			if (getNombre1() != null) {
				this.limpiar();
			}

			if (vepAsociado == null) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion1");
				toggleModal(actionEvent);
				limpiar();
				this.hidenPaneles();
			} else {
				setIdentificacion(asociado.getNumDocumento());
				setNombre1(asociado.getNombre1());
				setNombre2(asociado.getNombre2());
				setApellido1(asociado.getPrimerApellido());
				setApellido2(asociado.getSegundoApellido());
				setGenero(asociado.getSexo());
				setCodigoAsociado(asociado.getCodAsociado());
				setEstadoCivil(asociado.getEstadoCivil());
				setFechaNacimiento(StringUtils.generarFechaCorrecta(String
						.valueOf(asociado.getFecNacimiento())));
				setCuotasVencidas(Integer.parseInt(String.valueOf(asociado
						.getCuotaVencida())));
				setFechaIngresoVEP(formato.format(vepAsociado
						.getFechaIngresovp()));

				setEstadoCivil(asociado.getEstadoCivil());
				setOcupacion(asociado.getOcupacion());
				setTituloProfesional(asociado.getProfesion());

				if (vepAsociado.getTipoAsociado() != null) {
					if (new Integer(vepAsociado.getTipoAsociado()).intValue() == 1) {
						setFechaIngresoAsociado(StringUtils
								.generarFechaCorrecta(String.valueOf(asociado
										.getFecIngreso())));
						setFechaEstado(StringUtils.generarFechaCorrecta(String
								.valueOf(asociado.getFecEstado())));

						setCodigoCorte(asociado.getCorte());

						if (asociado.getEstado() != 0l) {
							List<SelectItem> estadosAsociado = ((LOVsVista) FacesUtils
									.getManagedBean("LOVs"))
									.getTipoEstadoAsociado();
							for (SelectItem item : estadosAsociado) {
								if (asociado.getEstado() == new Long(item
										.getValue().toString()).longValue()) {
									setEstadoAsociado(item.getLabel());
									break;
								}
							}
						}
					}
				}

				this.showPaneles();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_consultarGrupo(ActionEvent ae) {
		inscripcion = new InscripcionActividadesLogica();
		try {
			VepProgramacion listProgramacion = null;
			listProgramacion = inscripcion.findProgramacionGrupo("grupo",
					(Object) codigoGrupo.toUpperCase());
			if (listProgramacion == null) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion3");
				toggleModal(ae);
				codigoGrupo = null;
			} else {
				progra = listProgramacion;
				VepParametroActividad actividad = new VepParametroActividadDAO()
						.findById(progra.getIdActividadPar());
				codigoActividad = actividad.getIdActividadpar();
				nombreActividad = actividad.getNombre();
				estadoActividad = actividad.getEstadopar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoInscripcion.excepcion3");
			toggleModal(ae);
			codigoGrupo = null;
			e.printStackTrace();
		}
	}

	public void action_consultarActividad(ActionEvent ae) {
		inscripcion = new InscripcionActividadesLogica();
		VepParametroActividad param = new VepParametroActividad();
		int contador = 0;

		try {
			param = inscripcion.findParametroActividad(codigoActividad);
			if (param == null) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion2");
				toggleModal(ae);
			} else if (param != null
					&& param.getEstadopar().equalsIgnoreCase("ACTIVO")) {
				for (int i = 0; i < listParametroActividad.size(); i++) {
					if (param.getIdActividadpar().equals(
							listParametroActividad.get(i).getIdActividadpar())) {
						contador++;
					}
				}
				if (contador == 0) {
					listParametroActividad.add(param);
					setListParametroActividad(listParametroActividad);
					codigoActividad = null;
				} else {
					codigoActividad = null;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void removeActividad(ActionEvent event) {
		// Obtiene los items del contexto
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String nombreActividad = (String) map.get("nombreActividad");

		synchronized (listParametroActividad) {
			VepParametroActividad paramDelete;
			for (int i = 0; i < listParametroActividad.size(); i++) {
				paramDelete = (VepParametroActividad) listParametroActividad
						.get(i);
				// quita la actividad
				if (paramDelete.getNombre().equalsIgnoreCase(nombreActividad)) {
					listParametroActividad.remove(i);
					break;
				}
			}
		}
	}

	public void action_guardarInscripcion(ActionEvent ae) {
		inscripcion = new InscripcionActividadesLogica();
		List<VepAsistenteProg> listaInscripciones = new ArrayList<VepAsistenteProg>();
		try {
			if (identificacion.equals("")) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion4");
				toggleModal(ae);
			} else if (selectedTipoDocumento == 0) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion6");
				toggleModal(ae);
			} else if (codigoGrupo.equals("")) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion5");
				toggleModal(ae);
			} else if (asociado == null) {
				messageTittle = MessageBundleLoader.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.cuerpoInscripcion.excepcion8");
				toggleModal(ae);
			} else {
				if (progra.getCupoAsistentes().longValue() < progra
						.getCupoMaximo().longValue()) {
					listaInscripciones = inscripcion
							.buscarIncripciones(vepAsociado.getIdAsociado());
					if (listaInscripciones.size() != 0) {
						try {
							for (VepAsistenteProg vepAsistenteProg : listaInscripciones) {

								if (progra.getIdProgramacion().equals(
										vepAsistenteProg.getVepProgramacion()
												.getIdProgramacion())) {
									throw new Exception(
											MessageBundleLoader
													.getMessage("labels.cuerpoInscripcion.excepcion9"));
								}
								StringUtils.validarCruceHorarios(progra
										.getFechaInicio(),
										progra.getFechaFin(), vepAsistenteProg
												.getVepProgramacion(), progra
												.getHoraIni(), progra
												.getHoraFin(),
										"IncripcionActividades");
							}
							inscripcion.saveInscripcion(vepAsociado, progra);
							messageTittle = MessageBundleLoader
									.getMessage("labels.titulo");
							message = MessageBundleLoader
									.getMessage("labels.cuerpoInscripcion.mensajeGuardado");
							toggleModal(ae);
							this.limpiar();
							this.hidenPaneles();

						} catch (Exception e) {
							// TODO: handle exception
							messageTittle = MessageBundleLoader
									.getMessage("labels.titulo");
							message = e.getMessage();
							toggleModal(ae);
						}

					} else {
						inscripcion.saveInscripcion(vepAsociado, progra);
						messageTittle = MessageBundleLoader
								.getMessage("labels.titulo");
						message = MessageBundleLoader
								.getMessage("labels.cuerpoInscripcion.mensajeGuardado");
						toggleModal(ae);
						this.limpiar();
						this.hidenPaneles();
					}
				} else {
					messageTittle = MessageBundleLoader
							.getMessage("labels.titulo");
					message = MessageBundleLoader
							.getMessage("labels.cuerpoInscripcion.excepcion7");
					toggleModal(ae);
					this.limpiar();
					this.hidenPaneles();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			messageTittle = MessageBundleLoader.getMessage("labels.titulo");
			message = MessageBundleLoader
					.getMessage("labels.cuerpoInscripcion.mensajeNoGuardado");
			toggleModal(ae);
			e.printStackTrace();
		}
	}

	public void showPaneles() {
		panel2.setRendered(true);
		panel3.setRendered(true);
		panel4.setRendered(true);
	}

	public void hidenPaneles() {
		panel2.setRendered(false);
		panel3.setRendered(false);
		panel4.setRendered(false);
	}

	public void limpiar() {
		identificacion = null;
		nombreActividad = null;
		nombre1 = null;
		nombre2 = null;
		apellido1 = null;
		apellido2 = null;
		fechaNacimiento = null;
		genero = null;
		codigoAsociado = 0;
		asociadoCooperativa = null;
		estadoAsociado = null;
		fechaEstado = null;
		cuotasVencidas = null;
		fechaIngresoAsociado = null;
		codigoCorte = null;
		fechaIngresoVEP = null;
		tipoInscrito = null;
		estadoCivil = null;
		ocupacion = null;
		tituloProfesional = null;
		codigoGrupo = null;
		codigoActividad = null;
		nombreActividad = null;
		estadoActividad = null;
	}

	public HtmlInputText getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(HtmlInputText txtCedula) {
		this.txtCedula = txtCedula;
	}
}
