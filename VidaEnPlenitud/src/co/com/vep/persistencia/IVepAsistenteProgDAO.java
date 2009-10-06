package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAsistenteProg;

/**
 * Interface for VepAsistenteProgDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepAsistenteProgDAO {
	/**
	 * Perform an initial save of a previously unsaved VepAsistenteProg entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAsistenteProgDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAsistenteProg entity);

	/**
	 * Delete a persistent VepAsistenteProg entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAsistenteProgDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAsistenteProg entity);

	/**
	 * Persist a previously saved VepAsistenteProg entity and return it or a
	 * copy of it to the sender. A copy of the VepAsistenteProg entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepAsistenteProgDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsistenteProg entity to update
	 * @return VepAsistenteProg the persisted VepAsistenteProg entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAsistenteProg update(VepAsistenteProg entity);

	public VepAsistenteProg findById(Integer consecutivo);

	/**
	 * Find all VepAsistenteProg entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAsistenteProg property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAsistenteProg> found by query
	 */
	public List<VepAsistenteProg> findByProperty(String propertyName,
			Object value);

	/**
	 * Find all VepAsistenteProg entities.
	 * 
	 * @return List<VepAsistenteProg> all VepAsistenteProg entities
	 */
	public List<VepAsistenteProg> findAll();
}