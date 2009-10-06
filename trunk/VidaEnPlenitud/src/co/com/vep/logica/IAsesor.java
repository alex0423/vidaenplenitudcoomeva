package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;

public interface IAsesor {

	public VepAsociado obtener(Long id) throws Exception;

	public List<VepAsociado> obtenerByConocimiento(Integer idParametro)
			throws Exception;

	public List<VepPlusBuc> obtenerAsBucByConocimiento(Integer idConocimiento)
			throws Exception;
}
