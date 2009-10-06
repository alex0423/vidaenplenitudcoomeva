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

public class validadorHora extends BaseValidator implements Validator {

	/** Hora */
	// private static final String HOUR_FORMAT=
	// "([0-9]|([0-1][0-2]))\\:[0-5][0-9]";
	private static final String HOUR_FORMAT = "(0[0-9])|([0-1][0-9])|(2[0-3])";

	public validadorHora() {
		super();
	}

	public validadorHora(String msg) {
		super(msg);
	}

	public validadorHora(String msg, boolean required) {
		super(msg, required);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		validateRequired(context, component, value);
		/*
		 * se crea la mascara
		 */
		Pattern mask = Pattern.compile(HOUR_FORMAT);

		/* retrieve the string value of the field */
		String hourNumber = (String) value;

		Matcher matcher = mask.matcher(hourNumber);

		if (!matcher.matches()) {

			if (component instanceof HtmlInputTextarea)
				((HtmlInputTextarea) component).requestFocus();
			else if (component instanceof HtmlInputText)
				((HtmlInputText) component).requestFocus();

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			String ierrmsg = "Formato de hora mal digitada '" + errmsg + "'";

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
