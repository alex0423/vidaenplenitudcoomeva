package co.com.vep.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VepCiudadProfesor entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_CIUDAD_PROFESOR", uniqueConstraints = {})
public class VepCiudadProfesor implements java.io.Serializable {

	// Fields

	private VepCiudadProfesorId id;
	private VepProfesor vepProfesor;

	// Constructors

	/** default constructor */
	public VepCiudadProfesor() {
	}

	/** minimal constructor */
	public VepCiudadProfesor(VepCiudadProfesorId id) {
		this.id = id;
	}

	/** full constructor */
	public VepCiudadProfesor(VepCiudadProfesorId id, VepProfesor vepProfesor) {
		this.id = id;
		this.vepProfesor = vepProfesor;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "idProfesor", column = @Column(name = "ID_PROFESOR", unique = false, nullable = true, insertable = true, updatable = true)),
			@AttributeOverride(name = "idCiudad", column = @Column(name = "ID_CIUDAD", unique = false, nullable = true, insertable = true, updatable = true)) })
	public VepCiudadProfesorId getId() {
		return this.id;
	}

	public void setId(VepCiudadProfesorId id) {
		this.id = id;
	}

//	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
//	@JoinColumn(name = "ID_PROFESOR", unique = false, nullable = true, insertable = false, updatable = false)
//	public VepProfesor getVepProfesor() {
//		return this.vepProfesor;
//	}
//
//	public void setVepProfesor(VepProfesor vepProfesor) {
//		this.vepProfesor = vepProfesor;
//	}

}