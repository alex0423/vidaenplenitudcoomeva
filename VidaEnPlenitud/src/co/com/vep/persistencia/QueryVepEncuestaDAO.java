/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepEncuesta;

/**
 * @author Juank
 * 
 */
public class QueryVepEncuestaDAO implements IQueryVepEncuestaDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepEncuesta#insert(co.com.vep.modelo.VepEncuesta)
	 */
	public Long insert(VepEncuesta entity) throws Exception {
		EntityManagerHelper.log("Registrando una Encuesta", Level.INFO, null);
		Long nextId = searchSequence() + 1;
		entity.setIdEncuesta(new Integer(nextId.intValue()));
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
			return nextId;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepEncuesta#searchSequence()
	 */
	public Long searchSequence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.idEncuesta) from VepEncuesta model";
			Query query = getEntityManager().createQuery(queryString);
			Object rs = query.getSingleResult();
			if (rs != null)
				return new Long(String.valueOf(rs));
			return new Long(1);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
