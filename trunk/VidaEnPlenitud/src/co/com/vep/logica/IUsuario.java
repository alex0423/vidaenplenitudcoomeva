package co.com.vep.logica;

import co.com.vep.modelo.VepUsuario;

public interface IUsuario {

	public VepUsuario obtenerByLogin(String login);
	
}
