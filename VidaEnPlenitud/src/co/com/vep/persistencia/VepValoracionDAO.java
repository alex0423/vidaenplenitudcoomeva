package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepValoracion;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepValoracion entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.persistencia.VepValoracion
 * @author MyEclipse Persistence Tools
 */

public class VepValoracionDAO implements IVepValoracionDAO {
	// property constants
	public static final String ESTATURA = "estatura";
	public static final String PESO = "peso";
	public static final String CONSUMO_FARMACOS = "consumoFarmacos";
	public static final String DESCRIPCION_FARMACOS = "descripcionFarmacos";
	public static final String FREC_CARDIACA_MAX = "frecCardiacaMax";
	public static final String REFORZAR_EN = "reforzarEn";
	public static final String PLAN_SEGUIMIENTO = "planSeguimiento";
	public static final String IMC = "imc";
	public static final String PERIMETRO_CINTURA = "perimetroCintura";
	public static final String CV_EVENTOS_SIG = "cvEventosSig";
	public static final String CV_CAMBIOS_SIG = "cvCambiosSig";
	public static final String CV_MARCADORES_DES = "cvMarcadoresDes";
	public static final String PRESION_SISTOLICA = "presionSistolica";
	public static final String PRESION_DIASTOLICA = "presionDiastolica";
	public static final String OBS_PROYECTO_VIDA = "obsProyectoVida";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepValoracion entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepValoracionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepValoracion entity) {
		EntityManagerHelper.log("saving VepValoracion instance", Level.INFO,
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
	 * Delete a persistent VepValoracion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepValoracionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepValoracion entity) {
		EntityManagerHelper.log("deleting VepValoracion instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepValoracion.class,
					entity.getIdValoracion());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepValoracion entity and return it or a copy
	 * of it to the sender. A copy of the VepValoracion entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepValoracionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to update
	 * @return VepValoracion the persisted VepValoracion entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepValoracion update(VepValoracion entity) {
		EntityManagerHelper.log("updating VepValoracion instance", Level.INFO,
				null);
		try {
			VepValoracion result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepValoracion findById(Long id) {
		EntityManagerHelper.log(
				"finding VepValoracion instance with id: " + id, Level.INFO,
				null);
		try {
			VepValoracion instance = getEntityManager().find(
					VepValoracion.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepValoracion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepValoracion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepValoracion> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepValoracion> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VepValoracion instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepValoracion model where model."
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

	public List<VepValoracion> findByEstatura(Object estatura) {
		return findByProperty(ESTATURA, estatura);
	}

	public List<VepValoracion> findByPeso(Object peso) {
		return findByProperty(PESO, peso);
	}

	public List<VepValoracion> findByConsumoFarmacos(Object consumoFarmacos) {
		return findByProperty(CONSUMO_FARMACOS, consumoFarmacos);
	}

	public List<VepValoracion> findByDescripcionFarmacos(
			Object descripcionFarmacos) {
		return findByProperty(DESCRIPCION_FARMACOS, descripcionFarmacos);
	}

	public List<VepValoracion> findByFrecCardiacaMax(Object frecCardiacaMax) {
		return findByProperty(FREC_CARDIACA_MAX, frecCardiacaMax);
	}

	public List<VepValoracion> findByReforzarEn(Object reforzarEn) {
		return findByProperty(REFORZAR_EN, reforzarEn);
	}

	public List<VepValoracion> findByPlanSeguimiento(Object planSeguimiento) {
		return findByProperty(PLAN_SEGUIMIENTO, planSeguimiento);
	}

	public List<VepValoracion> findByImc(Object imc) {
		return findByProperty(IMC, imc);
	}

	public List<VepValoracion> findByPerimetroCintura(Object perimetroCintura) {
		return findByProperty(PERIMETRO_CINTURA, perimetroCintura);
	}

	public List<VepValoracion> findByCvEventosSig(Object cvEventosSig) {
		return findByProperty(CV_EVENTOS_SIG, cvEventosSig);
	}

	public List<VepValoracion> findByCvCambiosSig(Object cvCambiosSig) {
		return findByProperty(CV_CAMBIOS_SIG, cvCambiosSig);
	}

	public List<VepValoracion> findByCvMarcadoresDes(Object cvMarcadoresDes) {
		return findByProperty(CV_MARCADORES_DES, cvMarcadoresDes);
	}

	public List<VepValoracion> findByPresionSistolica(Object presionSistolica) {
		return findByProperty(PRESION_SISTOLICA, presionSistolica);
	}

	public List<VepValoracion> findByPresionDiastolica(Object presionDiastolica) {
		return findByProperty(PRESION_DIASTOLICA, presionDiastolica);
	}

	public List<VepValoracion> findByObsProyectoVida(Object obsProyectoVida) {
		return findByProperty(OBS_PROYECTO_VIDA, obsProyectoVida);
	}

	/**
	 * Find all VepValoracion entities.
	 * 
	 * @return List<VepValoracion> all VepValoracion entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepValoracion> findAll() {
		EntityManagerHelper.log("finding all VepValoracion instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepValoracion model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}