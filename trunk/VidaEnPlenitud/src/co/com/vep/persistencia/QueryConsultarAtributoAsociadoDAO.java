package co.com.vep.persistencia;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAtributoAsociado;

public class QueryConsultarAtributoAsociadoDAO implements
		IQueryConsultarAtributoAsociadoDAO {

	
	@SuppressWarnings("unused")
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> consultarAsociadoEnAtributo(
			List<Integer> codigos) {
		// TODO Auto-generated method stub

		EntityManagerHelper.log("finding all VepAtributoAsociado instances",
				Level.INFO, null);
		try {
			
			
			String param="";
			/*for(int i=0;i<codigos.size();i++)
			{
			   param=param+"model.vepSipParametro.idTipoClasif="+codigos.get(i)+" OR ";	
			}
			
			param=param.substring(0,param.length()-4);	
			*/
			
			//param="model.id.idTipoClasif=10";
			param="ID_TIPO_CLASIF=10";
			
			final String queryString = "select model from VepAtributoAsociado model WHERE "+param;
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> consultarASociadosParametrizados(
			Long codigo) {
		// TODO Auto-generated method stub
		
		EntityManagerHelper.log("finding all VepAtributoAsociado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAtributoAsociado model where ID_TIPO_CLASIF="+codigo;
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	
	}
	
 
}
