package co.com.vep.modelo.extension;

import co.com.vep.modelo.VepBeneficiado;
import co.com.vep.modelo.VepPlusBuc;

public class Beneficiario {

	private String nombre;
	private String identificacion;
	private String idAsociado;

	public Beneficiario() {
		// TODO Auto-generated constructor stub
	}

	public Beneficiario(VepBeneficiado vepBeneficiado) {
		this.nombre = vepBeneficiado.getIdBeneficiario().toString();
		this.identificacion = vepBeneficiado.getIdBeneficiario().toString();
		this.idAsociado = vepBeneficiado.getIdBeneficiario().toString();
	}

	public Beneficiario(VepPlusBuc registroBuc) {
		this.nombre = (registroBuc.getNombre1Asociado() + " " + registroBuc
				.getNombre2Asociado()).trim()
				+ " "
				+ (registroBuc.getApellido1Asociado() + " " + registroBuc
						.getApellido2Asociado()).trim();
		this.identificacion = registroBuc.getDocumento().toString();
		this.idAsociado = registroBuc.getNumintAsociado().toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(String idAsociado) {
		this.idAsociado = idAsociado;
	}

}
