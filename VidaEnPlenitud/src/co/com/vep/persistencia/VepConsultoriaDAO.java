package co.com.vep.persistencia;

import co.com.vep.modelo.VepConsultoria;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepConsultoria entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepConsultoria
 * @author MyEclipse Persistence Tools
 */

public class VepConsultoriaDAO implements IVepConsultoriaDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String ESTADO = "estado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepConsultoria entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepConsultoria entity) {
		EntityManagerHelper.log("saving VepConsultoria instance", Level.INFO,
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
	 * Delete a persistent VepConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepConsultoria entity) {
		EntityManagerHelper.log("deleting VepConsultoria instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepConsultoria.class,
					entity.getIdServiciocon());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepConsultoria entity and return it or a copy
	 * of it to the sender. A copy of the VepConsultoria entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to update
	 * @returns VepConsultoria the persisted VepConsultoria entity instance, may
	 *          not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepConsultoria update(VepConsultoria entity) {
		EntityManagerHelper.log("updating VepConsultoria instance", Level.INFO,
				null);
		try {
			VepConsultoria result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepConsultoria findById(Integer id) {
		EntityManagerHelper.log("finding VepConsultoria instance with id: "
				+ id, Level.INFO, null);
		try {
			VepConsultoria instance = getEntityManager().find(
					VepConsultoria.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepConsultoria> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepConsultoria> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepConsultoria instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepConsultoria model where model."
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

	public List<VepConsultoria> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepConsultoria> findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	public List<VepConsultoria> findByEstado(Object estado) {
		return findByProperty(ESTADO, estado);
	}

	/**
	 * Find all VepConsultoria entities.
	 * 
	 * @return List<VepConsultoria> all VepConsultoria entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepConsultoria> findAll() {
		EntityManagerHelper.log("finding all VepConsultoria instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepConsultoria model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}