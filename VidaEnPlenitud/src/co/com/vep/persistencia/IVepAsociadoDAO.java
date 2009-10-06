package co.com.vep.persistencia;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepAsociado;

/**
 * Interface for VepAsociadoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepAsociadoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepAsociado entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAsociadoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepAsociado entity);

	/**
	 * Delete a persistent VepAsociado entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepAsociadoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepAsociado entity);

	/**
	 * Persist a previously saved VepAsociado entity and return it or a copy of
	 * it to the sender. A copy of the VepAsociado entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepAsociadoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepAsociado entity to update
	 * @returns VepAsociado the persisted VepAsociado entity instance, may not
	 *          be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepAsociado update(VepAsociado entity);

	public VepAsociado findById(Long id);

	/**
	 * Find all VepAsociado entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepAsociado property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepAsociado> found by query
	 */
	public List<VepAsociado> findByProperty(String propertyName, Object value);

	public List<VepAsociado> findByTipoSangre(Object tipoSangre);

	public List<VepAsociado> findByCompartirConocimientos(
			Object compartirConocimientos);

	public List<VepAsociado> findByValidacionAspirante(
			Object validacionAspirante);

	public List<VepAsociado> findByTipoAsociado(Object tipoAsociado);

	public List<VepAsociado> findByNumeroHorasDispSv(Object numeroHorasDispSv);

	public List<VepAsociado> findByEstodoAsociado(Object estodoAsociado);

	public List<VepAsociado> findByIdAcudiente(Object idAcudiente);

	public List<VepAsociado> findByMedicamentos(Object medicamentos);

	public List<VepAsociado> findByTipoDocumento(Object tipoDocumento);

	public List<VepAsociado> findByDocumento(Object documento);

	public List<VepAsociado> findByTipoDocumentoAcu(Object tipoDocumentoAcu);

	public List<VepAsociado> findByDocumentoAcudiente(Object documentoAcudiente);

	public List<VepAsociado> findByGenero(Object genero);

	public List<VepAsociado> findByOcupacion(Object ocupacion);

	public List<VepAsociado> findByEstcivil(Object estcivil);

	/**
	 * Find all VepAsociado entities.
	 * 
	 * @return List<VepAsociado> all VepAsociado entities
	 */
	public List<VepAsociado> findAll();
}