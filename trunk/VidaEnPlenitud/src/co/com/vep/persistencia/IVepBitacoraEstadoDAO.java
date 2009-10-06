package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepBitacoraEstado;

/**
 * Interface for VepBitacoraEstadoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepBitacoraEstadoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepBitacoraEstado entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBitacoraEstadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBitacoraEstado entity);

	/**
	 * Delete a persistent VepBitacoraEstado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBitacoraEstadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBitacoraEstado entity);

	/**
	 * Persist a previously saved VepBitacoraEstado entity and return it or a
	 * copy of it to the sender. A copy of the VepBitacoraEstado entity
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
	 * entity = IVepBitacoraEstadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraEstado entity to update
	 * @return VepBitacoraEstado the persisted VepBitacoraEstado entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBitacoraEstado update(VepBitacoraEstado entity);

	public VepBitacoraEstado findById(Integer id);

	/**
	 * Find all VepBitacoraEstado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBitacoraEstado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBitacoraEstado> found by query
	 */
	public List<VepBitacoraEstado> findByProperty(String propertyName,
			Object value);

	public List<VepBitacoraEstado> findByEstadoAsociado(Object estadoAsociado);

	/**
	 * Find all VepBitacoraEstado entities.
	 * 
	 * @return List<VepBitacoraEstado> all VepBitacoraEstado entities
	 */
	public List<VepBitacoraEstado> findAll();
}