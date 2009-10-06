package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepBitacoraConsultoria;

/**
 * Interface for VepBitacoraConsultoriaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepBitacoraConsultoriaDAO {
	/**
	 * Perform an initial save of a previously unsaved VepBitacoraConsultoria
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBitacoraConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepBitacoraConsultoria entity);

	/**
	 * Delete a persistent VepBitacoraConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepBitacoraConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepBitacoraConsultoria entity);

	/**
	 * Persist a previously saved VepBitacoraConsultoria entity and return it or
	 * a copy of it to the sender. A copy of the VepBitacoraConsultoria entity
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
	 * entity = IVepBitacoraConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepBitacoraConsultoria entity to update
	 * @returns VepBitacoraConsultoria the persisted VepBitacoraConsultoria
	 *          entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepBitacoraConsultoria update(VepBitacoraConsultoria entity);

	public VepBitacoraConsultoria findById(Integer id);

	/**
	 * Find all VepBitacoraConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepBitacoraConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepBitacoraConsultoria> found by query
	 */
	public List<VepBitacoraConsultoria> findByProperty(String propertyName,
			Object value);

	public List<VepBitacoraConsultoria> findByObservacion(Object observacion);

	public List<VepBitacoraConsultoria> findByArchivoUrl(Object archivoUrl);

	public List<VepBitacoraConsultoria> findByIdDetalleCons(Object idDetalleCons);

	/**
	 * Find all VepBitacoraConsultoria entities.
	 * 
	 * @return List<VepBitacoraConsultoria> all VepBitacoraConsultoria entities
	 */
	public List<VepBitacoraConsultoria> findAll();
}