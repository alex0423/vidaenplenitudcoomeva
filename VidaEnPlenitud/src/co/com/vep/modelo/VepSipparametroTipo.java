package co.com.vep.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VepSipparametroTipo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_SIPPARAMETRO_TIPO")
public class VepSipparametroTipo implements java.io.Serializable {

	// Fields

	private Integer codTipo;
	private String observacion;
	private String estado;
	private Set<VepSipParametro> vepSipParametros = new HashSet<VepSipParametro>(
			0);

	// Constructors

	/** default constructor */
	public VepSipparametroTipo() {
	}

	/** minimal constructor */
	public VepSipparametroTipo(Integer codTipo) {
		this.codTipo = codTipo;
	}

	/** full constructor */
	public VepSipparametroTipo(Integer codTipo, String observacion,
			String estado, Set<VepSipParametro> vepSipParametros) {
		this.codTipo = codTipo;
		this.observacion = observacion;
		this.estado = estado;
		this.vepSipParametros = vepSipParametros;
	}

	// Property accessors
	@Id
	@Column(name = "COD_TIPO", unique = true, nullable = false)
	public Integer getCodTipo() {
		return this.codTipo;
	}

	public void setCodTipo(Integer codTipo) {
		this.codTipo = codTipo;
	}

	@Column(name = "OBSERVACION", length = 200)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Column(name = "ESTADO", length = 60)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vepSipparametroTipo")
	public Set<VepSipParametro> getVepSipParametros() {
		return this.vepSipParametros;
	}

	public void setVepSipParametros(Set<VepSipParametro> vepSipParametros) {
		this.vepSipParametros = vepSipParametros;
	}

}