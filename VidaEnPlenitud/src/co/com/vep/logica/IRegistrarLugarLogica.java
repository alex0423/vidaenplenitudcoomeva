package co.com.vep.logica;

import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepSitio;

public interface IRegistrarLugarLogica {

	public VepSitio buscarSitioPorCodigo(Integer codigo) throws Exception;

	public VepLugar buscarLugarPorCodigo(Integer codigo, Integer Lugar)
			throws Exception;

	public void registroLugarActividad(VepSitio sitio, VepLugar lugar)
			throws Exception;

	public void registroLugarActividad(VepLugar lugar) throws Exception;

	public VepLugar buscarLugarPorCodigo(Integer codigo) throws Exception;
	
	public String buscarCiudadxCodigo(String codigo)throws Exception;
}
