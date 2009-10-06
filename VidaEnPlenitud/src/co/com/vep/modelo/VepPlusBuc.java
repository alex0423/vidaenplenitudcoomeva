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
 * VepPlusBuc entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_PLUS_BUC", schema = "VEP")
@NamedQueries( {
		@NamedQuery(name = "vepplusbuc.findbydocumento", query = "select c from VepPlusBuc c where c.documento = :documento and c.tipodocumentoAsociado = :tipoId"),
		@NamedQuery(name = "vepplusbuc.findbyid", query = "select c from VepPlusBuc c where c.id = :id"),
		@NamedQuery(name = "vepplusbuc.findbyasociado", query = "select c from VepPlusBuc c where c.numintAsociado = :idAsociado") })
public class VepPlusBuc implements java.io.Serializable {

	// Fields
	private Long id;
	private Long numintAsociado;
	private Long documento;
	private String nombre1Asociado;
	private String nombre2Asociado;
	private String apellido1Asociado;
	private String apellido2Asociado;
	private Long idAsociado;
	private Long estadoAsociado;
	private Date fechaIngresovp;
	private String compartirConocimientos;
	private Long documentoAcudiente;
	private String nombre1Acudiente;
	private String nombre2Acudiente;
	private String apellido1Acudiente;
	private String apellido2Acudiente;
	private Long idAcudiente;
	private String estcivil;
	private Date fechaNace;
	private String genero;
	private String medicamentos;
	private Long numeroHorasDispSv;
	private String ocupacion;
	private String tipodocumentoAsociado;
	private String tipodocumentoAcudiente;
	private String tipoSangre;

	// Constructors

	/** default constructor */
	public VepPlusBuc() {
	}

	/** full constructor */
	public VepPlusBuc(Long id, Long numintAsociado, Long documento,
			String nombre1Asociado, String nombre2Asociado,
			String apellido1Asociado, String apellido2Asociado,
			Long idAsociado, Long estadoAsociado, Date fechaIngresovp,
			String compartirConocimientos, String nombre1Acudiente,
			String nombre2Acudiente, String apellido1Acudiente,
			String apellido2Acudiente, Long idAcudiente,
			String tipodocumentoAsociado, String tipoSangre) {
		this.id = id;
		this.numintAsociado = numintAsociado;
		this.documento = documento;
		this.nombre1Asociado = nombre1Asociado;
		this.nombre2Asociado = nombre2Asociado;
		this.apellido1Asociado = apellido1Asociado;
		this.apellido2Asociado = apellido2Asociado;
		this.idAsociado = idAsociado;
		this.estadoAsociado = estadoAsociado;
		this.fechaIngresovp = fechaIngresovp;
		this.compartirConocimientos = compartirConocimientos;
		this.nombre1Acudiente = nombre1Acudiente;
		this.nombre2Acudiente = nombre2Acudiente;
		this.apellido1Acudiente = apellido1Acudiente;
		this.apellido2Acudiente = apellido2Acudiente;
		this.idAcudiente = idAcudiente;
		this.tipodocumentoAsociado = tipodocumentoAsociado;
		this.tipoSangre = tipoSangre;
	}

	/** full constructor */
	public VepPlusBuc(Long id, Long numintAsociado, Long documento,
			String nombre1Asociado, String nombre2Asociado,
			String apellido1Asociado, String apellido2Asociado,
			Long idAsociado, Long estadoAsociado, Date fechaIngresovp,
			String compartirConocimientos, Long documentoAcudiente,
			String nombre1Acudiente, String nombre2Acudiente,
			String apellido1Acudiente, String apellido2Acudiente,
			Long idAcudiente, String estcivil, Date fechaNace, String genero,
			String medicamentos, Long numeroHorasDispSv, String ocupacion,
			String tipodocumentoAsociado, String tipodocumentoAcudiente,
			String tipoSangre) {
		this.id = id;
		this.numintAsociado = numintAsociado;
		this.documento = documento;
		this.nombre1Asociado = nombre1Asociado;
		this.nombre2Asociado = nombre2Asociado;
		this.apellido1Asociado = apellido1Asociado;
		this.apellido2Asociado = apellido2Asociado;
		this.idAsociado = idAsociado;
		this.estadoAsociado = estadoAsociado;
		this.compartirConocimientos = compartirConocimientos;
		this.documentoAcudiente = documentoAcudiente;
		this.nombre1Acudiente = nombre1Acudiente;
		this.nombre2Acudiente = nombre2Acudiente;
		this.apellido1Acudiente = apellido1Acudiente;
		this.apellido2Acudiente = apellido2Acudiente;
		this.idAcudiente = idAcudiente;
		this.estcivil = estcivil;
		this.fechaNace = fechaNace;
		this.genero = genero;
		this.medicamentos = medicamentos;
		this.numeroHorasDispSv = numeroHorasDispSv;
		this.ocupacion = ocupacion;
		this.tipodocumentoAsociado = tipodocumentoAsociado;
		this.tipodocumentoAcudiente = tipodocumentoAcudiente;
		this.tipoSangre = tipoSangre;
	}

	// Property accessors
	@Id
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NUMINT_ASOCIADO", nullable = false, precision = 17, scale = 0)
	public Long getNumintAsociado() {
		return this.numintAsociado;
	}

	public void setNumintAsociado(Long numintAsociado) {
		this.numintAsociado = numintAsociado;
	}

