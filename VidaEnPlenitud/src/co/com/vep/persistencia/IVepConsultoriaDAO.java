package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepConsultoria;

/**
 * Interface for VepConsultoriaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepConsultoriaDAO {
	/**
	 * Perform an initial save of a previously unsaved VepConsultoria entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepConsultoria entity);

	/**
	 * Delete a persistent VepConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepConsultoria entity);

	/**
	 * Persist a previously saved VepConsultoria entity and return it or a copy
	 * of it to the sender. A copy of the VepConsultoria entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepConsultoria entity to update
	 * @returns VepConsultoria the persisted VepConsultoria entity instance, may
	 *          not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepConsultoria update(VepConsultoria entity);

	public VepConsultoria findById(Integer id);

	/**
	 * Find all VepConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepConsultoria> found by query
	 */
	public List<VepConsultoria> findByProperty(String propertyName, Object value);

	public List<VepConsultoria> findByNombre(Object nombre);

	public List<VepConsultoria> findByDescripcion(Object descripcion);

	public List<VepConsultoria> findByEstado(Object estado);

	/**
	 * Find all VepConsultoria entities.
	 * 
	 * @return List<VepConsultoria> all VepConsultoria entities
	 */
	public List<VepConsultoria> findAll();
}