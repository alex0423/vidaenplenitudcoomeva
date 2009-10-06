package co.com.vep.util;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class CustomValueChangeListener implements ValueChangeListener {

	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		((UIInput) event.getComponent()).validate(FacesContext
				.getCurrentInstance());
	}
}
