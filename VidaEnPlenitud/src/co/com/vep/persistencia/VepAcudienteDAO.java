package co.com.vep.persistencia;

import co.com.vep.modelo.VepAcudiente;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepAcudiente entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepAcudiente
 * @author MyEclipse Persistence Tools
 */

public class VepAcudienteDAO implements IVepAcudienteDAO {
	// property constants
	public static final String TIPO_DOCUMENTO = "tipoDocumento";
	public static final String NUMERO_DOCUMENTO = "numeroDocumento";
	public static final String NOMBRE1 = "nombre1";
	public static final String NOMBRE2 = "nombre2";
	public static final String APELLIDO1 = "apellido1";
	public static final String APELLIDO2 = "apellido2";
	public static final String ID_ASOCIADO = "idAsociado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepAcudiente entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAcudienteDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAcudiente entity) {
		EntityManagerHelper.log("saving VepAcudiente instance", Level.INFO,
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
	 * Delete a persistent VepAcudiente entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAcudienteDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAcudiente entity) {
		EntityManagerHelper.log("deleting VepAcudiente instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepAcudiente.class,
					entity.getIdAcudiente());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepAcudiente entity and return it or a copy of
	 * it to the sender. A copy of the VepAcudiente entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepAcudienteDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to update
	 * @returns VepAcudiente the persisted VepAcudiente entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAcudiente update(VepAcudiente entity) {
		EntityManagerHelper.log("updating VepAcudiente instance", Level.INFO,
				null);
		try {
			VepAcudiente result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepAcudiente findById(Integer id) {
		EntityManagerHelper.log("finding VepAcudiente instance with id: " + id,
				Level.INFO, null);
		try {
			VepAcudiente instance = getEntityManager().find(VepAcudiente.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepAcudiente entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAcudiente property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAcudiente> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepAcudiente> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepAcudiente instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepAcudiente model where model."
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

	public List<VepAcudiente> findByTipoDocumento(Object tipoDocumento) {
		return findByProperty(TIPO_DOCUMENTO, tipoDocumento);
	}

	public List<VepAcudiente> findByNumeroDocumento(Object numeroDocumento) {
		return findByProperty(NUMERO_DOCUMENTO, numeroDocumento);
	}

	public List<VepAcudiente> findByNombre1(Object nombre1) {
		return findByProperty(NOMBRE1, nombre1);
	}

	public List<VepAcudiente> findByNombre2(Object nombre2) {
		return findByProperty(NOMBRE2, nombre2);
	}

	public List<VepAcudiente> findByApellido1(Object apellido1) {
		return findByProperty(APELLIDO1, apellido1);
	}

	public List<VepAcudiente> findByApellido2(Object apellido2) {
		return findByProperty(APELLIDO2, apellido2);
	}

	public List<VepAcudiente> findByIdAsociado(Object idAsociado) {
		return findByProperty(ID_ASOCIADO, idAsociado);
	}

	/**
	 * Find all VepAcudiente entities.
	 * 
	 * @return List<VepAcudiente> all VepAcudiente entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepAcudiente> findAll() {
		EntityManagerHelper.log("finding all VepAcudiente instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAcudiente model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}