package co.com.coomeva.wsasociado.configuration;

import java.io.InputStream;
import java.util.Properties;

public class LocalApplicationConfigurationWsAsociado {

	private Properties propiedades;

	public static class Util {
		private static LocalApplicationConfigurationWsAsociado instance = null;
		private static String archivoPropiedades = "/configurationWsAsociado.properties";

		public static LocalApplicationConfigurationWsAsociado getInstance() {
			if (instance == null) {
				instance = new LocalApplicationConfigurationWsAsociado();
				try {
					InputStream archivo = LocalApplicationConfigurationWsAsociado.class
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
