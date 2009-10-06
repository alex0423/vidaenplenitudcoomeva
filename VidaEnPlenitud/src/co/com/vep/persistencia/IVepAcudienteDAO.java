package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepAcudiente;

/**
 * Interface for VepAcudienteDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepAcudienteDAO {
	/**
	 * Perform an initial save of a previously unsaved VepAcudiente entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAcudienteDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAcudiente entity);

	/**
	 * Delete a persistent VepAcudiente entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAcudienteDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAcudiente entity);

	/**
	 * Persist a previously saved VepAcudiente entity and return it or a copy of
	 * it to the sender. A copy of the VepAcudiente entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepAcudienteDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAcudiente entity to update
	 * @returns VepAcudiente the persisted VepAcudiente entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAcudiente update(VepAcudiente entity);

	public VepAcudiente findById(Integer id);

	/**
	 * Find all VepAcudiente entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAcudiente property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAcudiente> found by query
	 */
	public List<VepAcudiente> findByProperty(String propertyName, Object value);

	public List<VepAcudiente> findByTipoDocumento(Object tipoDocumento);

	public List<VepAcudiente> findByNumeroDocumento(Object numeroDocumento);

	public List<VepAcudiente> findByNombre1(Object nombre1);

	public List<VepAcudiente> findByNombre2(Object nombre2);

	public List<VepAcudiente> findByApellido1(Object apellido1);

	public List<VepAcudiente> findByApellido2(Object apellido2);

	public List<VepAcudiente> findByIdAsociado(Object idAsociado);

	/**
	 * Find all VepAcudiente entities.
	 * 
	 * @return List<VepAcudiente> all VepAcudiente entities
	 */
	public List<VepAcudiente> findAll();
}