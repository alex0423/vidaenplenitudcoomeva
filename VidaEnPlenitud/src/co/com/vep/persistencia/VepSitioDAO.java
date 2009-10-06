package co.com.vep.persistencia;

import co.com.vep.modelo.VepSitio;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepSitio entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see co.com.vep.modelo.VepSitio
 * @author MyEclipse Persistence Tools
 */

public class VepSitioDAO implements IVepSitioDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String DIRECCION = "direccion";
	public static final String TELEFONO = "telefono";
	public static final String CIUDAD = "ciudad";
	public static final String DESCRIPCION = "descripcion";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepSitio entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSitioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSitio entity) {
		EntityManagerHelper.log("saving VepSitio instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepSitio entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepSitioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSitio entity) {
		EntityManagerHelper.log("deleting VepSitio instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepSitio.class,
					entity.getIdSitio());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepSitio entity and return it or a copy of it
	 * to the sender. A copy of the VepSitio entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepSitioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to update
	 * @returns VepSitio the persisted VepSitio entity instance, may not be the
	 *          same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSitio update(VepSitio entity) {
		EntityManagerHelper.log("updating VepSitio instance", Level.INFO, null);
		try {
			VepSitio result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepSitio findById(Integer id) {
		EntityManagerHelper.log("finding VepSitio instance with id: " + id,
				Level.INFO, null);
		try {
			VepSitio instance = getEntityManager().find(VepSitio.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepSitio entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSitio property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSitio> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepSitio> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding VepSitio instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepSitio model where model."
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

	public List<VepSitio> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepSitio> findByDireccion(Object direccion) {
		return findByProperty(DIRECCION, direccion);
	}

	public List<VepSitio> findByTelefono(Object telefono) {
		return findByProperty(TELEFONO, telefono);
	}

	public List<VepSitio> findByCiudad(Object ciudad) {
		return findByProperty(CIUDAD, ciudad);
	}

	public List<VepSitio> findByDescripcion(Object descripcion) {
		return findByProperty(DESCRIPCION, descripcion);
	}

	/**
	 * Find all VepSitio entities.
	 * 
	 * @return List<VepSitio> all VepSitio entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepSitio> findAll() {
		EntityManagerHelper.log("finding all VepSitio instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from VepSitio model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}