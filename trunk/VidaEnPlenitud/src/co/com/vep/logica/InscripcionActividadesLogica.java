package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.parametros.modelo.DelegadoWsParametros;
import co.com.parametros.modelo.DelegadoWsParametrosServiceLocator;
import co.com.parametros.modelo.Parametros;
import co.com.parametros.modelo.ParametrosWS;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipParametroWork;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepProgramacionDAO;
import co.com.vep.persistencia.QueryVepSipParametroDAO;
import co.com.vep.persistencia.VepAsistenteProgDAO;
import co.com.vep.persistencia.VepAsociadoDAO;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.persistencia.VepProgramacionDAO;

public class InscripcionActividadesLogica implements IInscripcionActividades {

	public List<VepSipParametro> findActividad() throws Exception {
		// TODO Auto-generated method stub
		try {
			return new QueryVepSipParametroDAO().findAllCodigo(new Integer(1));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public AsociadoVida consultarAsociado(long tipoDocumento,
			long identificacion) throws Exception {
		// TODO Auto-generated method stub
		DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
		DelegadoAsociadoVidaWS delegado = delASoc.getdatosAsociadoVida();
		AsociadoVida asociado = null;

		try {
			// Consulta los datos
			asociado = delegado.consultarAsociadoVida(identificacion,
					tipoDocumento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return asociado;
	}

	public VepSipParametroWork[] findActividadSelectedRow() throws Exception {
		// TODO Auto-generated method stub
		VepSipParametroWork para;
		int max = findActividad().size();
		VepSipParametroWork[] parametroWork = new VepSipParametroWork[max];
		List<VepSipParametro> vep = findActividad();
		for (int i = 0; i < max; i++) {
			para = new VepSipParametroWork();
			para.setParametro(vep.get(i));
			parametroWork[i] = para;
		}
		return parametroWork;
	}

	public Parametros[] getTipoDocumento(long codigo) throws Exception {
		// TODO Auto-generated method stub
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		DelegadoWsParametros delegado = null;
		ParametrosWS param = null;

		try {
			delegado = delLoc.getconsultarParametros();
			param = delegado.consultarParametrosXTipo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return param.getParametros();
	}

	public VepParametroActividad findParametroActividad(Integer codigoParametro)
			throws Exception {
		// TODO Auto-generated method stub
		return new VepParametroActividadDAO().findById(codigoParametro);
	}

	public VepProgramacion findProgramacionGrupo(String propertyName1,
			Object grupo) throws Exception {
		// TODO Auto-generated method stub
		return new QueryVepProgramacionDAO().findByPropertyGrupo(propertyName1,
				grupo);
	}

	public VepAsociado findAsociado(Long numInt) throws Exception {
		// TODO Auto-generated method stub
		return new VepAsociadoDAO().findById(numInt);
	}

	public void saveInscripcion(VepAsociado asociado,
			VepProgramacion programacion) throws Exception {
		// TODO Auto-generated method stub
		VepAsistenteProg asistenteProg = new VepAsistenteProg();
		asistenteProg.setFecha(new Date());
		asistenteProg.setVepAsociado(asociado);
		asistenteProg.setVepProgramacion(programacion);
		int cupo = programacion.getCupoAsistentes() + 1;
		programacion.setCupoAsistentes(new Integer(cupo));

		try {
			IQueryVepAsistenteProgDAO iqvapd = new QueryVepAsistenteProgDAO();
			iqvapd.insertNamedQuery(asistenteProg, programacion);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<VepAsistenteProg> buscarIncripciones(Long idAsociado)
			throws Exception {
		// TODO Auto-generated method stub
		return new QueryVepAsistenteProgDAO().findByIdAsociado(idAsociado);
	}
}
