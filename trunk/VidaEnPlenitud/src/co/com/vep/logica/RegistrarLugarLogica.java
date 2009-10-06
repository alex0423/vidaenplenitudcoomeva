package co.com.vep.logica;

import co.com.parametros.ws.cliente.ciudad.CiudadesWS;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametros;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosService;
import co.com.parametros.ws.cliente.ciudad.DelegadoWsParametrosServiceLocator;
import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepSitio;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.QueryVepLugarDAO;
import co.com.vep.persistencia.VepLugarDAO;
import co.com.vep.persistencia.VepSitioDAO;

public class RegistrarLugarLogica implements IRegistrarLugarLogica {

	public VepSitio buscarSitioPorCodigo(Integer codigo) throws Exception {
		// TODO Auto-generated method stub
		return new VepSitioDAO().findById(codigo);
	}

	public VepLugar buscarLugarPorCodigo(Integer codigo, Integer Lugar)
			throws Exception {
		// TODO Auto-generated method stub
		return new QueryVepLugarDAO().findByLugarSitio(codigo, Lugar);
	}

	public void registroLugarActividad(VepSitio sitio, VepLugar lugar)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();
			new VepSitioDAO().save(sitio);
			new VepLugarDAO().save(lugar);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			EntityManagerHelper.getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void registroLugarActividad(VepLugar lugar) throws Exception {
		// TODO Auto-generated method stub
		try {
			EntityManagerHelper.getEntityManager().getTransaction().begin();
			new VepLugarDAO().save(lugar);
			EntityManagerHelper.getEntityManager().flush();
			EntityManagerHelper.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			EntityManagerHelper.getEntityManager().getTransaction().rollback();			
		}
	}

	public VepLugar buscarLugarPorCodigo(Integer codigo) throws Exception {
		// TODO Auto-generated method stub
		return new VepLugarDAO().findById(codigo);
	}

	public String buscarCiudadxCodigo(String codigo) throws Exception {
		// TODO Auto-generated method stub
		long codigoCiudad = Long.parseLong(codigo);

		DelegadoWsParametrosService delLoc = new DelegadoWsParametrosServiceLocator();

		DelegadoWsParametros delegado = delLoc.getconsultarParametros();

		String ciudad = delegado.consultarCiudadxCodigo(codigoCiudad);

		return ciudad;
	}

}
