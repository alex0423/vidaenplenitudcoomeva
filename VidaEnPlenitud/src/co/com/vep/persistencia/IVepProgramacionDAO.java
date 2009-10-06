package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepProgramacion;

/**
 * Interface for VepProgramacionDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepProgramacionDAO {
	/**
	 * Perform an initial save of a previously unsaved VepProgramacion entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProgramacionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepProgramacion entity);

	/**
	 * Delete a persistent VepProgramacion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepProgramacionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepProgramacion entity);

	/**
	 * Persist a previously saved VepProgramacion entity and return it or a copy
	 * of it to the sender. A copy of the VepProgramacion entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepProgramacionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepProgramacion entity to update
	 * @returns VepProgramacion the persisted VepProgramacion entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepProgramacion update(VepProgramacion entity);

	public VepProgramacion findById(Integer id);

	/**
	 * Find all VepProgramacion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepProgramacion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepProgramacion> found by query
	 */
	public List<VepProgramacion> findByProperty(String propertyName,
			Object value);

	public List<VepProgramacion> findByCupoMaximo(Object cupoMaximo);

	public List<VepProgramacion> findByCupoMinimo(Object cupoMinimo);

	public List<VepProgramacion> findByNivel(Object nivel);

	public List<VepProgramacion> findByEstado(Object estado);

	public List<VepProgramacion> findByIdLugar(Object idLugar);

	public List<VepProgramacion> findByIdRegional(Object idRegional);

	public List<VepProgramacion> findByIdActividadPar(Object idActividadPar);

	public List<VepProgramacion> findByTipoId(Object tipoId);

	public List<VepProgramacion> findByIdProfesor(Object idProfesor);

	public List<VepProgramacion> findByGrupo(Object grupo);

	public List<VepProgramacion> findByCupoAsistentes(Object cupoAsistentes);

	/**
	 * Find all VepProgramacion entities.
	 * 
	 * @return List<VepProgramacion> all VepProgramacion entities
	 */
	public List<VepProgramacion> findAll();
}