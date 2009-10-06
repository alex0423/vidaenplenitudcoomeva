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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLInsert;

/**
 * VepAtributoAsociado entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_ATRIBUTO_ASOCIADO", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ID_ASOCIADO", "ID_TIPO_CLASIF", "VALOR" }))
@NamedQueries( { @NamedQuery(name = "vepatributoasociado.findbyasociado", query = "select c from VepAtributoAsociado c join c.vepAsociado a join c.vepSipParametro p where a.idAsociado = :idAsociado") })
public class VepAtributoAsociado implements java.io.Serializable {

	// Fields

	private Integer consecutivo;
	private VepSipParametro vepSipParametro;
	private VepAsociado vepAsociado;
	private String valor;

	// Constructors

	/** default constructor */
	public VepAtributoAsociado() {
	}

	/** minimal constructor */
	public VepAtributoAsociado(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	/** full constructor */
	public VepAtributoAsociado(Integer consecutivo,
			VepSipParametro vepSipParametro, VepAsociado vepAsociado,
			String valor) {
		this.consecutivo = consecutivo;
		this.vepSipParametro = vepSipParametro;
		this.vepAsociado = vepAsociado;
		this.valor = valor;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CONSECUTIVO", unique = true, nullable = false)
	public Integer getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_CLASIF", unique = false, nullable = false, insertable = true, updatable = true)
	public VepSipParametro getVepSipParametro() {
		return this.vepSipParametro;
	}

	public void setVepSipParametro(VepSipParametro vepSipParametro) {
		this.vepSipParametro = vepSipParametro;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ASOCIADO", unique = false, nullable = false, insertable = true, updatable = true)
	public VepAsociado getVepAsociado() {
		return this.vepAsociado;
	}

	public void setVepAsociado(VepAsociado vepAsociado) {
		this.vepAsociado = vepAsociado;
	}

	@Column(name = "VALOR", length = 1000)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}