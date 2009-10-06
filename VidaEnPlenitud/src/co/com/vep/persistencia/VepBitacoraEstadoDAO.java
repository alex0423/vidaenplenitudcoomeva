package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepBitacoraEstado;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepBitacoraEstado entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepBitacoraEstado
 * @author MyEclipse Persistence Tools
 */

public class VepBitacoraEstadoDAO implements IVepBitacoraEstadoDAO {
	// property constants
	public static final String ESTADO_ASOCIADO = "estadoAsociado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepBitacoraEstado entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBitacoraEstadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBitacoraEstado entity) {
		EntityManagerHelper.log("saving VepBitacoraEstado instance",
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
	 * Delete a persistent VepBitacoraEstado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBitacoraEstadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBitacoraEstado entity) {
		EntityManagerHelper.log("deleting VepBitacoraEstado instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepBitacoraEstado.class,
					entity.getIdBitacora());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepBitacoraEstado entity and return it or a
	 * copy of it to the sender. A copy of the VepBitacoraEstado entity
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
	 * entity = VepBitacoraEstadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to update
	 * @returns VepBitacoraEstado the persisted VepBitacoraEstado entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBitacoraEstado update(VepBitacoraEstado entity) {
		EntityManagerHelper.log("updating VepBitacoraEstado instance",
				Level.INFO, null);
		try {
			VepBitacoraEstado result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepBitacoraEstado findById(Integer id) {
		EntityManagerHelper.log("finding VepBitacoraEstado instance with id: "
				+ id, Level.INFO, null);
		try {
			VepBitacoraEstado instance = getEntityManager().find(
					VepBitacoraEstado.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepBitacoraEstado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBitacoraEstado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBitacoraEstado> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepBitacoraEstado> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepBitacoraEstado instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepBitacoraEstado model where model."
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

	public List<VepBitacoraEstado> findByEstadoAsociado(Object estadoAsociado) {
		return findByProperty(ESTADO_ASOCIADO, estadoAsociado);
	}

	/**
	 * Find all VepBitacoraEstado entities.
	 * 
	 * @return List<VepBitacoraEstado> all VepBitacoraEstado entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepBitacoraEstado> findAll() {
		EntityManagerHelper.log("finding all VepBitacoraEstado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepBitacoraEstado model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}