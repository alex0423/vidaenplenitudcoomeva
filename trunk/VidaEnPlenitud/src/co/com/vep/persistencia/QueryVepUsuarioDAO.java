package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepUsuario;

public class QueryVepUsuarioDAO implements IQueryVepUsuarioDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public void insert(VepUsuario entity) throws Exception {
		EntityManagerHelper.log("Registrando un Usuario", Level.INFO, null);
		try {
			entity.setCodUsuario(searchSequence() + 1);
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Integer searchSequence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(u.codUsuario) from VepUsuario u";
			Query query = getEntityManager().createQuery(queryString);
			Object rs = query.getSingleResult();
			if (rs != null)
				return new Integer(String.valueOf(rs));
			return new Integer(1);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
