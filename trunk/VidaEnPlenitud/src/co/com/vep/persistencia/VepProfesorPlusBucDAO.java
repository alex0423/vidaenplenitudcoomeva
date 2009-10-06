package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepProfesorPlusBuc;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepProfesorPlusBuc entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepProfesorPlusBuc
 * @author MyEclipse Persistence Tools
 */

public class VepProfesorPlusBucDAO implements IVepProfesorPlusBucDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepProfesorPlusBuc
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProfesorPlusBucDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProfesorPlusBuc entity) {
		EntityManagerHelper.log("saving VepProfesorPlusBuc instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepProfesorPlusBuc entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProfesorPlusBucDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProfesorPlusBuc entity) {
		EntityManagerHelper.log("deleting VepProfesorPlusBuc instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepProfesorPlusBuc.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepProfesorPlusBuc entity and return it or a
	 * copy of it to the sender. A copy of the VepProfesorPlusBuc entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepProfesorPlusBucDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to update
	 * @return VepProfesorPlusBuc the persisted VepProfesorPlusBuc entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProfesorPlusBuc update(VepProfesorPlusBuc entity) {
		EntityManagerHelper.log("updating VepProfesorPlusBuc instance",
				Level.INFO, null);
		try {
			VepProfesorPlusBuc result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepProfesorPlusBuc findById(Long id) {
		EntityManagerHelper.log("finding VepProfesorPlusBuc instance with id: "
				+ id, Level.INFO, null);
		try {
			VepProfesorPlusBuc instance = getEntityManager().find(
					VepProfesorPlusBuc.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepProfesorPlusBuc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProfesorPlusBuc property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProfesorPlusBuc> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepProfesorPlusBuc> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepProfesorPlusBuc instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepProfesorPlusBuc model where model."
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
	 * Find all VepProfesorPlusBuc entities.
	 * 
	 * @return List<VepProfesorPlusBuc> all VepProfesorPlusBuc entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepProfesorPlusBuc> findAll() {
		EntityManagerHelper.log("finding all VepProfesorPlusBuc instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepProfesorPlusBuc model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}