package co.com.vep.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VepDetalleConsultoria entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_DETALLE_CONSULTORIA", uniqueConstraints = {})
@NamedQueries( {
		@NamedQuery(name = "vepdetalleconsultoria.findAll", query = "select x from VepDetalleConsultoria x"),
		@NamedQuery(name = "vepdetalleconsultoria.findByConsultoria", query = "select x from VepDetalleConsultoria x, VepConsultoria c where x.idServicioCon = c.idServiciocon and c.idServiciocon = :id"),
		@NamedQuery(name = "vepdetalleconsultoria.findByConsultor", query = "select c from VepConsultor x join x.vepDetalleConsultoria c join x.vepAsociado a where a.idAsociado = :id and c.estado in ('168', '169')"),
		@NamedQuery(name = "vepdetalleconsultoria.findAllByConsultor", query = "select c from VepConsultor x join x.vepDetalleConsultoria c join x.vepAsociado a where a.idAsociado = :id"),
		@NamedQuery(name = "vepdetalleconsultoria.findByRegional", query = "select d from VepDetalleConsultoria d, VepRegional r where d.idRegional = r.idRegional and r.idRegional = :idRegional") })
public class VepDetalleConsultoria implements java.io.Serializable {

	// Fields

	private Integer idDetallecons;
	private Date fechaIni;
	private Date fechaseg;
	private Date fechaterm;
	private String observaciones;
	private String estado;
	private String objetivo;
	private Long numBeneficiados;
	private Integer idRegional;
	private Integer idServicioCon;

	// Constructors

	/** default constructor */
	public VepDetalleConsultoria() {
	}

	/** minimal constructor */
	public VepDetalleConsultoria(Integer idDetallecons, String estado) {
		this.idDetallecons = idDetallecons;
		this.estado = estado;
	}

	/** full constructor */
	public VepDetalleConsultoria(Integer idDetallecons, Date fechaIni,
			Date fechaseg, Date fechaterm, String observaciones, String estado,
			String objetivo, Long numBeneficiados, Integer idRegional,
			Integer idServicioCon) {
		this.idDetallecons = idDetallecons;
		this.fechaIni = fechaIni;
		this.fechaseg = fechaseg;
		this.fechaterm = fechaterm;
		this.observaciones = observaciones;
		this.estado = estado;
		this.objetivo = objetivo;
		this.numBeneficiados = numBeneficiados;
		this.idRegional = idRegional;
		this.idServicioCon = idServicioCon;
	}

	// Property accessors
	@Id
	@Column(name = "ID_DETALLECONS", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdDetallecons() {
		return this.idDetallecons;
	}

	public void setIdDetallecons(Integer idDetallecons) {
		this.idDetallecons = idDetallecons;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INI", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHASEG", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaseg() {
		return this.fechaseg;
	}

	public void setFechaseg(Date fechaseg) {
		this.fechaseg = fechaseg;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHATERM", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaterm() {
		return this.fechaterm;
	}

	public void setFechaterm(Date fechaterm) {
		this.fechaterm = fechaterm;
	}

	@Column(name = "OBSERVACIONES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "ESTADO", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "OBJETIVO", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@Column(name = "NUM_BENEFICIADOS", unique = false, nullable = true, insertable = true, updatable = true, precision = 15, scale = 0)
	public Long getNumBeneficiados() {
		return this.numBeneficiados;
	}

	public void setNumBeneficiados(Long numBeneficiados) {
		this.numBeneficiados = numBeneficiados;
	}

	@Column(name = "ID_REGIONAL", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdRegional() {
		return this.idRegional;
	}

	public void setIdRegional(Integer idRegional) {
		this.idRegional = idRegional;
	}

	@Column(name = "ID_SERVICIO_CON", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdServicioCon() {
		return this.idServicioCon;
	}

	public void setIdServicioCon(Integer idServicioCon) {
		this.idServicioCon = idServicioCon;
	}

}