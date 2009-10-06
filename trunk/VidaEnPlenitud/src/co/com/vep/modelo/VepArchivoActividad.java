package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VepArchivoActividad entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ARCHIVO_ACTIVIDAD", uniqueConstraints = {})
public class VepArchivoActividad implements java.io.Serializable {

	// Fields

	private Integer idArchivoActiv;
	private String urlArchivo;
	private Integer idProgramacion;
	private String estado;

	// Constructors

	/** default constructor */
	public VepArchivoActividad() {
	}

	/** minimal constructor */
	public VepArchivoActividad(Integer idArchivoActiv) {
		this.idArchivoActiv = idArchivoActiv;
	}

	/** full constructor */
	public VepArchivoActividad(Integer idArchivoActiv, String urlArchivo,
			Integer idProgramacion, String estado) {
		this.idArchivoActiv = idArchivoActiv;
		this.urlArchivo = urlArchivo;
		this.idProgramacion = idProgramacion;
		this.estado = estado;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ARCHIVO_ACTIV", unique = true, nullable = true, insertable = true, updatable = true)
	public Integer getIdArchivoActiv() {
		return this.idArchivoActiv;
	}

	public void setIdArchivoActiv(Integer idArchivoActiv) {
		this.idArchivoActiv = idArchivoActiv;
	}

	@Column(name = "URL_ARCHIVO", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getUrlArchivo() {
		return this.urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	@Column(name = "ID_PROGRAMACION", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdProgramacion() {
		return this.idProgramacion;
	}

	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	@Column(name = "ESTADO", unique = false, nullable = true, insertable = true, updatable = true, length = 30)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}