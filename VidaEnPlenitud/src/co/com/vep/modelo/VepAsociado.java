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
 * VepAsociado entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ASOCIADO", uniqueConstraints = {})
@NamedQueries( {
		@NamedQuery(name = "vepasociado.getall", query = "select model from VepAsociado model "),
		@NamedQuery(name = "vepasociado.findbyasociado", query = "select model from VepAsociado model where model.tipoDocumento = :tipoId and model.documento = :documento "),
		@NamedQuery(name = "vepasociado.findbydocumento", query = "select model from VepAsociado model where model.documento = :documento "),
		@NamedQuery(name = "vepasociado.findbyconocimiento", query = "select c from VepAtributoAsociado a join a.vepAsociado c join a.vepSipParametro p where p.idTipoClasif = :idClasif "),
		@NamedQuery(name = "vepasociado.findbyfilters", query = "select c from VepAtributoAsociado a join a.vepAsociado c join a.vepSipParametro p where (:tipoAsociado is null or c.tipoAsociado = :tipoAsociado) and (:tipoDocumento is null or c.tipoDocumento = :tipoDocumento) and (:documento is null or c.documento = :documento) and (:tipoSangre is null or c.tipoSangre = :tipoSangre) and (:genero is null or c.genero = :genero) and (:estadoCivil is null or c.estcivil = :estadoCivil) and (:fechaNace is null or c.fechaNace = :fechaNace) and (:fechaIngreso is null or c.fechaIngresovp = :fechaIngreso) and (:ocupacion is null or c.ocupacion = :ocupacion) and (:atributos is null or p.idTipoClasif IN (:atributos))") })
public class VepAsociado implements java.io.Serializable {

	// Fields

	private Long idAsociado;
	private String tipoSangre;
	private String compartirConocimientos;
	private Date fechaIngresovp;
	private String validacionAspirante;
	private String tipoAsociado;
	private Long numeroHorasDispSv;
	private String estodoAsociado;
	private Long idAcudiente;
	private String medicamentos;
	private String tipoDocumento;
	private Long documento;
	private String tipoDocumentoAcu;
	private Long documentoAcudiente;
	private Date fechaNace;
	private String genero;
	private String ocupacion;
	private String estcivil;

	// Constructors

	/** default constructor */
	public VepAsociado() {
	}

	/** minimal constructor */
	public VepAsociado(Long idAsociado, String tipoSangre,
			String compartirConocimientos, String tipoAsociado,
			String estodoAsociado, String tipoDocumento, Long documento) {
		this.idAsociado = idAsociado;
		this.tipoSangre = tipoSangre;
		this.compartirConocimientos = compartirConocimientos;
		this.tipoAsociado = tipoAsociado;
		this.estodoAsociado = estodoAsociado;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
	}

	/** full constructor */
	public VepAsociado(Long idAsociado, String tipoSangre,
			String compartirConocimientos, Date fechaIngresovp,
			String validacionAspirante, String tipoAsociado,
			Long numeroHorasDispSv, String estodoAsociado, Long idAcudiente,
			String medicamentos, String tipoDocumento, Long documento,
			String tipoDocumentoAcu, Long documentoAcudiente, Date fechaNace,
			String genero, String ocupacion, String estcivil) {
		this.idAsociado = idAsociado;
		this.tipoSangre = tipoSangre;
		this.compartirConocimientos = compartirConocimientos;
		this.fechaIngresovp = fechaIngresovp;
		this.validacionAspirante = validacionAspirante;
		this.tipoAsociado = tipoAsociado;
		this.numeroHorasDispSv = numeroHorasDispSv;
		this.estodoAsociado = estodoAsociado;
		this.idAcudiente = idAcudiente;
		this.medicamentos = medicamentos;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.tipoDocumentoAcu = tipoDocumentoAcu;
		this.documentoAcudiente = documentoAcudiente;
		this.fechaNace = fechaNace;
		this.genero = genero;
		this.ocupacion = ocupacion;
		this.estcivil = estcivil;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ASOCIADO", unique = true, nullable = false, insertable = true, updatable = true)
	public Long getIdAsociado() {
		return this.idAsociado;
	}

	public void setIdAsociado(Long idAsociado) {
		this.idAsociado = idAsociado;
	}

	@Column(name = "TIPO_SANGRE", unique = false, nullable = false, insertable = true, updatable = true, length = 3)
	public String getTipoSangre() {
		return this.tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	@Column(name = "COMPARTIR_CONOCIMIENTOS", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
	public String getCompartirConocimientos() {
		return this.compartirConocimientos;
	}

	public void setCompartirConocimientos(String compartirConocimientos) {
		this.compartirConocimientos = compartirConocimientos;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INGRESOVP", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaIngresovp() {
		return this.fechaIngresovp;
	}

	public void setFechaIngresovp(Date fechaIngresovp) {
		this.fechaIngresovp = fechaIngresovp;
	}

	@Column(name = "VALIDACION_ASPIRANTE", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getValidacionAspirante() {
		return this.validacionAspirante;
	}

	public void setValidacionAspirante(String validacionAspirante) {
		this.validacionAspirante = validacionAspirante;
	}

	@Column(name = "TIPO_ASOCIADO", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getTipoAsociado() {
		return this.tipoAsociado;
	}

	public void setTipoAsociado(String tipoAsociado) {
		this.tipoAsociado = tipoAsociado;
	}

	@Column(name = "NUMERO_HORAS_DISP_SV", unique = false, nullable = true, insertable = true, updatable = true)
	public Long getNumeroHorasDispSv() {
		return this.numeroHorasDispSv;
	}

	public void setNumeroHorasDispSv(Long numeroHorasDispSv) {
		this.numeroHorasDispSv = numeroHorasDispSv;
	}

	@Column(name = "ESTODO_ASOCIADO", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getEstodoAsociado() {
		return this.estodoAsociado;
	}

	public void setEstodoAsociado(String estodoAsociado) {
		this.estodoAsociado = estodoAsociado;
	}

	@Column(name = "ID_ACUDIENTE", unique = false, nullable = true, insertable = true, updatable = true)
	public Long getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(Long idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	@Column(name = "MEDICAMENTOS", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Column(name = "TIPO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getDocumento() {
		return this.documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	@Column(name = "TIPO_DOCUMENTO_ACU", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getTipoDocumentoAcu() {
		return this.tipoDocumentoAcu;
	}

	public void setTipoDocumentoAcu(String tipoDocumentoAcu) {
		this.tipoDocumentoAcu = tipoDocumentoAcu;
	}

	@Column(name = "DOCUMENTO_ACUDIENTE", unique = false, nullable = true, insertable = true, updatable = true)
	public Long getDocumentoAcudiente() {
		return this.documentoAcudiente;
	}

	public void setDocumentoAcudiente(Long documentoAcudiente) {
		this.documentoAcudiente = documentoAcudiente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaNace() {
		return this.fechaNace;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
	}

	@Column(name = "GENERO", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "OCUPACION", unique = false, nullable = true, insertable = true, updatable = true, length = 60)
	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	@Column(name = "ESTCIVIL", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getEstcivil() {
		return this.estcivil;
	}

	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}

}