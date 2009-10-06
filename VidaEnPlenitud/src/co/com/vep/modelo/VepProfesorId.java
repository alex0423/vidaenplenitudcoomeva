package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepProfesorId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepProfesorId implements java.io.Serializable {

	// Fields

	private Long tipoId;
	private Long idProfesor;

	// Constructors

	/** default constructor */
	public VepProfesorId() {
	}

	/** full constructor */
	public VepProfesorId(Long tipoId, Long idProfesor) {
		this.tipoId = tipoId;
		this.idProfesor = idProfesor;
	}

	// Property accessors

	@Column(name = "TIPO_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)
	public Long getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	@Column(name = "ID_PROFESOR", unique = false, nullable = false, insertable = true, updatable = true, precision = 17, scale = 0)
	public Long getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VepProfesorId))
			return false;
		VepProfesorId castOther = (VepProfesorId) other;

		return ((this.getTipoId() == castOther.getTipoId()) || (this
				.getTipoId() != null
				&& castOther.getTipoId() != null && this.getTipoId().equals(
				castOther.getTipoId())))
				&& ((this.getIdProfesor() == castOther.getIdProfesor()) || (this
						.getIdProfesor() != null
						&& castOther.getIdProfesor() != null && this
						.getIdProfesor().equals(castOther.getIdProfesor())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTipoId() == null ? 0 : this.getTipoId().hashCode());
		result = 37
				* result
				+ (getIdProfesor() == null ? 0 : this.getIdProfesor()
						.hashCode());
		return result;
	}

}