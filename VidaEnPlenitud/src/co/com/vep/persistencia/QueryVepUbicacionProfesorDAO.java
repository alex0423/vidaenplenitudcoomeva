package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepUbicacionProfesor;

public class QueryVepUbicacionProfesorDAO implements
		IQueryVepUbicacionProfesorDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<VepUbicacionProfesor> findByProperty(Object tipoId,
			Object numDocumento) {
		// TODO Auto-generated method stub
		EntityManagerHelper.log(
				"finding VepUbicacionProfesor instance with value 1: " + tipoId
						+ ", and value 2: " + numDocumento, Level.INFO, null);
		try {
			final String queryString = "select model from VepUbicacionProfesor model where " +
					"model.id.tipoId= :propertyValue1 and model.id.idProfesor= :propertyValue2";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue1", tipoId);
			query.setParameter("propertyValue2", numDocumento);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

}
