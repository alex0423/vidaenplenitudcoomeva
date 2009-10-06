package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAtributoAsociado;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepAtributoAsociado entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepAtributoAsociado
 * @author MyEclipse Persistence Tools
 */

public class VepAtributoAsociadoDAO implements IVepAtributoAsociadoDAO {
	// property constants
	public static final String VALOR = "valor";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepAtributoAsociado
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAtributoAsociadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAtributoAsociado entity) {
		EntityManagerHelper.log("saving VepAtributoAsociado instance",
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
	 * Delete a persistent VepAtributoAsociado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAtributoAsociadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAtributoAsociado entity) {
		EntityManagerHelper.log("deleting VepAtributoAsociado instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepAtributoAsociado.class,
					entity.getConsecutivo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepAtributoAsociado entity and return it or a
	 * copy of it to the sender. A copy of the VepAtributoAsociado entity
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
	 * entity = VepAtributoAsociadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to update
	 * @return VepAtributoAsociado the persisted VepAtributoAsociado entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAtributoAsociado update(VepAtributoAsociado entity) {
		EntityManagerHelper.log("updating VepAtributoAsociado instance",
				Level.INFO, null);
		try {
			VepAtributoAsociado result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepAtributoAsociado findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepAtributoAsociado instance with id: " + id,
				Level.INFO, null);
		try {
			VepAtributoAsociado instance = getEntityManager().find(
					VepAtributoAsociado.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepAtributoAsociado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAtributoAsociado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAtributoAsociado> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepAtributoAsociado instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepAtributoAsociado model where model."
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

	public List<VepAtributoAsociado> findByValor(Object valor) {
		return findByProperty(VALOR, valor);
	}

	/**
	 * Find all VepAtributoAsociado entities.
	 * 
	 * @return List<VepAtributoAsociado> all VepAtributoAsociado entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> findAll() {
		EntityManagerHelper.log("finding all VepAtributoAsociado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAtributoAsociado model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}