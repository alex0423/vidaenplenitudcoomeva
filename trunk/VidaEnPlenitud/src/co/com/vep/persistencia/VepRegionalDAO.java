package co.com.vep.persistencia;

import co.com.vep.modelo.VepRegional;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepRegional entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepRegional
 * @author MyEclipse Persistence Tools
 */

public class VepRegionalDAO implements IVepRegionalDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepRegional entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepRegionalDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepRegional entity) {
		EntityManagerHelper
				.log("saving VepRegional instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepRegional entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepRegionalDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepRegional entity) {
		EntityManagerHelper.log("deleting VepRegional instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepRegional.class,
					entity.getIdRegional());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepRegional entity and return it or a copy of
	 * it to the sender. A copy of the VepRegional entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepRegionalDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to update
	 * @returns VepRegional the persisted VepRegional entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepRegional update(VepRegional entity) {
		EntityManagerHelper.log("updating VepRegional instance", Level.INFO,
				null);
		try {
			VepRegional result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepRegional findById(Integer id) {
		EntityManagerHelper.log("finding VepRegional instance with id: " + id,
				Level.INFO, null);
		try {
			VepRegional instance = getEntityManager().find(VepRegional.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepRegional entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepRegional property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepRegional> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepRegional> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepRegional instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepRegional model where model."
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
	 * Find all VepRegional entities.
	 * 
	 * @return List<VepRegional> all VepRegional entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepRegional> findAll() {
		EntityManagerHelper.log("finding all VepRegional instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepRegional model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}