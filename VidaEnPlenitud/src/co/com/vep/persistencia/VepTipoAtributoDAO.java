package co.com.vep.persistencia;

import co.com.vep.modelo.VepTipoAtributo;
import co.com.vep.modelo.VepTipoAtributoId;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for VepTipoAtributo entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see co.com.vep.modelo.VepTipoAtributo
  * @author MyEclipse Persistence Tools 
 */

public class VepTipoAtributoDAO  implements IVepTipoAtributoDAO{
	//property constants





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved VepTipoAtributo entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   VepTipoAtributoDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity VepTipoAtributo entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(VepTipoAtributo entity) {
    				EntityManagerHelper.log("saving VepTipoAtributo instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent VepTipoAtributo entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   VepTipoAtributoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity VepTipoAtributo entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(VepTipoAtributo entity) {
    				EntityManagerHelper.log("deleting VepTipoAtributo instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(VepTipoAtributo.class, entity.getId());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved VepTipoAtributo entity and return it or a copy of it to the sender. 
	 A copy of the VepTipoAtributo entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = VepTipoAtributoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity VepTipoAtributo entity to update
	 @returns VepTipoAtributo the persisted VepTipoAtributo entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public VepTipoAtributo update(VepTipoAtributo entity) {
    				EntityManagerHelper.log("updating VepTipoAtributo instance", Level.INFO, null);
	        try {
            VepTipoAtributo result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public VepTipoAtributo findById( VepTipoAtributoId id) {
    				EntityManagerHelper.log("finding VepTipoAtributo instance with id: " + id, Level.INFO, null);
	        try {
            VepTipoAtributo instance = getEntityManager().find(VepTipoAtributo.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all VepTipoAtributo entities with a specific property value.  
	 
	  @param propertyName the name of the VepTipoAtributo property to query
	  @param value the property value to match
	  	  @return List<VepTipoAtributo> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<VepTipoAtributo> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding VepTipoAtributo instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from VepTipoAtributo model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	
	/**
	 * Find all VepTipoAtributo entities.
	  	  @return List<VepTipoAtributo> all VepTipoAtributo entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepTipoAtributo> findAll(
		) {
					EntityManagerHelper.log("finding all VepTipoAtributo instances", Level.INFO, null);
			try {
			final String queryString = "select model from VepTipoAtributo model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}