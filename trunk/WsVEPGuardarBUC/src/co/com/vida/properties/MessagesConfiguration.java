package co.com.vida.properties;

import java.io.InputStream;
import java.util.Properties;

public class MessagesConfiguration {

	private Properties propiedades;

	public static class Util {
		private static MessagesConfiguration instance = null;
		private static String archivoPropiedades = "/exceptions.properties";

		public static MessagesConfiguration getInstance() {
			if (instance == null) {
				instance = new MessagesConfiguration();
				try {
					InputStream archivo = MessagesConfiguration.class
							.getResourceAsStream(archivoPropiedades);
					if (archivo != null) {
						instance.propiedades = new Properties();
						instance.propiedades.load(archivo);
					} else {
						throw new Exception("Archivo fuente inalcanzable");
					}
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			return instance;
		}
	}

	public String getProperty(String name) {
		try {
			if (name.trim().length() > 0)
				return getProperty(Integer.parseInt(name));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getProperty(int name) {
		try {
			return propiedades.getProperty(("E" + name).trim());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
