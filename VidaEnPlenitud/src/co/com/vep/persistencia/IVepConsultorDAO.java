package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepConsultor;

/**
 * Interface for VepConsultorDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepConsultorDAO {
	/**
	 * Perform an initial save of a previously unsaved VepConsultor entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepConsultorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepConsultor entity);

	/**
	 * Delete a persistent VepConsultor entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepConsultorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepConsultor entity);

	/**
	 * Persist a previously saved VepConsultor entity and return it or a copy of
	 * it to the sender. A copy of the VepConsultor entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepConsultorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultor entity to update
	 * @return VepConsultor the persisted VepConsultor entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepConsultor update(VepConsultor entity);

	public VepConsultor findById(Integer id);

	/**
	 * Find all VepConsultor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepConsultor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepConsultor> found by query
	 */
	public List<VepConsultor> findByProperty(String propertyName, Object value);

	/**
	 * Find all VepConsultor entities.
	 * 
	 * @return List<VepConsultor> all VepConsultor entities
	 */
	public List<VepConsultor> findAll();
}