package co.com.vep.seguridad;

import java.util.Enumeration;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import co.com.coomeva.modelo.AutenticacionAutorizacion;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.vep.gui.autenticacion.LoginView;
import co.com.vep.logica.UsuarioLogica;
import co.com.vep.modelo.VepUsuario;
import co.com.vep.util.FacesUtils;

public class Session {

	public static HttpSession getSession() {
		return FacesUtils.getSession();
	}

	public static Object getSessionAttribute(String name) {
		try {
			return getSession().getAttribute(name);
		} catch (Exception e) {
			return null;
		}
	}

	public static void initSession(LoginView login) {
		if (login != null)
			initSession(login.getUsuarioVo());
		else
			forceLogin();
	}

	public static void disposeSession() {
		Enumeration<Object> atributos = FacesUtils.getSession()
				.getAttributeNames();
		while (atributos.hasMoreElements()) {
			Object atributo = atributos.nextElement();
			FacesUtils.getSession().removeAttribute(atributo.toString());
		}
	}

	public static void initSession(UserVo user) {
		if (user.getId() != null) {
//			String login = user.getMail().substring(0,
//					user.getMail().indexOf('@'));
			String login = user.getUserId();			
			setSessionAttribute("userId", user.getId());
			setSessionAttribute("userLogin", login);
			setSessionAttribute("userObj", user);
			setSessionAttribute("userName", user.getName());

			try {
				UsuarioLogica usrLogica = new UsuarioLogica();
				VepUsuario vu = usrLogica.obtenerByLogin(login.toLowerCase());
				if (vu == null)
					throw new Exception("Usuario no consistente");

				setSessionAttribute("userRegional", new Long(vu
						.getVepRegional().getIdRegional()));
				setSessionAttribute("REGIONALACTIVA", new Long(vu
						.getVepRegional().getIdRegional()));
			} catch (Exception e) {
				Session.forceLogin();
			}

		} else {
			forceLogin();
		}
	}

	public static void setSessionAttribute(String name, Object value) {
		try {
			if (getSessionAttribute(name) != null
					&& !getSessionAttribute(name).equals(null))
				getSession().removeAttribute(name);
		} catch (Exception e) {
		}

		getSession().setAttribute(name, value);
	}

	public static boolean isSessionAlive() {
		try {
			LoginView lview = (LoginView) FacesUtils
					.getManagedBean("loginView");
			if (lview == null) {
				forceLogin();
				return false;
			} else if (lview.getUsuarioVo() == null) {
				forceLogin();
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static void forceLogin() {
		FacesContext.getCurrentInstance().getApplication()
				.getNavigationHandler()
				.handleNavigation(FacesContext.getCurrentInstance(), null,
						"irPageInicio");
	}

	public AutenticacionAutorizacion getUsuarioSesion() {
		return (AutenticacionAutorizacion) FacesUtils.getSession()
				.getAttribute("autenticacion");
	}

}
