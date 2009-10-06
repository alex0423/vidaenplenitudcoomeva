package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepPlusBuc;

/**
 * Interface for VepPlusBucDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepPlusBucDAO {
	/**
	 * Perform an initial save of a previously unsaved VepPlusBuc entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepPlusBucDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepPlusBuc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepPlusBuc entity);

	/**
	 * Delete a persistent VepPlusBuc entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepPlusBucDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepPlusBuc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepPlusBuc entity);

	/**
	 * Persist a previously saved VepPlusBuc entity and return it or a copy of
	 * it to the sender. A copy of the VepPlusBuc entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepPlusBucDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepPlusBuc entity to update
	 * @return VepPlusBuc the persisted VepPlusBuc entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepPlusBuc update(VepPlusBuc entity);

	public VepPlusBuc findById(Long id);

	/**
	 * Find all VepPlusBuc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepPlusBuc property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepPlusBuc> found by query
	 */
	public List<VepPlusBuc> findByProperty(String propertyName, Object value);

	/**
	 * Find all VepPlusBuc entities.
	 * 
	 * @return List<VepPlusBuc> all VepPlusBuc entities
	 */
	public List<VepPlusBuc> findAll();
}