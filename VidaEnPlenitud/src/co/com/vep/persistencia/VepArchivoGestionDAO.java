package co.com.vep.persistencia;

import co.com.vep.modelo.VepArchivoGestion;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepArchivoGestion entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepArchivoGestion
 * @author MyEclipse Persistence Tools
 */

public class VepArchivoGestionDAO implements IVepArchivoGestionDAO {
	// property constants
	public static final String URL_ARCHIVO = "urlArchivo";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepArchivoGestion entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepArchivoGestionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepArchivoGestion entity) {
		EntityManagerHelper.log("saving VepArchivoGestion instance",
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
	 * Delete a persistent VepArchivoGestion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepArchivoGestionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepArchivoGestion entity) {
		EntityManagerHelper.log("deleting VepArchivoGestion instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepArchivoGestion.class,
					entity.getIdArchivo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepArchivoGestion entity and return it or a
	 * copy of it to the sender. A copy of the VepArchivoGestion entity
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
	 * entity = VepArchivoGestionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to update
	 * @returns VepArchivoGestion the persisted VepArchivoGestion entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepArchivoGestion update(VepArchivoGestion entity) {
		EntityManagerHelper.log("updating VepArchivoGestion instance",
				Level.INFO, null);
		try {
			VepArchivoGestion result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepArchivoGestion findById(Integer id) {
		EntityManagerHelper.log("finding VepArchivoGestion instance with id: "
				+ id, Level.INFO, null);
		try {
			VepArchivoGestion instance = getEntityManager().find(
					VepArchivoGestion.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepArchivoGestion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepArchivoGestion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepArchivoGestion> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepArchivoGestion> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepArchivoGestion instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepArchivoGestion model where model."
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

	public List<VepArchivoGestion> findByUrlArchivo(Object urlArchivo) {
		return findByProperty(URL_ARCHIVO, urlArchivo);
	}

	/**
	 * Find all VepArchivoGestion entities.
	 * 
	 * @return List<VepArchivoGestion> all VepArchivoGestion entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepArchivoGestion> findAll() {
		EntityManagerHelper.log("finding all VepArchivoGestion instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepArchivoGestion model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}