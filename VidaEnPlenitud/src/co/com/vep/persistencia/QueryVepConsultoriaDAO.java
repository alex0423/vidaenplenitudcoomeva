/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepConsultoria;

/**
 * @author Juank
 * 
 */
public class QueryVepConsultoriaDAO implements IQueryVepConsultoriaDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepConsultoria#insert(co.com.vep.modelo.VepConsultoria)
	 */
	public Integer insert(VepConsultoria entity) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("Registrando un Servicio de Consultoria",
				Level.INFO, null);
		Integer nextId = searchSequence() + 1;
		entity.setIdServiciocon(nextId.intValue());
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
	 * @see co.com.vep.persistencia.IQueryVepConsultoria#searchSequence()
	 */
	public Integer searchSequence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.idServiciocon) from VepConsultoria model";
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
