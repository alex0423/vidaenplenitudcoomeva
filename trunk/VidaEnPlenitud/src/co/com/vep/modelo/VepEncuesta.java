package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VepEncuesta entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ENCUESTA", uniqueConstraints = {})
public class VepEncuesta implements java.io.Serializable {

	// Fields

	private Integer idEncuesta;
	private VepDetalleConsultoria vepDetalleConsultoria;
	private String medioConocimiento;
	private String espMedioConocimiento;
	private String cumpEspectativas;
	private String aclaraCumplimientoEsp;
	private String cumplimientoProgEst;
	private String aclaracionCumpProgEst;
	private String atencion;
	private String sugerencias;
	private String nombreRef;
	private String apellidoRef;
	private String direccionRef;
	private Long telefonoRef;
	private String emailRef;
	private String actividadesInteres;

	// Constructors

	/** default constructor */
	public VepEncuesta() {
	}

	/** minimal constructor */
	public VepEncuesta(Integer idEncuesta, String medioConocimiento,
			String cumpEspectativas, String cumplimientoProgEst,
			String atencion, String nombreRef, String apellidoRef,
			String direccionRef, Long telefonoRef, String emailRef) {
		this.idEncuesta = idEncuesta;
		this.medioConocimiento = medioConocimiento;
		this.cumpEspectativas = cumpEspectativas;
		this.cumplimientoProgEst = cumplimientoProgEst;
		this.atencion = atencion;
		this.nombreRef = nombreRef;
		this.apellidoRef = apellidoRef;
		this.direccionRef = direccionRef;
		this.telefonoRef = telefonoRef;
		this.emailRef = emailRef;
	}

	/** full constructor */
	public VepEncuesta(Integer idEncuesta,
			VepDetalleConsultoria vepDetalleConsultoria,
			String medioConocimiento, String espMedioConocimiento,
			String cumpEspectativas, String aclaraCumplimientoEsp,
			String cumplimientoProgEst, String aclaracionCumpProgEst,
			String atencion, String sugerencias, String nombreRef,
			String apellidoRef, String direccionRef, Long telefonoRef,
			String emailRef, String actividadesInteres) {
		this.idEncuesta = idEncuesta;
		this.vepDetalleConsultoria = vepDetalleConsultoria;
		this.medioConocimiento = medioConocimiento;
		this.espMedioConocimiento = espMedioConocimiento;
		this.cumpEspectativas = cumpEspectativas;
		this.aclaraCumplimientoEsp = aclaraCumplimientoEsp;
		this.cumplimientoProgEst = cumplimientoProgEst;
		this.aclaracionCumpProgEst = aclaracionCumpProgEst;
		this.atencion = atencion;
		this.sugerencias = sugerencias;
		this.nombreRef = nombreRef;
		this.apellidoRef = apellidoRef;
		this.direccionRef = direccionRef;
		this.telefonoRef = telefonoRef;
		this.emailRef = emailRef;
		this.actividadesInteres = actividadesInteres;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ENCUESTA", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdEncuesta() {
		return this.idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
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

	@Column(name = "MEDIO_CONOCIMIENTO", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public String getMedioConocimiento() {
		return this.medioConocimiento;
	}

	public void setMedioConocimiento(String medioConocimiento) {
		this.medioConocimiento = medioConocimiento;
	}

	@Column(name = "ESP_MEDIO_CONOCIMIENTO", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getEspMedioConocimiento() {
		return this.espMedioConocimiento;
	}

	public void setEspMedioConocimiento(String espMedioConocimiento) {
		this.espMedioConocimiento = espMedioConocimiento;
	}

	@Column(name = "CUMP_ESPECTATIVAS", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	public String getCumpEspectativas() {
		return this.cumpEspectativas;
	}

	public void setCumpEspectativas(String cumpEspectativas) {
		this.cumpEspectativas = cumpEspectativas;
	}

	@Column(name = "ACLARA_CUMPLIMIENTO_ESP", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getAclaraCumplimientoEsp() {
		return this.aclaraCumplimientoEsp;
	}

	public void setAclaraCumplimientoEsp(String aclaraCumplimientoEsp) {
		this.aclaraCumplimientoEsp = aclaraCumplimientoEsp;
	}

	@Column(name = "CUMPLIMIENTO_PROG_EST", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	public String getCumplimientoProgEst() {
		return this.cumplimientoProgEst;
	}

	public void setCumplimientoProgEst(String cumplimientoProgEst) {
		this.cumplimientoProgEst = cumplimientoProgEst;
	}

	@Column(name = "ACLARACION_CUMP_PROG_EST", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getAclaracionCumpProgEst() {
		return this.aclaracionCumpProgEst;
	}

	public void setAclaracionCumpProgEst(String aclaracionCumpProgEst) {
		this.aclaracionCumpProgEst = aclaracionCumpProgEst;
	}

	@Column(name = "ATENCION", unique = false, nullable = false, insertable = true, updatable = true, length = 80)
	public String getAtencion() {
		return this.atencion;
	}

	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}

	@Column(name = "SUGERENCIAS", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getSugerencias() {
		return this.sugerencias;
	}

	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	@Column(name = "NOMBRE_REF", unique = false, nullable = false, insertable = true, updatable = true, length = 85)
	public String getNombreRef() {
		return this.nombreRef;
	}

	public void setNombreRef(String nombreRef) {
		this.nombreRef = nombreRef;
	}

	@Column(name = "APELLIDO_REF", unique = false, nullable = false, insertable = true, updatable = true, length = 85)
	public String getApellidoRef() {
		return this.apellidoRef;
	}

	public void setApellidoRef(String apellidoRef) {
		this.apellidoRef = apellidoRef;
	}

	@Column(name = "DIRECCION_REF", unique = false, nullable = false, insertable = true, updatable = true, length = 85)
	public String getDireccionRef() {
		return this.direccionRef;
	}

	public void setDireccionRef(String direccionRef) {
		this.direccionRef = direccionRef;
	}

	@Column(name = "TELEFONO_REF", unique = false, nullable = false, insertable = true, updatable = true, precision = 20, scale = 0)
	public Long getTelefonoRef() {
		return this.telefonoRef;
	}

	public void setTelefonoRef(Long telefonoRef) {
		this.telefonoRef = telefonoRef;
	}

	@Column(name = "EMAIL_REF", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public String getEmailRef() {
		return this.emailRef;
	}

	public void setEmailRef(String emailRef) {
		this.emailRef = emailRef;
	}

	@Column(name = "ACTIVIDADES_INTERES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getActividadesInteres() {
		return this.actividadesInteres;
	}

	public void setActividadesInteres(String actividadesInteres) {
		this.actividadesInteres = actividadesInteres;
	}

}