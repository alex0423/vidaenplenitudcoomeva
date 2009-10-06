package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.modelo.extension.DataRecordAsistenciasActividad;
import co.com.vep.modelo.extension.ListadoAsistencia;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepAsistenteProgDAO;
import co.com.vep.persistencia.QueryVepAsistenteProgDAO;

public class AsistenteProgramacionLogica {

	public List<VepAsistenteProg> obtenerByRango(Date fechaInicio,
			Date fechaFin, Integer idRegional) throws Exception {
		if (fechaInicio != null && fechaFin == null) {
			try {
				IQueryVepAsistenteProgDAO vapDao = new QueryVepAsistenteProgDAO();
				if (idRegional == null)
					return vapDao.findByDateRange1(fechaInicio);

				return vapDao.findByDateRange1(fechaInicio, idRegional);
			} catch (Exception e) {
				throw e;
			}
		} else if (fechaInicio == null && fechaFin != null) {
			try {
				IQueryVepAsistenteProgDAO vapDao = new QueryVepAsistenteProgDAO();
				if (idRegional == null)
					return vapDao.findByDateRange2(fechaFin);

				return vapDao.findByDateRange2(fechaFin, idRegional);
			} catch (Exception e) {
				throw e;
			}
		} else if (fechaInicio == null && fechaFin == null) {
			try {
				IQueryVepAsistenteProgDAO vapDao = new QueryVepAsistenteProgDAO();
				if (idRegional == null)
					return vapDao.findWithoutDateRange();

				return vapDao.findWithoutDateRange(idRegional);
			} catch (Exception e) {
				throw e;
			}
		} else {
			try {
				IQueryVepAsistenteProgDAO vapDao = new QueryVepAsistenteProgDAO();
				if (idRegional == null)
					return vapDao.findByDateRange(fechaInicio, fechaFin);

				return vapDao
						.findByDateRange(fechaInicio, fechaFin, idRegional);
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public void registrar(Long idAsociado, Long idProgramacion, String Asistio,
			Date fecha) throws Exception {
		try {

			VepAsociado vepAsociado = (VepAsociado) EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepasociado.findbyasociado").setParameter(
							"idAsociado", idAsociado).getSingleResult();
			if (vepAsociado == null)
				throw new Exception("VepAsociado no existe");

			VepProgramacion vepProgramacion = (VepProgramacion) EntityManagerHelper
					.getEntityManager().createNamedQuery(
							"vepprogramacion.findbyid").setParameter("id",
							idProgramacion).getSingleResult();
			if (vepProgramacion == null)
				throw new Exception("VepProgramacion no existe");

			VepAsistenteProg vap = new VepAsistenteProg();
			vap.setAsistio(Asistio);
			vap.setFecha(fecha);
			vap.setVepAsociado(vepAsociado);
			vap.setVepProgramacion(vepProgramacion);

			IQueryVepAsistenteProgDAO queryDao = new QueryVepAsistenteProgDAO();
			queryDao.insert(vap);
		} catch (Exception e) {
			throw e;
		}
	}

	public void saveListadoAsistencia(List<ListadoAsistencia> listaAsistencia,
			Date fecha) throws Exception {
		// TODO Auto-generated method stub
		VepAsistenteProg asistenteProg = null;
		try {
			for (ListadoAsistencia listadoAsistencia2 : listaAsistencia) {
				asistenteProg = new VepAsistenteProg();
				asistenteProg.setVepAsociado(listadoAsistencia2
						.getAsistenteProg().getVepAsociado());
				asistenteProg.setVepProgramacion(listadoAsistencia2
						.getAsistenteProg().getVepProgramacion());
				asistenteProg.setAsistio(listadoAsistencia2.getAsistenteProg()
						.getAsistio());
				asistenteProg.setFecha(fecha);

				IQueryVepAsistenteProgDAO queryDao = new QueryVepAsistenteProgDAO();
				queryDao.insert(asistenteProg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
