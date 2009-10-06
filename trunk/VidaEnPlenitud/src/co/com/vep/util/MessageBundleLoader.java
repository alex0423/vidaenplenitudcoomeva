package co.com.vep.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MessageBundleLoader {
	public static final String MESSAGE_PATH = "co.com.vep.etiquetas.labels";

	// message bundle for component.
	private static ResourceBundle messages;

	/**
	 * Initialize internationalization.
	 */
	private static void init() {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		// assign a default locale if the faces context has none, shouldn't
		// happen
		if (locale == null) {
			locale = Locale.ENGLISH;
		}
		messages = ResourceBundle.getBundle(MESSAGE_PATH, locale);
	}
	
	public static String getMessage(String key) {
		try {
			if (messages == null) {
				init();
			}
			return messages.getString(key);
		}
		// on any failure we just return the key, which should aid in debugging.
		catch (Exception e) {
			return key;
		}
	}
}
