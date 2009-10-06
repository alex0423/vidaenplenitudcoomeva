package co.com.vep.properties;

import java.io.InputStream;
import java.util.Properties;

public class LocalApplicationMessages {

	private Properties propiedades;

	public static class Util {
		private static LocalApplicationMessages instance = null;
		private static String archivoPropiedades = "/co/com/vep/etiquetas/labels.properties";

		public static LocalApplicationMessages getInstance() {
			if (instance == null) {
				instance = new LocalApplicationMessages();
				try {
					InputStream archivo = LocalApplicationMessages.class
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
			if (name.trim().length() > 0) {
				return propiedades.getProperty(name);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
