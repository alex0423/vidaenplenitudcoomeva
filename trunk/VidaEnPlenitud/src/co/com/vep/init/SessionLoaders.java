package co.com.vep.init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

public class SessionLoaders {

	private Map<String, List<SelectItem>> values;

	public static class Util {

		private static SessionLoaders _instance = null;

		public static SessionLoaders getInstance() {
			if (_instance == null)
				_instance = new SessionLoaders();
			return _instance;
		}
	}

	public void createLOV(String key) {
		try {
			if (values == null)
				values = new HashMap<String, List<SelectItem>>();

			if (values.containsKey(key))
				values.remove(key);

			List<SelectItem> content = LOVFactory.getItems(key);
			values.put(key, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getLOV(String key) {
		try {
			if (!values.containsKey(key))
				createLOV(key);
			return values.get(key);
		} catch (Exception e) {
			createLOV(key);
			return values.get(key);
		}
	}

}
