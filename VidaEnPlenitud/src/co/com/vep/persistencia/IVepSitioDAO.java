package co.com.vep.persistencia;

import java.util.List;
import java.util.Set;

import co.com.vep.modelo.VepSitio;

/**
 * Interface for VepSitioDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepSitioDAO {
	/**
	 * Perform an initial save of a previously unsaved VepSitio entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSitioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepSitio entity);

	/**
	 * Delete a persistent VepSitio entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepSitioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepSitio entity);

	/**
	 * Persist a previously saved VepSitio entity and return it or a copy of it
	 * to the sender. A copy of the VepSitio entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepSitioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepSitio entity to update
	 * @returns VepSitio the persisted VepSitio entity instance, may not be the
	 *          same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepSitio update(VepSitio entity);

	public VepSitio findById(Integer id);

	/**
	 * Find all VepSitio entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepSitio property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepSitio> found by query
	 */
	public List<VepSitio> findByProperty(String propertyName, Object value);

	public List<VepSitio> findByNombre(Object nombre);

	public List<VepSitio> findByDireccion(Object direccion);

	public List<VepSitio> findByTelefono(Object telefono);

	public List<VepSitio> findByCiudad(Object ciudad);

	public List<VepSitio> findByDescripcion(Object descripcion);

	/**
	 * Find all VepSitio entities.
	 * 
	 * @return List<VepSitio> all VepSitio entities
	 */
	public List<VepSitio> findAll();
}