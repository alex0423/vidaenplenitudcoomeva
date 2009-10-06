package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepRegional;

/**
 * Interface for VepRegionalDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepRegionalDAO {
	/**
	 * Perform an initial save of a previously unsaved VepRegional entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepRegionalDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepRegional entity);

	/**
	 * Delete a persistent VepRegional entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepRegionalDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepRegional entity);

	/**
	 * Persist a previously saved VepRegional entity and return it or a copy of
	 * it to the sender. A copy of the VepRegional entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepRegionalDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepRegional entity to update
	 * @returns VepRegional the persisted VepRegional entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepRegional update(VepRegional entity);

	public VepRegional findById(Integer id);

	/**
	 * Find all VepRegional entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepRegional property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepRegional> found by query
	 */
	public List<VepRegional> findByProperty(String propertyName, Object value);

	/**
	 * Find all VepRegional entities.
	 * 
	 * @return List<VepRegional> all VepRegional entities
	 */
	public List<VepRegional> findAll();
}