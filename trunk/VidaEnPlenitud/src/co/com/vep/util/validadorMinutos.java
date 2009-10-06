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

public class validadorMinutos extends BaseValidator implements Validator {

	/** Minutos */
	private static final String MINUTES_FORMAT = "[0-5][0-9]";

	public validadorMinutos() {
		super();
	}

	public validadorMinutos(String msg) {
		super(msg);
	}

	public validadorMinutos(String msg, boolean required) {
		super(msg, required);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		validateRequired(context, component, value);
		/*
		 * se crea la mascara
		 */
		Pattern mask = Pattern.compile(MINUTES_FORMAT);

		/* retrieve the string value of the field */
		String minuteNumber = (String) value;

		Matcher matcher = mask.matcher(minuteNumber);

		if (!matcher.matches()) {

			if (component instanceof HtmlInputTextarea)
				((HtmlInputTextarea) component).requestFocus();
			else if (component instanceof HtmlInputText)
				((HtmlInputText) component).requestFocus();

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			String ierrmsg = "Formato de minutos mal digitada '" + errmsg + "'";

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
