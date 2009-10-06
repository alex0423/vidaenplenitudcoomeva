package co.com.vep.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class BaseValidator {

	public String errmsg;
	public boolean asRequired = false;

	public BaseValidator() {
		this.errmsg = "";
		this.asRequired = false;
	}

	public BaseValidator(String msg) {
		this.errmsg = msg;
		this.asRequired = false;
	}

	public BaseValidator(String msg, boolean required) {
		this.errmsg = msg;
		this.asRequired = required;
	}

	public void validateRequired(FacesContext arg0, UIComponent component,
			Object value) throws ValidatorException {

		String newvalue = "";
		try {
			newvalue = String.valueOf(value);
		} catch (Exception e) {
			String ierrmsg = "El campo '" + errmsg.toUpperCase()
					+ "' no puede ser nulo o vacio";

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			FacesMessage message = new FacesMessage();
			message.setDetail(ierrmsg);
			message.setSummary(ierrmsg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

		if (newvalue == null || newvalue.trim().length() == 0) {
			if (asRequired == true) {
				String ierrmsg = "El campo '" + errmsg.toUpperCase()
						+ "' no puede ser nulo o vacio";

				((UIInput) component).setValid(false);
				component.getAttributes().put("styleClass", "ERROR");

				FacesMessage message = new FacesMessage();
				message.setDetail(ierrmsg);
				message.setSummary(ierrmsg);
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}

}
