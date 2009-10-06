package co.com.vep.modelo.extension;

import java.io.Serializable;
import java.util.Date;

import co.com.vep.modelo.VepDetalleConsultoria;

public class DataRecordDetalleConsultoria extends AbstractDataRecord implements
		Serializable {

	private Date fechaInicio;
	private Date fechaTermina;
	private String objetivos;
	private String observacion;

	public DataRecordDetalleConsultoria() {
		// TODO Auto-generated constructor stub
	}

	public DataRecordDetalleConsultoria(VepDetalleConsultoria detalle) {
		this.fechaInicio = detalle.getFechaIni();
		this.fechaTermina = detalle.getFechaterm();
		this.objetivos = detalle.getObjetivo();
		this.observacion = detalle.getObservaciones();
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
	 * @return the fechaTermina
	 */
	public Date getFechaTermina() {
		return fechaTermina;
	}

	/**
	 * @param fechaTermina
	 *            the fechaTermina to set
	 */
	public void setFechaTermina(Date fechaTermina) {
		this.fechaTermina = fechaTermina;
	}

	/**
	 * @return the objetivos
	 */
	public String getObjetivos() {
		return objetivos;
	}

	/**
	 * @param objetivos
	 *            the objetivos to set
	 */
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
