package co.com.vep.vista;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeListener;

import co.com.coomeva.delegado.seguridad.DelegadoServicioAutenticacion;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.utilidaldes.profile.LoadBundle;
import co.com.coomeva.utilidaldes.profile.Properties;
import co.com.vep.logica.UsuarioLogica;
import co.com.vep.modelo.VepUsuario;
import co.com.vep.seguridad.Seguridad;
import co.com.vep.seguridad.Session;
import co.com.vep.util.MessageBundleLoader;
import co.com.vep.util.validadorAlfabetico;

import com.icesoft.faces.component.ext.HtmlInputText;

public class VistaRegistrarUsuario {

	private Long selectedRegional;
	private String usuario;
	private LoadBundle parametros;

	private HtmlInputText txtUsuario;

	public VistaRegistrarUsuario() {
		if (Session.isSessionAlive()) {
			if (Seguridad.isAllowEntrance("RegistrarUsuario")) {
				initializeComponent();
				parametros = Properties.getInstance().getLoadBundleServicioAutenticacion();
			}
		}
	}

	private void initializeComponent() {

		if (txtUsuario == null) {
			txtUsuario = new HtmlInputText();
			txtUsuario.addValidator(new validadorAlfabetico(MessageBundleLoader
					.getMessage("labels.regusuario.usuario"), true));
			txtUsuario.addValueChangeListener(new ValueChangeListener() {
				public void processValueChange(ValueChangeEvent arg0)
						throws AbortProcessingException {
					txtUsuario.validate(FacesContext.getCurrentInstance());
				}
			});
		}
	}

	private void limpiar() {
		selectedRegional = new Long("-1");
		usuario = null;
	}

	public void action_guardarRegistro(ActionEvent action) {
		try {
			if (usuario == null || usuario.trim().length() == 0)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.regusuario.excepcion3"));
			if (selectedRegional == null
					|| selectedRegional.equals(new Long("-1")))
				throw new Exception(MessageBundleLoader
						.getMessage("labels.regusuario.excepcion4"));

			UsuarioLogica logica = new UsuarioLogica();
			VepUsuario vu = logica.obtenerByLogin(usuario);
			if (vu != null)
				throw new Exception(MessageBundleLoader
						.getMessage("labels.regusuario.excepcion5"));

			DelegadoServicioAutenticacion wsAutentica = new DelegadoServicioAutenticacion();
			UserVo vousuario = wsAutentica.validarUsuario(usuario, null,parametros.getProperty("url"),
					Integer.parseInt(parametros.getProperty("esquemaAute")),parametros.getProperty("nombreApp"),
					Integer.parseInt(parametros.getProperty("validarAplicacion")));
			if (vousuario == null)
				throw new Exception("error code 32");

			logica.registrar(usuario.toLowerCase(), new Integer(
					selectedRegional.intValue()));

			showException(MessageBundleLoader
					.getMessage("labels.regusuario.exito"));
			limpiar();

		} catch (RuntimeException r) {
			showException(r);
		} catch (Exception e) {
			if (e != null) {
				System.out.println("Exc: " + e.getMessage());
				if (e.getMessage().contains("error code 32"))
					showException(MessageBundleLoader
							.getMessage("labels.regusuario.excepcion1"));
				else if (e.getMessage().contains("noEmpleado"))
					showException(MessageBundleLoader
							.getMessage("labels.regusuario.excepcion1"));
				else if (e.getMessage().contains("noUsuario"))
					showException(MessageBundleLoader
							.getMessage("labels.regusuario.excepcion1"));
				else
					showException(e.getMessage());
			} else
				showException(MessageBundleLoader
						.getMessage("labels.regusuario.excepcion2"));
		}
	}

	public Long getSelectedRegional() {
		return selectedRegional;
	}

	public void setSelectedRegional(Long selectedRegional) {
		this.selectedRegional = selectedRegional;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public HtmlInputText getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(HtmlInputText txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public void showException(Exception ex) {
		showException(ex.getMessage());
	}

	public void showException(String ex) {
		FacesMessage msg = new FacesMessage(ex);
		FacesContext.getCurrentInstance().addMessage("msg", msg);
	}

}
