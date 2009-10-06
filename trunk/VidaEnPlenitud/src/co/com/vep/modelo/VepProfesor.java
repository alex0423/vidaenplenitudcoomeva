package co.com.vep.modelo;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VepProfesor entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_PROFESOR", uniqueConstraints = {})
@NamedQueries( { @NamedQuery(name = "vepprofesor.findbyid", query = "select c from VepProfesor c where c.id.tipoId = :id and c.id.idProfesor = :numero") })
public class VepProfesor implements java.io.Serializable {

	// Fields

	private VepProfesorId id;
	private String titulo;
	private String especialidad;
	private String urlHoja;
	private String estadoProfesor;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private Date fechaNace;
	private String estcivil;
	private String genero;

	// Constructors

	/** default constructor */
	public VepProfesor() {
	}

	/** minimal constructor */
	public VepProfesor(VepProfesorId id, String titulo, String especialidad,
			String estadoProfesor, String nombre1, String apellido1) {
		this.id = id;
		this.titulo = titulo;
		this.especialidad = especialidad;
		this.estadoProfesor = estadoProfesor;
		this.nombre1 = nombre1;
		this.apellido1 = apellido1;
	}

	/** full constructor */
	public VepProfesor(VepProfesorId id, String titulo, String especialidad,
			String urlHoja, String estadoProfesor, String nombre1,
			String nombre2, String apellido1, String apellido2, Date fechaNace,
			String estcivil, String genero) {
		this.id = id;
		this.titulo = titulo;
		this.especialidad = especialidad;
		this.urlHoja = urlHoja;
		this.estadoProfesor = estadoProfesor;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNace = fechaNace;
		this.estcivil = estcivil;
		this.genero = genero;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "tipoId", column = @Column(name = "TIPO_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)),
			@AttributeOverride(name = "idProfesor", column = @Column(name = "ID_PROFESOR", unique = false, nullable = false, insertable = true, updatable = true, precision = 17, scale = 0)) })
	public VepProfesorId getId() {
		return this.id;
	}

	public void setId(VepProfesorId id) {
		this.id = id;
	}

	@Column(name = "TITULO", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "ESPECIALIDAD", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Column(name = "URL_HOJA", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getUrlHoja() {
		return this.urlHoja;
	}

	public void setUrlHoja(String urlHoja) {
		this.urlHoja = urlHoja;
	}

	@Column(name = "ESTADO_PROFESOR", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getEstadoProfesor() {
		return this.estadoProfesor;
	}

	public void setEstadoProfesor(String estadoProfesor) {
		this.estadoProfesor = estadoProfesor;
	}

	@Column(name = "NOMBRE1", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	@Column(name = "NOMBRE2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	@Column(name = "APELLIDO1", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "APELLIDO2", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACE", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaNace() {
		return this.fechaNace;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
	}

	@Column(name = "ESTCIVIL", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getEstcivil() {
		return this.estcivil;
	}

	public void setEstcivil(String estcivil) {
		this.estcivil = estcivil;
	}

	@Column(name = "GENERO", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}