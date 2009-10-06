package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepSipParametro;

/**
 * Interface for VepSipParametroDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepSipParametroDAO {
	/**
	 * Perform an initial save of a previously unsaved VepSipParametro entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSipParametroDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSipParametro entity);

	/**
	 * Delete a persistent VepSipParametro entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSipParametroDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSipParametro entity);

	/**
	 * Persist a previously saved VepSipParametro entity and return it or a copy
	 * of it to the sender. A copy of the VepSipParametro entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepSipParametroDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipParametro entity to update
	 * @return VepSipParametro the persisted VepSipParametro entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSipParametro update(VepSipParametro entity);

	public VepSipParametro findById(Integer id);

	/**
	 * Find all VepSipParametro entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSipParametro property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSipParametro> found by query
	 */
	public List<VepSipParametro> findByProperty(String propertyName,
			Object value);

	public List<VepSipParametro> findByNombre(Object nombre);

	public List<VepSipParametro> findByEstadopar(Object estadopar);

	/**
	 * Find all VepSipParametro entities.
	 * 
	 * @return List<VepSipParametro> all VepSipParametro entities
	 */
	public List<VepSipParametro> findAll();
}