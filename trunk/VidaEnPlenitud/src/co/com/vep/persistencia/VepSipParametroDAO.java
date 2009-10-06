package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepSipParametro;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepSipParametro entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepSipParametro
 * @author MyEclipse Persistence Tools
 */

public class VepSipParametroDAO implements IVepSipParametroDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String ESTADOPAR = "estadopar";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepSipParametro entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSipParametroDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSipParametro entity) {
		EntityManagerHelper.log("saving VepSipParametro instance", Level.INFO,
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
	 * Delete a persistent VepSipParametro entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSipParametroDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSipParametro entity) {
		EntityManagerHelper.log("deleting VepSipParametro instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepSipParametro.class,
					entity.getIdTipoClasif());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepSipParametro entity and return it or a copy
	 * of it to the sender. A copy of the VepSipParametro entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepSipParametroDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to update
	 * @return VepSipParametro the persisted VepSipParametro entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSipParametro update(VepSipParametro entity) {
		EntityManagerHelper.log("updating VepSipParametro instance",
				Level.INFO, null);
		try {
			VepSipParametro result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepSipParametro findById(Integer id) {
		EntityManagerHelper.log("finding VepSipParametro instance with id: "
				+ id, Level.INFO, null);
		try {
			VepSipParametro instance = getEntityManager().find(
					VepSipParametro.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepSipParametro entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSipParametro property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSipParametro> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepSipParametro> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepSipParametro instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepSipParametro model where model."
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

	public List<VepSipParametro> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepSipParametro> findByEstadopar(Object estadopar) {
		return findByProperty(ESTADOPAR, estadopar);
	}

	/**
	 * Find all VepSipParametro entities.
	 * 
	 * @return List<VepSipParametro> all VepSipParametro entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepSipParametro> findAll() {
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepSipParametro model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}