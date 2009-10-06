package co.com.vep.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VepBitacoraConsultoria entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_BITACORA_CONSULTORIA", uniqueConstraints = {})
@NamedQuery(name = "vepbitacoraconsultoria.findbyconsultoria", query = "select x from VepBitacoraConsultoria x, VepDetalleConsultoria d, VepConsultoria c where x.idDetalleCons = d.idDetallecons and d.idServicioCon = c.idServiciocon and c.idServiciocon = :idConsultoria")
public class VepBitacoraConsultoria implements java.io.Serializable {

	// Fields

	private Integer idBitacoraCons;
	private Date fecha;
	private String observacion;
	private String archivoUrl;
	private Integer idDetalleCons;

	// Constructors

	/** default constructor */
	public VepBitacoraConsultoria() {
	}

	/** minimal constructor */
	public VepBitacoraConsultoria(Integer idBitacoraCons, Date fecha) {
		this.idBitacoraCons = idBitacoraCons;
		this.fecha = fecha;
	}

	/** full constructor */
	public VepBitacoraConsultoria(Integer idBitacoraCons, Date fecha,
			String observacion, String archivoUrl, Integer idDetalleCons) {
		this.idBitacoraCons = idBitacoraCons;
		this.fecha = fecha;
		this.observacion = observacion;
		this.archivoUrl = archivoUrl;
		this.idDetalleCons = idDetalleCons;
	}

	// Property accessors
	@Id
	@Column(name = "ID_BITACORA_CONS", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdBitacoraCons() {
		return this.idBitacoraCons;
	}

	public void setIdBitacoraCons(Integer idBitacoraCons) {
		this.idBitacoraCons = idBitacoraCons;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "OBSERVACION", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "ARCHIVO_URL", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getArchivoUrl() {
		return this.archivoUrl;
	}

	public void setArchivoUrl(String archivoUrl) {
		this.archivoUrl = archivoUrl;
	}

	@Column(name = "ID_DETALLE_CONS", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdDetalleCons() {
		return this.idDetalleCons;
	}

	public void setIdDetalleCons(Integer idDetalleCons) {
		this.idDetalleCons = idDetalleCons;
	}

}