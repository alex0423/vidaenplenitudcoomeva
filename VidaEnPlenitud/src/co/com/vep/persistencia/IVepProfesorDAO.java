package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorId;

/**
 * Interface for VepProfesorDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepProfesorDAO {
	/**
	 * Perform an initial save of a previously unsaved VepProfesor entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProfesorDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProfesor entity);

	/**
	 * Delete a persistent VepProfesor entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProfesorDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProfesor entity);

	/**
	 * Persist a previously saved VepProfesor entity and return it or a copy of
	 * it to the sender. A copy of the VepProfesor entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepProfesorDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProfesor entity to update
	 * @returns VepProfesor the persisted VepProfesor entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProfesor update(VepProfesor entity);

	public VepProfesor findById(VepProfesorId id);

	/**
	 * Find all VepProfesor entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProfesor property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProfesor> found by query
	 */
	public List<VepProfesor> findByProperty(String propertyName, Object value);

	public List<VepProfesor> findByTitulo(Object titulo);

	public List<VepProfesor> findByEspecialidad(Object especialidad);

	public List<VepProfesor> findByUrlHoja(Object urlHoja);

	public List<VepProfesor> findByEstadoProfesor(Object estadoProfesor);

	public List<VepProfesor> findByNombre1(Object nombre1);

	public List<VepProfesor> findByNombre2(Object nombre2);

	public List<VepProfesor> findByApellido1(Object apellido1);

	public List<VepProfesor> findByApellido2(Object apellido2);

	public List<VepProfesor> findByEstcivil(Object estcivil);

	public List<VepProfesor> findByGenero(Object genero);

	/**
	 * Find all VepProfesor entities.
	 * 
	 * @return List<VepProfesor> all VepProfesor entities
	 */
	public List<VepProfesor> findAll();
}