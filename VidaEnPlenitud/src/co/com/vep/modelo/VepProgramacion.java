package co.com.vep.modelo;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VepProgramacion entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_PROGRAMACION", uniqueConstraints = {})
@NamedNativeQuery(name = "callProceso1", query = "INSERT INTO VEP.VEP_PROGRAMACION VALUES(NEXTVAL FOR VEP.SECPROGRAMACION,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", resultClass = VepProgramacion.class)
@NamedQueries( {
		@NamedQuery(name = "vepprogramacion.findbyid", query = "select c from VepProgramacion c where c.idProgramacion = :id"),
		@NamedQuery(name = "vepprogramacion.findbyactividadgrupo", query = "select c from VepProgramacion c, VepParametroActividad p where c.idActividadPar = p.idActividadpar and p.idActividadpar = :idActividad and c.grupo = :grupo") })
public class VepProgramacion implements java.io.Serializable {

	// Fields

	private Integer idProgramacion;
	private Date fechaInicio;
	private Date fechaFin;
	private Timestamp horaIni;
	private Timestamp horaFin;
	private Long cupoMaximo;
	private Long cupoMinimo;
	private String nivel;
	private String estado;
	private Integer idLugar;
	private Integer idRegional;
	private Integer idActividadPar;
	private Long tipoId;
	private Long idProfesor;
	private String grupo;
	private Integer cupoAsistentes;

	// Constructors

	/** default constructor */
	public VepProgramacion() {
	}

	/** minimal constructor */
	public VepProgramacion(Integer idProgramacion, Date fechaInicio,
			Timestamp horaIni, Timestamp horaFin, String nivel, String estado) {
		this.idProgramacion = idProgramacion;
		this.fechaInicio = fechaInicio;
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		this.nivel = nivel;
		this.estado = estado;
	}

	/** full constructor */
	public VepProgramacion(Integer idProgramacion, Date fechaInicio,
			Date fechaFin, Timestamp horaIni, Timestamp horaFin, Long cupoMaximo,
			Long cupoMinimo, String nivel, String estado, Integer idLugar,
			Integer idRegional, Integer idActividadPar, Long tipoId,
			Long idProfesor, String grupo, Integer cupoAsistentes) {
		this.idProgramacion = idProgramacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		this.cupoMaximo = cupoMaximo;
		this.cupoMinimo = cupoMinimo;
		this.nivel = nivel;
		this.estado = estado;
		this.idLugar = idLugar;
		this.idRegional = idRegional;
		this.idActividadPar = idActividadPar;
		this.tipoId = tipoId;
		this.idProfesor = idProfesor;
		this.grupo = grupo;
		this.cupoAsistentes = cupoAsistentes;
	}

	// Property accessors
	@Id
	@Column(name = "ID_PROGRAMACION", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdProgramacion() {
		return this.idProgramacion;
	}

	public void setIdProgramacion(Integer idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HORA_INI", unique = false, nullable = false, insertable = true, updatable = true, length = 26)
	public Timestamp getHoraIni() {
		return this.horaIni;
	}

	public void setHoraIni(Timestamp horaIni) {
		this.horaIni = horaIni;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HORA_FIN", unique = false, nullable = false, insertable = true, updatable = true, length = 26)
	public Timestamp getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}

	@Column(name = "CUPO_MAXIMO", unique = false, nullable = true, insertable = true, updatable = true, precision = 5, scale = 0)
	public Long getCupoMaximo() {
		return this.cupoMaximo;
	}

	public void setCupoMaximo(Long cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	@Column(name = "CUPO_MINIMO", unique = false, nullable = true, insertable = true, updatable = true, precision = 5, scale = 0)
	public Long getCupoMinimo() {
		return this.cupoMinimo;
	}

	public void setCupoMinimo(Long cupoMinimo) {
		this.cupoMinimo = cupoMinimo;
	}

	@Column(name = "NIVEL", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Column(name = "ESTADO", unique = false, nullable = false, insertable = true, updatable = true, length = 30)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "ID_LUGAR", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdLugar() {
		return this.idLugar;
	}

	public void setIdLugar(Integer idLugar) {
		this.idLugar = idLugar;
	}

	@Column(name = "ID_REGIONAL", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdRegional() {
		return this.idRegional;
	}

	public void setIdRegional(Integer idRegional) {
		this.idRegional = idRegional;
	}

	@Column(name = "ID_ACTIVIDAD_PAR", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdActividadPar() {
		return this.idActividadPar;
	}

	public void setIdActividadPar(Integer idActividadPar) {
		this.idActividadPar = idActividadPar;
	}

	@Column(name = "TIPO_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 3, scale = 0)
	public Long getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	@Column(name = "ID_PROFESOR", unique = false, nullable = true, insertable = true, updatable = true, precision = 17, scale = 0)
	public Long getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	@Column(name = "GRUPO", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Column(name = "CUPO_ASISTENTES", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getCupoAsistentes() {
		return this.cupoAsistentes;
	}

	public void setCupoAsistentes(Integer cupoAsistentes) {
		this.cupoAsistentes = cupoAsistentes;
	}

}