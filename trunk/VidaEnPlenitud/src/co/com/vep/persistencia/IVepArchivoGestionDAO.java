package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepArchivoGestion;

/**
 * Interface for VepArchivoGestionDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepArchivoGestionDAO {
	/**
	 * Perform an initial save of a previously unsaved VepArchivoGestion entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepArchivoGestionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepArchivoGestion entity);

	/**
	 * Delete a persistent VepArchivoGestion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepArchivoGestionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepArchivoGestion entity);

	/**
	 * Persist a previously saved VepArchivoGestion entity and return it or a
	 * copy of it to the sender. A copy of the VepArchivoGestion entity
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
	 * entity = IVepArchivoGestionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoGestion entity to update
	 * @returns VepArchivoGestion the persisted VepArchivoGestion entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepArchivoGestion update(VepArchivoGestion entity);

	public VepArchivoGestion findById(Integer id);

	/**
	 * Find all VepArchivoGestion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepArchivoGestion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepArchivoGestion> found by query
	 */
	public List<VepArchivoGestion> findByProperty(String propertyName,
			Object value);

	public List<VepArchivoGestion> findByUrlArchivo(Object urlArchivo);

	/**
	 * Find all VepArchivoGestion entities.
	 * 
	 * @return List<VepArchivoGestion> all VepArchivoGestion entities
	 */
	public List<VepArchivoGestion> findAll();
}