package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepValoracion;

/**
 * Interface for VepValoracionDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepValoracionDAO {
	/**
	 * Perform an initial save of a previously unsaved VepValoracion entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepValoracionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepValoracion entity);

	/**
	 * Delete a persistent VepValoracion entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepValoracionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepValoracion entity);

	/**
	 * Persist a previously saved VepValoracion entity and return it or a copy
	 * of it to the sender. A copy of the VepValoracion entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepValoracionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepValoracion entity to update
	 * @return VepValoracion the persisted VepValoracion entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepValoracion update(VepValoracion entity);

	public VepValoracion findById(Long id);

	/**
	 * Find all VepValoracion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepValoracion property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepValoracion> found by query
	 */
	public List<VepValoracion> findByProperty(String propertyName, Object value);

	public List<VepValoracion> findByEstatura(Object estatura);

	public List<VepValoracion> findByPeso(Object peso);

	public List<VepValoracion> findByConsumoFarmacos(Object consumoFarmacos);

	public List<VepValoracion> findByDescripcionFarmacos(
			Object descripcionFarmacos);

	public List<VepValoracion> findByFrecCardiacaMax(Object frecCardiacaMax);

	public List<VepValoracion> findByReforzarEn(Object reforzarEn);

	public List<VepValoracion> findByPlanSeguimiento(Object planSeguimiento);

	public List<VepValoracion> findByImc(Object imc);

	public List<VepValoracion> findByPerimetroCintura(Object perimetroCintura);

	public List<VepValoracion> findByCvEventosSig(Object cvEventosSig);

	public List<VepValoracion> findByCvCambiosSig(Object cvCambiosSig);

	public List<VepValoracion> findByCvMarcadoresDes(Object cvMarcadoresDes);

	public List<VepValoracion> findByPresionSistolica(Object presionSistolica);

	public List<VepValoracion> findByPresionDiastolica(Object presionDiastolica);

	public List<VepValoracion> findByObsProyectoVida(Object obsProyectoVida);

	/**
	 * Find all VepValoracion entities.
	 * 
	 * @return List<VepValoracion> all VepValoracion entities
	 */
	public List<VepValoracion> findAll();
}