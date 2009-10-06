package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VepUbicacionProfesorId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class VepUbicacionProfesorId implements java.io.Serializable {

	// Fields

	private Long tipoId;
	private Long idProfesor;
	private String tipoUbicacion;

	// Constructors

	/** default constructor */
	public VepUbicacionProfesorId() {
	}

	/** full constructor */
	public VepUbicacionProfesorId(Long tipoId, Long idProfesor,
			String tipoUbicacion) {
		this.tipoId = tipoId;
		this.idProfesor = idProfesor;
		this.tipoUbicacion = tipoUbicacion;
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
		if (!(other instanceof VepUbicacionProfesorId))
			return false;
		VepUbicacionProfesorId castOther = (VepUbicacionProfesorId) other;

		return ((this.getTipoId() == castOther.getTipoId()) || (this
				.getTipoId() != null
				&& castOther.getTipoId() != null && this.getTipoId().equals(
				castOther.getTipoId())))
				&& ((this.getIdProfesor() == castOther.getIdProfesor()) || (this
						.getIdProfesor() != null
						&& castOther.getIdProfesor() != null && this
						.getIdProfesor().equals(castOther.getIdProfesor())))
				&& ((this.getTipoUbicacion() == castOther.getTipoUbicacion()) || (this
						.getTipoUbicacion() != null
						&& castOther.getTipoUbicacion() != null && this
						.getTipoUbicacion()
						.equals(castOther.getTipoUbicacion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTipoId() == null ? 0 : this.getTipoId().hashCode());
		result = 37
				* result
				+ (getIdProfesor() == null ? 0 : this.getIdProfesor()
						.hashCode());
		result = 37
				* result
				+ (getTipoUbicacion() == null ? 0 : this.getTipoUbicacion()
						.hashCode());
		return result;
	}

}