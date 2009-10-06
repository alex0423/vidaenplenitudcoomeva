package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepUsuario;

/**
 * Interface for VepUsuarioDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepUsuarioDAO {
	/**
	 * Perform an initial save of a previously unsaved VepUsuario entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUsuarioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUsuario entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepUsuario entity);

	/**
	 * Delete a persistent VepUsuario entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepUsuarioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepUsuario entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepUsuario entity);

	/**
	 * Persist a previously saved VepUsuario entity and return it or a copy of
	 * it to the sender. A copy of the VepUsuario entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepUsuarioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepUsuario entity to update
	 * @returns VepUsuario the persisted VepUsuario entity instance, may not be
	 *          the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepUsuario update(VepUsuario entity);

	public VepUsuario findById(Integer id);

	/**
	 * Find all VepUsuario entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepUsuario property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepUsuario> found by query
	 */
	public List<VepUsuario> findByProperty(String propertyName, Object value);

	public List<VepUsuario> findByLoginUsuario(Object loginUsuario);

	public List<VepUsuario> findByEstado(Object estado);

	/**
	 * Find all VepUsuario entities.
	 * 
	 * @return List<VepUsuario> all VepUsuario entities
	 */
	public List<VepUsuario> findAll();
}