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
 * VepBitacoraEstado entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="VEP_BITACORA_ESTADO", uniqueConstraints = {  }
)
public class VepBitacoraEstado implements java.io.Serializable {

	// Fields

	private Integer idBitacora;
	private VepAsociado vepAsociado;
	private Date fechaRegistro;
	private String estadoAsociado;

	// Constructors

	/** default constructor */
	public VepBitacoraEstado() {
	}

	/** minimal constructor */
	public VepBitacoraEstado(Integer idBitacora, Date fechaRegistro,
			String estadoAsociado) {
		this.idBitacora = idBitacora;
		this.fechaRegistro = fechaRegistro;
		this.estadoAsociado = estadoAsociado;
	}

	/** full constructor */
	public VepBitacoraEstado(Integer idBitacora, VepAsociado vepAsociado,
			Date fechaRegistro, String estadoAsociado) {
		this.idBitacora = idBitacora;
		this.vepAsociado = vepAsociado;
		this.fechaRegistro = fechaRegistro;
		this.estadoAsociado = estadoAsociado;
	}

	// Property accessors
	@Id
	@Column(name = "ID_BITACORA", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ASOCIADO", unique = false, nullable = true, insertable = true, updatable = true)
	public VepAsociado getVepAsociado() {
		return this.vepAsociado;
	}

	public void setVepAsociado(VepAsociado vepAsociado) {
		this.vepAsociado = vepAsociado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Column(name = "ESTADO_ASOCIADO", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getEstadoAsociado() {
		return this.estadoAsociado;
	}

	public void setEstadoAsociado(String estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}

}