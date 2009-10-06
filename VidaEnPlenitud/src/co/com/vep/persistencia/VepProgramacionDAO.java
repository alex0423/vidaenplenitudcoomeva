package co.com.vep.persistencia;

import co.com.vep.modelo.VepProgramacion;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepProgramacion entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepProgramacion
 * @author MyEclipse Persistence Tools
 */

public class VepProgramacionDAO implements IVepProgramacionDAO {
	// property constants
	public static final String CUPO_MAXIMO = "cupoMaximo";
	public static final String CUPO_MINIMO = "cupoMinimo";
	public static final String NIVEL = "nivel";
	public static final String ESTADO = "estado";
	public static final String ID_LUGAR = "idLugar";
	public static final String ID_REGIONAL = "idRegional";
	public static final String ID_ACTIVIDAD_PAR = "idActividadPar";
	public static final String TIPO_ID = "tipoId";
	public static final String ID_PROFESOR = "idProfesor";
	public static final String GRUPO = "grupo";
	public static final String CUPO_ASISTENTES = "cupoAsistentes";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepProgramacion entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProgramacionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProgramacion entity) {
		EntityManagerHelper.log("saving VepProgramacion instance", Level.INFO,
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
	 * Delete a persistent VepProgramacion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepProgramacionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProgramacion entity) {
		EntityManagerHelper.log("deleting VepProgramacion instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(VepProgramacion.class,
					entity.getIdProgramacion());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepProgramacion entity and return it or a copy
	 * of it to the sender. A copy of the VepProgramacion entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepProgramacionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to update
	 * @returns VepProgramacion the persisted VepProgramacion entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProgramacion update(VepProgramacion entity) {
		EntityManagerHelper.log("updating VepProgramacion instance",
				Level.INFO, null);
		try {
			VepProgramacion result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepProgramacion findById(Integer id) {
		EntityManagerHelper.log("finding VepProgramacion instance with id: "
				+ id, Level.INFO, null);
		try {
			VepProgramacion instance = getEntityManager().find(
					VepProgramacion.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepProgramacion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProgramacion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProgramacion> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepProgramacion> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepProgramacion instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepProgramacion model where model."
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

	public List<VepProgramacion> findByCupoMaximo(Object cupoMaximo) {
		return findByProperty(CUPO_MAXIMO, cupoMaximo);
	}

	public List<VepProgramacion> findByCupoMinimo(Object cupoMinimo) {
		return findByProperty(CUPO_MINIMO, cupoMinimo);
	}

	public List<VepProgramacion> findByNivel(Object nivel) {
		return findByProperty(NIVEL, nivel);
	}

	public List<VepProgramacion> findByEstado(Object estado) {
		return findByProperty(ESTADO, estado);
	}

	public List<VepProgramacion> findByIdLugar(Object idLugar) {
		return findByProperty(ID_LUGAR, idLugar);
	}

	public List<VepProgramacion> findByIdRegional(Object idRegional) {
		return findByProperty(ID_REGIONAL, idRegional);
	}

	public List<VepProgramacion> findByIdActividadPar(Object idActividadPar) {
		return findByProperty(ID_ACTIVIDAD_PAR, idActividadPar);
	}

	public List<VepProgramacion> findByTipoId(Object tipoId) {
		return findByProperty(TIPO_ID, tipoId);
	}

	public List<VepProgramacion> findByIdProfesor(Object idProfesor) {
		return findByProperty(ID_PROFESOR, idProfesor);
	}

	public List<VepProgramacion> findByGrupo(Object grupo) {
		return findByProperty(GRUPO, grupo);
	}

	public List<VepProgramacion> findByCupoAsistentes(Object cupoAsistentes) {
		return findByProperty(CUPO_ASISTENTES, cupoAsistentes);
	}

	/**
	 * Find all VepProgramacion entities.
	 * 
	 * @return List<VepProgramacion> all VepProgramacion entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepProgramacion> findAll() {
		EntityManagerHelper.log("finding all VepProgramacion instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepProgramacion model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}