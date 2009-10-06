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

public class validadorReales extends BaseValidator implements Validator {

	private static final String REAL_FORMAT = "[1|2]\\.[0-9]{2}";

	public validadorReales() {
		super();
	}

	public validadorReales(String msg) {
		super(msg);
	}

	public validadorReales(String msg, boolean required) {
		super(msg, required);
	}

	public void validate(FacesContext arg0, UIComponent component, Object value)
			throws ValidatorException {
		// TODO Auto-generated method stub
		/*
		 * se crea la mascara
		 */
		Pattern mask = Pattern.compile(REAL_FORMAT);

		/* retrieve the string value of the field */
		String realFormat = value.toString();

		Matcher matcher = mask.matcher(realFormat);

		if (!matcher.matches()) {
			if (component instanceof HtmlInputTextarea)
				((HtmlInputTextarea) component).requestFocus();
			else if (component instanceof HtmlInputText)
				((HtmlInputText) component).requestFocus();

			((UIInput) component).setValid(false);
			component.getAttributes().put("styleClass", "ERROR");

			String ierrmsg = "Formato mal digitado Ej: 1.90 '" + errmsg + "'";

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
