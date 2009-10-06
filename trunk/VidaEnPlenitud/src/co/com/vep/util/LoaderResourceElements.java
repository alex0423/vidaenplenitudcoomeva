package co.com.vep.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Julian Andres Marin - GeniarArq S.A
 * @version 1.0 
 * Descripción : Componente que proporciona la funcionalidad de
 * carga y procesamiento de archivos de propiedades, de acuerdo al
 * nombre del archivo y las claves correspondientes.
 */
public class LoaderResourceElements {
	private static LoaderResourceElements loaderResourceElements;

	private LoaderResourceElements() {
	}

	/**
	 * Retorna una única instancia de la clase LoaderReourceElements
	 * 
	 * @return loaderReourceElements
	 *         
	 */
	public static LoaderResourceElements getInstance() {
		if (loaderResourceElements == null)
			loaderResourceElements = new LoaderResourceElements();
		return loaderResourceElements;
	}

	/**
	 * Retorna una cadena los mensajes de error de la aplicación
	 * 
	 * @return loaderReourceElements
	 *         
	 */
	public String getMensajeError(String key) {
		String keyValue = null;
		try {
			InputStream tables = this.getClass().getClassLoader().getResourceAsStream("co/com/coomeva/uti/tgv/web/etiquetas/etiqErrores.properties");
			Properties properties = new Properties();

			properties.load(tables);
			keyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyValue;
	}
	
	/**
	 * Retorna una cadena los mensajes de error de la aplicación
	 * 
	 * @return loaderReourceElements
	 *         
	 */
	public String getValorDefecto(String key) {
		String keyValue = null;
		try {
			InputStream tables = this.getClass().getClassLoader().getResourceAsStream("co/com/rpro/label/etiqValoresDefecto.properties");
			Properties properties = new Properties();

			properties.load(tables);
			keyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyValue;
	}

	public String getNavegacion(String key) {
		// TODO Auto-generated method stub
		String keyValue = null;
		try {
			InputStream tables = this.getClass().getClassLoader().getResourceAsStream("co/com/coomeva/uti/tgv/web/etiquetas/etiqNavegacion.properties");
			Properties properties = new Properties();

			properties.load(tables);
			keyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyValue;
	}
	
	public String getSolicitudViaje(String key) {
		// TODO Auto-generated method stub
		String keyValue = null;
		try {
			InputStream tables = this.getClass().getClassLoader().getResourceAsStream("co/com/coomeva/uti/tgv/web/etiquetas/etiqSolicitudViaje.properties");
			Properties properties = new Properties();

			properties.load(tables);
			keyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return keyValue;
	}
	
	
	

	

}
