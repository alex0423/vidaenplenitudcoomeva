package co.com.vep.persistencia;

import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorPlusBuc;

public interface IQueryVepProfesorDAO {

	public abstract VepProfesor obtener(Long tipoId, Long idProfesor)
			throws Exception;
}