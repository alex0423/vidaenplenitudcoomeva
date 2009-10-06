package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepConsultor;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepConsultor entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepConsultor
 * @author MyEclipse Persistence Tools
 */

public class VepConsultorDAO implements IVepConsultorDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepConsultor entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepConsultorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepConsultor entity) {
		EntityManagerHelper.log("saving VepConsultor instance", Level.INFO,
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
	 * Delete a persistent VepConsultor entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepConsultorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepConsultor entity) {
		EntityManagerHelper.log("deleting VepConsultor instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepConsultor.class,
					entity.getIdConsultor());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepConsultor entity and return it or a copy of
	 * it to the sender. A copy of the VepConsultor entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepConsultorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to update
	 * @returns VepConsultor the persisted VepConsultor entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepConsultor update(VepConsultor entity) {
		EntityManagerHelper.log("updating VepConsultor instance", Level.INFO,
				null);
		try {
			VepConsultor result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepConsultor findById(Integer id) {
		EntityManagerHelper.log("finding VepConsultor instance with id: " + id,
				Level.INFO, null);
		try {
			VepConsultor instance = getEntityManager().find(VepConsultor.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepConsultor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepConsultor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepConsultor> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepConsultor> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepConsultor instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepConsultor model where model."
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
	 * Find all VepConsultor entities.
	 * 
	 * @return List<VepConsultor> all VepConsultor entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepConsultor> findAll() {
		EntityManagerHelper.log("finding all VepConsultor instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepConsultor model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}