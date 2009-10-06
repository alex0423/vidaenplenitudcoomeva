package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VepConsultoria entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_CONSULTORIA", uniqueConstraints = {})
@NamedQueries( {
		@NamedQuery(name = "vepconsultoria.findAll", query = "select p from VepConsultoria p"),
		@NamedQuery(name = "vepconsultoria.findByRegional", query = "select c from VepDetalleConsultoria d, VepConsultoria c, VepRegional r where d.idServicioCon = c.idServiciocon and d.idRegional = r.idRegional and r.idRegional = :idRegional") })
public class VepConsultoria implements java.io.Serializable {

	// Fields

	private Integer idServiciocon;
	private String nombre;
	private String descripcion;
	private String estado;

	// Constructors

	/** default constructor */
	public VepConsultoria() {
	}

	/** minimal constructor */
	public VepConsultoria(Integer idServiciocon, String nombre, String estado) {
		this.idServiciocon = idServiciocon;
		this.nombre = nombre;
		this.estado = estado;
	}

	/** full constructor */
	public VepConsultoria(Integer idServiciocon, String nombre,
			String descripcion, String estado) {
		this.idServiciocon = idServiciocon;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	// Property accessors
	@Id
	@Column(name = "ID_SERVICIOCON", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdServiciocon() {
		return this.idServiciocon;
	}

	public void setIdServiciocon(Integer idServiciocon) {
		this.idServiciocon = idServiciocon;
	}

	@Column(name = "NOMBRE", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
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

	@Column(name = "ESTADO", unique = false, nullable = false, insertable = true, updatable = true, length = 60)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}