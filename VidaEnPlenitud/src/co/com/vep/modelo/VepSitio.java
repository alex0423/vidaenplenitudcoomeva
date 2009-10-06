package co.com.vep.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VepSitio entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_SITIO", uniqueConstraints = {})
public class VepSitio implements java.io.Serializable {

	// Fields

	private Integer idSitio;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;
	private String descripcion;
	private Set<VepLugar> vepLugars = new HashSet<VepLugar>(0);

	// Constructors

	/** default constructor */
	public VepSitio() {
	}

	/** minimal constructor */
	public VepSitio(Integer idSitio, String nombre, String direccion,
			String telefono, String ciudad) {
		this.idSitio = idSitio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	/** full constructor */
	public VepSitio(Integer idSitio, String nombre, String direccion,
			String telefono, String ciudad, String descripcion,
			Set<VepLugar> vepLugars) {
		this.idSitio = idSitio;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.vepLugars = vepLugars;
	}

	// Property accessors
	@Id
	@Column(name = "ID_SITIO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdSitio() {
		return this.idSitio;
	}

	public void setIdSitio(Integer idSitio) {
		this.idSitio = idSitio;
	}

	@Column(name = "NOMBRE", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DIRECCION", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "TELEFONO", unique = false, nullable = false, insertable = true, updatable = true, length = 16)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "CIUDAD", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "DESCRIPCION", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "vepSitio")
	public Set<VepLugar> getVepLugars() {
		return this.vepLugars;
	}

	public void setVepLugars(Set<VepLugar> vepLugars) {
		this.vepLugars = vepLugars;
	}

}