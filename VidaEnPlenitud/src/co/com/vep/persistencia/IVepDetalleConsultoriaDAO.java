package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepDetalleConsultoria;

/**
 * Interface for VepDetalleConsultoriaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepDetalleConsultoriaDAO {
	/**
	 * Perform an initial save of a previously unsaved VepDetalleConsultoria
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepDetalleConsultoriaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepDetalleConsultoria entity);

	/**
	 * Delete a persistent VepDetalleConsultoria entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepDetalleConsultoriaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepDetalleConsultoria entity);

	/**
	 * Persist a previously saved VepDetalleConsultoria entity and return it or
	 * a copy of it to the sender. A copy of the VepDetalleConsultoria entity
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
	 * entity = IVepDetalleConsultoriaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepDetalleConsultoria entity to update
	 * @returns VepDetalleConsultoria the persisted VepDetalleConsultoria entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepDetalleConsultoria update(VepDetalleConsultoria entity);

	public VepDetalleConsultoria findById(Integer id);

	/**
	 * Find all VepDetalleConsultoria entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepDetalleConsultoria property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepDetalleConsultoria> found by query
	 */
	public List<VepDetalleConsultoria> findByProperty(String propertyName,
			Object value);

	public List<VepDetalleConsultoria> findByObservaciones(Object observaciones);

	public List<VepDetalleConsultoria> findByEstado(Object estado);

	public List<VepDetalleConsultoria> findByObjetivo(Object objetivo);

	public List<VepDetalleConsultoria> findByNumBeneficiados(
			Object numBeneficiados);

	public List<VepDetalleConsultoria> findByIdRegional(Object idRegional);

	public List<VepDetalleConsultoria> findByIdServicioCon(Object idServicioCon);

	/**
	 * Find all VepDetalleConsultoria entities.
	 * 
	 * @return List<VepDetalleConsultoria> all VepDetalleConsultoria entities
	 */
	public List<VepDetalleConsultoria> findAll();
}