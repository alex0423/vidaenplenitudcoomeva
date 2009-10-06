package co.com.vep.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;

import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.IRegistrarLugarLogica;
import co.com.vep.logica.RealizarConsultas;
import co.com.vep.logica.RegistrarLugarLogica;
import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepSitio;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorNumerico;

public class VistaRegistrarLugarActividad {

	private String codigoSitio;
	private String nombreSitio;
	private String direccionSitio;
	private String telefonoSitio;
	private String ciudadSitio;
	private String descripcionSitio;

	private String codigoLugar;
	private String nombreLugar;
	private String descripcionLugar;
	private String cupoMinimo;
	private String cupoMaximo;
	private String messageTittle;
	private String messageBody;

	private boolean modalRendered = false;
	private boolean autoCentre = false;

	private String pais;
	private List<SelectItem> lista_deptos;
	private Long deptos;
	private List<SelectItem> lista_ciu;
	private Long ciu;
	private String selectorDestination = "";
	private boolean visible = false;
	private String labelCiudad;
	private String codigoCiu;
	private Long hddCiudadSitio;

	private IRegistrarLugarLogica registrar;

	private HtmlInputText txtCodigoSitio;
	private HtmlInputText txtTelefonoSitio;
	private HtmlInputText txtCodigoLugar;
	private HtmlInputText txtCupoMinimo;
	private HtmlInputText txtCupoMaximo;

	private VepSitio sitio;
	private VepLugar lugar;
	VepSitio sitioLugar = new VepSitio();

