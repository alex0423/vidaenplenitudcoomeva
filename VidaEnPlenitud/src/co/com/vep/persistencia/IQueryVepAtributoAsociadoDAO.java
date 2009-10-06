package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAtributoAsociado;

public interface IQueryVepAtributoAsociadoDAO {

	public abstract List<VepAtributoAsociado> obtenerByAsociado(Long idAsociado)
			throws Exception;

}