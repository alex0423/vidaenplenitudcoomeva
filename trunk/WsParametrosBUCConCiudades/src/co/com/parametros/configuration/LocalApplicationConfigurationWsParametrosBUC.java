package co.com.parametros.configuration;

import java.io.InputStream;
import java.util.Properties;

public class LocalApplicationConfigurationWsParametrosBUC {

	private Properties propiedades;

	public static class Util {
		private static LocalApplicationConfigurationWsParametrosBUC instance = null;
		private static String archivoPropiedades = "/configurationWsParametrosBUC.properties";

		public static LocalApplicationConfigurationWsParametrosBUC getInstance() {
			if (instance == null) {
				instance = new LocalApplicationConfigurationWsParametrosBUC();
				try {
					InputStream archivo = LocalApplicationConfigurationWsParametrosBUC.class
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
