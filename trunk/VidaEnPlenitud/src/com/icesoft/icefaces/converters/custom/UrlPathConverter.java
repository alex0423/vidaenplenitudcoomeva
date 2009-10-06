package com.icesoft.icefaces.converters.custom;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class UrlPathConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return reducePath(String.valueOf(value));
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return reducePath(String.valueOf(value));
	}

	private String reducePath(String realPath) {
		try {
			if (realPath.contains("/"))
				return realPath.substring(realPath.lastIndexOf("/") + 1);
			else if (realPath.contains("\\"))
				return realPath.substring(realPath.lastIndexOf("\\") + 1);
			return realPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
