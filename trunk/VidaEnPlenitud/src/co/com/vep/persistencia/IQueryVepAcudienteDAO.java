package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepUbicacionAcudiente;

public interface IQueryVepAcudienteDAO {

	public VepAcudiente findByTipoDocDocumento(Long tipoDocumento,
			Long documento) throws Exception;

	public List<VepUbicacionAcudiente> findUbicacionAcudiente(Integer idAcudiente)
			throws Exception;

}
