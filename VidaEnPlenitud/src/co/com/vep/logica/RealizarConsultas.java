package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;
import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.CiudadesWS;
import co.com.parametros.modelo.DelegadoWsParametros;
import co.com.parametros.modelo.DelegadoWsParametrosServiceLocator;
import co.com.parametros.modelo.Pais;
import co.com.parametros.modelo.PaisesWS;
import co.com.parametros.modelo.Parametros;
import co.com.parametros.modelo.ParametrosWS;
import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipparametroTipo;
import co.com.vep.modelo.VepUbicacionAcudiente;
import co.com.vep.persistencia.IQueryVepAcudienteDAO;
import co.com.vep.persistencia.QueryConsultarAsociadoVEPDAO;
import co.com.vep.persistencia.QueryVepAcudienteDAO;
import co.com.vep.persistencia.QueryVepSipParametroDAO;
import co.com.vep.persistencia.VepAsociadoDAO;
import co.com.vep.persistencia.VepValoracionDAO;

public class RealizarConsultas implements IRealizarConsultas {

	public Parametros[] mostrarParametrosBUCXTipo(long idpar) {

		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		Parametros[] datos = null;

		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			ParametrosWS param = delegado.consultarParametrosXTipo(idpar);
			datos = param.getParametros();

		} catch (Exception err) {
		}

		return datos;

	}

	public List<VepSipParametro> consultarParametrosVEP(Integer idpar)
			throws Exception {
		return new QueryVepSipParametroDAO().findAllCodigo(idpar);
	}

	public co.com.coomeva.wsasociado.vida.AsociadoVida consultarDatosAsociadoBUC(
			long identificacion, long tipoID) throws Exception {

		DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
		DelegadoAsociadoVidaWS delegado = delASoc.getdatosAsociadoVida();

		try {
			return delegado.consultarAsociadoVida(identificacion, tipoID);
		} catch (Exception err) {
			throw err;
		}
	}

	private long validarTipoDocumento(String tipoID) {

		int posslash = tipoID.indexOf("-");
		String tipo = tipoID.substring(0, posslash);
		return Long.parseLong(tipo);

	}

	public VepAsociado consultarASociadoInscritoVEP(long id_asociado) {
		// TODO Auto-generated method stub

		return new VepAsociadoDAO().findById(id_asociado);
	}

	public List<VepAsociado> consultarAsociadoVEPxTD_Doc(Long identificacion,
			String tipoID) {
		// TODO Auto-generated method stub

		return new QueryConsultarAsociadoVEPDAO().realizarConsultaxTD_Doc(
				identificacion, tipoID);
	}

	public ArrayList<VepSipParametro> serviciosMedicosAsociado(Long idAsociado)
			throws Exception {
		// TODO Auto-generated method stub

		ArrayList<VepSipParametro> listaSM = null;

		List<VepSipParametro> datos_sipParam = new QueryVepSipParametroDAO()
				.findAllCodigo(new Integer(3));
		List<VepAtributoAsociado> datos_atriAso = new QueryVepSipParametroDAO()
				.codigoParametrosAtriASO(new Integer(10), new Integer(13),
						idAsociado);

		try {

			// if(!datos_sipParam.isEmpty() && !datos_atriAso.isEmpty())
			listaSM = new QueryVepSipParametroDAO()
					.obtenerNombresServicioMedico(datos_sipParam, datos_atriAso);

		} catch (Exception err) {
			err.printStackTrace();
		}

		return listaSM;

	}

	public List<VepSipparametroTipo> consultarParametrosTipo(Integer idpar1,
			Integer idpar2) throws Exception {
		return new QueryVepSipParametroDAO().codigoParametrosTipo(idpar1,
				idpar2);

	}

	public Pais[] mostrarPaises() {
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		Pais[] lista = null;
		PaisesWS paisesWS = null;
		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			paisesWS = delegado.consultarTodosPaises();
			lista = paisesWS.getPais();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public Parametros[] mostrarDeptos(String codPais) {
		// TODO Auto-generated method stub

		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		Parametros[] lista = null;
		ParametrosWS parametrosWS = null;

		try {

			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			parametrosWS = delegado.consultaDepartamentosxPais(codPais);
			lista = parametrosWS.getParametros();

		} catch (Exception err) {
		}

		return lista;
	}

	public Ciudad[] mostrarCiudades(String codPais, Long codDepto) {
		// TODO Auto-generated method stub
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		CiudadesWS ciudadesWS = null;
		Ciudad[] lista = null;
		try {

			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			ciudadesWS = delegado.consultarCiudadxParametros(codPais, codDepto
					.longValue());
			lista = ciudadesWS.getCiudad();

		} catch (Exception err) {
		}

		return lista;
	}

	public String paisPorDefecto(String paisDef) {
		// TODO Auto-generated method stub

		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();

		PaisesWS paisesWS = null;
		String paisSel = null;

		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			paisesWS = delegado.consultarTodosPaises();
			for (int i = 0; i < paisesWS.getPais().length; i++) {
				Pais array_element = paisesWS.getPais()[i];
				if (array_element.getCodigoPais().trim().equals(paisDef)) {
					paisSel = array_element.getCodigoPais() + "-"
							+ array_element.getNombrePais();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return paisSel;

	}

	public Long consultarValoracion(String tipoID, Long cedula) {
		// TODO Auto-generated method stub

		Long idAsociado = new QueryConsultarAsociadoVEPDAO()
				.realizarConsultaxTD_Doc(cedula, tipoID).get(0).getIdAsociado();
		Long idValoracion = new VepValoracionDAO().findById(idAsociado)
				.getIdValoracion();

		return idValoracion;
	}

	private long validarTipoParametroBUC(String tipoID) {

		int posslash = tipoID.indexOf("-");
		String tipo = tipoID.substring(0, posslash);
		return Long.parseLong(tipo);

	}

	private boolean validarStrings(String cadena1, String cadena2) {
		boolean validar = false;

		cadena1 = cadena1.toUpperCase();
		cadena2 = cadena2.toUpperCase();
		if (!cadena2.equals("") && cadena1.startsWith(cadena2))
			validar = true;

		return validar;
	}

	public VepAcudiente consultarDatosAcudiente(Long tipoDocumento,
			Long documento) {
		// TODO Auto-generated method stub
		VepAcudiente va = new VepAcudiente();
		IQueryVepAcudienteDAO iqvad = new QueryVepAcudienteDAO();
		try {
			va = iqvad.findByTipoDocDocumento(tipoDocumento, documento);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return va;
	}

	public List<VepUbicacionAcudiente> consultarUbicacionAcudiente(
			Integer idAcudiente) {
		// TODO Auto-generated method stub
		List<VepUbicacionAcudiente> lista = new ArrayList<VepUbicacionAcudiente>();
		try {
			lista = new QueryVepAcudienteDAO()
					.findUbicacionAcudiente(idAcudiente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
