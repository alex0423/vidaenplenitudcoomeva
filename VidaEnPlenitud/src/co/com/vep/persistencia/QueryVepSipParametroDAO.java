package co.com.vep.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipparametroTipo;

public class QueryVepSipParametroDAO implements IQueryVepSipParametroDAO {

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	} 

	@SuppressWarnings("unchecked")
	public List<VepSipParametro> findAllCodigo(Object codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
		try {
			final String queryString = "from VepSipParametro model where model.vepSipparametroTipo.codTipo="
					+ codigo;//+" order by ID_TIPO_CLASIF";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
		// return null;
	}
	 
	public Long searchSecuence() throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding Secuence", Level.INFO, null);
		try {
			final String queryString = "select max(model.codigo) from VepSipParametro model";
			Query query = getEntityManager().createQuery(queryString);
			return (Long) query.getSingleResult();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}




	@SuppressWarnings("deprecation")
	public void insertActividad(VepSipParametro entity) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("Registrando una Actividad", Level.INFO, null);
		//entity.setCodigo(searchSecuence()+1);
		// entity.setCodigo(searchSecuence()+1);
		// entity.setCodigo(searchSecuence()+1);
		// entity.setCodigo(searchSecuence()+1);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepSipparametroTipo> codigoParametrosTipo(Object codigo1,Object codigo2)
			throws Exception {
		
		
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
		try {
			final String queryString = "from VepSipparametroTipo model where COD_TIPO BETWEEN "
					+ codigo1 + " AND "+codigo2;
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> codigoParametrosAtriASO(Object codigo1,
			Object codigo2,Long idAsociado) throws Exception {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepAtributoAsociado instances",
				Level.INFO, null);
		try {
			/*final String queryString = "from VepAtributoAsociado model where model.vepSipParametro.VepAtributoAsociadoId.idAsociado="+idAsociado+
			" AND model.vepSipParametro.VepAtributoAsociadoId.idTipoClasif BETWEEN "
					+ codigo1 + " AND "+codigo2;
			*/
			
			final String queryString = "from VepAtributoAsociado model where ID_ASOCIADO="+idAsociado+
			" AND ID_TIPO_CLASIF BETWEEN "+ codigo1 + " AND "+codigo2;
	
			
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
 
	}

	public ArrayList<VepSipParametro> obtenerNombresServicioMedico(
			List<VepSipParametro> datos_sipParam,
			List<VepAtributoAsociado> datos_atriAso)throws Exception {
		    
		 	int indiceLista=0;
	        
		 	//ArrayList<VepSipParametro> valores=new ArrayList<VepSipParametro>();
		 	
		 	ArrayList<VepSipParametro> valores=(ArrayList<VepSipParametro>)findAllCodigo(new Integer(3));
		 	
		 	/*for(int i=0;i<datos_atriAso.size();i++)
		 	{  
		 		for(int j=0;j<datos_sipParam.size();j++)
		 		{
		 		     if(datos_atriAso.get(i).getId().getIdTipoClasif()==datos_sipParam.get(j).getIdTipoClasif())	
		 		     {
		 		       valores.add(indiceLista, datos_sipParam.get(j)) ;
		 		      indiceLista++;
		 		    	 
		 		     }
		 		}
		 		 
		 	}*/
		 	
		 

		// TODO Auto-generated method stub
		return valores;
	}

	@SuppressWarnings("unchecked")
	public List<VepSipParametro> sacarListadoServicioMedico(Long idAsociado) {

		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
		try {
			final String queryString = "from VepSipParametro model,VepAtributoAsociado model1 "+
			"where model.vepSipparametroTipo.codTipo=3 and model1.id.idAsociado="+idAsociado;
			
			Query query = getEntityManager().createQuery(queryString);
			List resultList = query.getResultList();
			return resultList;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
		
	 
	}

 
	

	
}
