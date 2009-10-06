package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsistenteProg;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepAsistenteProg entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepAsistenteProg
 * @author MyEclipse Persistence Tools
 */

public class VepAsistenteProgDAO implements IVepAsistenteProgDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepAsistenteProg entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAsistenteProgDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAsistenteProg entity) {
		EntityManagerHelper.log("saving VepAsistenteProg instance", Level.INFO,
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
	 * Delete a persistent VepAsistenteProg entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAsistenteProgDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAsistenteProg entity) {
		EntityManagerHelper.log("deleting VepAsistenteProg instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepAsistenteProg.class,
					entity.getConsecutivo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepAsistenteProg entity and return it or a
	 * copy of it to the sender. A copy of the VepAsistenteProg entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepAsistenteProgDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to update
	 * @return VepAsistenteProg the persisted VepAsistenteProg entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAsistenteProg update(VepAsistenteProg entity) {
		EntityManagerHelper.log("updating VepAsistenteProg instance",
				Level.INFO, null);
		try {
			VepAsistenteProg result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepAsistenteProg findById(Integer consecutivo) {
		EntityManagerHelper.log("finding VepAsistenteProg instance with id: "
				+ consecutivo, Level.INFO, null);
		try {
			VepAsistenteProg instance = getEntityManager().find(
					VepAsistenteProg.class, consecutivo);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepAsistenteProg entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAsistenteProg property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAsistenteProg> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepAsistenteProg instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepAsistenteProg model where model."
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

	/**
	 * Find all VepAsistenteProg entities.
	 * 
	 * @return List<VepAsistenteProg> all VepAsistenteProg entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepAsistenteProg> findAll() {
		EntityManagerHelper.log("finding all VepAsistenteProg instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAsistenteProg model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}