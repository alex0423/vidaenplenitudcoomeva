package co.com.vep.logica;

import java.util.List;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.parametros.modelo.Parametros;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipParametroWork;

public interface IInscripcionActividades {

	public AsociadoVida consultarAsociado(long tipoDocumento,
			long identificacion) throws Exception;

	public List<VepSipParametro> findActividad() throws Exception;

	public VepSipParametroWork[] findActividadSelectedRow() throws Exception;

	public Parametros[] getTipoDocumento(long codigo) throws Exception;

	public VepParametroActividad findParametroActividad(Integer codigoParametro)
			throws Exception;

	public VepProgramacion findProgramacionGrupo(String propertyName1,
			Object grupo) throws Exception;

	public VepAsociado findAsociado(Long numInt) throws Exception;

	public void saveInscripcion(VepAsociado asociado,
			VepProgramacion programacion) throws Exception;

	public List<VepAsistenteProg> buscarIncripciones(Long idAsociado)
			throws Exception;
}
