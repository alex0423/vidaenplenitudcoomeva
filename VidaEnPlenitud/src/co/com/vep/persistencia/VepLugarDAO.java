package co.com.vep.persistencia;

import co.com.vep.modelo.VepLugar;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepLugar entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see co.com.vep.modelo.VepLugar
 * @author MyEclipse Persistence Tools
 */

public class VepLugarDAO implements IVepLugarDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String CUPO_MAXIMO = "cupoMaximo";
	public static final String CUPO_MINIMO = "cupoMinimo";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepLugar entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepLugarDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepLugar entity) {
		EntityManagerHelper.log("saving VepLugar instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepLugar entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepLugarDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepLugar entity) {
		EntityManagerHelper.log("deleting VepLugar instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepLugar.class,
					entity.getIdLugar());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepLugar entity and return it or a copy of it
	 * to the sender. A copy of the VepLugar entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepLugarDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to update
	 * @returns VepLugar the persisted VepLugar entity instance, may not be the
	 *          same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepLugar update(VepLugar entity) {
		EntityManagerHelper.log("updating VepLugar instance", Level.INFO, null);
		try {
			VepLugar result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepLugar findById(Integer id) {
		EntityManagerHelper.log("finding VepLugar instance with id: " + id,
				Level.INFO, null);
		try {
			VepLugar instance = getEntityManager().find(VepLugar.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepLugar entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepLugar property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepLugar> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepLugar> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding VepLugar instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepLugar model where model."
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

	public List<VepLugar> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepLugar> findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	public List<VepLugar> findByCupoMaximo(Object cupoMaximo) {
		return findByProperty(CUPO_MAXIMO, cupoMaximo);
	}

	public List<VepLugar> findByCupoMinimo(Object cupoMinimo) {
		return findByProperty(CUPO_MINIMO, cupoMinimo);
	}

	/**
	 * Find all VepLugar entities.
	 * 
	 * @return List<VepLugar> all VepLugar entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepLugar> findAll() {
		EntityManagerHelper.log("finding all VepLugar instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from VepLugar model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}