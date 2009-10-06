package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepProgramacionDAO;

public class GrabarAsistenciaLogica implements IGrabarAsistencia {

	public List<VepProgramacion> findProgramacionGrupo(String property,
			Object value) throws Exception {
		return new QueryVepProgramacionDAO().findByProperty(property, value);
	}

	public List<VepPlusBuc> findListadoAsistencia(Integer actividad,
			String grupo) throws Exception {

		try {
			Query nquery = EntityManagerHelper
					.getEntityManager()
					.createNativeQuery(
							"SELECT DISTINCT "
									+ "buc.id, buc.numint_asociado, "
									+ "buc.documento, buc.nombre1_asociado,  "
									+ "buc.nombre2_asociado, buc.apellido1_asociado, "
									+ "buc.apellido2_asociado, buc.id_asociado, "
									+ "buc.estado_asociado, buc.FECHA_INGRESOVP, "
									+ "buc.COMPARTIR_CONOCIMIENTOS, buc.DOCUMENTO_ACUDIENTE, "
									+ "buc.nombre1_acudiente, buc.nombre2_acudiente,  "
									+ "buc.apellido1_acudiente, buc.apellido2_acudiente, "
									+ "buc.id_acudiente, buc.ESTCIVIL,  "
									+ "buc.FECHA_NACE, buc.GENERO, "
									+ "buc.MEDICAMENTOS, buc.NUMERO_HORAS_DISP_SV, "
									+ "buc.OCUPACION, buc.TIPODOCUMENTO_ASOCIADO,  "
									+ "buc.TIPODOCUMENTO_ACUDIENTE, buc.TIPO_SANGRE  "
									+ "from VEP.VEP_PLUS_BUC buc  "
									+ "JOIN (  "
									+ "select asistente.ID_ASOCIADO, asistente.ID_PROGRAMACION, asistente.FECHA "
									+ "from vep.vep_asistente_prog asistente "
									+ "JOIN vep.vep_programacion programacion ON asistente.ID_PROGRAMACION = programacion.ID_PROGRAMACION "
									+ "where programacion.ID_ACTIVIDAD_PAR = :idActividad and programacion.GRUPO = :idGrupo and asistente.ASISTIO IS NULL "
									+ ") asistencia ON asistencia.ID_ASOCIADO = buc.numint_asociado ",
							VepPlusBuc.class);
			nquery.setParameter("idActividad", actividad);
			nquery.setParameter("idGrupo", grupo);
			return nquery.getResultList();
		} catch (Exception e) {
			throw e;
		}

		/*
		 * DelegadoAsociadoVidaWSServiceLocator delASoc = new
		 * DelegadoAsociadoVidaWSServiceLocator(); DelegadoAsociadoVidaWS
		 * delegado = delASoc.getdatosAsociadoVida(); AsociadoVida asociado =
		 * null; AsociadoVida asociadoProfesor = null; ListadoAsistencia
		 * asistencia = null; VepProgramacion vepProgramacion = new
		 * VepProgramacion(); List<VepAsistenteProg> listaAsistentes = new
		 * ArrayList<VepAsistenteProg>(); List<ListadoAsistencia> listado =
		 * new ArrayList<ListadoAsistencia>(); String nombreProfesor = "";
		 * String nombreAsociado = "";
		 * 
		 * vepProgramacion = new QueryVepProgramacionDAO().findByActividadGrupo(
		 * actividad, grupo);
		 * 
		 * long idProfesor = vepProgramacion.getVepProfesor().getIdProfesor()
		 * .longValue(); try { // Consulta los datos asociadoProfesor =
		 * delegado.consultarAsociadoVida(idProfesor, 1l); nombreProfesor =
		 * asociadoProfesor.getNombre1() + " " + asociadoProfesor.getNombre2() + " " +
		 * asociadoProfesor.getPrimerApellido() + " " +
		 * asociadoProfesor.getSegundoApellido(); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * listaAsistentes = new QueryVepAsistenteProgDAO()
		 * .findByProgramacion(vepProgramacion.getIdProgramacion());
		 * 
		 * for (VepAsistenteProg asistentes : listaAsistentes) { long
		 * tipoIdentificacion = Long.parseLong(asistentes
		 * .getVepAsociado().getTipoDocumento()); long identificacion =
		 * asistentes.getVepAsociado().getDocumento() .longValue(); try { //
		 * Consulta los datos asociado =
		 * delegado.consultarAsociadoVida(identificacion, tipoIdentificacion);
		 * nombreAsociado = asociado.getNombre1() + " " + asociado.getNombre2() + " " +
		 * asociado.getPrimerApellido() + " " + asociado.getSegundoApellido();
		 * asistencia = new ListadoAsistencia();
		 * asistencia.setProgramacion(vepProgramacion);
		 * asistencia.setNombreAsociado(nombreAsociado);
		 * asistencia.setNombreProfesor(nombreProfesor);
		 * asistencia.setAsociado(asociado);
		 * asistencia.setAsistenteProg(asistentes); listado.add(asistencia); }
		 * catch (Exception e) { e.printStackTrace(); } } return listado;
		 */}

	public void saveListadoAsistencia(Integer idProgramacion,
			List<Long> asistenciaPositiva, List<Long> asistenciaNegativa,
			Date fecha) throws Exception {

		VepAsistenteProg asistenteProg = null;
		VepAsociado asociado = null;
		VepProgramacion programacion = null;
		List<VepAsistenteProg> listaAsistentes = new ArrayList<VepAsistenteProg>();
		try {
			for (Long item : asistenciaPositiva) {
				asistenteProg = new VepAsistenteProg();
				asociado = new VepAsociado();
				programacion = new VepProgramacion();

				asociado.setIdAsociado(item);
				programacion.setIdProgramacion(idProgramacion);

				asistenteProg.setVepAsociado(asociado);
				asistenteProg.setVepProgramacion(programacion);
				asistenteProg.setAsistio("SI");
				asistenteProg.setFecha(fecha);
				listaAsistentes.add(asistenteProg);
			}

			for (Long item : asistenciaNegativa) {
				asistenteProg = new VepAsistenteProg();
				asociado = new VepAsociado();
				programacion = new VepProgramacion();

				asociado.setIdAsociado(item);
				programacion.setIdProgramacion(idProgramacion);

				asistenteProg.setVepAsociado(asociado);
				asistenteProg.setVepProgramacion(programacion);
				asistenteProg.setAsistio("NO");
				asistenteProg.setFecha(fecha);
				listaAsistentes.add(asistenteProg);
			}

			IQueryVepAsistenteProgDAO queryDao = new QueryVepAsistenteProgDAO();
			queryDao.insert(listaAsistentes);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
