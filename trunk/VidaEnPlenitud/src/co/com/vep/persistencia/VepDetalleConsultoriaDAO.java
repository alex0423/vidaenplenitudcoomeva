package co.com.vep.persistencia;

import co.com.vep.modelo.VepDetalleConsultoria;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepDetalleConsultoria entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepDetalleConsultoria
 * @author MyEclipse Persistence Tools
 */

public class VepDetalleConsultoriaDAO implements IVepDetalleConsultoriaDAO {
	// property constants
	public static final String OBSERVACIONES = "observaciones";
	public static final String ESTADO = "estado";
	public static final String OBJETIVO = "objetivo";
	public static final String NUM_BENEFICIADOS = "numBeneficiados";
	public static final String ID_REGIONAL = "idRegional";
	public static final String ID_SERVICIO_CON = "idServicioCon";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepDetalleConsultoria
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepDetalleConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepDetalleConsultoria entity) {
		EntityManagerHelper.log("saving VepDetalleConsultoria instance",
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
	 * Delete a persistent VepDetalleConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepDetalleConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepDetalleConsultoria entity) {
		EntityManagerHelper.log("deleting VepDetalleConsultoria instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VepDetalleConsultoria.class, entity.getIdDetallecons());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepDetalleConsultoria entity and return it or
	 * a copy of it to the sender. A copy of the VepDetalleConsultoria entity
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
	 * entity = VepDetalleConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to update
	 * @returns VepDetalleConsultoria the persisted VepDetalleConsultoria entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepDetalleConsultoria update(VepDetalleConsultoria entity) {
		EntityManagerHelper.log("updating VepDetalleConsultoria instance",
				Level.INFO, null);
		try {
			VepDetalleConsultoria result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepDetalleConsultoria findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepDetalleConsultoria instance with id: " + id,
				Level.INFO, null);
		try {
			VepDetalleConsultoria instance = getEntityManager().find(
					VepDetalleConsultoria.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepDetalleConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepDetalleConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepDetalleConsultoria> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepDetalleConsultoria> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepDetalleConsultoria instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepDetalleConsultoria model where model."
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

	public List<VepDetalleConsultoria> findByObservaciones(Object observaciones) {
		return findByProperty(OBSERVACIONES, observaciones);
	}

	public List<VepDetalleConsultoria> findByEstado(Object estado) {
		return findByProperty(ESTADO, estado);
	}

	public List<VepDetalleConsultoria> findByObjetivo(Object objetivo) {
		return findByProperty(OBJETIVO, objetivo);
	}

	public List<VepDetalleConsultoria> findByNumBeneficiados(
			Object numBeneficiados) {
		return findByProperty(NUM_BENEFICIADOS, numBeneficiados);
	}

	public List<VepDetalleConsultoria> findByIdRegional(Object idRegional) {
		return findByProperty(ID_REGIONAL, idRegional);
	}

	public List<VepDetalleConsultoria> findByIdServicioCon(Object idServicioCon) {
		return findByProperty(ID_SERVICIO_CON, idServicioCon);
	}

	/**
	 * Find all VepDetalleConsultoria entities.
	 * 
	 * @return List<VepDetalleConsultoria> all VepDetalleConsultoria entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepDetalleConsultoria> findAll() {
		EntityManagerHelper.log("finding all VepDetalleConsultoria instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepDetalleConsultoria model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}