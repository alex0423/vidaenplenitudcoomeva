package co.com.vep.modelo.extension;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepPlusBuc;

public class DataRecordAsistente extends AbstractDataRecord implements
		java.io.Serializable {

	private Long idAsociado;
	private String nombre;
	private String tipoDocumento;
	private Long documento;

	public DataRecordAsistente() {
	}

	public DataRecordAsistente(VepAsociado asociado) {
		this.idAsociado = asociado.getIdAsociado();
		this.tipoDocumento = asociado.getTipoDocumento();
		this.documento = asociado.getDocumento();
		this.selected = false;
	}

	public DataRecordAsistente(VepPlusBuc registroBuc) {
		this.nombre = (registroBuc.getNombre1Asociado() + " " + registroBuc
				.getNombre2Asociado()).trim()
				+ " "
				+ (registroBuc.getApellido1Asociado() + " " + registroBuc
						.getApellido2Asociado()).trim();
		this.documento = registroBuc.getDocumento();
		this.tipoDocumento = registroBuc.getTipodocumentoAsociado();
		this.idAsociado = registroBuc.getNumintAsociado();
		this.selected = false;
	}

	/**
	 * @return the idAsociado
	 */
	public Long getIdAsociado() {
		return idAsociado;
	}

	/**
	 * @param idAsociado
	 *            the idAsociado to set
	 */
	public void setIdAsociado(Long idAsociado) {
		this.idAsociado = idAsociado;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento
	 *            the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the documento
	 */
	public Long getDocumento() {
		return documento;
	}

	/**
	 * @param documento
	 *            the documento to set
	 */
	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
