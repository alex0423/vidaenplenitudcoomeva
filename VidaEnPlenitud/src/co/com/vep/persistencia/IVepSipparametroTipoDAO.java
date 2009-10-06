package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepSipparametroTipo;

/**
 * Interface for VepSipparametroTipoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepSipparametroTipoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepSipparametroTipo
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSipparametroTipoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSipparametroTipo entity);

	/**
	 * Delete a persistent VepSipparametroTipo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSipparametroTipoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSipparametroTipo entity);

	/**
	 * Persist a previously saved VepSipparametroTipo entity and return it or a
	 * copy of it to the sender. A copy of the VepSipparametroTipo entity
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
	 * entity = IVepSipparametroTipoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSipparametroTipo entity to update
	 * @return VepSipparametroTipo the persisted VepSipparametroTipo entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSipparametroTipo update(VepSipparametroTipo entity);

	public VepSipparametroTipo findById(Integer id);

	/**
	 * Find all VepSipparametroTipo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSipparametroTipo property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSipparametroTipo> found by query
	 */
	public List<VepSipparametroTipo> findByProperty(String propertyName,
			Object value);

	public List<VepSipparametroTipo> findByObservacion(Object observacion);

	public List<VepSipparametroTipo> findByEstado(Object estado);

	/**
	 * Find all VepSipparametroTipo entities.
	 * 
	 * @return List<VepSipparametroTipo> all VepSipparametroTipo entities
	 */
	public List<VepSipparametroTipo> findAll();
}