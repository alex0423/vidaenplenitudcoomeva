/**
 * 
 */
package co.com.vep.persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;

/**
 * @author tobias.mosquera
 *
 */

//Esta clase contiene las busquedas detalladas de registrados en VEP
public class QueryConsultarAsociadoVEPDAO implements IQueryConsultarAsociadoVEPDAO  {

	/* (non-Javadoc)
	 * @see co.com.vep.persistencia.IVepAsociadoDAO#delete(co.com.vep.modelo.VepAsociado)
	 */
	
	
	@SuppressWarnings("unused")
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	

	@SuppressWarnings("unchecked")
	public List<VepAsociado> realizarConsultaxTD_Doc(Long identificacion,
			String tipoID) {
		EntityManagerHelper.log("finding all VepAsociado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAsociado model where TIPO_DOCUMENTO='"+tipoID+"' and DOCUMENTO="+identificacion;                
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<VepAtributoAsociado> hallarServiciosMedicosAsociado(Long idAsociado) {
		EntityManagerHelper.log("finding all VepAtributoAsociado instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VepAtributoAsociado model where ID_ASOCIADO="+idAsociado+" and ID_TIPO_CLASIF BETWEEN 10 AND 13";
			//final String queryString = "select model from VepAtributoAsociado model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
    

	@SuppressWarnings("unchecked")
	/*public List<VepSipParametro> nombresServiciosMedicos(
			List<VepAtributoAsociado> info)throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
	    
	    try {
									
			//final String queryString = "select model from VepSipParametro model where "+parametroConsulta;
			final String queryString = "select model from VepSipParametro model where COD_TIPO=3";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	
		 
	}*/
	
	public List<VepSipParametro> nombresServiciosMedicos(
			List<VepAtributoAsociado> info)throws Exception {
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepSipParametro instances",
				Level.INFO, null);
		
		//VepAtributoAsociado val1=info.get(0);
		
		
	    try {
									
			 final String queryString = "select model from VepSipParametro model where COD_TIPO=3";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed:", Level.SEVERE, re);
			throw re;
		}
	
		 
	}

	private String conversionFechas(Date fecha)
	{  
		
		try{
			Calendar cal = new GregorianCalendar(); 
			cal.setTimeInMillis(fecha.getTime()); 
			cal.add(Calendar.DATE, 1); 
			fecha=new Date(cal.getTimeInMillis());
		 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
			String fechaString = dateFormat.format(fecha);
			return "='"+fechaString+"'";
			
		}catch(Exception err)
		{
		   return "IS NULL";	
		}
		
		
	}


	@SuppressWarnings("unchecked")
	public List<VepAsociado> consultarAsociadoVEP_Datos(Date fechaIngVEP,
			Date fechaNace, String genero, String ocupacion, String tipoSangre,
			String estCivil, Integer edad) {
		
		// TODO Auto-generated method stub
		EntityManagerHelper.log("finding all VepAsociado instances",
				Level.INFO, null);
		
		String fecha1=this.conversionFechas(fechaIngVEP);
		String fecha2=this.conversionFechas(fechaNace);
		
		//Aqui el signo "=" ya esta incluido igual 	que las comillas sencillas
		try {
	           
			   String queryString="";
			   
			   if(fechaIngVEP!=null)
			   {
				   queryString = "select model from VepAsociado model where FECHA_INGRESOVP "+fecha1;
			   }
			   if(fechaIngVEP!=null && fechaNace!=null)
			   {
				   queryString = "select model from VepAsociado model where FECHA_INGRESOVP "+fecha1+" AND FECHA_NACE "+fecha2; 
			   }
			   if(fechaIngVEP!=null && tipoSangre!="--Seleccionar--")
			   {
				   queryString = "select model from VepAsociado model where FECHA_INGRESOVP "+fecha1+" AND TIPO_SANGRE='"+tipoSangre+"'";      
			   }
			   
			   
				
			   Query query = getEntityManager().createQuery(queryString);
				
				return query.getResultList();
	           
	        
		
		
		
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
 
	}


 
 
 
	
	
 

}
