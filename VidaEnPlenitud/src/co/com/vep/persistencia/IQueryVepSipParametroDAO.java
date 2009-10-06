package co.com.vep.persistencia;

import java.util.ArrayList;
import java.util.List;

import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipparametroTipo;

public interface IQueryVepSipParametroDAO {

	public List<VepSipParametro> findAllCodigo(Object codigo)throws Exception;
	public List<VepSipparametroTipo> codigoParametrosTipo(Object codigo1,Object codigo2)throws Exception;
	public Long searchSecuence()throws Exception;
	public void insertActividad(VepSipParametro entity)throws Exception;
	
	public List<VepAtributoAsociado> codigoParametrosAtriASO(Object codigo1,Object codigo2,Long idAsociado)throws Exception;
	
	public ArrayList<VepSipParametro> obtenerNombresServicioMedico(List<VepSipParametro> datos_sipParam,List<VepAtributoAsociado> datos_atriAso)
	throws Exception;
	
	public List<VepSipParametro> sacarListadoServicioMedico(Long idAsociado);
	
	//public List<VepSipParametro> obtener
	
}
