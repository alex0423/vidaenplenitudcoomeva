package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.VepProgramacion;

public interface IGrabarAsistencia {

	public List<VepProgramacion> findProgramacionGrupo(String property,
			Object value) throws Exception;

	public List<VepPlusBuc> findListadoAsistencia(Integer actividad,
			String grupo) throws Exception;

	public void saveListadoAsistencia(Integer idProgramacion,
			List<Long> asistenciaPositiva, List<Long> asistenciaNegativa,
			Date fecha) throws Exception;
}
