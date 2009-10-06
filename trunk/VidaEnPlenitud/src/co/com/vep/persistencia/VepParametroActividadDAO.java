package co.com.vep.persistencia;

import co.com.vep.modelo.VepParametroActividad;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepParametroActividad entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepParametroActividad
 * @author MyEclipse Persistence Tools
 */

public class VepParametroActividadDAO implements IVepParametroActividadDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String ESTADOPAR = "estadopar";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepParametroActividad
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepParametroActividadDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepParametroActividad entity) {
		EntityManagerHelper.log("saving VepParametroActividad instance",
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
	 * Delete a persistent VepParametroActividad entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepParametroActividadDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepParametroActividad entity) {
		EntityManagerHelper.log("deleting VepParametroActividad instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VepParametroActividad.class, entity.getIdActividadpar());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepParametroActividad entity and return it or
	 * a copy of it to the sender. A copy of the VepParametroActividad entity
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
	 * entity = VepParametroActividadDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to update
	 * @returns VepParametroActividad the persisted VepParametroActividad entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepParametroActividad update(VepParametroActividad entity) {
		EntityManagerHelper.log("updating VepParametroActividad instance",
				Level.INFO, null);
		try {
			VepParametroActividad result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepParametroActividad findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepParametroActividad instance with id: " + id,
				Level.INFO, null);
		try {
			VepParametroActividad instance = getEntityManager().find(
					VepParametroActividad.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepParametroActividad entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepParametroActividad property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepParametroActividad> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepParametroActividad> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepParametroActividad instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepParametroActividad model where model."
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

	public List<VepParametroActividad> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepParametroActividad> findByEstadopar(Object estadopar) {
		return findByProperty(ESTADOPAR, estadopar);
	}

	/**
	 * Find all VepParametroActividad entities.
	 * 
	 * @return List<VepParametroActividad> all VepParametroActividad entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepParametroActividad> findAll() {
		EntityManagerHelper.log("finding all VepParametroActividad instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepParametroActividad model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}