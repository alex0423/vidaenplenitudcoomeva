package co.com.vep.modelo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VepTipoAtributo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_TIPO_ATRIBUTO")
public class VepTipoAtributo implements java.io.Serializable {

	// Fields

	private VepTipoAtributoId id;
	private VepSipParametro vepSipParametro;
	private VepValoracion vepValoracion;

	// Constructors

	/** default constructor */
	public VepTipoAtributo() {
	}

	/** minimal constructor */
	public VepTipoAtributo(VepTipoAtributoId id) {
		this.id = id;
	}

	/** full constructor */
	public VepTipoAtributo(VepTipoAtributoId id,
			VepSipParametro vepSipParametro, VepValoracion vepValoracion) {
		this.id = id;
		this.vepSipParametro = vepSipParametro;
		this.vepValoracion = vepValoracion;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "idTipoClasif", column = @Column(name = "ID_TIPO_CLASIF", unique = false, nullable = true, insertable = true, updatable = true)),
			@AttributeOverride(name = "idValoracion", column = @Column(name = "ID_VALORACION", unique = false, nullable = true, insertable = true, updatable = true)),
			@AttributeOverride(name = "observaciones", column = @Column(name = "OBSERVACIONES", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)) })
	public VepTipoAtributoId getId() {
		return this.id;
	}

	public void setId(VepTipoAtributoId id) {
		this.id = id;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_CLASIF", unique = false, nullable = true, insertable = false, updatable = false)
	public VepSipParametro getVepSipParametro() {
		return this.vepSipParametro;
	}

	public void setVepSipParametro(VepSipParametro vepSipParametro) {
		this.vepSipParametro = vepSipParametro;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VALORACION", unique = false, nullable = true, insertable = false, updatable = false)
	public VepValoracion getVepValoracion() {
		return this.vepValoracion;
	}

	public void setVepValoracion(VepValoracion vepValoracion) {
		this.vepValoracion = vepValoracion;
	}

}