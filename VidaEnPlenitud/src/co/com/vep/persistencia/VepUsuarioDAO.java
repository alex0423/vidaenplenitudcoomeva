package co.com.vep.persistencia;

import co.com.vep.modelo.VepUsuario;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for VepUsuario entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see co.com.vep.modelo.VepUsuario
  * @author MyEclipse Persistence Tools 
 */

public class VepUsuarioDAO  implements IVepUsuarioDAO{
	//property constants
	public static final String LOGIN_USUARIO = "loginUsuario";
	public static final String ESTADO = "estado";





	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}	
	
		/**
	 Perform an initial save of a previously unsaved VepUsuario entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   VepUsuarioDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity VepUsuario entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(VepUsuario entity) {
    				EntityManagerHelper.log("saving VepUsuario instance", Level.INFO, null);
	        try {
            getEntityManager().persist(entity);
            			EntityManagerHelper.log("save successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("save failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Delete a persistent VepUsuario entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   VepUsuarioDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity VepUsuario entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(VepUsuario entity) {
    				EntityManagerHelper.log("deleting VepUsuario instance", Level.INFO, null);
	        try {
        	entity = getEntityManager().getReference(VepUsuario.class, entity.getCodUsuario());
            getEntityManager().remove(entity);
            			EntityManagerHelper.log("delete successful", Level.INFO, null);
	        } catch (RuntimeException re) {
        				EntityManagerHelper.log("delete failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    /**
	 Persist a previously saved VepUsuario entity and return it or a copy of it to the sender. 
	 A copy of the VepUsuario entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = VepUsuarioDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity VepUsuario entity to update
	 @returns VepUsuario the persisted VepUsuario entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
    public VepUsuario update(VepUsuario entity) {
    				EntityManagerHelper.log("updating VepUsuario instance", Level.INFO, null);
	        try {
            VepUsuario result = getEntityManager().merge(entity);
            			EntityManagerHelper.log("update successful", Level.INFO, null);
	            return result;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("update failed", Level.SEVERE, re);
	            throw re;
        }
    }
    
    public VepUsuario findById( Integer id) {
    				EntityManagerHelper.log("finding VepUsuario instance with id: " + id, Level.INFO, null);
	        try {
            VepUsuario instance = getEntityManager().find(VepUsuario.class, id);
            return instance;
        } catch (RuntimeException re) {
        				EntityManagerHelper.log("find failed", Level.SEVERE, re);
	            throw re;
        }
    }    
    

/**
	 * Find all VepUsuario entities with a specific property value.  
	 
	  @param propertyName the name of the VepUsuario property to query
	  @param value the property value to match
	  	  @return List<VepUsuario> found by query
	 */
    @SuppressWarnings("unchecked")
    public List<VepUsuario> findByProperty(String propertyName, final Object value
        ) {
    				EntityManagerHelper.log("finding VepUsuario instance with property: " + propertyName + ", value: " + value, Level.INFO, null);
			try {
			final String queryString = "select model from VepUsuario model where model." 
			 						+ propertyName + "= :propertyValue";
								Query query = getEntityManager().createQuery(queryString);
					query.setParameter("propertyValue", value);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
				throw re;
		}
	}			
	public List<VepUsuario> findByLoginUsuario(Object loginUsuario
	) {
		return findByProperty(LOGIN_USUARIO, loginUsuario
		);
	}
	
	public List<VepUsuario> findByEstado(Object estado
	) {
		return findByProperty(ESTADO, estado
		);
	}
	
	
	/**
	 * Find all VepUsuario entities.
	  	  @return List<VepUsuario> all VepUsuario entities
	 */
	@SuppressWarnings("unchecked")
	public List<VepUsuario> findAll(
		) {
					EntityManagerHelper.log("finding all VepUsuario instances", Level.INFO, null);
			try {
			final String queryString = "select model from VepUsuario model";
								Query query = getEntityManager().createQuery(queryString);
					return query.getResultList();
		} catch (RuntimeException re) {
						EntityManagerHelper.log("find all failed", Level.SEVERE, re);
				throw re;
		}
	}
	
}