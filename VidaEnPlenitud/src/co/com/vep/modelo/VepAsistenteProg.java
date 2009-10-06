package co.com.vep.modelo;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VepAsistenteProg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ASISTENTE_PROG", uniqueConstraints = {})
@NamedNativeQuery(name = "vepasistenteprog.insertAsistente", query = "insert into VEP.VEP_ASISTENTE_PROG (id_asociado, id_programacion, asistio, fecha) values (?, ?, ?, ?)", resultClass = VepAsistenteProg.class)
@NamedQueries( {
		@NamedQuery(name = "vepasistenteprog.findbydate", query = "select a from VepAsistenteProg a where a.fecha between :fechaInicio and :fechaFin"),
		@NamedQuery(name = "vepasistenteprog.findbyid", query = "select a from VepAsistenteProg a where a.consecutivo = :consecutivo") })
public class VepAsistenteProg implements java.io.Serializable {

	// Fields
	private Integer consecutivo;
	private VepProgramacion vepProgramacion;
	private VepAsociado vepAsociado;
	private String asistio;
	private Date fecha;

	// Constructors

	/** default constructor */
	public VepAsistenteProg() {
	}

	/** full constructor */
	public VepAsistenteProg(Integer consecutivo,
			VepProgramacion vepProgramacion, VepAsociado vepAsociado,
			String asistio, Date fecha) {
		this.consecutivo = consecutivo;
		this.vepProgramacion = vepProgramacion;
		this.vepAsociado = vepAsociado;
		this.asistio = asistio;
		this.fecha = fecha;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CONSECUTIVO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROGRAMACION", unique = true, nullable = true, insertable = false, updatable = false)
	public VepProgramacion getVepProgramacion() {
		return this.vepProgramacion;
	}

	public void setVepProgramacion(VepProgramacion vepProgramacion) {
		this.vepProgramacion = vepProgramacion;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ASOCIADO", unique = true, nullable = true, insertable = false, updatable = false)
	public VepAsociado getVepAsociado() {
		return this.vepAsociado;
	}

	public void setVepAsociado(VepAsociado vepAsociado) {
		this.vepAsociado = vepAsociado;
	}

	public String getAsistio() {
		return asistio;
	}

	public void setAsistio(String asistio) {
		this.asistio = asistio;
	}

	@Column(name = "FECHA", nullable = false, unique = true, insertable = true, updatable = true)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}