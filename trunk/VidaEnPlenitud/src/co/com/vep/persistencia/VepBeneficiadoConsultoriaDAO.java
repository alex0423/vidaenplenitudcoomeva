package co.com.vep.persistencia;

import co.com.vep.modelo.VepBeneficiadoConsultoria;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepBeneficiadoConsultoria entities. Transaction control of the save(),
 * update() and delete() operations must be handled externally by senders of
 * these methods or must be manually added to each of these methods for data to
 * be persisted to the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepBeneficiadoConsultoria
 * @author MyEclipse Persistence Tools
 */

public class VepBeneficiadoConsultoriaDAO implements
		IVepBeneficiadoConsultoriaDAO {
	// property constants
	public static final String TIPO_DOCUMENTO = "tipoDocumento";
	public static final String ID_BENEFICIARIO = "idBeneficiario";
	public static final String URLARCHIVO = "urlarchivo";
	public static final String ID_DETALLE_CONS = "idDetalleCons";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepBeneficiadoConsultoria
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiadoConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiadoConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiadoConsultoria entity) {
		EntityManagerHelper.log("saving VepBeneficiadoConsultoria instance",
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
	 * Delete a persistent VepBeneficiadoConsultoria entity. This operation must
	 * be performed within the a database transaction context for the entity's
	 * data to be permanently deleted from the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepBeneficiadoConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiadoConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiadoConsultoria entity) {
		EntityManagerHelper.log("deleting VepBeneficiadoConsultoria instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VepBeneficiadoConsultoria.class, entity.getConsecutivo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepBeneficiadoConsultoria entity and return it
	 * or a copy of it to the sender. A copy of the VepBeneficiadoConsultoria
	 * entity parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepBeneficiadoConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiadoConsultoria entity to update
	 * @returns VepBeneficiadoConsultoria the persisted
	 *          VepBeneficiadoConsultoria entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBeneficiadoConsultoria update(VepBeneficiadoConsultoria entity) {
		EntityManagerHelper.log("updating VepBeneficiadoConsultoria instance",
				Level.INFO, null);
		try {
			VepBeneficiadoConsultoria result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepBeneficiadoConsultoria findById(Integer id) {
		EntityManagerHelper.log(
				"finding VepBeneficiadoConsultoria instance with id: " + id,
				Level.INFO, null);
		try {
			VepBeneficiadoConsultoria instance = getEntityManager().find(
					VepBeneficiadoConsultoria.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepBeneficiadoConsultoria entities with a specific property
	 * value.
	 * 
	 * @param propertyName
	 *            the name of the VepBeneficiadoConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBeneficiadoConsultoria> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiadoConsultoria> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepBeneficiadoConsultoria instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepBeneficiadoConsultoria model where model."
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

	public List<VepBeneficiadoConsultoria> findByTipoDocumento(
			Object tipoDocumento) {
		return findByProperty(TIPO_DOCUMENTO, tipoDocumento);
	}

	public List<VepBeneficiadoConsultoria> findByIdBeneficiario(
			Object idBeneficiario) {
		return findByProperty(ID_BENEFICIARIO, idBeneficiario);
	}

	public List<VepBeneficiadoConsultoria> findByUrlarchivo(Object urlarchivo) {
		return findByProperty(URLARCHIVO, urlarchivo);
	}

	public List<VepBeneficiadoConsultoria> findByIdDetalleCons(
			Object idDetalleCons) {
		return findByProperty(ID_DETALLE_CONS, idDetalleCons);
	}

	/**
	 * Find all VepBeneficiadoConsultoria entities.
	 * 
	 * @return List<VepBeneficiadoConsultoria> all VepBeneficiadoConsultoria
	 *         entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepBeneficiadoConsultoria> findAll() {
		EntityManagerHelper.log(
				"finding all VepBeneficiadoConsultoria instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from VepBeneficiadoConsultoria model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}