package co.com.vep.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator extends BaseValidator implements Validator {

	private static final String MAIL_PATTERN = "^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$";

	public EmailValidator() {
		super();
	}

	public EmailValidator(String msg) {
		super(msg);
	}

	public EmailValidator(String msg, boolean required) {
		super(msg, required);
	}

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		validateRequired(context, component, value);

		/* create a mask */
		Pattern mask = Pattern.compile(MAIL_PATTERN);

		/* retrieve the string value of the field */
		String email = (String) value;

		/* check to ensure that the value is a phone number */
		Matcher matcher = mask.matcher(email);

		if (!matcher.matches()) {
			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			errmsg = "El campo '" + errmsg.toUpperCase()
					+ "' de tipo Email no cumple con el formato valido";

			FacesMessage msg = new FacesMessage();
			msg.setDetail(errmsg);
			msg.setSummary(errmsg);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		} else
			((UIInput) component).setValid(true);
	}

}
