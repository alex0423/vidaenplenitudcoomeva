package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VepConsultor entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_CONSULTOR", uniqueConstraints = {})
@NamedQueries( {
		@NamedQuery(name = "vepconsultor.findbydocumento", query = "select c from VepConsultor c join c.vepAsociado a where a.documento = :documento"),
		@NamedQuery(name = "vepconsultor.findbydetalle", query = "select c from VepConsultor c join c.vepDetalleConsultoria d where d.idDetallecons = :idDetalle") })
public class VepConsultor implements java.io.Serializable {

	// Fields

	private Integer idConsultor;
	private VepAsociado vepAsociado;
	private VepDetalleConsultoria vepDetalleConsultoria;

	// Constructors

	/** default constructor */
	public VepConsultor() {
	}

	/** minimal constructor */
	public VepConsultor(Integer idConsultor) {
		this.idConsultor = idConsultor;
	}

	/** full constructor */
	public VepConsultor(Integer idConsultor, VepAsociado vepAsociado,
			VepDetalleConsultoria vepDetalleConsultoria) {
		this.idConsultor = idConsultor;
		this.vepAsociado = vepAsociado;
		this.vepDetalleConsultoria = vepDetalleConsultoria;
	}

	// Property accessors
	@Id
	@Column(name = "ID_CONSULTOR", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdConsultor() {
		return this.idConsultor;
	}

	public void setIdConsultor(Integer idConsultor) {
		this.idConsultor = idConsultor;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ASOCIADO", unique = false, nullable = true, insertable = true, updatable = true)
	public VepAsociado getVepAsociado() {
		return this.vepAsociado;
	}

	public void setVepAsociado(VepAsociado vepAsociado) {
		this.vepAsociado = vepAsociado;
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

}