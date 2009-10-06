package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepTipoAtributoId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepTipoAtributoId implements java.io.Serializable {

	// Fields

	private Integer idTipoClasif;
	private Long idValoracion;
	private String observaciones;

	// Constructors

	/** default constructor */
	public VepTipoAtributoId() {
	}

	/** full constructor */
	public VepTipoAtributoId(Integer idTipoClasif, Long idValoracion,
			String observaciones) {
		this.idTipoClasif = idTipoClasif;
		this.idValoracion = idValoracion;
		this.observaciones = observaciones;
	}

	// Property accessors

	@Column(name = "ID_TIPO_CLASIF", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdTipoClasif() {
		return this.idTipoClasif;
	}

	public void setIdTipoClasif(Integer idTipoClasif) {
		this.idTipoClasif = idTipoClasif;
	}

	@Column(name = "ID_VALORACION", unique = false, nullable = true, insertable = true, updatable = true)
	public Long getIdValoracion() {
		return this.idValoracion;
	}

	public void setIdValoracion(Long idValoracion) {
		this.idValoracion = idValoracion;
	}

	@Column(name = "OBSERVACIONES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VepTipoAtributoId))
			return false;
		VepTipoAtributoId castOther = (VepTipoAtributoId) other;

		return ((this.getIdTipoClasif() == castOther.getIdTipoClasif()) || (this
				.getIdTipoClasif() != null
				&& castOther.getIdTipoClasif() != null && this
				.getIdTipoClasif().equals(castOther.getIdTipoClasif())))
				&& ((this.getIdValoracion() == castOther.getIdValoracion()) || (this
						.getIdValoracion() != null
						&& castOther.getIdValoracion() != null && this
						.getIdValoracion().equals(castOther.getIdValoracion())))
				&& ((this.getObservaciones() == castOther.getObservaciones()) || (this
						.getObservaciones() != null
						&& castOther.getObservaciones() != null && this
						.getObservaciones()
						.equals(castOther.getObservaciones())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdTipoClasif() == null ? 0 : this.getIdTipoClasif()
						.hashCode());
		result = 37
				* result
				+ (getIdValoracion() == null ? 0 : this.getIdValoracion()
						.hashCode());
		result = 37
				* result
				+ (getObservaciones() == null ? 0 : this.getObservaciones()
						.hashCode());
		return result;
	}

}