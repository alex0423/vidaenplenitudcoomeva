package co.com.vep.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.joda.time.DateTime;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.IRegistrarProfesorLogica;
import co.com.vep.logica.RealizarConsultas;
import co.com.vep.logica.RegistroProfesorLogica;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepUbicacionProfesor;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.InputFileData;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.StringUtils;
import co.com.vep.vista.excepciones.VepException;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;

public class VistaRegistrarProfesor extends VistaAgregarAsociado implements Serializable{

	private String url;
	private TimeZone timeZone;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private boolean modalRendered1 = false;
	private boolean autoCentre1 = false;
	private String message;
	private String messageTittle;
	private String message1;
	private String messageTittle1;

	private static final long serialVersionUID = 1L;
	// File sizes used to generate formatted label
	public static final long MEGABYTE_LENGTH_BYTES = 1048000l;
	public static final long KILOBYTE_LENGTH_BYTES = 1024l;

	// files associated with the current user
	@SuppressWarnings("unchecked")
	private final List fileList = Collections.synchronizedList(new ArrayList());
	// latest file uploaded by client
	private InputFileData currentFile;
	// file upload completed percent (Progress)
	private int fileProgress;

	IRegistrarProfesorLogica profesor;
	AsociadoVida asociado;
	VepProfesor profesorObj;
	List<VepUbicacionProfesor> vup;

	private Long selectedGenero;
	private Integer estadoRegistro;

	private boolean visible = false;
	private String pais;
	private List<SelectItem> lista_deptos;
	private Long deptos;
	private List<SelectItem> lista_ciu;
	private Long ciu;
	private String labelCiudad;
	private String usuarioLogin;
	private String componentStatus;

	private Long hddCiudadComercial;
	private Long hddCiudadResidencia;

	// Botones para validar la Ciudad
	private HtmlCommandButton btnCiuRes;
	private HtmlCommandButton btnCiuCom;

	private SelectInputDate txtFechaNacimiento;

