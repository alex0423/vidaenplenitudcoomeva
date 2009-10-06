package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.VepRegional;

public interface IDetalleConsultoria {

	public Integer registrarDetalleConsultoria() throws Exception;

	public List<VepDetalleConsultoria> obtenerTodosAsVep() throws Exception;

	public List<VepDetalleConsultoria> obtenerByConsultoria(VepConsultoria id)
			throws Exception;

	public List<VepDetalleConsultoria> obtenerByConsultor(Long id)
			throws Exception;

	public List<VepDetalleConsultoria> obtenerByConsultoria(Integer id)
			throws Exception;

	public List<VepDetalleConsultoria> obtenerByRegional(VepRegional id)
			throws Exception;

	public List<VepDetalleConsultoria> obtenerByRegional(Integer id)
			throws Exception;

	public void actualizarFechaInicioByConsultoria(Integer id, Date date)
			throws Exception;

	public void actualizarFechaTerminacionByConsultoria(Integer id, Date date)
			throws Exception;

}
