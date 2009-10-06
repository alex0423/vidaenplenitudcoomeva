package co.com.vep.persistencia;

import co.com.vep.modelo.VepProfesor;

public interface IQueryVepProfesorPlusBucDAO {

	public abstract VepProfesor obtenerByAsociado(Long tipoId, Long numero)
			throws Exception;

}