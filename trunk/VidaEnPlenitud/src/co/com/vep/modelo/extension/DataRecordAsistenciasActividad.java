package co.com.vep.modelo.extension;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Column;

import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.util.FacesUtils;
import co.com.vep.vista.LOVsVista;

public class DataRecordAsistenciasActividad {

	private Integer idActividad;
	private String nombre;
	private Integer inscritos;
	private Integer idRegional;
	private String regionalLabel;

	public DataRecordAsistenciasActividad() {

	}

	public DataRecordAsistenciasActividad(Integer idActividad, String nombre,
			Integer inscritos, Integer idRegional) {
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.inscritos = inscritos;
		this.idRegional = idRegional;
		List<SelectItem> lst = ((LOVsVista) FacesUtils.getManagedBean("LOVs"))
				.getRegionales();
		for (SelectItem regional : lst) {
			System.out.println("Regional " + idRegional + " "
					+ regional.getValue());
			if (idRegional.toString().equals(regional.getValue().toString())) {
				System.out.println("Encontrado");
				regionalLabel = regional.getLabel();
				break;
			}
		}
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getInscritos() {
		return inscritos;
	}

	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	public Integer getIdRegional() {
		return idRegional;
	}

	public void setIdRegional(Integer idRegional) {
		this.idRegional = idRegional;
	}

	public String getRegionalLabel() {
		return regionalLabel;
	}

	public void setRegionalLabel(String regionalLabel) {
		this.regionalLabel = regionalLabel;
	}

}
