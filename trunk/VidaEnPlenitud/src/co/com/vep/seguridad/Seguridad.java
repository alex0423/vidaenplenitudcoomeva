package co.com.vep.seguridad;

import javax.faces.context.FacesContext;

import co.com.coomeva.profile.ws.client.CaasStub.Section;
import co.com.vep.properties.LocalApplicationConfiguration;
import co.com.vep.util.StringUtils;

public class Seguridad extends Session {

	public static boolean isAllowEntrance(String page) {
		try {
			page = LocalApplicationConfiguration.Util.getInstance()
					.getProperty(page);
			Section[] sections = (Section[]) getSessionAttribute("Section");
			if (sections != null)
				for (int k = 0; k < sections.length; k++) {
					Section section = sections[k];
					String[] actions = section.getActions();
					if (actions != null) {
						for (String theAction : actions) {
							theAction = StringUtils.clean(theAction);
							if (theAction.equals(page))
								return true;
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forcePrincipal();
		return false;
	}

	public static void forcePrincipal() {
		FacesContext.getCurrentInstance().getApplication()
				.getNavigationHandler().handleNavigation(
						FacesContext.getCurrentInstance(), null,
						"irMenuAplicacion");
	}

}
