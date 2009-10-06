/**
 * 
 */
package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;

/**
 * @author tobias.mosquera
 *
 */
public interface IQueryConsultarAsociadoVEPDAO {
	public List<VepAsociado> realizarConsultaxTD_Doc(Long identificacion,
			String tipoID);
	
	public List<VepAtributoAsociado> hallarServiciosMedicosAsociado(Long idAsociado);
	public List<VepSipParametro> nombresServiciosMedicos(List<VepAtributoAsociado> info) throws Exception;
    public List<VepAsociado> consultarAsociadoVEP_Datos(Date fechaIngVEP,
			Date fechaNace, String genero, String ocupacion, String tipoSangre,
			String estCivil, Integer edad);
 
}
