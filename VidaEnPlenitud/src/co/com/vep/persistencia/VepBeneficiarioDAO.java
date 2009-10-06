package co.com.vep.persistencia;

import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepBeneficiarioId;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepBeneficiario entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepBeneficiario
 * @author MyEclipse Persistence Tools
 */

public class VepBeneficiarioDAO implements IVepBeneficiarioDAO {
	// property constants
	public static final String NOMBRE = "nombre";
	public static final String APELLIDO1 = "apellido1";
	public static final String APELLIDO2 = "apellido2";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepBeneficiario entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiarioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiario entity) {
		EntityManagerHelper.log("saving VepBeneficiario instance", Level.INFO,
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
	 * Delete a persistent VepBeneficiario entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiarioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiario entity) {
		EntityManagerHelper.log("deleting VepBeneficiario instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepBeneficiario.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepBeneficiario entity and return it or a copy
	 * of it to the sender. A copy of the VepBeneficiario entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepBeneficiarioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to update
	 * @returns VepBeneficiario the persisted VepBeneficiario entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBeneficiario update(VepBeneficiario entity) {
		EntityManagerHelper.log("updating VepBeneficiario instance",
				Level.INFO, null);
		try {
			VepBeneficiario result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepBeneficiario findById(VepBeneficiarioId id) {
		EntityManagerHelper.log("finding VepBeneficiario instance with id: "
				+ id, Level.INFO, null);
		try {
			VepBeneficiario instance = getEntityManager().find(
					VepBeneficiario.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepBeneficiario entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBeneficiario property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBeneficiario> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiario> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepBeneficiario instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepBeneficiario model where model."
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

	public List<VepBeneficiario> findByNombre(Object nombre) {
		return findByProperty(NOMBRE, nombre);
	}

	public List<VepBeneficiario> findByApellido1(Object apellido1) {
		return findByProperty(APELLIDO1, apellido1);
	}

	public List<VepBeneficiario> findByApellido2(Object apellido2) {
		return findByProperty(APELLIDO2, apellido2);
	}

	/**
	 * Find all VepBeneficiario entities.
	 * 
	 * @return List<VepBeneficiario> all VepBeneficiario entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiario> findAll() {
		EntityManagerHelper.log("finding all VepBeneficiario instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepBeneficiario model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}