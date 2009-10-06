package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepDetalleConsultoria;

public interface IQueryVepDetalleConsultoriaDAO {

	public Integer searchSequence() throws Exception;

	public Integer insert(VepDetalleConsultoria entity) throws Exception;

	public List<VepDetalleConsultoria> findByFilter(String idServicio,
			String asesor, String ciudad, String estado, Date fechaInicio,
			Date fechaFin, Long idRegional) throws Exception;
}
