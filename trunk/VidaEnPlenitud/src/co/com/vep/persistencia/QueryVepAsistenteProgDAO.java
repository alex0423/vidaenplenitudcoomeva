package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepProgramacion;

public class QueryVepAsistenteProgDAO implements IQueryVepAsistenteProgDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByDateRange(Date fechaInicio,
			Date fechaFin) throws Exception {
		try {
			return EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepasistenteprog.findbydate").setParameter("fechaInicio",
					fechaInicio).setParameter("fechaFin", fechaFin)
					.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByProgramacion(Integer programacion)
			throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper
				.log("finding VepAsistenteProg instance with value: "
						+ programacion, Level.INFO, null);
		try {
			final String queryString = "select distinct model from VepAsistenteProg model join model.vepProgramacion b "
					+ "where b.idProgramacion = :value";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("value", programacion);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public void insert(VepAsistenteProg entity) throws Exception {
		try {
			VepAsistenteProgDAO vapDao = new VepAsistenteProgDAO();

			EntityManagerHelper.beginTransaction();
			vapDao.save(entity);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			throw e;
		}
	}

	public void insert(List<VepAsistenteProg> entities) throws Exception {
		try {
			VepAsistenteProgDAO vapDao = new VepAsistenteProgDAO();

			EntityManagerHelper.beginTransaction();
			for (VepAsistenteProg entity : entities) {
				EntityManagerHelper.getEntityManager().createNamedQuery(
						"vepasistenteprog.insertAsistente").setParameter(1,
						entity.getVepAsociado().getIdAsociado()).setParameter(
						2, entity.getVepProgramacion().getIdProgramacion())
						.setParameter(3, entity.getAsistio()).setParameter(4,
								entity.getFecha()).executeUpdate();
			}
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
			throw e;
		}
	}

	public void insertNamedQuery(VepAsistenteProg entity,
			VepProgramacion programacion) throws Exception {
		// TODO Auto-generated method stub
		try {
			EntityManagerHelper.beginTransaction();
			EntityManagerHelper.getEntityManager().createNamedQuery(
					"vepasistenteprog.insertAsistente").setParameter(1,
					entity.getVepAsociado().getIdAsociado()).setParameter(2,
					entity.getVepProgramacion().getIdProgramacion())
					.setParameter(3, entity.getAsistio()).setParameter(4,
							entity.getFecha()).executeUpdate();
			new VepProgramacionDAO().update(programacion);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.commit();
		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerHelper.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByDateRange1(Date fechaInicio)
			throws Exception {
		try {
			final String queryString = "select a from VepAsistenteProg a join a.vepProgramacion p where a.fecha > :fechaInicio)";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("fechaInicio", fechaInicio);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByDateRange1(Date fechaInicio,
			Integer idRegional) throws Exception {
		try {
			final String queryString = "select a from VepAsistenteProg a join a.vepProgramacion p, VepRegional r where p.idRegional = r.idRegional and a.fecha > :fechaInicio and r.idRegional = :regional";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("fechaInicio", fechaInicio);
			query.setParameter("idRegional", idRegional);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByDateRange2(Date fechaFin)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select a from VepAsistenteProg a where a.fecha < :fechaFin";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("fechaFin", fechaFin);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByDateRange2(Date fechaFin,
			Integer idRegional) throws Exception {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select a from VepAsistenteProg a join a.vepProgramacion p, VepRegional r where a.fecha < :fechaFin  and p.idRegional = r.idRegional and r.idRegional = :regional";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("fechaFin", fechaFin);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findWithoutDateRange() throws Exception {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select a from VepAsistenteProg a";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findWithoutDateRange(Integer idRegional)
			throws Exception {
		try {
			System.out.println("codigo regional -> "+idRegional);
			final String queryString = "select a from VepAsistenteProg a join a.vepProgramacion p, VepRegional r where p.idRegional = r.idRegional and r.idRegional = :idRegional";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("idRegional", idRegional);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByDateRange(Date fechaInicio,
			Date fechaFin, Integer idRegional) throws Exception {
		try {
			final String queryString = "select a from VepAsistenteProg a join a.vepProgramacion p, VepRegional r where a.fecha between :fechaInicio and :fechaFin and p.idRegional = r.idRegional and r.idRegional = :idRegional";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("fechaInicio", fechaInicio);
			query.setParameter("fechaFin", fechaFin);
			query.setParameter("idRegional", idRegional);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepAsistenteProg> findByIdAsociado(Long idAsociado)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			final String queryString = "select a from VepAsistenteProg a where a.vepAsociado.idAsociado = :idAsociado and a.asistio is null";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("idAsociado", idAsociado);
			//query.setParameter("asistioVacio", "null");			
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

}
