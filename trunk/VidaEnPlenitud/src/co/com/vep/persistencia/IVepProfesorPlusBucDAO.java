package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepProfesorPlusBuc;

/**
 * Interface for VepProfesorPlusBucDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepProfesorPlusBucDAO {
	/**
	 * Perform an initial save of a previously unsaved VepProfesorPlusBuc
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProfesorPlusBucDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProfesorPlusBuc entity);

	/**
	 * Delete a persistent VepProfesorPlusBuc entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProfesorPlusBucDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProfesorPlusBuc entity);

	/**
	 * Persist a previously saved VepProfesorPlusBuc entity and return it or a
	 * copy of it to the sender. A copy of the VepProfesorPlusBuc entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepProfesorPlusBucDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesorPlusBuc entity to update
	 * @return VepProfesorPlusBuc the persisted VepProfesorPlusBuc entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProfesorPlusBuc update(VepProfesorPlusBuc entity);

	public VepProfesorPlusBuc findById(Long id);

	/**
	 * Find all VepProfesorPlusBuc entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProfesorPlusBuc property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProfesorPlusBuc> found by query
	 */
	public List<VepProfesorPlusBuc> findByProperty(String propertyName,
			Object value);

	/**
	 * Find all VepProfesorPlusBuc entities.
	 * 
	 * @return List<VepProfesorPlusBuc> all VepProfesorPlusBuc entities
	 */
	public List<VepProfesorPlusBuc> findAll();
}