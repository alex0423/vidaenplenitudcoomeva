package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepSipparametroTipo;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepSipparametroTipo entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepSipparametroTipo
 * @author MyEclipse Persistence Tools
 */

public class VepSipparametroTipoDAO implements IVepSipparametroTipoDAO {
	// property constants
	public static final String OBSERVACION = "observacion";
	public static final String ESTADO = "estado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepSipparametroTipo
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSipparametroTipoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSipparametroTipo entity) {
		EntityManagerHelper.log("saving VepSipparametroTipo instance",
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
	 * Delete a persistent VepSipparametroTipo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSipparametroTipoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSipparametroTipo entity) {
		EntityManagerHelper.log("deleting VepSipparametroTipo instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepSipparametroTipo.class,
					entity.getCodTipo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepSipparametroTipo entity and return it or a
	 * copy of it to the sender. A copy of the VepSipparametroTipo entity
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
	 * entity = VepSipparametroTipoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to update
	 * @return VepSipparametroTipo the persisted VepSipparametroTipo entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSipparametroTipo update(VepSipparametroTipo entity) {
		EntityManagerHelper.log("updating VepSipparametroTipo instance",
				Level.INFO, null);
		try {
			VepSipparametroTipo result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepSipparametroTipo findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepSipparametroTipo instance with id: " + id,
				Level.INFO, null);
		try {
			VepSipparametroTipo instance = getEntityManager().find(
					VepSipparametroTipo.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepSipparametroTipo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSipparametroTipo property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSipparametroTipo> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepSipparametroTipo> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepSipparametroTipo instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepSipparametroTipo model where model."
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

	public List<VepSipparametroTipo> findByObservacion(Object observacion) {
		return findByProperty(OBSERVACION, observacion);
	}

	public List<VepSipparametroTipo> findByEstado(Object estado) {
		return findByProperty(ESTADO, estado);
	}

	/**
	 * Find all VepSipparametroTipo entities.
	 * 
	 * @return List<VepSipparametroTipo> all VepSipparametroTipo entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepSipparametroTipo> findAll() {
		EntityManagerHelper.log("finding all VepSipparametroTipo instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepSipparametroTipo model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}