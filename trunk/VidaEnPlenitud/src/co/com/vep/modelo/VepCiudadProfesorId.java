package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepCiudadProfesorId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepCiudadProfesorId implements java.io.Serializable {

	// Fields

	private Integer idProfesor;
	private Integer idCiudad;

	// Constructors

	/** default constructor */
	public VepCiudadProfesorId() {
	}

	/** full constructor */
	public VepCiudadProfesorId(Integer idProfesor, Integer idCiudad) {
		this.idProfesor = idProfesor;
		this.idCiudad = idCiudad;
	}

	// Property accessors

	@Column(name = "ID_PROFESOR", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	@Column(name = "ID_CIUDAD", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VepCiudadProfesorId))
			return false;
		VepCiudadProfesorId castOther = (VepCiudadProfesorId) other;

		return ((this.getIdProfesor() == castOther.getIdProfesor()) || (this
				.getIdProfesor() != null
				&& castOther.getIdProfesor() != null && this.getIdProfesor()
				.equals(castOther.getIdProfesor())))
				&& ((this.getIdCiudad() == castOther.getIdCiudad()) || (this
						.getIdCiudad() != null
						&& castOther.getIdCiudad() != null && this
						.getIdCiudad().equals(castOther.getIdCiudad())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdProfesor() == null ? 0 : this.getIdProfesor()
						.hashCode());
		result = 37 * result
				+ (getIdCiudad() == null ? 0 : this.getIdCiudad().hashCode());
		return result;
	}

}