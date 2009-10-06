package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepProfesorPlusBuc;
import co.com.vep.modelo.VepProgramacion;

public interface IQueryVepProgramacionDAO {

	public VepProgramacion findByPropertyGrupo(String propertyName1,
			Object value1);

	public List<VepProgramacion> findByProperty(String propertyName1,
			Object value1);

	public List<VepAsistenteProg> findByFecha(String propertyName1,
			Object value1, Object value2);

	public VepProgramacion findByActividadGrupo(Integer actividad, String grupo)
			throws Exception;

	public List<VepAsistenteProg> findByFecha1(String propertyName1,
			Object value1);

	public List<VepAsistenteProg> findByFecha2(String propertyName1,
			Object value2);

	public List<VepAsistenteProg> findWithoutFecha();

	public List<VepProgramacion> findProfesorProgramado(Long tipoId,
			Long identificacion) throws Exception;
}