	@Column(name = "DOCUMENTO", nullable = false, precision = 17, scale = 0)
	public Long getDocumento() {
		return this.documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	@Column(name = "NOMBRE1_ASOCIADO", nullable = false, length = 60)
	public String getNombre1Asociado() {
		return this.nombre1Asociado;
	}

	public void setNombre1Asociado(String nombre1Asociado) {
		this.nombre1Asociado = nombre1Asociado;
	}

	@Column(name = "NOMBRE2_ASOCIADO", nullable = false, length = 60)
	public String getNombre2Asociado() {
		return this.nombre2Asociado;
	}

	public void setNombre2Asociado(String nombre2Asociado) {
		this.nombre2Asociado = nombre2Asociado;
	}

	@Column(name = "APELLIDO1_ASOCIADO", nullable = false, length = 60)
	public String getApellido1Asociado() {
		return this.apellido1Asociado;
	}

	public void setApellido1Asociado(String apellido1Asociado) {
		this.apellido1Asociado = apellido1Asociado;
	}

	@Column(name = "APELLIDO2_ASOCIADO", nullable = false, length = 60)
	public String getApellido2Asociado() {
		return this.apellido2Asociado;
	}

	public void setApellido2Asociado(String apellido2Asociado) {
		this.apellido2Asociado = apellido2Asociado;
	}

	@Column(name = "ID_ASOCIADO", nullable = false, precision = 1, scale = 0)
	public Long getIdAsociado() {
		return this.idAsociado;
	}

	public void setIdAsociado(Long idAsociado) {
		this.idAsociado = idAsociado;
	}

	@Column(name = "ESTADO_ASOCIADO", nullable = false, precision = 2, scale = 0)
	public Long getEstadoAsociado() {
		return this.estadoAsociado;
	}

	public void setEstadoAsociado(Long estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}

	@Column(name = "FECHA_INGRESOVP", nullable = false)
	public Date getFechaIngresovp() {
		return fechaIngresovp;
	}

	public void setFechaIngresovp(Date fechaIngresovp) {
		this.fechaIngresovp = fechaIngresovp;
	}

	@Column(name = "COMPARTIR_CONOCIMIENTOS", nullable = false, length = 1)
	public String getCompartirConocimientos() {
		return this.compartirConocimientos;
	}

	public void setCompartirConocimientos(String compartirConocimientos) {
		this.compartirConocimientos = compartirConocimientos;
	}

	@Column(name = "DOCUMENTO_ACUDIENTE")
	public Long getDocumentoAcudiente() {
		return this.documentoAcudiente;
	}

	public void setDocumentoAcudiente(Long documentoAcudiente) {
		this.documentoAcudiente = documentoAcudiente;
	}

	@Column(name = "NOMBRE1_ACUDIENTE", nullable = false, length = 60)
	public String getNombre1Acudiente() {
		return this.nombre1Acudiente;
	}

	public void setNombre1Acudiente(String nombre1Acudiente) {
		this.nombre1Acudiente = nombre1Acudiente;
	}

	@Column(name = "NOMBRE2_ACUDIENTE", nullable = false, length = 60)
	public String getNombre2Acudiente() {
		return this.nombre2Acudiente;
	}

	public void setNombre2Acudiente(String nombre2Acudiente) {
		this.nombre2Acudiente = nombre2Acudiente;
	}

	@Column(name = "APELLIDO1_ACUDIENTE", nullable = false, length = 60)
	public String getApellido1Acudiente() {
		return this.apellido1Acudiente;
	}

	public void setApellido1Acudiente(String apellido1Acudiente) {
		this.apellido1Acudiente = apellido1Acudiente;
	}

	@Column(name = "APELLIDO2_ACUDIENTE", nullable = false, length = 60)
	public String getApellido2Acudiente() {
		return this.apellido2Acudiente;
	}

	public void setApellido2Acudiente(String apellido2Acudiente) {
		this.apellido2Acudiente = apellido2Acudiente;
	}

	@Column(name = "ID_ACUDIENTE", nullable = false, precision = 1, scale = 0)
	public Long getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(Long idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	@Column(name = "ESTCIVIL", length = 50)
	public String getEstcivil() {
		return this.estcivil;
	}

	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACE", length = 10, nullable = true)
	public Date getFechaNace() {
		return this.fechaNace;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
	}

	@Column(name = "GENERO", length = 40)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "MEDICAMENTOS", length = 1000)
	public String getMedicamentos() {
		return this.medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	@Column(name = "NUMERO_HORAS_DISP_SV")
	public Long getNumeroHorasDispSv() {
		return this.numeroHorasDispSv;
	}

	public void setNumeroHorasDispSv(Long numeroHorasDispSv) {
		this.numeroHorasDispSv = numeroHorasDispSv;
	}

	@Column(name = "OCUPACION", length = 60)
	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	@Column(name = "TIPODOCUMENTO_ASOCIADO", nullable = false, length = 200)
	public String getTipodocumentoAsociado() {
		return this.tipodocumentoAsociado;
	}

	public void setTipodocumentoAsociado(String tipodocumentoAsociado) {
		this.tipodocumentoAsociado = tipodocumentoAsociado;
	}

	@Column(name = "TIPODOCUMENTO_ACUDIENTE", length = 200)
	public String getTipodocumentoAcudiente() {
		return this.tipodocumentoAcudiente;
	}

	public void setTipodocumentoAcudiente(String tipodocumentoAcudiente) {
		this.tipodocumentoAcudiente = tipodocumentoAcudiente;
	}

	@Column(name = "TIPO_SANGRE", nullable = false, length = 3)
	public String getTipoSangre() {
		return this.tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

}