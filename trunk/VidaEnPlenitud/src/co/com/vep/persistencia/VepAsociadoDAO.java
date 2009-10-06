package co.com.vep.persistencia;

import co.com.vep.modelo.VepAsociado;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VepAsociado entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see co.com.vep.modelo.VepAsociado
 * @author MyEclipse Persistence Tools
 */

public class VepAsociadoDAO implements IVepAsociadoDAO {
	// property constants
	public static final String TIPO_SANGRE = "tipoSangre";
	public static final String COMPARTIR_CONOCIMIENTOS = "compartirConocimientos";
	public static final String VALIDACION_ASPIRANTE = "validacionAspirante";
	public static final String TIPO_ASOCIADO = "tipoAsociado";
	public static final String NUMERO_HORAS_DISP_SV = "numeroHorasDispSv";
	public static final String ESTODO_ASOCIADO = "estodoAsociado";
	public static final String ID_ACUDIENTE = "idAcudiente";
	public static final String MEDICAMENTOS = "medicamentos";
	public static final String TIPO_DOCUMENTO = "tipoDocumento";
	public static final String DOCUMENTO = "documento";
	public static final String TIPO_DOCUMENTO_ACU = "tipoDocumentoAcu";
	public static final String DOCUMENTO_ACUDIENTE = "documentoAcudiente";
	public static final String GENERO = "genero";
	public static final String OCUPACION = "ocupacion";
	public static final String ESTCIVIL = "estcivil";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VepAsociado entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAsociadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAsociado entity) {
		EntityManagerHelper
				.log("saving VepAsociado instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VepAsociado entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VepAsociadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAsociado entity) {
		EntityManagerHelper.log("deleting VepAsociado instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VepAsociado.class,
					entity.getIdAsociado());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VepAsociado entity and return it or a copy of
	 * it to the sender. A copy of the VepAsociado entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VepAsociadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to update
	 * @returns VepAsociado the persisted VepAsociado entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAsociado update(VepAsociado entity) {
		EntityManagerHelper.log("updating VepAsociado instance", Level.INFO,
				null);
		try {
			VepAsociado result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VepAsociado findById(Long id) {
		EntityManagerHelper.log("finding VepAsociado instance with id: " + id,
				Level.INFO, null);
		try {
			VepAsociado instance = getEntityManager().find(VepAsociado.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VepAsociado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAsociado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAsociado> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VepAsociado> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VepAsociado instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VepAsociado model where model."
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

	public List<VepAsociado> findByTipoSangre(Object tipoSangre) {
		return findByProperty(TIPO_SANGRE, tipoSangre);
	}

	public List<VepAsociado> findByCompartirConocimientos(
			Object compartirConocimientos) {
		return findByProperty(COMPARTIR_CONOCIMIENTOS, compartirConocimientos);
	}

	public List<VepAsociado> findByValidacionAspirante(
			Object validacionAspirante) {
		return findByProperty(VALIDACION_ASPIRANTE, validacionAspirante);
	}

	public List<VepAsociado> findByTipoAsociado(Object tipoAsociado) {
		return findByProperty(TIPO_ASOCIADO, tipoAsociado);
	}

	public List<VepAsociado> findByNumeroHorasDispSv(Object numeroHorasDispSv) {
		return findByProperty(NUMERO_HORAS_DISP_SV, numeroHorasDispSv);
	}

	public List<VepAsociado> findByEstodoAsociado(Object estodoAsociado) {
		return findByProperty(ESTODO_ASOCIADO, estodoAsociado);
	}

	public List<VepAsociado> findByIdAcudiente(Object idAcudiente) {
		return findByProperty(ID_ACUDIENTE, idAcudiente);
	}

	public List<VepAsociado> findByMedicamentos(Object medicamentos) {
		return findByProperty(MEDICAMENTOS, medicamentos);
	}

	public List<VepAsociado> findByTipoDocumento(Object tipoDocumento) {
		return findByProperty(TIPO_DOCUMENTO, tipoDocumento);
	}

	public List<VepAsociado> findByDocumento(Object documento) {
		return findByProperty(DOCUMENTO, documento);
	}

	public List<VepAsociado> findByTipoDocumentoAcu(Object tipoDocumentoAcu) {
		return findByProperty(TIPO_DOCUMENTO_ACU, tipoDocumentoAcu);
	}

	public List<VepAsociado> findByDocumentoAcudiente(Object documentoAcudiente) {
		return findByProperty(DOCUMENTO_ACUDIENTE, documentoAcudiente);
	}

	public List<VepAsociado> findByGenero(Object genero) {
		return findByProperty(GENERO, genero);
	}

	public List<VepAsociado> findByOcupacion(Object ocupacion) {
		return findByProperty(OCUPACION, ocupacion);
	}

	public List<VepAsociado> findByEstcivil(Object estcivil) {
		return findByProperty(ESTCIVIL, estcivil);
	}

	/**
	 * Find all VepAsociado entities.
	 * 
	 * @return List<VepAsociado> all VepAsociado entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepAsociado> findAll() {
		EntityManagerHelper.log("finding all VepAsociado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAsociado model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}