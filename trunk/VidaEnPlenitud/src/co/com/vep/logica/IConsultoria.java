package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.vep.modelo.VepBitacoraConsultoria;
import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.modelo.extension.ItemConsultoria;

public interface IConsultoria {

	public abstract void registrar(String nombre, String descripcion,
			Long numBeneficiados, String objetivo, String observaciones,
			Long idConsultor, Integer tipoIdentificacion, Long idRegional)
			throws Exception;

	public abstract VepConsultoria obtenerConsultoria(Integer id)
			throws Exception;

	public abstract List<ItemConsultoria> obtenerTodasAsItem() throws Exception;

	public abstract List<VepConsultoria> obtenerTodasAsVep() throws Exception;

	public abstract List<VepDetalleConsultoria> obtenerDetalle(VepConsultoria id)
			throws Exception;

	public abstract List<VepDetalleConsultoria> obtenerDetalle(Integer id)
			throws Exception;

	public abstract List<ItemConsultoria> obtenerByRegionalAsItem(
			Integer idRegional) throws Exception;

	public abstract List<VepConsultoria> obtenerByRegionalAsVep(
			Integer idRegional) throws Exception;

	public abstract void cambiarEstadoConsultoria(Integer id, String Estado)
			throws Exception;

	public abstract boolean validarEstadoAsActivo(Integer id);

	public abstract Long registrarBitacora(Integer idConsultoria,
			String observacion, String urlArchivo) throws Exception;

	public abstract void guardarSeguimiento(Integer id, String observacion,
			String urlArchivo) throws Exception;

	public abstract void iniciarConsultoria(Integer id, Date fechaInicio,
			String observacion, String urlArchivo) throws Exception;

	public abstract void anularConsultoria(Integer id, String observacion,
			String urlArchivo) throws Exception;

	public abstract void finalizarConsultoria(Integer id) throws Exception;

	public abstract void registrar(String nombre, String descripcion,
			Long numBeneficiados, Long idConsultor, Integer tipoIdentificacion,
			Long idBeneficiado, Long idRegional) throws Exception;

	public abstract void registrar(String nombre, String descripcion,
			Long numBeneficiados, List<Long> idConsultor,
			Integer tipoIdentificacion, Long idBeneficiado, Long idRegional,
			String objetivo, String observaciones) throws Exception;

	public abstract void registrar(String nombre, String descripcion,
			Long numBeneficiados, List<Long> idConsultor,
			Integer tipoIdentificacion, Long idBeneficiado,
			String nombreBeneficiario, String apellido1, String apellido2,
			Long idRegional, String objetivo, String observaciones)
			throws Exception;

	public abstract List<VepBitacoraConsultoria> obtenerBitacora(
			Integer idConsultoria) throws Exception;

	public abstract void incluirArchivo(Long idBitacora, String fileAnexo)
			throws Exception;

	public abstract List<VepDetalleConsultoria> filterAsVep(
			String axIdServicio, String axAsesor, String axCiudad,
			String axEstado, Date sFechaInicio, Date sFechaFin, Long idRegional)
			throws Exception;

}