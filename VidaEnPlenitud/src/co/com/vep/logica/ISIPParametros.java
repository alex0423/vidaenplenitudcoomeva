package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepSipParametro;

public interface ISIPParametros {

	public List<VepSipParametro> obtenerByTipo(Integer tipo) throws Exception;

	//public List<VepSipParametro> obtenerTodosConocimiento() throws Exception;

	public VepSipParametro obtener(Integer id) throws Exception;

	public List<VepSipParametro> loadParameters(String parameterGroup)
			throws Exception;
}
