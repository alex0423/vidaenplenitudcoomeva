/**
 * 
 */
package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepBeneficiado;

/**
 * @author Juank
 *
 */
public class QueryVepBeneficiarioDAO implements IQueryVepBeneficiarioDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/* (non-Javadoc)
	 * @see co.com.vep.persistencia.IQueryVepBeneficiario#insert(co.com.vep.modelo.VepBeneficiado)
	 */
	public void insert(VepBeneficiado entity) throws Exception {
		EntityManagerHelper.log("Registrando un Beneficiario",
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
