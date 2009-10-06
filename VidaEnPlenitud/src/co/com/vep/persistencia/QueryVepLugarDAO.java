package co.com.vep.persistencia;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepLugar;

public class QueryVepLugarDAO implements IQueryVepLugarDAO {

	@SuppressWarnings("unused")
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public VepLugar findByLugarSitio(Integer sitio, Integer Lugar)
			throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding VepLugar instance with value: "
				+ sitio + "," + Lugar, Level.INFO, null);
		try {
			final String queryString = "select model from VepLugar model where model.vepSitio.idSitio= :value1 and model.idLugar = :value2";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("value1", sitio);
			query.setParameter("value2", Lugar);
			return (VepLugar) query.getSingleResult();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

}
