package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VepAcudiente entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ACUDIENTE", uniqueConstraints = {})
public class VepAcudiente implements java.io.Serializable {

	// Fields

	private Integer idAcudiente;
	private Long tipoDocumento;
	private Long numeroDocumento;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private Long idAsociado;

	// Constructors

	/** default constructor */
	public VepAcudiente() {
	}

	/** minimal constructor */
	public VepAcudiente(Integer idAcudiente, String nombre1, String apellido1,
			Long idAsociado) {
		this.idAcudiente = idAcudiente;
		this.nombre1 = nombre1;
		this.apellido1 = apellido1;
		this.idAsociado = idAsociado;
	}

	/** full constructor */
	public VepAcudiente(Integer idAcudiente, Long tipoDocumento,
			Long numeroDocumento, String nombre1, String nombre2,
			String apellido1, String apellido2, Long idAsociado) {
		this.idAcudiente = idAcudiente;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.idAsociado = idAsociado;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID_ACUDIENTE", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(Integer idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	@Column(name = "TIPO_DOCUMENTO", unique = false, nullable = true, insertable = true, updatable = true, precision = 3, scale = 0)
	public Long getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "NUMERO_DOCUMENTO", unique = false, nullable = true, insertable = true, updatable = true, precision = 17, scale = 0)
	public Long getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	@Column(name = "NOMBRE1", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	@Column(name = "NOMBRE2", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	@Column(name = "APELLIDO1", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "APELLIDO2", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "ID_ASOCIADO", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdAsociado() {
		return this.idAsociado;
	}

	public void setIdAsociado(Long idAsociado) {
		this.idAsociado = idAsociado;
	}

}