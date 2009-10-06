package co.com.vep.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VepValoracion entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_VALORACION")
public class VepValoracion implements java.io.Serializable {

	// Fields

	private Long idValoracion;
	private VepAsociado vepAsociado;
	private Date fechaActual;
	private Double estatura;
	private Double peso;
	private String consumoFarmacos;
	private String descripcionFarmacos;
	private Long frecCardiacaMax;
	private String reforzarEn;
	private String planSeguimiento;
	private String imc;
	private Long perimetroCintura;
	private String cvEventosSig;
	private String cvCambiosSig;
	private String cvMarcadoresDes;
	private Integer presionSistolica;
	private Integer presionDiastolica;
	private String obsProyectoVida;

	// Constructors

	/** default constructor */
	public VepValoracion() {
	}

	/** minimal constructor */
	public VepValoracion(Long idValoracion, Date fechaActual) {
		this.idValoracion = idValoracion;
		this.fechaActual = fechaActual;
	}

	/** full constructor */
	public VepValoracion(Long idValoracion, VepAsociado vepAsociado,
			Date fechaActual, Double estatura, Double peso,
			String consumoFarmacos, String descripcionFarmacos,
			Long frecCardiacaMax, String reforzarEn, String planSeguimiento,
			String imc, Long perimetroCintura, String cvEventosSig,
			String cvCambiosSig, String cvMarcadoresDes,
			Integer presionSistolica, Integer presionDiastolica,
			String obsProyectoVida) {
		this.idValoracion = idValoracion;
		this.vepAsociado = vepAsociado;
		this.fechaActual = fechaActual;
		this.estatura = estatura;
		this.peso = peso;
		this.consumoFarmacos = consumoFarmacos;
		this.descripcionFarmacos = descripcionFarmacos;
		this.frecCardiacaMax = frecCardiacaMax;
		this.reforzarEn = reforzarEn;
		this.planSeguimiento = planSeguimiento;
		this.imc = imc;
		this.perimetroCintura = perimetroCintura;
		this.cvEventosSig = cvEventosSig;
		this.cvCambiosSig = cvCambiosSig;
		this.cvMarcadoresDes = cvMarcadoresDes;
		this.presionSistolica = presionSistolica;
		this.presionDiastolica = presionDiastolica;
		this.obsProyectoVida = obsProyectoVida;
	}

	// Property accessors
	@Id
	@Column(name = "ID_VALORACION", unique = true, nullable = false)
	public Long getIdValoracion() {
		return this.idValoracion;
	}

	public void setIdValoracion(Long idValoracion) {
		this.idValoracion = idValoracion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ASOCIADO")
	public VepAsociado getVepAsociado() {
		return this.vepAsociado;
	}

	public void setVepAsociado(VepAsociado vepAsociado) {
		this.vepAsociado = vepAsociado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ACTUAL", nullable = false, length = 10)
	public Date getFechaActual() {
		return this.fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	@Column(name = "ESTATURA", precision = 4)
	public Double getEstatura() {
		return this.estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	@Column(name = "PESO", precision = 4)
	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Column(name = "CONSUMO_FARMACOS", length = 1)
	public String getConsumoFarmacos() {
		return this.consumoFarmacos;
	}

	public void setConsumoFarmacos(String consumoFarmacos) {
		this.consumoFarmacos = consumoFarmacos;
	}

	@Column(name = "DESCRIPCION_FARMACOS", length = 1000)
	public String getDescripcionFarmacos() {
		return this.descripcionFarmacos;
	}

	public void setDescripcionFarmacos(String descripcionFarmacos) {
		this.descripcionFarmacos = descripcionFarmacos;
	}

	@Column(name = "FREC_CARDIACA_MAX", precision = 3, scale = 0)
	public Long getFrecCardiacaMax() {
		return this.frecCardiacaMax;
	}

	public void setFrecCardiacaMax(Long frecCardiacaMax) {
		this.frecCardiacaMax = frecCardiacaMax;
	}

	@Column(name = "REFORZAR_EN", length = 2000)
	public String getReforzarEn() {
		return this.reforzarEn;
	}

	public void setReforzarEn(String reforzarEn) {
		this.reforzarEn = reforzarEn;
	}

	@Column(name = "PLAN_SEGUIMIENTO", length = 2000)
	public String getPlanSeguimiento() {
		return this.planSeguimiento;
	}

	public void setPlanSeguimiento(String planSeguimiento) {
		this.planSeguimiento = planSeguimiento;
	}

	@Column(name = "IMC", length = 2000)
	public String getImc() {
		return this.imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	@Column(name = "PERIMETRO_CINTURA", precision = 5, scale = 0)
	public Long getPerimetroCintura() {
		return this.perimetroCintura;
	}

	public void setPerimetroCintura(Long perimetroCintura) {
		this.perimetroCintura = perimetroCintura;
	}

	@Column(name = "CV_EVENTOS_SIG", length = 2000)
	public String getCvEventosSig() {
		return this.cvEventosSig;
	}

	public void setCvEventosSig(String cvEventosSig) {
		this.cvEventosSig = cvEventosSig;
	}

	@Column(name = "CV_CAMBIOS_SIG", length = 2000)
	public String getCvCambiosSig() {
		return this.cvCambiosSig;
	}

	public void setCvCambiosSig(String cvCambiosSig) {
		this.cvCambiosSig = cvCambiosSig;
	}

	@Column(name = "CV_MARCADORES_DES", length = 2000)
	public String getCvMarcadoresDes() {
		return this.cvMarcadoresDes;
	}

	public void setCvMarcadoresDes(String cvMarcadoresDes) {
		this.cvMarcadoresDes = cvMarcadoresDes;
	}

	@Column(name = "PRESION_SISTOLICA")
	public Integer getPresionSistolica() {
		return this.presionSistolica;
	}

	public void setPresionSistolica(Integer presionSistolica) {
		this.presionSistolica = presionSistolica;
	}

	@Column(name = "PRESION_DIASTOLICA")
	public Integer getPresionDiastolica() {
		return this.presionDiastolica;
	}

	public void setPresionDiastolica(Integer presionDiastolica) {
		this.presionDiastolica = presionDiastolica;
	}

	@Column(name = "OBS_PROYECTO_VIDA", length = 2000)
	public String getObsProyectoVida() {
		return this.obsProyectoVida;
	}

	public void setObsProyectoVida(String obsProyectoVida) {
		this.obsProyectoVida = obsProyectoVida;
	}

}