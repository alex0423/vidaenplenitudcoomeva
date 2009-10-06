package co.com.vep.logica;

import java.util.Date;
import java.util.List;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepUbicacionProfesor;

public interface IRegistrarProfesorLogica {

	public AsociadoVida consultarAsociado(Long tipoDocumento,
			Long identificacion) throws Exception;

	public void registrarProfesor(Long tipoid, String identificacion,
			String nombre1, String nombre2, String apellido1, String apellido2,
			Date fechaNace, Long genero, String direccionResidencia,
			Long ciuRes, String telefonoResidencia, Long tituloProfesional,
			Long ocupacion, Long estadoCivil, String url, Integer estado,
			String usuario, String direccionComercial, Long ciudadCom,
			String telefonoComercial, String celular, String mail)
			throws Exception;

	public VepProfesor obtener(Long tipoId, Long idProfesor) throws Exception;

	public String buscarCiudadxCodigo(String codigo) throws Exception;

	public List<VepUbicacionProfesor> obtenerUbicacioProfesor(Long tipoId,
			Long idProfesor) throws Exception;
}
