package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VepProfesorPlusBuc entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "VEP_PROFESOR_PLUS_BUC")
//@NamedQueries( { @NamedQuery(name = "vepprofesorplusbuc.findbyasociado", query = "select c from VepProfesorPlusBuc c where c.documento = :idAsociado") })
public class VepProfesorPlusBuc implements java.io.Serializable {

	// Fields
	private Long id;
	private Long numintAsociado;
	private Long documento;
	private String nombre1Asociado;
	private String nombre2Asociado;
	private String apellido1Asociado;
	private String apellido2Asociado;
	private Long idAsociado;
	private String tituloprofesional;
	private String especialidad;
	private String urlHoja;
	private String estado;
	private Long ocupacion;

	// Constructors

	/** default constructor */
	public VepProfesorPlusBuc() {
	}

	/** full constructor */
	public VepProfesorPlusBuc(Long numintAsociado, Long documento,
			String nombre1Asociado, String nombre2Asociado,
			String apellido1Asociado, String apellido2Asociado,
			Long idAsociado, String tituloprofesional, String especialidad,
			String estado, Long ocupacion) {
		this.numintAsociado = numintAsociado;
		this.documento = documento;
		this.nombre1Asociado = nombre1Asociado;
		this.nombre2Asociado = nombre2Asociado;
		this.apellido1Asociado = apellido1Asociado;
		this.apellido2Asociado = apellido2Asociado;
		this.idAsociado = idAsociado;
		this.tituloprofesional = tituloprofesional;
		this.especialidad = especialidad;
		this.estado = estado;
		this.ocupacion = ocupacion;
	}

	/** full constructor */
	public VepProfesorPlusBuc(Long id, Long numintAsociado, Long documento,
			String nombre1Asociado, String nombre2Asociado,
			String apellido1Asociado, String apellido2Asociado,
			Long idAsociado, String tituloprofesional, String especialidad,
			String urlHoja, String estado, Long ocupacion) {
		this.id = id;
		this.numintAsociado = numintAsociado;
		this.documento = documento;
		this.nombre1Asociado = nombre1Asociado;
		this.nombre2Asociado = nombre2Asociado;
		this.apellido1Asociado = apellido1Asociado;
		this.apellido2Asociado = apellido2Asociado;
		this.idAsociado = idAsociado;
		this.tituloprofesional = tituloprofesional;
		this.especialidad = especialidad;
		this.urlHoja = urlHoja;
		this.estado = estado;
		this.ocupacion = ocupacion;
	}

	@Id
	@Column(name = "ID", precision = 15, scale = 0)
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

	@Column(name = "TITULOPROFESIONAL", nullable = false, length = 50)
	public String getTituloprofesional() {
		return this.tituloprofesional;
	}

	public void setTituloprofesional(String tituloprofesional) {
		this.tituloprofesional = tituloprofesional;
	}

	@Column(name = "ESPECIALIDAD", nullable = false, length = 50)
	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Column(name = "URL_HOJA", length = 2000)
	public String getUrlHoja() {
		return this.urlHoja;
	}

	public void setUrlHoja(String urlHoja) {
		this.urlHoja = urlHoja;
	}

	@Column(name = "ESTADO", nullable = false, length = 50)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "OCUPACION", nullable = false, precision = 4, scale = 0)
	public Long getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(Long ocupacion) {
		this.ocupacion = ocupacion;
	}

}