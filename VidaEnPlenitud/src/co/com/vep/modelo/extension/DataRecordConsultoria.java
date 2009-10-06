package co.com.vep.modelo.extension;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import co.com.vep.modelo.VepConsultoria;
import co.com.vep.modelo.VepDetalleConsultoria;
import co.com.vep.persistencia.VepConsultoriaDAO;
import co.com.vep.util.FacesUtils;
import co.com.vep.vista.LOVsVista;

public class DataRecordConsultoria extends AbstractDataRecord implements
		Serializable {

	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private String estado;
	private String descripcion;
	private String numBeneficiados;
	private String objetivo;

	public DataRecordConsultoria() {
		// TODO Auto-generated constructor stub
	}

	public DataRecordConsultoria(VepDetalleConsultoria detalle) {
		VepConsultoria vc = new VepConsultoria();
		vc = new VepConsultoriaDAO().findById(detalle.getIdServicioCon());
		this.id = vc.getIdServiciocon();
		this.nombre = vc.getNombre();
		this.descripcion = vc.getDescripcion();

		List<SelectItem> lstEstado = ((LOVsVista) FacesUtils
				.getManagedBean("LOVs")).getEstadoConsultoria();
		for (SelectItem Ge : lstEstado) {
			if (Ge.getValue().toString().equals(detalle.getEstado())) {
				this.estado = Ge.getLabel();
				break;
			}
		}

		this.fechaInicio = detalle.getFechaIni();
		this.objetivo = detalle.getObjetivo();
		this.numBeneficiados = detalle.getNumBeneficiados().toString();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumBeneficiados() {
		return numBeneficiados;
	}

	public void setNumBeneficiados(String numBeneficiados) {
		this.numBeneficiados = numBeneficiados;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

}
