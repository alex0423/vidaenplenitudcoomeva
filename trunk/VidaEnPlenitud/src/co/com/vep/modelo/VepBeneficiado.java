package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VepBeneficiado entity.
 * 
 * @author MyEclipse Persistence Tools
 */
//@Entity
//@Table(name = "VEP_BENEFICIADO", uniqueConstraints = {})
//@NamedQueries( {
//		@NamedQuery(name = "vepbeneficiado.findByConsultoria", query = "select x from VepBeneficiado x join x.vepDetalleConsultoria d join d.vepConsultoria c where x.idBeneficiario = :idBeneficiario and c.idServiciocon = :idConsultoria"),
//		@NamedQuery(name = "vepbeneficiado.findAllByConsultoria", query = "select x from VepBeneficiado x join x.vepDetalleConsultoria d join d.vepConsultoria c where c.idServiciocon = :idConsultoria") })
public class VepBeneficiado implements java.io.Serializable {

	private Long idBeneficiario;
	private VepDetalleConsultoria vepDetalleConsultoria;
	private String urlarchivo;

	// Constructors

	/** default constructor */
	public VepBeneficiado() {
	}


	/** full constructor */
	public VepBeneficiado(Long idBeneficiario,
			VepDetalleConsultoria vepDetalleConsultoria, String urlarchivo) {
		this.idBeneficiario = idBeneficiario;
		this.vepDetalleConsultoria = vepDetalleConsultoria;
		this.urlarchivo = urlarchivo;
	}

	//@Column(name = "ID_BENEFICIARIO", unique = true, nullable = false, insertable = true, updatable = true)
	public Long getIdBeneficiario() {
		return this.idBeneficiario;
	}

	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

//	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
//	@JoinColumn(name = "ID_DETALLE_CONS", unique = false, nullable = true, insertable = true, updatable = true)
	public VepDetalleConsultoria getVepDetalleConsultoria() {
		return this.vepDetalleConsultoria;
	}

	public void setVepDetalleConsultoria(
			VepDetalleConsultoria vepDetalleConsultoria) {
		this.vepDetalleConsultoria = vepDetalleConsultoria;
	}

//	@Column(name = "URLARCHIVO", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getUrlarchivo() {
		return this.urlarchivo;
	}

	public void setUrlarchivo(String urlarchivo) {
		this.urlarchivo = urlarchivo;
	}

}