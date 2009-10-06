/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepRegional;

/**
 * @author Juank
 * 
 */
public class QueryVepRegionalDAO implements IQueryVepRegionalDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepRegionalDAO#insert(co.com.vep.modelo.VepRegional)
	 */
	public void insert(VepRegional entity) throws Exception {
		EntityManagerHelper.log("Registrando una Regional", Level.INFO, null);
		Integer nextId = searchSequence() + 1;
		entity.setIdRegional(new Integer(nextId.intValue()));
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Integer searchSequence() throws Exception {

		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.idRegional) from VepRegional model";
			Query query = getEntityManager().createQuery(queryString);
			Object rs = query.getSingleResult();
			if (rs != null)
				return (Integer) rs;
			return new Integer(1);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
