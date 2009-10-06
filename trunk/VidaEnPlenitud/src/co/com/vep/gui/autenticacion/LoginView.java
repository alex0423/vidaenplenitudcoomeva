package co.com.vep.gui.autenticacion;

import javax.faces.event.ActionEvent;

import co.com.coomeva.control.Validacion;
import co.com.coomeva.delegado.seguridad.DelegadoServicioAutenticacion;
import co.com.coomeva.modelo.AutenticacionAutorizacion;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.utilidaldes.profile.LoadBundle;
import co.com.coomeva.utilidaldes.profile.Properties;
import co.com.vep.seguridad.Session;
import co.com.vep.util.FacesUtils;
import co.com.vep.util.MessageBundleLoader;

public class LoginView extends Validacion {

	private String txtLogin;
	private String txtPassword;
	private MensajeView mensajeView;
	private String empresa;
	private boolean todasLasEmpresas;
	private String txtClaveProveedor;
	UserVo usuarioVo;
	private boolean modalRendered = false;
	private boolean autoCentre = false;
	private String message;
	private String messageTittle;
	private LoadBundle parametros;

	public LoginView() {
		super();
		Object cerrarSesion = FacesUtils.getSession().getAttribute(
				"cerrarSesion");
		if (cerrarSesion != null)
			Session.disposeSession();
		parametros = Properties.getInstance().getLoadBundleServicioAutenticacion();
		mensajeView = (MensajeView) FacesUtils.getManagedBean("mensajeView");
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(String txtLogin) {
		this.txtLogin = txtLogin;
	}

	public String getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	public AutenticacionAutorizacion autenticacion = new AutenticacionAutorizacion();

	public String autenticar() {
		UserVo usuario = null;
		String paginaRetorno = null;
		try {
			DelegadoServicioAutenticacion wsAutentica = new DelegadoServicioAutenticacion();
			// Validaciones de campos obligatorios
			validar(getTxtLogin().toString(), mensajes.getProperty("noUsuario"));
			validar(getTxtPassword().toString(), mensajes
					.getProperty("noClave"));

			usuario = wsAutentica.validarUsuario(getTxtLogin().toString(),
					getTxtPassword().toString(),parametros.getProperty("url"),
					Integer.parseInt(parametros.getProperty("esquemaAute")),parametros.getProperty("nombreApp"),
					Integer.parseInt(parametros.getProperty("validarAplicacion")));
			if (usuario == null)
				throw new Exception("error code 32");

			if (usuario.getAuthorized().equalsIgnoreCase("false")) {
				setMessage(mensajes.getProperty("noAutorizado"));				
				toggleModal();
				paginaRetorno = "";
			} else {
				String aplicacion = mensajes.getProperty("aplicacion");

				autenticacion.setUsuario(usuario);
				autenticacion.cargarModulosUsuario(aplicacion, usuario);

				Session.initSession(usuario);
				Session.setSessionAttribute("autenticacion", autenticacion);
				// FacesUtils.getSession().setAttribute("autenticacion",
				// autenticacion);
				setUsuarioVo(usuario);

				MenuBean menu = (MenuBean) FacesUtils.getManagedBean("menuBar");
				menu.obtenerDatos();

				paginaRetorno = "irMenuAplicacion";
			}
		} catch (RuntimeException r) {
			mensajeView.mostrarMensaje(r.getMessage());			
		} catch (Exception e) {
			if (e != null) {
				// Valida si el error es por usuario o clave incorrectos				
				if (e.getMessage().contains(
						mensajes.getProperty("noUsuarioValido"))) {
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessage(mensajes.getProperty("noUsuarioValido"));
					toggleModal();
				} else if (e.getMessage().contains(
						mensajes.getProperty("noUsuario"))) {
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessage(mensajes.getProperty("noUsuario"));
					toggleModal();
				} else if (e.getMessage().contains(
						mensajes.getProperty("noClave"))) {
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessage(mensajes.getProperty("noClave"));
					toggleModal();
				} else if (e.getMessage().contains("error code 32")) {
					setMessage(mensajes.getProperty("noUsuarioRegistrado"));
					toggleModal();
				}else {
					setMessageTittle(MessageBundleLoader
							.getMessage("labels.titulo"));
					setMessage(e.getMessage());
					toggleModal();
				}

			}
		}
		return paginaRetorno;
	}

	public boolean isTodasLasEmpresas() {
		return todasLasEmpresas;
	}

	public void setTodasLasEmpresas(boolean todasLasEmpresas) {
		this.todasLasEmpresas = todasLasEmpresas;
	}

	public UserVo getUsuarioVo() {
		return usuarioVo;
	}

	public void setUsuarioVo(UserVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}

	public boolean isModalRendered() {
		return modalRendered;
	}

	public void setModalRendered(boolean modalRendered) {
		this.modalRendered = modalRendered;
	}

	public boolean isAutoCentre() {
		return autoCentre;
	}

	public void setAutoCentre(boolean autoCentre) {
		this.autoCentre = autoCentre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageTittle() {
		return messageTittle;
	}

	public void setMessageTittle(String messageTittle) {
		this.messageTittle = messageTittle;
	}

	public void toggleModal() {
		modalRendered = !modalRendered;
	}
}
