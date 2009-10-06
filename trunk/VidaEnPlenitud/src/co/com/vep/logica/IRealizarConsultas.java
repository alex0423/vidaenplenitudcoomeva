/**
 * 
 */
package co.com.vep.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.Pais;
import co.com.parametros.modelo.Parametros;
import co.com.vep.modelo.VepAcudiente;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepSipParametro;
import co.com.vep.modelo.VepSipparametroTipo;
import co.com.vep.modelo.VepUbicacionAcudiente;

/**
 * @author tobias.mosquera
 * 
 */
public interface IRealizarConsultas {

	// public Parametros[] mostrarDescripcionTiposDocumento();
	public Parametros[] mostrarParametrosBUCXTipo(long idpar);

	public String paisPorDefecto(String paisDef);

	public Pais[] mostrarPaises();

	public Parametros[] mostrarDeptos(String codPais);

	public Ciudad[] mostrarCiudades(String codPais, Long codDepto);

	public List<VepSipParametro> consultarParametrosVEP(Integer idpar)
			throws Exception;

	public co.com.coomeva.wsasociado.vida.AsociadoVida consultarDatosAsociadoBUC(
			long identificacion, long tipoID) throws Exception;

	public VepAsociado consultarASociadoInscritoVEP(long id_asociado);

	public List<VepAsociado> consultarAsociadoVEPxTD_Doc(Long identificacion,
			String tipoID);

	public ArrayList<VepSipParametro> serviciosMedicosAsociado(Long idAsociado)
			throws Exception;

	public List<VepSipparametroTipo> consultarParametrosTipo(Integer idpar1,
			Integer idpar2) throws Exception;

	public Long consultarValoracion(String tipoID, Long cedula);

	public VepAcudiente consultarDatosAcudiente(Long tipoDocumento, Long documento);
	
	public List<VepUbicacionAcudiente> consultarUbicacionAcudiente(Integer idAcudiente);
}
