package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepLugar;

/**
 * Interface for VepLugarDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepLugarDAO {
	/**
	 * Perform an initial save of a previously unsaved VepLugar entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepLugarDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepLugar entity);

	/**
	 * Delete a persistent VepLugar entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepLugarDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepLugar entity);

	/**
	 * Persist a previously saved VepLugar entity and return it or a copy of it
	 * to the sender. A copy of the VepLugar entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepLugarDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepLugar entity to update
	 * @returns VepLugar the persisted VepLugar entity instance, may not be the
	 *          same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepLugar update(VepLugar entity);

	public VepLugar findById(Integer id);

	/**
	 * Find all VepLugar entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepLugar property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepLugar> found by query
	 */
	public List<VepLugar> findByProperty(String propertyName, Object value);

	public List<VepLugar> findByNombre(Object nombre);

	public List<VepLugar> findByDescripcion(Object descripcion);

	public List<VepLugar> findByCupoMaximo(Object cupoMaximo);

	public List<VepLugar> findByCupoMinimo(Object cupoMinimo);

	/**
	 * Find all VepLugar entities.
	 * 
	 * @return List<VepLugar> all VepLugar entities
	 */
	public List<VepLugar> findAll();
}