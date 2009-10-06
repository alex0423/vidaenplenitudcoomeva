package co.com.coomeva.delegado.seguridad;

import co.com.coomeva.profile.ws.client.CaasStub;
import co.com.coomeva.profile.ws.client.CaasStub.Application;
import co.com.coomeva.profile.ws.client.CaasStub.SetAplicacionBuscada;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUser;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUserResponse;
import co.com.coomeva.utilidaldes.profile.LoadBundle;
import co.com.coomeva.utilidaldes.profile.Properties;

/**
 * @author Giovanni Arzayus Mera Coomeva - Unidad de Tecnología Informática
 * 
 * Delegado para el consumo del serivio que expone Coomeva para autenticar los
 * usuario contra el Profile Manager o contra el Directorio Activo.
 */
public class DelegadoServicioAutenticacion {

	private LoadBundle parametros;
	
	/**
	 * Constructor de la clase
	 */
	public DelegadoServicioAutenticacion() {
		parametros = Properties.getInstance().getLoadBundleServicioAutenticacion();
	}


	/**
	 * esquema: Valida el usuario dependiento el esquema de autenticación que se pase por
	 * parametro.
	 * 
	 * 	# 0 - Profile Manager
	 *	# 1 - LDAP
	 *	# 2 - Consulta en los dos.
	 *	 
	 *	validaAplicacion: A parte que el usuario este parametrizado en el profile
	 *	                  valida que pueda ecceder a esta aplicación en particular.
	 *	# 0 - No valida la aplicación.
	 *	# 1 - Valida la aplicación.
	 * @throws Exception
	 */
	public UserVo validarUsuario(String usuario, String clave,
			String url,
			int esquema,
			String aplicacion,
			int validaAplicacion)
			throws Exception {

		UserVo userVo = null;
		
		ValidateUserResponse resp = null;
		
		CaasStub caasStub = new CaasStub(url);
	    ValidateUser valUser = new ValidateUser();
	    SetAplicacionBuscada aplicacionBuscada = new SetAplicacionBuscada();
	    aplicacionBuscada.setAplicacionBuscada(aplicacion);
	    valUser.setUserName(usuario);
		valUser.setPassword(clave);
        caasStub.setAplicacionBuscada(aplicacionBuscada);

		/**
		 * Obtiene el esquema de autenticación del archivo de propiedades
		 */
	
		switch (esquema) {
		case 0:
			/*
			 * Directorio 1 dice que los usuarios son de coomeva
			 */
			valUser.setDirectory(1);
			resp= caasStub.validateUser(valUser);
			if( resp.get_return() == null )
				return null;
			
			break;
		case 1:
			/*
			 * directorio 2 = usuarios externos
			 */
			valUser.setDirectory(2);
			resp= caasStub.validateUser(valUser);
			if( resp.get_return() == null )
				return null;
			
			break;
		case 2:
			/*
			 * Directorio 1 dice que los usuarios son de coomeva
			 */
			valUser.setDirectory(1);
			resp= caasStub.validateUser(valUser);
			// Cambia el directorio por si el usuario no es de coomeva
			if( resp.get_return() == null ){
				valUser.setDirectory(2);
				resp= caasStub.validateUser(valUser);
			}
			break;
		default:
			break;
		}

		
		
		userVo = resp.get_return();

		/**
		 * Valida que exista un usuario
		 */
		if( userVo == null){
			throw new Exception(parametros.getProperty("noUsuarioValido"));
		}
		
		/**
		 * Valida que el usuario esté autorizado
		 */
			
		/*if (userVo.getAuthorized().equals("false")) {
			throw new Exception(parametros.getProperty("ingresoDatosInvalidos"));
		}*/

		/**
		 * Si es necesario validar que el usuario está autorizado sobre
		 * la aplicación.
		 */
		if( validaAplicacion == 1 ){
			if(!estaAutorizado(resp.get_return(), aplicacion)){
				/**
				 * TODO Agregar la excepcion de que el usuario no tiene permisos para
				 * hace uso de esta aplicación
				 */
				throw new Exception(parametros.getProperty("noPermisos"));
			}
		}
		
		return userVo;
	}

	/**
	 * Retorna el listado de las apliaciones a las cuales tiene acceso el
	 * usuario.
	 * 
	 * @param usuario
	 * @return Application[] Arreglo de aplicaciones.
	 */
	public Application[] listadoAplicaciones(UserVo usuario) {
		return usuario.getApplications();
	}
	
	/**
	 * Indica si un usuario está o no autorizado para acceder 
	 * a una aplicación en particular que este registrada en el 
	 * Profile Manager.
	 * 
	 * @param nombreAplicacion
	 * @return boolean, Respuesta de autorización
	 */
	public boolean estaAutorizado( UserVo usuario, String nombreAplicacion ){
		
		Application[] listadoApp = listadoAplicaciones(usuario);
		
		/**
		 * Valida la autorización para la aplicación entregada por
		 * parametro.
		 */
		if (listadoApp != null)
		{
			for (int i = 0; i < listadoApp.length; i++) {
				if( listadoApp[i].getName().equals(nombreAplicacion)){
					return true;
				}
			}
		}
		
		/**
		 * Si llega a este punto es porque no tiene permisos
		 */
		return false;
	}

}
