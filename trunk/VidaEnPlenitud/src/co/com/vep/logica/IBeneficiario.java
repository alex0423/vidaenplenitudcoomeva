package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepBeneficiado;
import co.com.vep.modelo.VepBeneficiario;

public interface IBeneficiario extends IAsociado {

//	public void registrar(Integer idConsultoria, Integer idAsociado,
//			Integer idTipoIdentificacion) throws Exception;

	public VepBeneficiado obtener(Integer identificacion) throws Exception;

	public List<VepBeneficiado> obtenerByConsultoria(Integer idConsultoria)
			throws Exception;

	public List<VepBeneficiario> obtenerAsBucByConsultoria(Integer idConsultoria)
			throws Exception;
}
