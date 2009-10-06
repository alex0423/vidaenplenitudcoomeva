package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepSipParametro;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.VepSipParametroDAO;
import co.com.vep.properties.LocalApplicationConfiguration;

public class SIPParametrosLogica implements ISIPParametros {

	public VepSipParametro obtener(Integer id) throws Exception {
		try {
			VepSipParametroDAO vspDao = new VepSipParametroDAO();
			return vspDao.findById(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<VepSipParametro> obtenerByTipo(Integer tipo) throws Exception {
		try {
			return (List<VepSipParametro>) EntityManagerHelper
					.getEntityManager()
					.createNamedQuery("vepsipparametro.tipo").setParameter(
							"idTipo", tipo).getResultList();
		} catch (Exception e) {
			throw e;
		}
	}
	
//	public List<VepSipParametro> obtenerTodosConocimiento() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_conocimiento"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosHobbies() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_hobbies"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosServiciosMedicos()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_serviciosmedicos"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosServiciosOfrecer()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_serviciosofrecer"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosPatologias() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_patologias"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosEstados() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_estado"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosMediosConocimiento()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_mediosconocimiento"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAtencion() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_atencion"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosRequiereApoyo() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_apoyorecuerdos"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosRecuerdosPasados()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_hechospasados"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosRecuerdosRecientes()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_hechosrecientes"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosGrupoAmigos() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_amigos"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosApoyoFamiliar() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_apoyofamiliar"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosSituacionTristeza()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_tristeza"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosSituacionDuelo() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_duelo"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAcondicionamiento()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_acondicionamiento1"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAutopercepcion() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_autopercepcion"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosValoracionPostura()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_postura"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosValoracionCuello()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_cuello"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosFMMS() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_fmms"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosFMMI() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_fmmi"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodoAIVD() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_aivd"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAAVD() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_aavd"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosMAMI() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_mami"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosMAMS() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_mams"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAbdominales() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_abdominales"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAntecedentesClinicos()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_antecedentesclinicos"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosAutopercepcionVida()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_autopercepcionvida"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosEstadoConsultoria()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_estadoconsultoria"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosNivelAcondicionamiento()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_nivelacondicionamiento"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosABVD() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_abvd"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosNivelDependenciaVD()
//			throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_niveldependencia_vd"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosEquilibrio() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_equilibrio"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosFlexibilidad() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_flexibilidad"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//
//	public List<VepSipParametro> obtenerTodosMarcha() throws Exception {
//		try {
//			int tipo = Integer.parseInt(LocalApplicationConfiguration.Util
//					.getInstance().getProperty("tipo_marcha"));
//			if (tipo == 0)
//				throw new Exception("Error de configuracion de parametros");
//			return obtenerByTipo(tipo);
//		} catch (Exception e) {
//			throw e;
//		}
//	}

	public List<VepSipParametro> loadParameters(String parameterGroup)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			int tipo = Integer.parseInt(parameterGroup);
			if (tipo == 0)
				throw new Exception("Error de configuracion de parametros");
			return obtenerByTipo(tipo);
		} catch (Exception e) {
			throw e;
		}
	}
}
