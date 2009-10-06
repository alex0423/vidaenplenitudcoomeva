package co.com.vep.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;

/**
 * @author Juan Pablo Pazmin
 * @version 1.0
 * @date 2009-04-15
 * 
 */

public class validadorNumerico extends BaseValidator implements Validator {

	/** Número Telefonico */
	private static final String PHONE_NUM = "[0-9]*";

	// o bien sea -> private static final String PHONE_NUM= "[0-9]{1,13}";

	public validadorNumerico() {
		super();
	}

	public validadorNumerico(String msg) {
		super(msg);
	}

	public validadorNumerico(String msg, boolean required) {
		super(msg, required);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		validateRequired(context, component, value);

		/*
		 * se crea la mascara
		 */
		Pattern mask = Pattern.compile(PHONE_NUM);

		/* retrieve the string value of the field */
		String phoneNumber = value.toString();

		/* ensure value is a phone number */
		Matcher matcher = mask.matcher(phoneNumber);

		if (!matcher.matches()) {

			if (component instanceof HtmlInputTextarea)
				((HtmlInputTextarea) component).requestFocus();
			else if (component instanceof HtmlInputText)
				((HtmlInputText) component).requestFocus();

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			String ierrmsg = "Solo puede contener caracteres numéricos para el campo '"
					+ errmsg + "'";

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
