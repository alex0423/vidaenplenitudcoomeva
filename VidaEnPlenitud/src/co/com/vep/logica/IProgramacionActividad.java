package co.com.vep.logica;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.extension.VepAsistenteProgAsociado;

public interface IProgramacionActividad {

	public List<VepParametroActividad> findParametroActividad()
			throws Exception;

	public List<VepProgramacion> findProgramacionGrupo(Object grupo)
			throws Exception;

	public VepProgramacion obtener(Integer idProgramacion) throws Exception;

	public VepProgramacion obtenerByActividadGrupo(Integer idActividad,
			String grupo) throws Exception;

	public VepProfesor findProfesor(Long tipoId, Long identificacion)
			throws Exception;

	public List<VepLugar> findLugar() throws Exception;

	public List<VepSipParametro> findListEstados(String propiedad, Object value)
			throws Exception;

	public void registrarProgramacion(Integer codigoActividad,
			String codigoGrupo, Date fechaInicio, Date fechaFinal,
			Timestamp horaInicio, Timestamp horaTermina, String nivel, String estado,
			Long tipoId, Long identificacionProfesor, Integer codigoLugar,
			Long cupoMinimo, Long cupoMaximo, Long regional) throws Exception;

	public List<VepAsistenteProgAsociado> listaProgActividades(String property,
			Object date1, Object date2) throws Exception;

	public VepLugar findLugarSitio(Integer codigoLugar) throws Exception;

	public String buscarCiudadxCodigo(String codigo) throws Exception;

	public List<VepProgramacion> programadasProfesor(Long tipoId,
			Long identificacion) throws Exception;
}
