package co.com.vep.properties;

import java.io.InputStream;
import java.util.Properties;

public class LocalApplicationConfiguration {

	private Properties propiedades;

	public static class Util {
		private static LocalApplicationConfiguration instance = null;
		private static String archivoPropiedades = "/server.properties";

		public static LocalApplicationConfiguration getInstance() {
			if (instance == null) {
				instance = new LocalApplicationConfiguration();
				try {
					InputStream archivo = LocalApplicationConfiguration.class
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
