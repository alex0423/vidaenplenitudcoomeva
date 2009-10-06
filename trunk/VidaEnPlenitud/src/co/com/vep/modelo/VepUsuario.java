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
 * VepUsuario entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "VEP_USUARIO", uniqueConstraints = {})
@NamedQueries( { @NamedQuery(name = "vepusuario.findByLogin", query = "select c from VepUsuario c where c.loginUsuario = :login") })
public class VepUsuario implements java.io.Serializable {

	// Fields

	private Integer codUsuario;
	private VepRegional vepRegional;
	private String loginUsuario;
	private String estado;

	// Constructors

	/** default constructor */
	public VepUsuario() {
	}

	/** full constructor */
	public VepUsuario(Integer codUsuario, VepRegional vepRegional,
			String loginUsuario, String estado) {
		this.codUsuario = codUsuario;
		this.vepRegional = vepRegional;
		this.loginUsuario = loginUsuario;
		this.estado = estado;
	}

	// Property accessors
	@Id
	@Column(name = "COD_USUARIO", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REGIONAL", unique = false, nullable = false, insertable = true, updatable = true)
	public VepRegional getVepRegional() {
		return this.vepRegional;
	}

	public void setVepRegional(VepRegional vepRegional) {
		this.vepRegional = vepRegional;
	}

	@Column(name = "LOGIN_USUARIO", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getLoginUsuario() {
		return this.loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	@Column(name = "ESTADO", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}