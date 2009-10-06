package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepUbicacionProfesor;

public interface IQueryVepUbicacionProfesorDAO {

	public List<VepUbicacionProfesor> findByProperty(Object tipoId,
			Object numDocumento);
}
