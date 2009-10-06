package co.com.vep.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VepRegional entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_REGIONAL", uniqueConstraints = {})
public class VepRegional implements java.io.Serializable {

	// Fields

	private Integer idRegional;

	// Constructors

	/** default constructor */
	public VepRegional() {
	}

	/** full constructor */
	public VepRegional(Integer idRegional) {
		this.idRegional = idRegional;
	}

	// Property accessors
	@Id
	@Column(name = "ID_REGIONAL", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getIdRegional() {
		return this.idRegional;
	}

	public void setIdRegional(Integer idRegional) {
		this.idRegional = idRegional;
	}

}