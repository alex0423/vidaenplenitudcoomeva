package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VepParametroActividad entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_PARAMETRO_ACTIVIDAD", uniqueConstraints = {})
public class VepParametroActividad implements java.io.Serializable {

	// Fields

	private Integer idActividadpar;
	private String nombre;
	private String estadopar;

	// Constructors

	/** default constructor */
	public VepParametroActividad() {
	}

	/** minimal constructor */
	public VepParametroActividad(Integer idActividadpar, String nombre) {
		this.idActividadpar = idActividadpar;
		this.nombre = nombre;
	}

	/** full constructor */
	public VepParametroActividad(Integer idActividadpar, String nombre,
			String estadopar) {
		this.idActividadpar = idActividadpar;
		this.nombre = nombre;
		this.estadopar = estadopar;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ACTIVIDADPAR", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdActividadpar() {
		return this.idActividadpar;
	}

	public void setIdActividadpar(Integer idActividadpar) {
		this.idActividadpar = idActividadpar;
	}

	@Column(name = "NOMBRE", unique = false, nullable = false, insertable = true, updatable = true, length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ESTADOPAR", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public String getEstadopar() {
		return this.estadopar;
	}

	public void setEstadopar(String estadopar) {
		this.estadopar = estadopar;
	}

}