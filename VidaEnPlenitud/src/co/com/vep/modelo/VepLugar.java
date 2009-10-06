package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VepLugar entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_LUGAR", uniqueConstraints = {})
public class VepLugar implements java.io.Serializable {

	// Fields

	private Integer idLugar;
	private VepSitio vepSitio;
	private String nombre;
	private String descripcion;
	private Long cupoMaximo;
	private Long cupoMinimo;

	// Constructors

	/** default constructor */
	public VepLugar() {
	}

	/** minimal constructor */
	public VepLugar(Integer idLugar, String nombre) {
		this.idLugar = idLugar;
		this.nombre = nombre;
	}

	/** full constructor */
	public VepLugar(Integer idLugar, VepSitio vepSitio, String nombre,
			String descripcion, Long cupoMaximo, Long cupoMinimo) {
		this.idLugar = idLugar;
		this.vepSitio = vepSitio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cupoMaximo = cupoMaximo;
		this.cupoMinimo = cupoMinimo;
	}

	// Property accessors
	@Id
	@Column(name = "ID_LUGAR", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdLugar() {
		return this.idLugar;
	}

	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SITIO", unique = false, nullable = true, insertable = true, updatable = true)
	public VepSitio getVepSitio() {
		return this.vepSitio;
	}

	public void setVepSitio(VepSitio vepSitio) {
		this.vepSitio = vepSitio;
	}

	@Column(name = "NOMBRE", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "CUPO_MAXIMO", unique = false, nullable = true, insertable = true, updatable = true, precision = 5, scale = 0)
	public Long getCupoMaximo() {
		return this.cupoMaximo;
	}

	public void setCupoMaximo(Long cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	@Column(name = "CUPO_MINIMO", unique = false, nullable = true, insertable = true, updatable = true, precision = 5, scale = 0)
	public Long getCupoMinimo() {
		return this.cupoMinimo;
	}

	public void setCupoMinimo(Long cupoMinimo) {
		this.cupoMinimo = cupoMinimo;
	}

}