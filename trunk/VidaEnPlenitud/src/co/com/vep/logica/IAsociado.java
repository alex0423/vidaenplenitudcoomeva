package co.com.vep.logica;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepBeneficiario;

public interface IAsociado {

	public AsociadoVida obtenerAsAsociado(Long identificacion,
			Integer tipoIdentificacion) throws Exception;

	public VepAsociado obtenerAsVep(Long identificacion,
			Integer tipoIdentificacion) throws Exception;

	public VepBeneficiario obtenerBeneficiario(Long tipoId, Long numDocumento)
			throws Exception;

}
