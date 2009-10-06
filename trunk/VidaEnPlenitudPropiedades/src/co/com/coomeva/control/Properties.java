package co.com.coomeva.control;

/**
 * @author Oscar Javier Salazar
 * 
 * Clase encargada del manejo de los archivos 
 * de parametrizacion.
 */
public class Properties {

	private LoadBundle loadBundleServicioAutenticacion;
	private LoadBundle loadBundleMensajes;
	private LoadBundle loadBundleParametros;
	
	private static Properties instance;

	/**
	 * Constructor de la clase.
	 */
	private Properties() {
		loadBundleServicioAutenticacion = new LoadBundle("co.com.coomeva.propiedades.seguridad");
		loadBundleMensajes = new LoadBundle("co.com.coomeva.propiedades.mensajes");
		loadBundleParametros = new LoadBundle("co.com.coomeva.propiedades.parametros");
	}

	/**
	 * Retorna una unica instancia de la clase.
	 */
	public static Properties getInstance() {
		if (instance == null) {
			instance = new Properties();
		}
		return instance;
	}

	/**
	 * Metodos accesores.
	 */
	public LoadBundle getLoadBundleServicioAutenticacion() {
		return loadBundleServicioAutenticacion;
	}

	public LoadBundle getLoadBundleMensajes() {
		return loadBundleMensajes;
	}

	public LoadBundle getLoadBundleParametros() {
		return loadBundleParametros;
	}
	
}
