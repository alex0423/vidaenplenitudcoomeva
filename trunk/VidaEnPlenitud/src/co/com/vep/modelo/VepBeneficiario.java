package co.com.vep.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VepBeneficiario entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_BENEFICIARIO", uniqueConstraints = {})
public class VepBeneficiario implements java.io.Serializable {

	// Fields

	private VepBeneficiarioId id;
	private String nombre;
	private String apellido1;
	private String apellido2;

	// Constructors

	/** default constructor */
	public VepBeneficiario() {
	}

	/** minimal constructor */
	public VepBeneficiario(VepBeneficiarioId id, String nombre, String apellido1) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	/** full constructor */
	public VepBeneficiario(VepBeneficiarioId id, String nombre,
			String apellido1, String apellido2) {
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "tipoDocumento", column = @Column(name = "TIPO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)),
			@AttributeOverride(name = "numeroDocumento", column = @Column(name = "NUMERO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, precision = 17, scale = 0)) })
	public VepBeneficiarioId getId() {
		return this.id;
	}

	public void setId(VepBeneficiarioId id) {
		this.id = id;
	}

	@Column(name = "NOMBRE", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDO1", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "APELLIDO2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

}