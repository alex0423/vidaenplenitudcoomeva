package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.persistencia.VepSipParametroDAO;

public class CreacionActividadesLogica implements ICreacionActividadesLogica {

	public VepParametroActividad findParametroActividad(Integer codigoParametro) throws Exception {
		// TODO Auto-generated method stub
		return new VepParametroActividadDAO().findById(codigoParametro);
	}

	public void registrarActividad(Integer codigo, String actividad, String estado) throws Exception {
		// TODO Auto-generated method stub
		VepParametroActividad parametro = new VepParametroActividad();
		
		parametro.setIdActividadpar(codigo);
		parametro.setNombre(actividad);
		parametro.setEstadopar(estado);

		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();
			new VepParametroActividadDAO().save(parametro);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	public List<VepParametroActividad> findByNombre(Object nombre) throws Exception {
		// TODO Auto-generated method stub
		return new VepParametroActividadDAO().findByNombre(nombre);
	}

	public List<VepSipParametro> listaEstados(String propiedad, Object value)
			throws Exception {
		// TODO Auto-generated method stub
		return new VepSipParametroDAO().findByProperty(propiedad, value);
	}
}
