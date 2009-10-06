package co.com.vep.vista;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.ext.HtmlInputText;

import co.com.vep.logica.CreacionActividadesLogica;
import co.com.vep.logica.ICreacionActividadesLogica;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorAlfabetico;
import co.com.vep.util.validadorNumerico;

public class VistaCreacionActividades {

	private String codigo;
	private String actividad;
	private ICreacionActividadesLogica parametroActividad;
	private ICreacionActividadesLogica registrar;
	private ICreacionActividadesLogica validaNombre;
	private VepParametroActividad paraActividad;

	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;

	List<VepParametroActividad> validaExiste = null;

	private String selectedEstado;

	private SelectItem[] tipoEstados;

	private List<VepSipParametro> listaEstados;

	private HtmlInputText txtActividad;
	private HtmlInputText txtCodigo;

	public VistaCreacionActividades() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("IngresarActividad")) {
				initializeComponent();
			}
		}
	}

	private void initializeComponent() {

		txtCodigo = new HtmlInputText();
		txtCodigo.addValidator(new validadorNumerico(MessageBundleLoader
				.getMessage("labels.codigoActividad"), true));
		txtCodigo.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtCodigo.validate(FacesContext.getCurrentInstance());
			}
		});

		txtActividad = new HtmlInputText();
		txtActividad.addValidator(new validadorAlfabetico(MessageBundleLoader
				.getMessage("labels.nombreActividad"), true));
		txtActividad.addValueChangeListener(new ValueChangeListener() {
			public void processValueChange(ValueChangeEvent arg0)
					throws AbortProcessingException {
				txtActividad.validate(FacesContext.getCurrentInstance());
			}
		});
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(ICreacionActividadesLogica parametroActividad) {
		this.parametroActividad = parametroActividad;
	}

	/**
	 * @param validaNombre
	 *            the validaNombre to set
	 */
	public void setValidaNombre(ICreacionActividadesLogica validaNombre) {
		this.validaNombre = validaNombre;
	}

	/**
	 * @return the validaNombre
	 */
	public ICreacionActividadesLogica getValidaNombre() {
		return validaNombre;
	}

	/**
	 * @return the secuencia
	 */
	public ICreacionActividadesLogica getSecuencia() {
		return parametroActividad;
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
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param messageTittle
	 *            the messageTittle to set
	 */
	public void setMessageTittle(String messageTittle) {
		this.messageTittle = messageTittle;
	}

	/**
	 * @return the messageTittle
	 */
	public String getMessageTittle() {
		return messageTittle;
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
	 * @return the listaEstados
	 */
	public List<VepSipParametro> getListaEstados() {
		parametroActividad = new CreacionActividadesLogica();
		if (listaEstados == null) {
			try {
				listaEstados = parametroActividad.listaEstados(
						"vepSipparametroTipo.codTipo", 6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaEstados;
	}

	/**
	 * @param listaEstados
	 *            the listaEstados to set
	 */
	public void setListaEstados(List<VepSipParametro> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public void toggleModal(ActionEvent event) {
		modalRendered = !modalRendered;
	}

	public void action_verificarCodigo(ActionEvent ae) {
		parametroActividad = new CreacionActividadesLogica();
		paraActividad = new VepParametroActividad();

		try {
			paraActividad = parametroActividad.findParametroActividad(Integer
					.valueOf(codigo));
			if (paraActividad != null) {
				messageTittle = MessageBundleLoader
						.getMessage("labels.message.tittle.error");
				message = MessageBundleLoader
						.getMessage("labels.message.excepcion2");
				toggleModal(ae);
			} else {
				messageTittle = MessageBundleLoader
						.getMessage("labels.titulo");
				message = MessageBundleLoader
						.getMessage("labels.message.excepcion7");
				toggleModal(ae);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void action_crearActividad(ActionEvent actionEvent) {
		registrar = new CreacionActividadesLogica();
		validaNombre = new CreacionActividadesLogica();
		paraActividad = new VepParametroActividad();
		actividad = actividad.toUpperCase();
		int flag = 0;

		if (codigo.equals("")) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.message.tittle.error");
			message = MessageBundleLoader
					.getMessage("labels.message.excepcion4");
			toggleModal(actionEvent);
			flag = 1;
		} else if (actividad == null || actividad.trim().length() == 0) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.message.tittle.error");
			message = MessageBundleLoader
					.getMessage("labels.message.excepcion6");
			toggleModal(actionEvent);
			flag = 1;
		} else if (selectedEstado.equals("-1")) {
			messageTittle = MessageBundleLoader
					.getMessage("labels.message.tittle.error");
			message = MessageBundleLoader
					.getMessage("labels.message.excepcion5");
			toggleModal(actionEvent);
			flag = 1;
		} else if (flag == 0) {
			try {
				validaExiste = validaNombre.findByNombre(actividad);
				paraActividad = parametroActividad
						.findParametroActividad(Integer.valueOf(codigo));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (!validaExiste.isEmpty()) {
				messageTittle = MessageBundleLoader
						.getMessage("labels.message.tittle.error");
				message = MessageBundleLoader
						.getMessage("labels.message.excepcion1");
				toggleModal(actionEvent);
				actividad = null;
			} else if (paraActividad != null) {
				messageTittle = MessageBundleLoader
						.getMessage("labels.message.tittle.error");
				message = MessageBundleLoader
						.getMessage("labels.message.excepcion2");
				toggleModal(actionEvent);
				codigo = null;
			} else {

				try {
					registrar.registrarActividad(Integer.valueOf(codigo),
							actividad, selectedEstado);
					messageTittle = MessageBundleLoader
							.getMessage("labels.message.tittle.informacion");
					message = MessageBundleLoader
							.getMessage("labels.message.message1");
					toggleModal(actionEvent);
					limpiar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					messageTittle = MessageBundleLoader
							.getMessage("labels.message.tittle.error");
					message = MessageBundleLoader
							.getMessage("labels.message.excepcion3");
					toggleModal(actionEvent);
					limpiar();
					e.printStackTrace();
				}
			}
		}
	}

	public void limpiar() {
		codigo = null;
		actividad = null;
		selectedEstado = "-1";
	}

	public HtmlInputText getTxtActividad() {
		return txtActividad;
	}

	public void setTxtActividad(HtmlInputText txtActividad) {
		this.txtActividad = txtActividad;
	}

	public HtmlInputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(HtmlInputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

}
