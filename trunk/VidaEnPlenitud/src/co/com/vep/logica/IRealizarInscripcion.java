package co.com.vep.logica;

import java.util.Date;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAsociado;

public interface IRealizarInscripcion {

	public void guardarAsociado(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2, Date fechaNace,
			String genero, Long codigoAsociado, String estadoAsociado,
			Date fechaEstado, Date fechaIngresoAsociado, Long corte,
			String direccionResidencia, String ciudad, String dirComercial,
			String ciudadComercial, String telefonoResidencia,
			String telefonoComercial, String telefonoCelular,
			String correoElectrinico, Long tituloProfesional, Long ocupacion,
			Long estadoCivil, Integer num_cuotas_vencidas, Long tipoidacu,
			Long cedulaAcudiente, String nombre1Acudiente,
			String nombre2Acudiente, String apellido1Acudiente,
			String apellido2Acudiente, String telefonoResidenciaAcudiente,
			String telefonoComercialAcudiente, String telefonoCelularAcudiente,
			String tipoSangre, Date fechaIngresovp, Long tipoAsociado,
			Integer[] seleccionPatologias, Integer[] seleccionServMedico,
			Integer[] seleccionServOfrecer, Integer[] seleccionConocimiento,
			Integer[] seleccionHobbies, Integer[] seleccionPAM,
			String otraPatologia, String otroServOfrecer,
			String otroConocimiento, String otroHobbie, String medicamentos,
			Long numHoras, String usuario) throws Exception;

	public String guardarBUC(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2,
			String telefonoResidencia, String telefonoComercial,
			String telefonoCelular) throws Exception;

	public String guardarBUC(Long tipoid, Long cedula, String nombre1,
			String nombre2, String apellido1, String apellido2, Date fechaNace,
			String genero, String direccionResidencia,
			String telefonoResidencia, Long tituloProfesional, Long ocupacion,
			Long estadoCivil, String usuario) throws Exception;

	public void actualizaTipoAsociado(long nitcli, long tipdoc, long asocia,
			String usruac) throws Exception;

	public void actualizaDatosUbicacion(AsociadoVida asociado) throws Exception;

	public void saveAcudiente(Long tipoDoc, Long cedula, String nombre,
			String nombre2, String apellido1, String apellido2,
			Long idAsociado, String telefonoResidencia,
			String telefonoComercial, String telefonoCelular, VepAsociado va) throws Exception;
}