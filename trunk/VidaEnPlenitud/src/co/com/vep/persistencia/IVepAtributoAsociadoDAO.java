package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAtributoAsociado;

/**
 * Interface for VepAtributoAsociadoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepAtributoAsociadoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepAtributoAsociado
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAtributoAsociadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAtributoAsociado entity);

	/**
	 * Delete a persistent VepAtributoAsociado entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAtributoAsociadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAtributoAsociado entity);

	/**
	 * Persist a previously saved VepAtributoAsociado entity and return it or a
	 * copy of it to the sender. A copy of the VepAtributoAsociado entity
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
	 * entity = IVepAtributoAsociadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAtributoAsociado entity to update
	 * @return VepAtributoAsociado the persisted VepAtributoAsociado entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAtributoAsociado update(VepAtributoAsociado entity);

	public VepAtributoAsociado findById(Integer id);

	/**
	 * Find all VepAtributoAsociado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAtributoAsociado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAtributoAsociado> found by query
	 */
	public List<VepAtributoAsociado> findByProperty(String propertyName,
			Object value);

	public List<VepAtributoAsociado> findByValor(Object valor);

	/**
	 * Find all VepAtributoAsociado entities.
	 * 
	 * @return List<VepAtributoAsociado> all VepAtributoAsociado entities
	 */
	public List<VepAtributoAsociado> findAll();
}