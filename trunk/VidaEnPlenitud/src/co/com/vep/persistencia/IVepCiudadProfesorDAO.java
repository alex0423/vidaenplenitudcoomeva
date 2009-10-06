package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepCiudadProfesor;
import co.com.vep.modelo.VepCiudadProfesorId;

/**
 * Interface for VepCiudadProfesorDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepCiudadProfesorDAO {
	/**
	 * Perform an initial save of a previously unsaved VepCiudadProfesor entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepCiudadProfesorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepCiudadProfesor entity);

	/**
	 * Delete a persistent VepCiudadProfesor entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepCiudadProfesorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepCiudadProfesor entity);

	/**
	 * Persist a previously saved VepCiudadProfesor entity and return it or a
	 * copy of it to the sender. A copy of the VepCiudadProfesor entity
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
	 * entity = IVepCiudadProfesorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepCiudadProfesor entity to update
	 * @returns VepCiudadProfesor the persisted VepCiudadProfesor entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepCiudadProfesor update(VepCiudadProfesor entity);

	public VepCiudadProfesor findById(VepCiudadProfesorId id);

	/**
	 * Find all VepCiudadProfesor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepCiudadProfesor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepCiudadProfesor> found by query
	 */
	public List<VepCiudadProfesor> findByProperty(String propertyName,
			Object value);

	/**
	 * Find all VepCiudadProfesor entities.
	 * 
	 * @return List<VepCiudadProfesor> all VepCiudadProfesor entities
	 */
	public List<VepCiudadProfesor> findAll();
}