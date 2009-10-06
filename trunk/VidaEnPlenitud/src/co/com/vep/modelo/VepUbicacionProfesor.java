package co.com.vep.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VepUbicacionProfesor entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_UBICACION_PROFESOR", uniqueConstraints = {})
public class VepUbicacionProfesor implements java.io.Serializable {

	// Fields

	private VepUbicacionProfesorId id;
	private String descripcionUbicacion;
	private Long ciudad;

	// Constructors

	/** default constructor */
	public VepUbicacionProfesor() {
	}

	/** minimal constructor */
	public VepUbicacionProfesor(VepUbicacionProfesorId id,
			String descripcionUbicacion) {
		this.id = id;
		this.descripcionUbicacion = descripcionUbicacion;
	}

	/** full constructor */
	public VepUbicacionProfesor(VepUbicacionProfesorId id,
			String descripcionUbicacion, Long ciudad) {
		this.id = id;
		this.descripcionUbicacion = descripcionUbicacion;
		this.ciudad = ciudad;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "tipoId", column = @Column(name = "TIPO_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)),
			@AttributeOverride(name = "idProfesor", column = @Column(name = "ID_PROFESOR", unique = false, nullable = false, insertable = true, updatable = true, precision = 17, scale = 0)),
			@AttributeOverride(name = "tipoUbicacion", column = @Column(name = "TIPO_UBICACION", unique = false, nullable = false, insertable = true, updatable = true, length = 20)) })
	public VepUbicacionProfesorId getId() {
		return this.id;
	}

	public void setId(VepUbicacionProfesorId id) {
		this.id = id;
	}

	@Column(name = "DESCRIPCION_UBICACION", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getDescripcionUbicacion() {
		return this.descripcionUbicacion;
	}

	public void setDescripcionUbicacion(String descripcionUbicacion) {
		this.descripcionUbicacion = descripcionUbicacion;
	}

	@Column(name = "CIUDAD", unique = false, nullable = true, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Long ciudad) {
		this.ciudad = ciudad;
	}

}