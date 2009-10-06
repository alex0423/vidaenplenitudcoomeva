package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepUbicacionAcudiente;
import co.com.vep.modelo.VepUbicacionAcudienteId;

/**
 * Interface for VepUbicacionAcudienteDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepUbicacionAcudienteDAO {
	/**
	 * Perform an initial save of a previously unsaved VepUbicacionAcudiente
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUbicacionAcudienteDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepUbicacionAcudiente entity);

	/**
	 * Delete a persistent VepUbicacionAcudiente entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUbicacionAcudienteDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepUbicacionAcudiente entity);

	/**
	 * Persist a previously saved VepUbicacionAcudiente entity and return it or
	 * a copy of it to the sender. A copy of the VepUbicacionAcudiente entity
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
	 * entity = IVepUbicacionAcudienteDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUbicacionAcudiente entity to update
	 * @returns VepUbicacionAcudiente the persisted VepUbicacionAcudiente entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepUbicacionAcudiente update(VepUbicacionAcudiente entity);

	public VepUbicacionAcudiente findById(VepUbicacionAcudienteId id);

	/**
	 * Find all VepUbicacionAcudiente entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepUbicacionAcudiente property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepUbicacionAcudiente> found by query
	 */
	public List<VepUbicacionAcudiente> findByProperty(String propertyName,
			Object value);

	public List<VepUbicacionAcudiente> findByDescripcionUbicacion(
			Object descripcionUbicacion);

	public List<VepUbicacionAcudiente> findByCiudadUbicacion(
			Object ciudadUbicacion);

	/**
	 * Find all VepUbicacionAcudiente entities.
	 * 
	 * @return List<VepUbicacionAcudiente> all VepUbicacionAcudiente entities
	 */
	public List<VepUbicacionAcudiente> findAll();
}