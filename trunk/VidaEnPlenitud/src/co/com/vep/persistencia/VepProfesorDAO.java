package co.com.vep.persistencia;

import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorId;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepProfesor entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepProfesor
 * @author MyEclipse Persistence Tools
 */

public class VepProfesorDAO implements IVepProfesorDAO {
	// property constants
	public static final String TITULO = "titulo";
	public static final String ESPECIALIDAD = "especialidad";
	public static final String URL_HOJA = "urlHoja";
	public static final String ESTADO_PROFESOR = "estadoProfesor";
	public static final String NOMBRE1 = "nombre1";
	public static final String NOMBRE2 = "nombre2";
	public static final String APELLIDO1 = "apellido1";
	public static final String APELLIDO2 = "apellido2";
	public static final String ESTCIVIL = "estcivil";
	public static final String GENERO = "genero";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepProfesor entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProfesorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProfesor entity) {
		EntityManagerHelper
				.log("saving VepProfesor instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepProfesor entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProfesorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProfesor entity) {
		EntityManagerHelper.log("deleting VepProfesor instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepProfesor.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepProfesor entity and return it or a copy of
	 * it to the sender. A copy of the VepProfesor entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepProfesorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to update
	 * @returns VepProfesor the persisted VepProfesor entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProfesor update(VepProfesor entity) {
		EntityManagerHelper.log("updating VepProfesor instance", Level.INFO,
				null);
		try {
			VepProfesor result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepProfesor findById(VepProfesorId id) {
		EntityManagerHelper.log("finding VepProfesor instance with id: " + id,
				Level.INFO, null);
		try {
			VepProfesor instance = getEntityManager().find(VepProfesor.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepProfesor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProfesor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProfesor> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepProfesor> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepProfesor instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepProfesor model where model."
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

	public List<VepProfesor> findByTitulo(Object titulo) {
		return findByProperty(TITULO, titulo);
	}

	public List<VepProfesor> findByEspecialidad(Object especialidad) {
		return findByProperty(ESPECIALIDAD, especialidad);
	}

	public List<VepProfesor> findByUrlHoja(Object urlHoja) {
		return findByProperty(URL_HOJA, urlHoja);
	}

	public List<VepProfesor> findByEstadoProfesor(Object estadoProfesor) {
		return findByProperty(ESTADO_PROFESOR, estadoProfesor);
	}

	public List<VepProfesor> findByNombre1(Object nombre1) {
		return findByProperty(NOMBRE1, nombre1);
	}

	public List<VepProfesor> findByNombre2(Object nombre2) {
		return findByProperty(NOMBRE2, nombre2);
	}

	public List<VepProfesor> findByApellido1(Object apellido1) {
		return findByProperty(APELLIDO1, apellido1);
	}

	public List<VepProfesor> findByApellido2(Object apellido2) {
		return findByProperty(APELLIDO2, apellido2);
	}

	public List<VepProfesor> findByEstcivil(Object estcivil) {
		return findByProperty(ESTCIVIL, estcivil);
	}

	public List<VepProfesor> findByGenero(Object genero) {
		return findByProperty(GENERO, genero);
	}

	/**
	 * Find all VepProfesor entities.
	 * 
	 * @return List<VepProfesor> all VepProfesor entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepProfesor> findAll() {
		EntityManagerHelper.log("finding all VepProfesor instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepProfesor model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}