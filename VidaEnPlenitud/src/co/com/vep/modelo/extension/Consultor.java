package co.com.vep.modelo.extension;

import co.com.vep.modelo.VepConsultor;
import co.com.vep.modelo.VepPlusBuc;

public class Consultor {

	private String nombre;
	private String identificacion;
	private String idAsociado;

	public Consultor() {
		// TODO Auto-generated constructor stub
	}

	public Consultor(VepConsultor vepConsultor) {
		this.nombre = vepConsultor.getIdConsultor().toString();
		this.identificacion = vepConsultor.getVepAsociado().getDocumento()
				.toString();
		this.idAsociado = vepConsultor.getVepAsociado().getIdAsociado()
				.toString();
	}

	public Consultor(VepPlusBuc registroBuc) {
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
