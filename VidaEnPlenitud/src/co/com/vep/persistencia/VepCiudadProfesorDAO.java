package co.com.vep.persistencia;

import co.com.vep.modelo.VepCiudadProfesor;
import co.com.vep.modelo.VepCiudadProfesorId;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepCiudadProfesor entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepCiudadProfesor
 * @author MyEclipse Persistence Tools
 */

public class VepCiudadProfesorDAO implements IVepCiudadProfesorDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepCiudadProfesor entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepCiudadProfesorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepCiudadProfesor entity) {
		EntityManagerHelper.log("saving VepCiudadProfesor instance",
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
	 * Delete a persistent VepCiudadProfesor entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepCiudadProfesorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepCiudadProfesor entity) {
		EntityManagerHelper.log("deleting VepCiudadProfesor instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepCiudadProfesor.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepCiudadProfesor entity and return it or a
	 * copy of it to the sender. A copy of the VepCiudadProfesor entity
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
	 * entity = VepCiudadProfesorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to update
	 * @returns VepCiudadProfesor the persisted VepCiudadProfesor entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepCiudadProfesor update(VepCiudadProfesor entity) {
		EntityManagerHelper.log("updating VepCiudadProfesor instance",
				Level.INFO, null);
		try {
			VepCiudadProfesor result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepCiudadProfesor findById(VepCiudadProfesorId id) {
		EntityManagerHelper.log("finding VepCiudadProfesor instance with id: "
				+ id, Level.INFO, null);
		try {
			VepCiudadProfesor instance = getEntityManager().find(
					VepCiudadProfesor.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepCiudadProfesor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepCiudadProfesor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepCiudadProfesor> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepCiudadProfesor> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepCiudadProfesor instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepCiudadProfesor model where model."
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
	 * Find all VepCiudadProfesor entities.
	 * 
	 * @return List<VepCiudadProfesor> all VepCiudadProfesor entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepCiudadProfesor> findAll() {
		EntityManagerHelper.log("finding all VepCiudadProfesor instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepCiudadProfesor model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}