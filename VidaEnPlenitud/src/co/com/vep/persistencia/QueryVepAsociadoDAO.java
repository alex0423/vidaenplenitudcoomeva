/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;

import co.com.vep.modelo.VepAsociado;

/**
 * @author Juank
 * 
 */
public class QueryVepAsociadoDAO implements IQueryVepAsociadoDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepConsultor#insert(co.com.vep.modelo.VepConsultor)
	 */
	public void insert(VepAsociado entity) throws Exception {
		EntityManagerHelper.log("Registrando un Asociado",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

}
