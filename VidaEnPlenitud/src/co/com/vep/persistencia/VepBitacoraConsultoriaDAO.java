package co.com.vep.persistencia;

import co.com.vep.modelo.VepBitacoraConsultoria;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepBitacoraConsultoria entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepBitacoraConsultoria
 * @author MyEclipse Persistence Tools
 */

public class VepBitacoraConsultoriaDAO implements IVepBitacoraConsultoriaDAO {
	// property constants
	public static final String OBSERVACION = "observacion";
	public static final String ARCHIVO_URL = "archivoUrl";
	public static final String ID_DETALLE_CONS = "idDetalleCons";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepBitacoraConsultoria
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBitacoraConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBitacoraConsultoria entity) {
		EntityManagerHelper.log("saving VepBitacoraConsultoria instance",
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
	 * Delete a persistent VepBitacoraConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBitacoraConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBitacoraConsultoria entity) {
		EntityManagerHelper.log("deleting VepBitacoraConsultoria instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VepBitacoraConsultoria.class, entity.getIdBitacoraCons());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepBitacoraConsultoria entity and return it or
	 * a copy of it to the sender. A copy of the VepBitacoraConsultoria entity
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
	 * entity = VepBitacoraConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to update
	 * @returns VepBitacoraConsultoria the persisted VepBitacoraConsultoria
	 *          entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBitacoraConsultoria update(VepBitacoraConsultoria entity) {
		EntityManagerHelper.log("updating VepBitacoraConsultoria instance",
				Level.INFO, null);
		try {
			VepBitacoraConsultoria result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepBitacoraConsultoria findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepBitacoraConsultoria instance with id: " + id,
				Level.INFO, null);
		try {
			VepBitacoraConsultoria instance = getEntityManager().find(
					VepBitacoraConsultoria.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepBitacoraConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBitacoraConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBitacoraConsultoria> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepBitacoraConsultoria> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepBitacoraConsultoria instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepBitacoraConsultoria model where model."
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

	public List<VepBitacoraConsultoria> findByObservacion(Object observacion) {
		return findByProperty(OBSERVACION, observacion);
	}

	public List<VepBitacoraConsultoria> findByArchivoUrl(Object archivoUrl) {
		return findByProperty(ARCHIVO_URL, archivoUrl);
	}

	public List<VepBitacoraConsultoria> findByIdDetalleCons(Object idDetalleCons) {
		return findByProperty(ID_DETALLE_CONS, idDetalleCons);
	}

	/**
	 * Find all VepBitacoraConsultoria entities.
	 * 
	 * @return List<VepBitacoraConsultoria> all VepBitacoraConsultoria entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepBitacoraConsultoria> findAll() {
		EntityManagerHelper.log("finding all VepBitacoraConsultoria instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepBitacoraConsultoria model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}