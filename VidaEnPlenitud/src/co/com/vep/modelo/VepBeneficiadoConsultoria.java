package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * VepBeneficiadoConsultoria entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_BENEFICIADO_CONSULTORIA", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"ID_BENEFICIARIO", "ID_DETALLE_CONS" }) })
@NamedQueries( {
		@NamedQuery(name = "vepbeneficiado.findByConsultoria", query = "select x from VepBeneficiadoConsultoria x, VepDetalleConsultoria d, VepConsultoria c where x.idDetalleCons = d.idDetallecons and d.idServicioCon = c.idServiciocon and x.tipoDocumento = :tipoDocumento and x.idBeneficiario = :idBeneficiario and c.idServiciocon = :idConsultoria"),																
		@NamedQuery(name = "vepbeneficiado.findAllByConsultoria", query = "select x from VepBeneficiadoConsultoria x, VepDetalleConsultoria d, VepConsultoria c where x.idDetalleCons = d.idDetallecons and d.idServicioCon = c.idServiciocon and c.idServiciocon = :idConsultoria") })		
public class VepBeneficiadoConsultoria implements java.io.Serializable {

	// Fields

	private Integer consecutivo;
	private Long tipoDocumento;
	private Long idBeneficiario;
	private String urlarchivo;
	private Integer idDetalleCons;

	// Constructors

	/** default constructor */
	public VepBeneficiadoConsultoria() {
	}

	/** minimal constructor */
	public VepBeneficiadoConsultoria(Integer consecutivo, Long tipoDocumento) {
		this.consecutivo = consecutivo;
		this.tipoDocumento = tipoDocumento;
	}

	/** full constructor */
	public VepBeneficiadoConsultoria(Integer consecutivo, Long tipoDocumento,
			Long idBeneficiario, String urlarchivo, Integer idDetalleCons) {
		this.consecutivo = consecutivo;
		this.tipoDocumento = tipoDocumento;
		this.idBeneficiario = idBeneficiario;
		this.urlarchivo = urlarchivo;
		this.idDetalleCons = idDetalleCons;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CONSECUTIVO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	@Column(name = "TIPO_DOCUMENTO", unique = false, nullable = false, insertable = true, updatable = true, precision = 3, scale = 0)
	public Long getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Column(name = "ID_BENEFICIARIO", unique = false, nullable = true, insertable = true, updatable = true, precision = 17, scale = 0)
	public Long getIdBeneficiario() {
		return this.idBeneficiario;
	}

	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	@Column(name = "URLARCHIVO", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getUrlarchivo() {
		return this.urlarchivo;
	}

	public void setUrlarchivo(String urlarchivo) {
		this.urlarchivo = urlarchivo;
	}

	@Column(name = "ID_DETALLE_CONS", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getIdDetalleCons() {
		return this.idDetalleCons;
	}

	public void setIdDetalleCons(Integer idDetalleCons) {
		this.idDetalleCons = idDetalleCons;
	}

}