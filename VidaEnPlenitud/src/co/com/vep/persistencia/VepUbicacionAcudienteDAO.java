package co.com.vep.persistencia;

import co.com.vep.modelo.VepUbicacionAcudiente;
import co.com.vep.modelo.VepUbicacionAcudienteId;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepUbicacionAcudiente entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepUbicacionAcudiente
 * @author MyEclipse Persistence Tools
 */

public class VepUbicacionAcudienteDAO implements IVepUbicacionAcudienteDAO {
	// property constants
	public static final String DESCRIPCION_UBICACION = "descripcionUbicacion";
	public static final String CIUDAD_UBICACION = "ciudadUbicacion";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepUbicacionAcudiente
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepUbicacionAcudienteDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepUbicacionAcudiente entity) {
		EntityManagerHelper.log("saving VepUbicacionAcudiente instance",
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
	 * Delete a persistent VepUbicacionAcudiente entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepUbicacionAcudienteDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepUbicacionAcudiente entity) {
		EntityManagerHelper.log("deleting VepUbicacionAcudiente instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VepUbicacionAcudiente.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepUbicacionAcudiente entity and return it or
	 * a copy of it to the sender. A copy of the VepUbicacionAcudiente entity
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
	 * entity = VepUbicacionAcudienteDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to update
	 * @returns VepUbicacionAcudiente the persisted VepUbicacionAcudiente entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepUbicacionAcudiente update(VepUbicacionAcudiente entity) {
		EntityManagerHelper.log("updating VepUbicacionAcudiente instance",
				Level.INFO, null);
		try {
			VepUbicacionAcudiente result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepUbicacionAcudiente findById(VepUbicacionAcudienteId id) {
		EntityManagerHelper.log(
				"finding VepUbicacionAcudiente instance with id: " + id,
				Level.INFO, null);
		try {
			VepUbicacionAcudiente instance = getEntityManager().find(
					VepUbicacionAcudiente.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepUbicacionAcudiente entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepUbicacionAcudiente property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepUbicacionAcudiente> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepUbicacionAcudiente> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepUbicacionAcudiente instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepUbicacionAcudiente model where model."
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

	public List<VepUbicacionAcudiente> findByDescripcionUbicacion(
			Object descripcionUbicacion) {
		return findByProperty(DESCRIPCION_UBICACION, descripcionUbicacion);
	}

	public List<VepUbicacionAcudiente> findByCiudadUbicacion(
			Object ciudadUbicacion) {
		return findByProperty(CIUDAD_UBICACION, ciudadUbicacion);
	}

	/**
	 * Find all VepUbicacionAcudiente entities.
	 * 
	 * @return List<VepUbicacionAcudiente> all VepUbicacionAcudiente entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepUbicacionAcudiente> findAll() {
		EntityManagerHelper.log("finding all VepUbicacionAcudiente instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepUbicacionAcudiente model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}