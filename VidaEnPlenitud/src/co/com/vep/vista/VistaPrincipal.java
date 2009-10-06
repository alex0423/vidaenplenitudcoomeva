package co.com.vep.vista;

import co.com.vep.seguridad.Session;

public class VistaPrincipal {

	private String inicio;
	
	public VistaPrincipal() {
		if (Session.isSessionAlive()) {
		}
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

}
