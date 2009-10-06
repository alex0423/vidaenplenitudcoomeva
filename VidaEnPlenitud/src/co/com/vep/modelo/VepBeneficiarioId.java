package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepBeneficiarioId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepBeneficiarioId implements java.io.Serializable {

	// Fields

	private Long tipoDocumento;
	private Long numeroDocumento;

	// Constructors

	/** default constructor */
	public VepBeneficiarioId() {
	}

	/** full constructor */
	public VepBeneficiarioId(Long tipoDocumento, Long numeroDocumento) {
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	// Property accessors

	@Column(name = "TIPO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)
	public Long getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "NUMERO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, precision = 17, scale = 0)
	public Long getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VepBeneficiarioId))
			return false;
		VepBeneficiarioId castOther = (VepBeneficiarioId) other;

		return ((this.getTipoDocumento() == castOther.getTipoDocumento()) || (this
				.getTipoDocumento() != null
				&& castOther.getTipoDocumento() != null && this
				.getTipoDocumento().equals(castOther.getTipoDocumento())))
				&& ((this.getNumeroDocumento() == castOther
						.getNumeroDocumento()) || (this.getNumeroDocumento() != null
						&& castOther.getNumeroDocumento() != null && this
						.getNumeroDocumento().equals(
								castOther.getNumeroDocumento())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTipoDocumento() == null ? 0 : this.getTipoDocumento()
						.hashCode());
		result = 37
				* result
				+ (getNumeroDocumento() == null ? 0 : this.getNumeroDocumento()
						.hashCode());
		return result;
	}

}