	public VistaRegistrarProfesor() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("IngresarProfesor")) {
				lista_deptos = new ArrayList<SelectItem>();
				lista_ciu = new ArrayList<SelectItem>();
				usuarioLogin = (String) Session
						.getSessionAttribute("userLogin");
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {
		if (txtFechaNacimiento == null)
			txtFechaNacimiento = new SelectInputDate();
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
									.getNombreCiudad()));
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
				} else if (selectorDestination.equals("COM")) {
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

	/**
	 * @return the selectedGenero
	 */
	public Long getSelectedGenero() {
		return selectedGenero;
	}

	/**
	 * @param selectedGenero
	 *            the selectedGenero to set
	 */
	public void setSelectedGenero(Long selectedGenero) {
		this.selectedGenero = selectedGenero;
	}

	public InputFileData getCurrentFile() {
		return currentFile;
	}

	public int getFileProgress() {
		return fileProgress;
	}

	@SuppressWarnings("unchecked")
	public List getFileList() {
		return fileList;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the selectedEstado
	 */
	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	/**
	 * @param selectedEstado
	 *            the selectedEstado to set
	 */
	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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
	 * @return the modalRendered1
	 */
	public boolean isModalRendered1() {
		return modalRendered1;
	}

	/**
	 * @param modalRendered1
	 *            the modalRendered1 to set
	 */
	public void setModalRendered1(boolean modalRendered1) {
		this.modalRendered1 = modalRendered1;
	}

	/**
	 * @return the autoCentre1
	 */
	public boolean isAutoCentre1() {
		return autoCentre1;
	}

	/**
	 * @param autoCentre1
	 *            the autoCentre1 to set
	 */
	public void setAutoCentre1(boolean autoCentre1) {
		this.autoCentre1 = autoCentre1;
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
	 * @return the message1
	 */
	public String getMessage1() {
		return message1;
	}

	/**
	 * @param message1
	 *            the message1 to set
	 */
	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	/**
	 * @return the messageTittle1
	 */
	public String getMessageTittle1() {
		return messageTittle1;
	}

	/**
	 * @param messageTittle1
	 *            the messageTittle1 to set
	 */
	public void setMessageTittle1(String messageTittle1) {
		this.messageTittle1 = messageTittle1;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}

	public void toggleModal1(ActionEvent event) {
		modalRendered1 = !modalRendered1;
	}

	@SuppressWarnings("unchecked")
	public void uploadFile(ActionEvent event) {
		InputFile inputFile = (InputFile) event.getSource();

		// file has been saved
		String subio = inputFile.getValidatedSubmitOnUpload();
		if (subio.equals(InputFile.SUBMIT_POST_UPLOAD)) {
			url = inputFile.getFile().getPath();
			componentStatus = MessageBundleLoader
					.getMessage("labels.uploadfile.exito");
			//fileAnexoPath = fileAnexo;
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
	}

	public void fileUploadProgress(EventObject event) {
		InputFile ifile = (InputFile) event.getSource();
		fileProgress = ifile.getFileInfo().getPercent();
	}

	@SuppressWarnings("unchecked")
	public void removeUploadedFile(ActionEvent event) {
		// Get the inventory item ID from the context.
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String fileName = (String) map.get("fileName");

		synchronized (fileList) {
			InputFileData inputFileData;
			for (int i = 0; i < fileList.size(); i++) {
				inputFileData = (InputFileData) fileList.get(i);
				// remove our file
				if (inputFileData.getFileInfo().getFileName().equals(fileName)) {
					fileList.remove(i);
					break;
				}
			}
		}
	}

	public void action_consultarAsociado(ActionEvent ae) {
		profesor = new RegistroProfesorLogica();
		profesorObj = new VepProfesor();
		vup = new ArrayList<VepUbicacionProfesor>();
		profesorObj = null;

		try {

			if (tipoid == null || tipoid.equals(new Long(-1)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion2"));

			if (cedula == null || cedula.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion3"));

			profesorObj = profesor.obtener(tipoid, Long.parseLong(cedula));
			vup = profesor.obtenerUbicacioProfesor(profesorObj.getId()
					.getTipoId(), profesorObj.getId().getIdProfesor());

			if (profesorObj == null) {
				desactivarCamposAsociado(false);
				showException(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion1"));
			} else {
				nombre1 = profesorObj.getNombre1();
				nombre2 = profesorObj.getNombre2();
				apellido1 = profesorObj.getApellido1();
				apellido2 = profesorObj.getApellido2();
				fechaNace = profesorObj.getFechaNace();
				for (VepUbicacionProfesor vupo : vup) {
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("direccion_residencia"))) {
						direccionResidencia = vupo.getDescripcionUbicacion();
						ciuRes = new RegistroProfesorLogica()
								.buscarCiudadxCodigo(vupo.getCiudad().toString());
					}
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("telefono_residencia"))) {
						telefonoResidencia = vupo.getDescripcionUbicacion();
					}
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("direccion_comercial"))) {
						dirComercial = vupo.getDescripcionUbicacion();
						ciuCom = new RegistroProfesorLogica()
								.buscarCiudadxCodigo(vupo.getCiudad().toString());
					}
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("telefono_comercial"))) {
						telefonoComercial = vupo.getDescripcionUbicacion();
					}
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("telefono_celular"))) {
						telefonoCelular = vupo.getDescripcionUbicacion();
					}
					if (vupo.getId().getTipoUbicacion().contains(
							LocalApplicationConfiguration.Util.getInstance()
									.getProperty("correo_electronico"))) {
						correoElectrinico = vupo.getDescripcionUbicacion();
					}
				}

				if (profesorObj.getGenero() != null) {
					List<SelectItem> lstGenero = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getGenero();
					for (SelectItem Ge : lstGenero) {
						if (Ge.getLabel().trim().equalsIgnoreCase(
								profesorObj.getGenero().trim())) {
							selectedGenero = new Long(Ge.getValue().toString());
							break;
						}
					}
				}

				if (profesorObj.getEstcivil() != null) {
					List<SelectItem> lstEstadoCivil = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getEstadoCivil();
					for (SelectItem EC : lstEstadoCivil) {
						if (EC.getLabel().contains(
								profesorObj.getEstcivil().trim())) {
							estadoCivil = new Long(EC.getValue().toString());
							break;
						}
					}
				}

				if (profesorObj.getTitulo() != null) {
					List<SelectItem> lstTituloProfesional = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getTituloProfesional();
					for (SelectItem TP : lstTituloProfesional) {
						if (TP.getLabel().contains(profesorObj.getTitulo())) {
							tituloProfesional = new Long(TP.getValue()
									.toString());
							break;
						}
					}
				}

				if (profesorObj.getEspecialidad() != null) {
					List<SelectItem> lstOcupacion = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getOcupacion();
					for (SelectItem Oc : lstOcupacion) {
						if (Oc.getLabel().contains(
								profesorObj.getEspecialidad())) {
							ocupacion = new Long(Oc.getValue().toString());
							break;
						}
					}
				}

				if (profesorObj.getEstadoProfesor() != null) {
					List<SelectItem> lstOcupacion = ((LOVsVista) FacesUtils
							.getManagedBean("LOVs")).getEstado();
					for (SelectItem Es : lstOcupacion) {
						if (Es.getValue().toString().contains(
								profesorObj.getEstadoProfesor())) {
							estadoRegistro = new Integer(Es.getValue()
									.toString());
							break;
						}
					}
				}

				desactivarCamposAsociado(true);

			}
		} catch (Exception e) {
			showException(e);
		}
	}

	public void desactivarCamposAsociado(boolean active) {
		habilitarInput(active);
		txtFechaNacimiento.setReadonly(active);

		btnCiuCom.setDisabled(active);
		btnCiuRes.setDisabled(active);
	}

	public void action_limpiar(ActionEvent event) {
		limpiarComponent();
	}

	private void limpiarComponent() {

		limpiar();
		estadoRegistro = new Integer(-1);
		selectedGenero = new Long(-1);
		desactivarCamposAsociado(false);
	}

	public void action_registrarProfesor(ActionEvent ae) {
		try {

			if (tipoid.equals(new Long("-1")))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion2"));

			if (cedula == null || cedula.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionBE.excepcion3"));

			if (nombre1.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err14"));

			if (apellido1.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.inscripcionaso.err15"));

			if (fechaNace == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion2"));
			else if (new DateTime().isBefore(new DateTime(fechaNace)))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion3"));

			if (estadoCivil.equals(new Long(0)) || estadoCivil < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion4"));

			if (ocupacion == null || ocupacion.equals(new Long(0))
					|| ocupacion < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion5"));

			if (tituloProfesional == null
					|| tituloProfesional.equals(new Long(0))
					|| tituloProfesional < new Long(0))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion6"));

			if (direccionResidencia.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion7"));
			
			if(ciuRes == null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.cuerpoRegProfesor.excepcion9"));

			RegistroProfesorLogica logica = new RegistroProfesorLogica();
			logica.registrarProfesor(tipoid, cedula, nombre1.toUpperCase(),
					nombre2.toUpperCase(), apellido1.toUpperCase(), apellido2
							.toUpperCase(), fechaNace, selectedGenero,
					direccionResidencia, hddCiudadResidencia,
					telefonoResidencia, tituloProfesional, ocupacion,
					estadoCivil, url, estadoRegistro, usuarioLogin,
					dirComercial, hddCiudadComercial,
					telefonoComercial, telefonoCelular, correoElectrinico);
			showException(MessageBundleLoader
					.getMessage("labels.cuerpoRegProfesor.mensajeRegistrado"));
			limpiarDatos();
		} catch (Exception e) {
			showException(e);
			e.printStackTrace();
		}
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLabelCiudad() {
		return labelCiudad;
	}

	public void setLabelCiudad(String labelCiudad) {
		this.labelCiudad = labelCiudad;
	}

	private void showException(String msg) {
		messageTittle = MessageBundleLoader.getMessage("labels.titulo");
		message = msg;
		toggleModal();
	}

	private void showException(Exception e) {
		if (e.getMessage().contains("No entity found for query")) {
			showException(MessageBundleLoader
					.getMessage("labels.cuerpoRegProfesor.excepcion1"));
		}else{
			showException(e.getMessage());
		}
		e.printStackTrace();
	}

	public SelectInputDate getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(SelectInputDate txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	
	public void limpiarDatos() {
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
		selectedGenero = new Long(-1);
		tipoid = new Long(-1);
		cedula = null;
		fileProgress = 0;
	}
}
