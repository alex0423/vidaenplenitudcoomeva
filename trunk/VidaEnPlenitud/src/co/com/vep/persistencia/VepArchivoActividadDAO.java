package co.com.vep.persistencia;

import co.com.vep.modelo.VepArchivoActividad;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepArchivoActividad entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepArchivoActividad
 * @author MyEclipse Persistence Tools
 */

public class VepArchivoActividadDAO implements IVepArchivoActividadDAO {
	// property constants
	public static final String URL_ARCHIVO = "urlArchivo";
	public static final String ID_PROGRAMACION = "idProgramacion";
	public static final String ESTADO = "estado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepArchivoActividad
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepArchivoActividadDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepArchivoActividad entity) {
		EntityManagerHelper.log("saving VepArchivoActividad instance",
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
	 * Delete a persistent VepArchivoActividad entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepArchivoActividadDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepArchivoActividad entity) {
		EntityManagerHelper.log("deleting VepArchivoActividad instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepArchivoActividad.class,
					entity.getIdArchivoActiv());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepArchivoActividad entity and return it or a
	 * copy of it to the sender. A copy of the VepArchivoActividad entity
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
	 * entity = VepArchivoActividadDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to update
	 * @returns VepArchivoActividad the persisted VepArchivoActividad entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepArchivoActividad update(VepArchivoActividad entity) {
		EntityManagerHelper.log("updating VepArchivoActividad instance",
				Level.INFO, null);
		try {
			VepArchivoActividad result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepArchivoActividad findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepArchivoActividad instance with id: " + id,
				Level.INFO, null);
		try {
			VepArchivoActividad instance = getEntityManager().find(
					VepArchivoActividad.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepArchivoActividad entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepArchivoActividad property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepArchivoActividad> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepArchivoActividad> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepArchivoActividad instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepArchivoActividad model where model."
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

	public List<VepArchivoActividad> findByUrlArchivo(Object urlArchivo) {
		return findByProperty(URL_ARCHIVO, urlArchivo);
	}

	public List<VepArchivoActividad> findByIdProgramacion(Object idProgramacion) {
		return findByProperty(ID_PROGRAMACION, idProgramacion);
	}

	public List<VepArchivoActividad> findByEstado(Object estado) {
		return findByProperty(ESTADO, estado);
	}

	/**
	 * Find all VepArchivoActividad entities.
	 * 
	 * @return List<VepArchivoActividad> all VepArchivoActividad entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepArchivoActividad> findAll() {
		EntityManagerHelper.log("finding all VepArchivoActividad instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepArchivoActividad model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}