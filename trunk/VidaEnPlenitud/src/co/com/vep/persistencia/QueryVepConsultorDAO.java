/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepConsultor;

/**
 * @author Juank
 * 
 */
public class QueryVepConsultorDAO implements IQueryVepConsultorDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepConsultor#insert(co.com.vep.modelo.VepConsultor)
	 */
	public Integer insert(VepConsultor entity) throws Exception {
		EntityManagerHelper.log("Registrando un Servicio de Consultoria",
				Level.INFO, null);
		try {
			Integer nextId = searchSequence() + 1;
			entity.setIdConsultor(nextId.intValue());			
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
	 * @see co.com.vep.persistencia.IQueryVepConsultor#searchSequence()
	 */
	public Integer searchSequence() throws Exception {
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.idConsultor) from VepConsultor model";
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
