package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepArchivoActividad;

/**
 * Interface for VepArchivoActividadDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepArchivoActividadDAO {
	/**
	 * Perform an initial save of a previously unsaved VepArchivoActividad
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepArchivoActividadDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepArchivoActividad entity);

	/**
	 * Delete a persistent VepArchivoActividad entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepArchivoActividadDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepArchivoActividad entity);

	/**
	 * Persist a previously saved VepArchivoActividad entity and return it or a
	 * copy of it to the sender. A copy of the VepArchivoActividad entity
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
	 * entity = IVepArchivoActividadDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepArchivoActividad entity to update
	 * @returns VepArchivoActividad the persisted VepArchivoActividad entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepArchivoActividad update(VepArchivoActividad entity);

	public VepArchivoActividad findById(Integer id);

	/**
	 * Find all VepArchivoActividad entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepArchivoActividad property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepArchivoActividad> found by query
	 */
	public List<VepArchivoActividad> findByProperty(String propertyName,
			Object value);

	public List<VepArchivoActividad> findByUrlArchivo(Object urlArchivo);

	public List<VepArchivoActividad> findByIdProgramacion(Object idProgramacion);

	public List<VepArchivoActividad> findByEstado(Object estado);

	/**
	 * Find all VepArchivoActividad entities.
	 * 
	 * @return List<VepArchivoActividad> all VepArchivoActividad entities
	 */
	public List<VepArchivoActividad> findAll();
}