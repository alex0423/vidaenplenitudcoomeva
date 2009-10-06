package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepBeneficiado;

/**
 * Interface for VepBeneficiadoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepBeneficiadoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepBeneficiado entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBeneficiadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiado entity);

	/**
	 * Delete a persistent VepBeneficiado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBeneficiadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiado entity);

	/**
	 * Persist a previously saved VepBeneficiado entity and return it or a copy
	 * of it to the sender. A copy of the VepBeneficiado entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepBeneficiadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiado entity to update
	 * @return VepBeneficiado the persisted VepBeneficiado entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBeneficiado update(VepBeneficiado entity);

	public VepBeneficiado findById(Integer id);

	/**
	 * Find all VepBeneficiado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBeneficiado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBeneficiado> found by query
	 */
	public List<VepBeneficiado> findByProperty(String propertyName, Object value);

	public List<VepBeneficiado> findByUrlarchivo(Object urlarchivo);

	/**
	 * Find all VepBeneficiado entities.
	 * 
	 * @return List<VepBeneficiado> all VepBeneficiado entities
	 */
	public List<VepBeneficiado> findAll();
}