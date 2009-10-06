package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepParametroActividad;

/**
 * Interface for VepParametroActividadDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepParametroActividadDAO {
	/**
	 * Perform an initial save of a previously unsaved VepParametroActividad
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepParametroActividadDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepParametroActividad entity);

	/**
	 * Delete a persistent VepParametroActividad entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepParametroActividadDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepParametroActividad entity);

	/**
	 * Persist a previously saved VepParametroActividad entity and return it or
	 * a copy of it to the sender. A copy of the VepParametroActividad entity
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
	 * entity = IVepParametroActividadDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepParametroActividad entity to update
	 * @returns VepParametroActividad the persisted VepParametroActividad entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepParametroActividad update(VepParametroActividad entity);

	public VepParametroActividad findById(Integer id);

	/**
	 * Find all VepParametroActividad entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepParametroActividad property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepParametroActividad> found by query
	 */
	public List<VepParametroActividad> findByProperty(String propertyName,
			Object value);

	public List<VepParametroActividad> findByNombre(Object nombre);

	public List<VepParametroActividad> findByEstadopar(Object estadopar);

	/**
	 * Find all VepParametroActividad entities.
	 * 
	 * @return List<VepParametroActividad> all VepParametroActividad entities
	 */
	public List<VepParametroActividad> findAll();
}