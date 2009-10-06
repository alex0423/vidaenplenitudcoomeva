package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepSipParametro;

public interface ICreacionActividadesLogica {

	public VepParametroActividad findParametroActividad(Integer codigoParametro) throws Exception;

	public void registrarActividad(Integer codigo, String actividad, String estado) throws Exception;

	public List<VepParametroActividad> findByNombre(Object nombre) throws Exception;
	
	public List<VepSipParametro> listaEstados(String propiedad, Object value) throws Exception;
}
