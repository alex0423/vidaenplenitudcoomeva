package co.com.vep.persistencia;

import javax.persistence.EntityManager;

import co.com.vep.modelo.VepProfesor;

public class QueryVepProfesorDAO implements IQueryVepProfesorDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryVepProfesorDAO#obtener(java.lang.Long)
	 */
	public VepProfesor obtener(Long tipoId, Long idProfesor) throws Exception {
		try {
			return (VepProfesor) EntityManagerHelper.getEntityManager()
					.createNamedQuery("vepprofesor.findbyid").setParameter(
							"id", tipoId).setParameter("numero", idProfesor)
					.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
	}

}
