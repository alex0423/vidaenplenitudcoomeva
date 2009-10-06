package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepUbicacionProfesor;
import co.com.vep.modelo.VepUbicacionProfesorId;

/**
 * Interface for VepUbicacionProfesorDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepUbicacionProfesorDAO {
	/**
	 * Perform an initial save of a previously unsaved VepUbicacionProfesor
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUbicacionProfesorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionProfesor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepUbicacionProfesor entity);

	/**
	 * Delete a persistent VepUbicacionProfesor entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUbicacionProfesorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionProfesor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepUbicacionProfesor entity);

	/**
	 * Persist a previously saved VepUbicacionProfesor entity and return it or a
	 * copy of it to the sender. A copy of the VepUbicacionProfesor entity
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
	 * entity = IVepUbicacionProfesorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionProfesor entity to update
	 * @returns VepUbicacionProfesor the persisted VepUbicacionProfesor entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepUbicacionProfesor update(VepUbicacionProfesor entity);

	public VepUbicacionProfesor findById(VepUbicacionProfesorId id);

	/**
	 * Find all VepUbicacionProfesor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepUbicacionProfesor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepUbicacionProfesor> found by query
	 */
	public List<VepUbicacionProfesor> findByProperty(String propertyName,
			Object value);

	public List<VepUbicacionProfesor> findByDescripcionUbicacion(
			Object descripcionUbicacion);

	public List<VepUbicacionProfesor> findByCiudad(Object ciudad);

	/**
	 * Find all VepUbicacionProfesor entities.
	 * 
	 * @return List<VepUbicacionProfesor> all VepUbicacionProfesor entities
	 */
	public List<VepUbicacionProfesor> findAll();
}