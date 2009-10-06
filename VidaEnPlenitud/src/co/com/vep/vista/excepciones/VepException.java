package co.com.vep.vista.excepciones;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class VepException {

	public static void displayError(Exception ex) {
//		FacesMessage msg = new FacesMessage();
//		msg.setDetail(ex.getMessage());
//		msg.setSummary(ex.getMessage());
//		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//		FacesContext.getCurrentInstance().addMessage("Mensaje", msg);
		
		ex.printStackTrace();
	}
	
}
