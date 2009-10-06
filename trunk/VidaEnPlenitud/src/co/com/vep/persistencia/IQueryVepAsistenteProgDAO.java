package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepProgramacion;

public interface IQueryVepAsistenteProgDAO {

	public List<VepAsistenteProg> findByDateRange(Date fechaInicio,
			Date fechaFin) throws Exception;

	public List<VepAsistenteProg> findByDateRange(Date fechaInicio,
			Date fechaFin, Integer idRegional) throws Exception;

	public List<VepAsistenteProg> findByProgramacion(Integer programacion)
			throws Exception;

	public void insert(VepAsistenteProg entity) throws Exception;

	public void insert(List<VepAsistenteProg> entities) throws Exception;

	public void insertNamedQuery(VepAsistenteProg entity,
			VepProgramacion programacion) throws Exception;

	public List<VepAsistenteProg> findByDateRange1(Date fechaInicio)
			throws Exception;

	public List<VepAsistenteProg> findByDateRange1(Date fechaInicio,
			Integer idRegional) throws Exception;

	public List<VepAsistenteProg> findByDateRange2(Date fechaFin)
			throws Exception;

	public List<VepAsistenteProg> findByDateRange2(Date fechaFin,
			Integer idRegional) throws Exception;

	public List<VepAsistenteProg> findWithoutDateRange() throws Exception;

	public List<VepAsistenteProg> findWithoutDateRange(Integer idRegional)
			throws Exception;

	public List<VepAsistenteProg> findByIdAsociado(Long idAsociado)
			throws Exception;
}
