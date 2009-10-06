package co.com.vep.persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepProfesorPlusBuc;
import co.com.vep.modelo.VepProgramacion;

public class QueryVepProgramacionDAO implements IQueryVepProgramacionDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public VepProgramacion findByPropertyGrupo(String propertyName1,
			Object value1) {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepProgramacion instance with property1: "
						+ propertyName1 + ", value: " + value1, Level.INFO,
				null);
		try {
			final String queryString = "select a from VepProgramacion a where a."
					+ propertyName1 + "= :propertyValue1";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			return (VepProgramacion) query.getSingleResult();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepProgramacion> findByProperty(String propertyName1,
			Object value1) {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepProgramacion instance with property1: "
						+ propertyName1 + ", value: " + value1, Level.INFO,
				null);
		try {
			final String queryString = "select a from VepProgramacion a, VepParametroActividad b where a.idActividadPar = b.idActividadpar and b.idActividadpar = :propertyValue1";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", value1);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByFecha(String propertyName1,
			Object value1, Object value2) {
		// TODO Auto-generated method stub
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		Date date1 = (Date) value1;
		Date date2 = (Date) value2;

		String formatoDate1 = formato.format(date1);
		String formatoDate2 = formato.format(date2);

		EntityManagerHelper.log(
				"finding VepProgramacion instance with property1: "
						+ propertyName1 + ", value: " + value1, Level.INFO,
				null);
		try {
			final String queryString = "select model2 from VepProgramacion model, VepAsistenteProg model2 where model."
					+ propertyName1
					+ " between '"
					+ formatoDate1
					+ "' and '"
					+ formatoDate2
					+ "' and "
					+ "model2.vepProgramacion.idProgramacion = model.idProgramacion ";
			Query query = getEntityManager().createQuery(queryString);
			// query.setParameter("propertyValue1", value1);
			// query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public VepProgramacion findByActividadGrupo(Integer actividad, String grupo)
			throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepProgramacion instance with value1: " + actividad
						+ ", value2: " + grupo, Level.INFO, null);
		try {
			final String queryString = "select a from VepProgramacion a, "
					+ "VepParametroActividad b where "
					+ "a.idActividadPar = b.idActividadpar and b.idActividadpar = :value1 and a.grupo = :value2";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("value1", actividad);
			query.setParameter("value2", grupo);
			return (VepProgramacion) query.getSingleResult();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByFecha1(String propertyName1,
			Object value1) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		Date date1 = (Date) value1;

		String formatoDate1 = formato.format(date1);

		try {
			final String queryString = "select model2 from VepProgramacion model, VepAsistenteProg model2 where model."
					+ propertyName1
					+ " between '"
					+ formatoDate1
					+ "' and '"
					+ formatoDate1
					+ "' and "
					+ "model2.vepProgramacion.idProgramacion = model.idProgramacion ";
			Query query = getEntityManager().createQuery(queryString);
			// query.setParameter("propertyValue1", value1);
			// query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByFecha2(String propertyName1,
			Object value2) {

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		Date date2 = (Date) value2;

		String formatoDate2 = formato.format(date2);
		try {
			final String queryString = "select model2 from VepProgramacion model, VepAsistenteProg model2 where model."
					+ propertyName1
					+ " between '"
					+ formatoDate2
					+ "' and '"
					+ formatoDate2
					+ "' and "
					+ "model2.vepProgramacion.idProgramacion = model.idProgramacion ";
			Query query = getEntityManager().createQuery(queryString);
			// query.setParameter("propertyValue1", value1);
			// query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findWithoutFecha() {
		try {
			final String queryString = "select model2 from VepProgramacion model, VepAsistenteProg model2 where "
					+ "model2.vepProgramacion.idProgramacion = model.idProgramacion ";
			Query query = getEntityManager().createQuery(queryString);
			// query.setParameter("propertyValue1", value1);
			// query.setParameter("propertyValue2", value2);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepProgramacion> findProfesorProgramado(Long tipoId,
			Long identificacion) throws Exception {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select a from VepProgramacion a where a.tipoId = :tipoId and a.idProfesor = :idProfesor";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("tipoId", tipoId);
			query.setParameter("idProfesor", identificacion);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}
}
