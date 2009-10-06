package co.com.vep.modelo.extension;

import co.com.vep.modelo.VepBeneficiario;

public class DataRecordBeneficiario {

	private VepBeneficiario beneficiado;
	private String tipoDocumento;
	
	public VepBeneficiario getBeneficiado() {
		return beneficiado;
	}
	public void setBeneficiado(VepBeneficiario beneficiado) {
		this.beneficiado = beneficiado;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
