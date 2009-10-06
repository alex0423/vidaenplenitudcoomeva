package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepEncuesta;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepEncuesta entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepEncuesta
 * @author MyEclipse Persistence Tools
 */

public class VepEncuestaDAO implements IVepEncuestaDAO {
	// property constants
	public static final String MEDIO_CONOCIMIENTO = "medioConocimiento";
	public static final String ESP_MEDIO_CONOCIMIENTO = "espMedioConocimiento";
	public static final String CUMP_ESPECTATIVAS = "cumpEspectativas";
	public static final String ACLARA_CUMPLIMIENTO_ESP = "aclaraCumplimientoEsp";
	public static final String CUMPLIMIENTO_PROG_EST = "cumplimientoProgEst";
	public static final String ACLARACION_CUMP_PROG_EST = "aclaracionCumpProgEst";
	public static final String ATENCION = "atencion";
	public static final String SUGERENCIAS = "sugerencias";
	public static final String NOMBRE_REF = "nombreRef";
	public static final String APELLIDO_REF = "apellidoRef";
	public static final String DIRECCION_REF = "direccionRef";
	public static final String TELEFONO_REF = "telefonoRef";
	public static final String EMAIL_REF = "emailRef";
	public static final String ACTIVIDADES_INTERES = "actividadesInteres";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepEncuesta entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepEncuestaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepEncuesta entity) {
		EntityManagerHelper
				.log("saving VepEncuesta instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepEncuesta entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepEncuestaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepEncuesta entity) {
		EntityManagerHelper.log("deleting VepEncuesta instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepEncuesta.class,
					entity.getIdEncuesta());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepEncuesta entity and return it or a copy of
	 * it to the sender. A copy of the VepEncuesta entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepEncuestaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to update
	 * @returns VepEncuesta the persisted VepEncuesta entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepEncuesta update(VepEncuesta entity) {
		EntityManagerHelper.log("updating VepEncuesta instance", Level.INFO,
				null);
		try {
			VepEncuesta result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepEncuesta findById(Integer id) {
		EntityManagerHelper.log("finding VepEncuesta instance with id: " + id,
				Level.INFO, null);
		try {
			VepEncuesta instance = getEntityManager().find(VepEncuesta.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepEncuesta entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepEncuesta property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepEncuesta> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepEncuesta> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepEncuesta instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepEncuesta model where model."
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

	public List<VepEncuesta> findByMedioConocimiento(Object medioConocimiento) {
		return findByProperty(MEDIO_CONOCIMIENTO, medioConocimiento);
	}

	public List<VepEncuesta> findByEspMedioConocimiento(
			Object espMedioConocimiento) {
		return findByProperty(ESP_MEDIO_CONOCIMIENTO, espMedioConocimiento);
	}

	public List<VepEncuesta> findByCumpEspectativas(Object cumpEspectativas) {
		return findByProperty(CUMP_ESPECTATIVAS, cumpEspectativas);
	}

	public List<VepEncuesta> findByAclaraCumplimientoEsp(
			Object aclaraCumplimientoEsp) {
		return findByProperty(ACLARA_CUMPLIMIENTO_ESP, aclaraCumplimientoEsp);
	}

	public List<VepEncuesta> findByCumplimientoProgEst(
			Object cumplimientoProgEst) {
		return findByProperty(CUMPLIMIENTO_PROG_EST, cumplimientoProgEst);
	}

	public List<VepEncuesta> findByAclaracionCumpProgEst(
			Object aclaracionCumpProgEst) {
		return findByProperty(ACLARACION_CUMP_PROG_EST, aclaracionCumpProgEst);
	}

	public List<VepEncuesta> findByAtencion(Object atencion) {
		return findByProperty(ATENCION, atencion);
	}

	public List<VepEncuesta> findBySugerencias(Object sugerencias) {
		return findByProperty(SUGERENCIAS, sugerencias);
	}

	public List<VepEncuesta> findByNombreRef(Object nombreRef) {
		return findByProperty(NOMBRE_REF, nombreRef);
	}

	public List<VepEncuesta> findByApellidoRef(Object apellidoRef) {
		return findByProperty(APELLIDO_REF, apellidoRef);
	}

	public List<VepEncuesta> findByDireccionRef(Object direccionRef) {
		return findByProperty(DIRECCION_REF, direccionRef);
	}

	public List<VepEncuesta> findByTelefonoRef(Object telefonoRef) {
		return findByProperty(TELEFONO_REF, telefonoRef);
	}

	public List<VepEncuesta> findByEmailRef(Object emailRef) {
		return findByProperty(EMAIL_REF, emailRef);
	}

	public List<VepEncuesta> findByActividadesInteres(Object actividadesInteres) {
		return findByProperty(ACTIVIDADES_INTERES, actividadesInteres);
	}

	/**
	 * Find all VepEncuesta entities.
	 * 
	 * @return List<VepEncuesta> all VepEncuesta entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepEncuesta> findAll() {
		EntityManagerHelper.log("finding all VepEncuesta instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepEncuesta model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}