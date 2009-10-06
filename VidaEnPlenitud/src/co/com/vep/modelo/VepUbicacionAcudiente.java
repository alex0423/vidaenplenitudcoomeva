package co.com.vep.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VepUbicacionAcudiente entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_UBICACION_ACUDIENTE", uniqueConstraints = {})
public class VepUbicacionAcudiente implements java.io.Serializable {

	// Fields

	private VepUbicacionAcudienteId id;
	private String descripcionUbicacion;
	private Long ciudadUbicacion;

	// Constructors

	/** default constructor */
	public VepUbicacionAcudiente() {
	}

	/** minimal constructor */
	public VepUbicacionAcudiente(VepUbicacionAcudienteId id,
			String descripcionUbicacion) {
		this.id = id;
		this.descripcionUbicacion = descripcionUbicacion;
	}

	/** full constructor */
	public VepUbicacionAcudiente(VepUbicacionAcudienteId id,
			String descripcionUbicacion, Long ciudadUbicacion) {
		this.id = id;
		this.descripcionUbicacion = descripcionUbicacion;
		this.ciudadUbicacion = ciudadUbicacion;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "idAcudiente", column = @Column(name = "ID_ACUDIENTE", unique = false, nullable = false, insertable = true, updatable = true)),
			@AttributeOverride(name = "tipoUbicacion", column = @Column(name = "TIPO_UBICACION", unique = false, nullable = false, insertable = true, updatable = true, length = 20)) })
	public VepUbicacionAcudienteId getId() {
		return this.id;
	}

	public void setId(VepUbicacionAcudienteId id) {
		this.id = id;
	}

	@Column(name = "DESCRIPCION_UBICACION", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getDescripcionUbicacion() {
		return this.descripcionUbicacion;
	}

	public void setDescripcionUbicacion(String descripcionUbicacion) {
		this.descripcionUbicacion = descripcionUbicacion;
	}

	@Column(name = "CIUDAD_UBICACION", unique = false, nullable = true, insertable = true, updatable = true, precision = 10, scale = 0)
	public Long getCiudadUbicacion() {
		return this.ciudadUbicacion;
	}

	public void setCiudadUbicacion(Long ciudadUbicacion) {
		this.ciudadUbicacion = ciudadUbicacion;
	}

}