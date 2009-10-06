package co.com.vep.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class SelectOneValidator extends BaseValidator implements Validator {

	public SelectOneValidator() {
		super();
	}

	public SelectOneValidator(String msg) {
		super(msg);
	}

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		
	}

}
