package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VepArchivoGestion entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ARCHIVO_GESTION", uniqueConstraints = {})
public class VepArchivoGestion implements java.io.Serializable {

	// Fields

	private Integer idArchivo;
	private VepParametroActividad vepParametroActividad;
	private VepDetalleConsultoria vepDetalleConsultoria;
	private String urlArchivo;

	// Constructors

	/** default constructor */
	public VepArchivoGestion() {
	}

	/** minimal constructor */
	public VepArchivoGestion(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	/** full constructor */
	public VepArchivoGestion(Integer idArchivo,
			VepParametroActividad vepParametroActividad,
			VepDetalleConsultoria vepDetalleConsultoria, String urlArchivo) {
		this.idArchivo = idArchivo;
		this.vepParametroActividad = vepParametroActividad;
		this.vepDetalleConsultoria = vepDetalleConsultoria;
		this.urlArchivo = urlArchivo;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ARCHIVO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ACTIVIDAD_PAR", unique = false, nullable = true, insertable = true, updatable = true)
	public VepParametroActividad getVepParametroActividad() {
		return this.vepParametroActividad;
	}

	public void setVepParametroActividad(
			VepParametroActividad vepParametroActividad) {
		this.vepParametroActividad = vepParametroActividad;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DETALLE_CONS", unique = false, nullable = true, insertable = true, updatable = true)
	public VepDetalleConsultoria getVepDetalleConsultoria() {
		return this.vepDetalleConsultoria;
	}

	public void setVepDetalleConsultoria(
			VepDetalleConsultoria vepDetalleConsultoria) {
		this.vepDetalleConsultoria = vepDetalleConsultoria;
	}

	@Column(name = "URL_ARCHIVO", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getUrlArchivo() {
		return this.urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

}