package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepBeneficiado;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepBeneficiado entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepBeneficiado
 * @author MyEclipse Persistence Tools
 */

public class VepBeneficiadoDAO implements IVepBeneficiadoDAO {
	// property constants
	public static final String URLARCHIVO = "urlarchivo";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepBeneficiado entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiado entity) {
		EntityManagerHelper.log("saving VepBeneficiado instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepBeneficiado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiado entity) {
		EntityManagerHelper.log("deleting VepBeneficiado instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepBeneficiado.class,
					entity.getIdBeneficiario());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepBeneficiado entity and return it or a copy
	 * of it to the sender. A copy of the VepBeneficiado entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepBeneficiadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to update
	 * @returns VepBeneficiado the persisted VepBeneficiado entity instance, may
	 *          not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBeneficiado update(VepBeneficiado entity) {
		EntityManagerHelper.log("updating VepBeneficiado instance", Level.INFO,
				null);
		try {
			VepBeneficiado result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepBeneficiado findById(Integer id) {
		EntityManagerHelper.log("finding VepBeneficiado instance with id: "
				+ id, Level.INFO, null);
		try {
			VepBeneficiado instance = getEntityManager().find(
					VepBeneficiado.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepBeneficiado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBeneficiado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBeneficiado> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiado> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepBeneficiado instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepBeneficiado model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VepBeneficiado> findByUrlarchivo(Object urlarchivo) {
		return findByProperty(URLARCHIVO, urlarchivo);
	}

	/**
	 * Find all VepBeneficiado entities.
	 * 
	 * @return List<VepBeneficiado> all VepBeneficiado entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiado> findAll() {
		EntityManagerHelper.log("finding all VepBeneficiado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepBeneficiado model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}