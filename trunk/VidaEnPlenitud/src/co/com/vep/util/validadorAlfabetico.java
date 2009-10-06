package co.com.vep.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class validadorAlfabetico extends BaseValidator implements Validator {

	/** Caracteres permitidos */
	private static final String ALPHABETIC = "[0-9A-Za-z\\s\\.\\@_\\-~#´]+";

	public validadorAlfabetico() {
		super();
	}

	public validadorAlfabetico(String errmsg) {
		super(errmsg);
	}

	public validadorAlfabetico(String errmsg, boolean required) {
		super(errmsg, required);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		validateRequired(context, component, value);

		Pattern mask = Pattern.compile(ALPHABETIC);
		/* retrieve the string value of the field */
		String alfabetico = (String) value;

		/* ensure value is a phone number */
		Matcher matcher = mask.matcher(alfabetico);
		if (!matcher.matches()) {
			String ierrmsg = "El campo '" + errmsg.toUpperCase()
					+ "' no pueden existir caracteres especiales";

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			FacesMessage message = new FacesMessage();
			message.setDetail(ierrmsg);
			message.setSummary(ierrmsg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		} else {
			((UIInput) component).setValid(true);
			component.getAttributes().put("styleClass", "ingresos");
		}
	}

}
