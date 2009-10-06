package co.com.vep.logica;

import java.util.List;

import co.com.vep.modelo.VepConsultor;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepPlusBuc;

public interface IConsultor extends IAsociado {

	public void registrar(Long identificacion, Integer tipoIdentificacion,
			Integer idDetalle) throws Exception;

	public VepConsultor obtener(Integer identificacion) throws Exception;

	public VepConsultor obtenerByDocumento(Long identificacion)
			throws Exception;

	public List<VepConsultor> obtenerByDetalle(VepDetalleConsultoria item)
			throws Exception;

	public List<VepPlusBuc> obtenerAsBucByDetalle(VepDetalleConsultoria item)
			throws Exception;
}
