package co.com.vep.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VepSipParametro entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_SIP_PARAMETRO")
@NamedQuery(name = "vepsipparametro.tipo", query = "select c from VepSipParametro c join c.vepSipparametroTipo t where t.codTipo = :idTipo")
public class VepSipParametro implements java.io.Serializable {

	// Fields

	private Integer idTipoClasif;
	private VepSipparametroTipo vepSipparametroTipo;
	private String nombre;
	private String estadopar;
	private Set<VepTipoAtributo> vepTipoAtributos = new HashSet<VepTipoAtributo>(
			0);
	private Set<VepAtributoAsociado> vepAtributoAsociados = new HashSet<VepAtributoAsociado>(
			0);

	// Constructors

	/** default constructor */
	public VepSipParametro() {
	}

	/** minimal constructor */
	public VepSipParametro(Integer idTipoClasif, String nombre) {
		this.idTipoClasif = idTipoClasif;
		this.nombre = nombre;
	}

	/** full constructor */
	public VepSipParametro(Integer idTipoClasif,
			VepSipparametroTipo vepSipparametroTipo, String nombre,
			String estadopar, Set<VepTipoAtributo> vepTipoAtributos,
			Set<VepAtributoAsociado> vepAtributoAsociados) {
		this.idTipoClasif = idTipoClasif;
		this.vepSipparametroTipo = vepSipparametroTipo;
		this.nombre = nombre;
		this.estadopar = estadopar;
		this.vepTipoAtributos = vepTipoAtributos;
		this.vepAtributoAsociados = vepAtributoAsociados;
	}

	// Property accessors
	@Id
	@Column(name = "ID_TIPO_CLASIF", unique = true, nullable = false)
	public Integer getIdTipoClasif() {
		return this.idTipoClasif;
	}

	public void setIdTipoClasif(Integer idTipoClasif) {
		this.idTipoClasif = idTipoClasif;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO")
	public VepSipparametroTipo getVepSipparametroTipo() {
		return this.vepSipparametroTipo;
	}

	public void setVepSipparametroTipo(VepSipparametroTipo vepSipparametroTipo) {
		this.vepSipparametroTipo = vepSipparametroTipo;
	}

	@Column(name = "NOMBRE", nullable = false, length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ESTADOPAR", length = 30)
	public String getEstadopar() {
		return this.estadopar;
	}

	public void setEstadopar(String estadopar) {
		this.estadopar = estadopar;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vepSipParametro")
	public Set<VepTipoAtributo> getVepTipoAtributos() {
		return this.vepTipoAtributos;
	}

	public void setVepTipoAtributos(Set<VepTipoAtributo> vepTipoAtributos) {
		this.vepTipoAtributos = vepTipoAtributos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vepSipParametro")
	public Set<VepAtributoAsociado> getVepAtributoAsociados() {
		return this.vepAtributoAsociados;
	}

	public void setVepAtributoAsociados(
			Set<VepAtributoAsociado> vepAtributoAsociados) {
		this.vepAtributoAsociados = vepAtributoAsociados;
	}

}