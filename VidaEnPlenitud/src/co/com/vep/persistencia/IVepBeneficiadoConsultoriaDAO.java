package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepBeneficiadoConsultoria;

/**
 * Interface for VepBeneficiadoConsultoriaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepBeneficiadoConsultoriaDAO {
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
	 * IVepBeneficiadoConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiadoConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiadoConsultoria entity);

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
	 * IVepBeneficiadoConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiadoConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiadoConsultoria entity);

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
	 * entity = IVepBeneficiadoConsultoriaDAO.update(entity);
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
	public VepBeneficiadoConsultoria update(VepBeneficiadoConsultoria entity);

	public VepBeneficiadoConsultoria findById(Integer id);

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
	public List<VepBeneficiadoConsultoria> findByProperty(String propertyName,
			Object value);

	public List<VepBeneficiadoConsultoria> findByTipoDocumento(
			Object tipoDocumento);

	public List<VepBeneficiadoConsultoria> findByIdBeneficiario(
			Object idBeneficiario);

	public List<VepBeneficiadoConsultoria> findByUrlarchivo(Object urlarchivo);

	public List<VepBeneficiadoConsultoria> findByIdDetalleCons(
			Object idDetalleCons);

	/**
	 * Find all VepBeneficiadoConsultoria entities.
	 * 
	 * @return List<VepBeneficiadoConsultoria> all VepBeneficiadoConsultoria
	 *         entities
	 */
	public List<VepBeneficiadoConsultoria> findAll();
}