	public VistaRegistrarLugarActividad() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("IngresarSitioPractica")) {
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {

		txtCodigoSitio = new HtmlInputText();
		txtCodigoSitio.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.codigoSitio"), true));
		txtCodigoSitio.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCodigoSitio.validate(FacesContext.getCurrentInstance());
			}
		});

		txtTelefonoSitio = new HtmlInputText();
		txtTelefonoSitio.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.telefono"), true));
		txtTelefonoSitio.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtTelefonoSitio.validate(FacesContext.getCurrentInstance());
			}
		});

		txtCodigoLugar = new HtmlInputText();
		txtCodigoLugar.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.codigoLugar"), true));
		txtCodigoLugar.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCodigoLugar.validate(FacesContext.getCurrentInstance());
			}
		});

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
	}

	/**
	 * @return the codigoSitio
	 */
	public String getCodigoSitio() {
		return codigoSitio;
	}

	/**
	 * @param codigoSitio
	 *            the codigoSitio to set
	 */
	public void setCodigoSitio(String codigoSitio) {
		this.codigoSitio = codigoSitio;
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
	 * @return the direccionSitio
	 */
	public String getDireccionSitio() {
		return direccionSitio;
	}

	/**
	 * @param direccionSitio
	 *            the direccionSitio to set
	 */
	public void setDireccionSitio(String direccionSitio) {
		this.direccionSitio = direccionSitio;
	}

	/**
	 * @return the telefonoSitio
	 */
	public String getTelefonoSitio() {
		return telefonoSitio;
	}

	/**
	 * @param telefonoSitio
	 *            the telefonoSitio to set
	 */
	public void setTelefonoSitio(String telefonoSitio) {
		this.telefonoSitio = telefonoSitio;
	}

	/**
	 * @return the ciudadSitio
	 */
	public String getCiudadSitio() {
		return ciudadSitio;
	}

	/**
	 * @param ciudadSitio
	 *            the ciudadSitio to set
	 */
	public void setCiudadSitio(String ciudadSitio) {
		this.ciudadSitio = ciudadSitio;
	}

	/**
	 * @return the descripcionSitio
	 */
	public String getDescripcionSitio() {
		return descripcionSitio;
	}

	/**
	 * @param descripcionSitio
	 *            the descripcionSitio to set
	 */
	public void setDescripcionSitio(String descripcionSitio) {
		this.descripcionSitio = descripcionSitio;
	}

	/**
	 * @return the codigoLugar
	 */
	public String getCodigoLugar() {
		return codigoLugar;
	}

	/**
	 * @param codigoLugar
	 *            the codigoLugar to set
	 */
	public void setCodigoLugar(String codigoLugar) {
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
	 * @return the descripcionLugar
	 */
	public String getDescripcionLugar() {
		return descripcionLugar;
	}

	/**
	 * @param descripcionLugar
	 *            the descripcionLugar to set
	 */
	public void setDescripcionLugar(String descripcionLugar) {
		this.descripcionLugar = descripcionLugar;
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
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody
	 *            the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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

	public String getSelectorDestination() {
		return selectorDestination;
	}

	public void setSelectorDestination(String selectorDestination) {
		this.selectorDestination = selectorDestination;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getLabelCiudad() {
		return labelCiudad;
	}

	public void setLabelCiudad(String labelCiudad) {
		this.labelCiudad = labelCiudad;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void action_consultarSitioSiExiste(ActionEvent ae) {
		registrar = new RegistrarLugarLogica();
		sitio = new VepSitio();

		try {
			sitio = registrar
					.buscarSitioPorCodigo(Integer.valueOf(codigoSitio));
			if (sitio != null) {
				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessageBody(MessageBundleLoader
						.getMessage("labels.cuerpo.excepcion1"));
				// toggleModal(ae);

				nombreSitio = sitio.getNombre();
				telefonoSitio = sitio.getTelefono();
				direccionSitio = sitio.getDireccion();
				ciudadSitio = registrar.buscarCiudadxCodigo(sitio.getCiudad());
				descripcionSitio = sitio.getDescripcion();
				sitioLugar = sitio;
				codigoCiu = sitio.getCiudad();
			} else {
				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessageBody(MessageBundleLoader
						.getMessage("labels.message.excepcion8"));
				toggleModal(ae);
				limpiarCamposSitio();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_consultarLugarSiExiste(ActionEvent ae) {
		registrar = new RegistrarLugarLogica();
		lugar = new VepLugar();

		try {
			if (sitioLugar != null) {
				try {
					lugar = registrar.buscarLugarPorCodigo(sitioLugar
							.getIdSitio(), Integer.valueOf(codigoLugar));
					if (lugar != null) {
						setMessageTittle(MessageBundleLoader
								.getMessage("labels.titulo"));
						setMessageBody(MessageBundleLoader
								.getMessage("labels.cuerpo.excepcion2"));
						toggleModal(ae);
					}else {
						setMessageTittle(MessageBundleLoader
								.getMessage("labels.titulo"));
						setMessageBody(MessageBundleLoader
								.getMessage("labels.message.excepcion9"));
						toggleModal(ae);
						limpiarCamposLugar();
					}
				} catch (Exception e) {
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessageBody(MessageBundleLoader
							.getMessage("labels.cuerpo.excepcion10"));
					toggleModal(ae);
					codigoLugar = null;
				}
			} else {
				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessageBody(MessageBundleLoader
						.getMessage("labels.cuerpo.excepcion9"));
				toggleModal(ae);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_registrarLugar(ActionEvent ae) {
		registrar = new RegistrarLugarLogica();
		sitio = new VepSitio();
		lugar = new VepLugar();
		VepSitio sitioValidar = new VepSitio();
		VepLugar lugarValidar = new VepLugar();
		int flag = 0;

		if (codigoSitio.equals("")) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessageBody(MessageBundleLoader
					.getMessage("labels.cuerpo.excepcion7"));
			toggleModal(ae);
			flag = 1;
		} else if (codigoLugar.equals("")) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessageBody(MessageBundleLoader
					.getMessage("labels.cuerpo.excepcion8"));
			toggleModal(ae);
			flag = 1;
		} else if (cupoMinimo.equals("")) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessageBody(MessageBundleLoader
					.getMessage("labels.cuerpo.excepcion5"));
			toggleModal(ae);
			flag = 1;
		} else if (cupoMaximo.equals("")) {
			setMessageTittle(MessageBundleLoader.getMessage("labels.titulo"));
			setMessageBody(MessageBundleLoader
					.getMessage("labels.cuerpo.excepcion6"));
			toggleModal(ae);
			flag = 1;
		} else if (flag == 0) {
			Long minimo = Long.valueOf(cupoMinimo);
			Long maximo = Long.valueOf(cupoMaximo);

			if (minimo <= 0) {
				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessageBody(MessageBundleLoader
						.getMessage("labels.cuerpo.excepcion3"));
				toggleModal(ae);
			} else if (maximo < minimo) {
				setMessageTittle(MessageBundleLoader
						.getMessage("labels.titulo"));
				setMessageBody(MessageBundleLoader
						.getMessage("labels.cuerpo.excepcion4"));
				toggleModal(ae);
			} else {
				sitio.setCiudad(codigoCiu);
				sitio.setDescripcion(descripcionSitio.toUpperCase());
				sitio.setDireccion(direccionSitio.toUpperCase());
				sitio.setIdSitio(Integer.valueOf(codigoSitio));
				sitio.setNombre(nombreSitio.toUpperCase());
				sitio.setTelefono(telefonoSitio.toString());

				lugar.setCupoMaximo(Long.valueOf(cupoMaximo));
				lugar.setCupoMinimo(Long.valueOf(cupoMinimo));
				lugar.setDescripcion(descripcionLugar.toUpperCase());
				lugar.setIdLugar(Integer.valueOf(codigoLugar));
				lugar.setNombre(nombreLugar.toUpperCase());
				lugar.setVepSitio(sitio);

				try {
					if (sitioLugar.getIdSitio() != null) {
						lugarValidar = registrar.buscarLugarPorCodigo(lugar
								.getIdLugar());
						if (lugarValidar != null) {
							setMessageTittle(MessageBundleLoader
									.getMessage("labels.titulo"));
							setMessageBody(MessageBundleLoader
									.getMessage("labels.cuerpo.excepcion2"));
							toggleModal(ae);
							codigoLugar = null;
						} else {
							registrar.registroLugarActividad(lugar);
							setMessageTittle(MessageBundleLoader
									.getMessage("labels.titulo"));
							setMessageBody(MessageBundleLoader
									.getMessage("labels.cuerpo.mensajeRegistrado"));
							limpiarCampos();
							toggleModal(ae);
						}
					} else {
						registrar.registroLugarActividad(sitio, lugar);
						setMessageTittle(MessageBundleLoader
								.getMessage("labels.titulo"));
						setMessageBody(MessageBundleLoader
								.getMessage("labels.cuerpo.mensajeRegistrado"));
						limpiarCampos();
						toggleModal(ae);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessageBody(MessageBundleLoader
							.getMessage("labels.cuerpo.mensajeNoRegistrado"));
					toggleModal(ae);
				}
			}
		}
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
					codigoCiu = item.getValue().toString();
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
				if (selectorDestination.equals("SIT")) {
					ciudadSitio = labelCiudad;
					hddCiudadSitio = ciu;
				}
			}
		}
	}

	public void popupSitio() {
		limpiarPopup();
		visible = true;
		selectorDestination = "SIT";
	}

	private void limpiarPopup() {
		pais = "-1";
		lista_ciu = new ArrayList<SelectItem>();
		ciu = new Long("-1");
		lista_deptos = new ArrayList<SelectItem>();
		deptos = new Long("-1");
	}

	public void limpiarCampos() {
		codigoSitio = null;
		nombreSitio = null;
		direccionSitio = null;
		ciudadSitio = null;
		telefonoSitio = null;
		descripcionSitio = null;
		codigoLugar = null;
		nombreLugar = null;
		descripcionLugar = null;
		cupoMaximo = null;
		cupoMinimo = null;
	}
	
	public void limpiarCamposSitio() {		
		nombreSitio = null;
		direccionSitio = null;
		ciudadSitio = null;
		telefonoSitio = null;
		descripcionSitio = null;		
	}
	
	public void limpiarCamposLugar() {		
		nombreLugar = null;
		descripcionLugar = null;
		cupoMaximo = null;
		cupoMinimo = null;
	}

	public String getCodigoCiu() {
		return codigoCiu;
	}

	public void setCodigoCiu(String codigoCiu) {
		this.codigoCiu = codigoCiu;
	}

	public HtmlInputText getTxtCodigoSitio() {
		return txtCodigoSitio;
	}

	public void setTxtCodigoSitio(HtmlInputText txtCodigoSitio) {
		this.txtCodigoSitio = txtCodigoSitio;
	}

	public HtmlInputText getTxtTelefonoSitio() {
		return txtTelefonoSitio;
	}

	public void setTxtTelefonoSitio(HtmlInputText txtTelefonoSitio) {
		this.txtTelefonoSitio = txtTelefonoSitio;
	}

	public HtmlInputText getTxtCodigoLugar() {
		return txtCodigoLugar;
	}

	public void setTxtCodigoLugar(HtmlInputText txtCodigoLugar) {
		this.txtCodigoLugar = txtCodigoLugar;
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
}
