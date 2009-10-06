package com.icesoft.icefaces.validators.custom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class PhoneValidator implements Validator {

	private static final String PHONE_PATTERN = "^3{0,1}[0-9]{6,13}$";

	public void validate(FacesContext arg0, UIComponent component, Object value)
			throws ValidatorException {
		/* create a mask */
		Pattern mask = Pattern.compile(PHONE_PATTERN);

		/* retrieve the string value of the field */
		String phone = (String) value;

		/* check to ensure that the value is a phone number */
		Matcher matcher = mask.matcher(phone);

		if (!matcher.matches()) {
			((UIInput) component).setValid(false);

			FacesMessage msg = new FacesMessage();
			msg.setDetail("Numero de Telefono no esta en el formato valido");
			msg.setSummary("Numero de Telefono no esta en el formato valido");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
