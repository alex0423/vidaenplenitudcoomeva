package co.com.vep.persistencia;

import java.util.List;

import co.com.vep.modelo.VepTipoAtributo;
import co.com.vep.modelo.VepTipoAtributoId;

/**
 * Interface for VepTipoAtributoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVepTipoAtributoDAO {
	/**
	 * Perform an initial save of a previously unsaved VepTipoAtributo entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepTipoAtributoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepTipoAtributo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VepTipoAtributo entity);

	/**
	 * Delete a persistent VepTipoAtributo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVepTipoAtributoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VepTipoAtributo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VepTipoAtributo entity);

	/**
	 * Persist a previously saved VepTipoAtributo entity and return it or a copy
	 * of it to the sender. A copy of the VepTipoAtributo entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVepTipoAtributoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VepTipoAtributo entity to update
	 * @return VepTipoAtributo the persisted VepTipoAtributo entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VepTipoAtributo update(VepTipoAtributo entity);

	public VepTipoAtributo findById(VepTipoAtributoId id);

	/**
	 * Find all VepTipoAtributo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VepTipoAtributo property to query
	 * @param value
	 *            the property value to match
	 * @return List<VepTipoAtributo> found by query
	 */
	public List<VepTipoAtributo> findByProperty(String propertyName,
			Object value);

	/**
	 * Find all VepTipoAtributo entities.
	 * 
	 * @return List<VepTipoAtributo> all VepTipoAtributo entities
	 */
	public List<VepTipoAtributo> findAll();
}