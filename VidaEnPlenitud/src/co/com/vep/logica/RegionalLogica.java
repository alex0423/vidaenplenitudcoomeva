/**
 * 
 */
package co.com.vep.logica;

import java.util.ArrayList;
import java.util.List;

import co.com.parametros.modelo.DelegadoWsParametros;
import co.com.parametros.modelo.DelegadoWsParametrosServiceLocator;
import co.com.parametros.modelo.Parametros;
import co.com.parametros.modelo.ParametrosWS;
import co.com.vep.modelo.VepRegional;
import co.com.vep.persistencia.EntityManagerHelper;
import co.com.vep.persistencia.IQueryVepRegionalDAO;
import co.com.vep.persistencia.QueryVepRegionalDAO;

/**
 * @author Juank
 * 
 */
public class RegionalLogica implements IRegional {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRegional#obtenerRegional(java.lang.Integer)
	 */
	public VepRegional obtenerRegional(Integer identificacion) throws Exception {
		VepRegional regional;
		try {
			regional = EntityManagerHelper.getEntityManager().find(
					VepRegional.class, identificacion);
			if (regional == null) {
				DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
				DelegadoWsParametros service = locator.getconsultarParametros();
				ParametrosWS rs = service
						.consultarParametrosXTipo(new Long(907));
				Parametros[] rsarray = rs.getArrayParametros();
				for (Parametros parametros : rsarray) {
					System.out.println("ID: " + parametros.getCodigoParam()
							+ " Nombre: " + parametros.getDescripcionParam());
					if (Long.valueOf(parametros.getCodigoParam()).equals(
							new Long(identificacion))) {

						try {
							EntityManagerHelper.getEntityManager()
									.getTransaction().begin();
							IQueryVepRegionalDAO iqvr = new QueryVepRegionalDAO();

							regional = new VepRegional();
							regional.setIdRegional(identificacion);
							iqvr.insert(regional);
							EntityManagerHelper.getEntityManager()
									.getTransaction().commit();
						} catch (Exception e) {
							EntityManagerHelper.getEntityManager()
									.getTransaction().rollback();
							throw e;
						}
						
						regional = EntityManagerHelper.getEntityManager().find(
								VepRegional.class, identificacion);
						return regional;
					}
				}
				if (regional == null)
					throw new Exception("Regional no existe como registro!");
			}
			return regional;
		} catch (Exception e) {

			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRegional#obtenerTodasAsParametro()
	 */
	public List<Parametros> obtenerTodasAsParametro() throws Exception {
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(907));
			Parametros[] rsarray = rs.getArrayParametros();
			List<Parametros> lstParametros = new ArrayList<Parametros>();
			for (Parametros parametros : rsarray) {
				lstParametros.add(parametros);
			}
			return lstParametros;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRegional#obtenerTodasAsVep()
	 */
	public List<VepRegional> obtenerTodasAsVep() throws Exception {
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(907));
			Parametros[] rsarray = rs.getArrayParametros();
			List<VepRegional> lstParametros = new ArrayList<VepRegional>();
			for (Parametros parametros : rsarray) {
				VepRegional aux = new VepRegional();
				aux.setIdRegional(Integer.parseInt(String.valueOf(parametros
						.getCodigoParam())));
				lstParametros.add(aux);
			}
			return lstParametros;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.logica.IRegional#validarRegional(java.lang.Integer)
	 */
	public boolean validarRegional(Integer identificacion) {
		try {
			if (obtenerRegional(identificacion) != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public Parametros obtenerRegionalAsParametro(Integer identificacion)
			throws Exception {
		try {
			DelegadoWsParametrosServiceLocator locator = new DelegadoWsParametrosServiceLocator();
			DelegadoWsParametros service = locator.getconsultarParametros();
			ParametrosWS rs = service.consultarParametrosXTipo(new Long(907));
			Parametros[] rsarray = rs.getArrayParametros();
			for (Parametros parametros : rsarray) {
				if (new Long(parametros.getCodigoParam()).equals(new Long(
						identificacion))) {
					return parametros;
				}
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}
}
