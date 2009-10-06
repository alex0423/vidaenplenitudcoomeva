package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepUbicacionAcudienteId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepUbicacionAcudienteId implements java.io.Serializable {

	// Fields

	private Integer idAcudiente;
	private String tipoUbicacion;

	// Constructors

	/** default constructor */
	public VepUbicacionAcudienteId() {
	}

	/** full constructor */
	public VepUbicacionAcudienteId(Integer idAcudiente, String tipoUbicacion) {
		this.idAcudiente = idAcudiente;
		this.tipoUbicacion = tipoUbicacion;
	}

	// Property accessors

	@Column(name = "ID_ACUDIENTE", unique = false, nullable = false, insertable = true, updatable = true)
	public Integer getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(Integer idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	@Column(name = "TIPO_UBICACION", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getTipoUbicacion() {
		return this.tipoUbicacion;
	}

	public void setTipoUbicacion(String tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VepUbicacionAcudienteId))
			return false;
		VepUbicacionAcudienteId castOther = (VepUbicacionAcudienteId) other;

		return ((this.getIdAcudiente() == castOther.getIdAcudiente()) || (this
				.getIdAcudiente() != null
				&& castOther.getIdAcudiente() != null && this.getIdAcudiente()
				.equals(castOther.getIdAcudiente())))
				&& ((this.getTipoUbicacion() == castOther.getTipoUbicacion()) || (this
						.getTipoUbicacion() != null
						&& castOther.getTipoUbicacion() != null && this
						.getTipoUbicacion()
						.equals(castOther.getTipoUbicacion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdAcudiente() == null ? 0 : this.getIdAcudiente()
						.hashCode());
		result = 37
				* result
				+ (getTipoUbicacion() == null ? 0 : this.getTipoUbicacion()
						.hashCode());
		return result;
	}

}