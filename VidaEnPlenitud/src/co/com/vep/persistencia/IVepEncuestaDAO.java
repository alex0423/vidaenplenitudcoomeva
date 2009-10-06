package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepEncuesta;

/**
 * Interface for VepEncuestaDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepEncuestaDAO {
	/**
	 * Perform an initial save of a previously unsaved VepEncuesta entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepEncuestaDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepEncuesta entity);

	/**
	 * Delete a persistent VepEncuesta entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepEncuestaDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepEncuesta entity);

	/**
	 * Persist a previously saved VepEncuesta entity and return it or a copy of
	 * it to the sender. A copy of the VepEncuesta entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepEncuestaDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepEncuesta entity to update
	 * @return VepEncuesta the persisted VepEncuesta entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepEncuesta update(VepEncuesta entity);

	public VepEncuesta findById(Integer id);

	/**
	 * Find all VepEncuesta entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepEncuesta property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepEncuesta> found by query
	 */
	public List<VepEncuesta> findByProperty(String propertyName, Object value);

	public List<VepEncuesta> findByMedioConocimiento(Object medioConocimiento);

	public List<VepEncuesta> findByEspMedioConocimiento(
			Object espMedioConocimiento);

	public List<VepEncuesta> findByCumpEspectativas(Object cumpEspectativas);

	public List<VepEncuesta> findByAclaraCumplimientoEsp(
			Object aclaraCumplimientoEsp);

	public List<VepEncuesta> findByCumplimientoProgEst(
			Object cumplimientoProgEst);

	public List<VepEncuesta> findByAclaracionCumpProgEst(
			Object aclaracionCumpProgEst);

	public List<VepEncuesta> findByAtencion(Object atencion);

	public List<VepEncuesta> findBySugerencias(Object sugerencias);

	public List<VepEncuesta> findByNombreRef(Object nombreRef);

	public List<VepEncuesta> findByApellidoRef(Object apellidoRef);

	public List<VepEncuesta> findByDireccionRef(Object direccionRef);

	public List<VepEncuesta> findByTelefonoRef(Object telefonoRef);

	public List<VepEncuesta> findByEmailRef(Object emailRef);

	public List<VepEncuesta> findByActividadesInteres(Object actividadesInteres);

	/**
	 * Find all VepEncuesta entities.
	 * 
	 * @return List<VepEncuesta> all VepEncuesta entities
	 */
	public List<VepEncuesta> findAll();
}