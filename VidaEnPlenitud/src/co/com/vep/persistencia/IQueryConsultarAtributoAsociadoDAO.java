/**
 * 
 */
package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAtributoAsociado;

/**
 * @author tobias.mosquera
 *
 */
public interface IQueryConsultarAtributoAsociadoDAO {
	
	public List<VepAtributoAsociado> consultarAsociadoEnAtributo(List<Integer> codigos);
	public List<VepAtributoAsociado> consultarASociadosParametrizados(Long codigo);

}
