package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepBeneficiario;
import co.com.vep.modelo.VepBeneficiarioId;

/**
 * Interface for VepBeneficiarioDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepBeneficiarioDAO {
	/**
	 * Perform an initial save of a previously unsaved VepBeneficiario entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBeneficiarioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBeneficiario entity);

	/**
	 * Delete a persistent VepBeneficiario entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBeneficiarioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBeneficiario entity);

	/**
	 * Persist a previously saved VepBeneficiario entity and return it or a copy
	 * of it to the sender. A copy of the VepBeneficiario entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepBeneficiarioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBeneficiario entity to update
	 * @returns VepBeneficiario the persisted VepBeneficiario entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBeneficiario update(VepBeneficiario entity);

	public VepBeneficiario findById(VepBeneficiarioId id);

	/**
	 * Find all VepBeneficiario entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBeneficiario property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBeneficiario> found by query
	 */
	public List<VepBeneficiario> findByProperty(String propertyName,
			Object value);

	public List<VepBeneficiario> findByNombre(Object nombre);

	public List<VepBeneficiario> findByApellido1(Object apellido1);

	public List<VepBeneficiario> findByApellido2(Object apellido2);

	/**
	 * Find all VepBeneficiario entities.
	 * 
	 * @return List<VepBeneficiario> all VepBeneficiario entities
	 */
	public List<VepBeneficiario> findAll();
}