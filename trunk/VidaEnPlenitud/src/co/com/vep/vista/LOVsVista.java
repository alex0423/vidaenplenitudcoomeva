/**
 * 
 */
package co.com.vep.vista;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.vep.init.SessionLoaders;

/**
 * @author Juank
 * 
 */
public class LOVsVista {

	public List<SelectItem> getTiposIdentificacion() {
		return SessionLoaders.Util.getInstance().getLOV("tiposIdentificacion");
	}

	public List<SelectItem> getRegionales() {
		return SessionLoaders.Util.getInstance().getLOV("regionales");
	}

	public List<SelectItem> getRegionalesUsuario() {
		return SessionLoaders.Util.getInstance().getLOV("regionalesUsuario");
	}

	public List<SelectItem> getPaises() {
		return SessionLoaders.Util.getInstance().getLOV("paises");
	}

	public List<SelectItem> getOcupacion() {
		return SessionLoaders.Util.getInstance().getLOV("ocupacion");
	}

	public List<SelectItem> getTiposAsociado() {
		return SessionLoaders.Util.getInstance().getLOV("tiposAsociado");
	}

	public List<SelectItem> getCorte() {
		return SessionLoaders.Util.getInstance().getLOV("corte");
	}

	public List<SelectItem> getEstadoCivil() {
		return SessionLoaders.Util.getInstance().getLOV("estadoCivil");
	}

	public List<SelectItem> getTituloProfesional() {
		return SessionLoaders.Util.getInstance().getLOV("tituloProfesional");
	}

	public List<SelectItem> getPAM() {
		return SessionLoaders.Util.getInstance().getLOV("PAM");
	}

	public List<SelectItem> getConocimientos() {
		return SessionLoaders.Util.getInstance().getLOV("conocimientos");
	}

	public List<SelectItem> getAreasConocimiento() {
		return SessionLoaders.Util.getInstance().getLOV("areasConocimiento");
	}

	public List<SelectItem> getServiciosOfrecer() {
		return SessionLoaders.Util.getInstance().getLOV("serviciosOfrecer");
	}

	public List<SelectItem> getServicioMedico() {
		return SessionLoaders.Util.getInstance().getLOV("servicioMedico");
	}

	public List<SelectItem> getHobbies() {
		return SessionLoaders.Util.getInstance().getLOV("hobbies");
	}

	public List<SelectItem> getPatologias() {
		return SessionLoaders.Util.getInstance().getLOV("patologias");
	}

	public List<SelectItem> getGenero() {
		return SessionLoaders.Util.getInstance().getLOV("genero");
	}

	public List<SelectItem> getEstado() {
		return SessionLoaders.Util.getInstance().getLOV("estado");
	}

	public List<SelectItem> getMediosConocimiento() {
		return SessionLoaders.Util.getInstance().getLOV("mediosConocimiento");
	}

	public List<SelectItem> getAtencion() {
		return SessionLoaders.Util.getInstance().getLOV("atencion");
	}

	public List<SelectItem> getSiNo() {
		return SessionLoaders.Util.getInstance().getLOV("sino");
	}

	public List<SelectItem> getMAMS() {
		return SessionLoaders.Util.getInstance().getLOV("MAMS");
	}

	public List<SelectItem> getMAMI() {
		return SessionLoaders.Util.getInstance().getLOV("MAMI");
	}

	public List<SelectItem> getAAVD() {
		return SessionLoaders.Util.getInstance().getLOV("AAVD");
	}

	public List<SelectItem> getABVD() {
		return SessionLoaders.Util.getInstance().getLOV("ABVD");
	}

	public List<SelectItem> getAIVD() {
		return SessionLoaders.Util.getInstance().getLOV("AIVD");
	}

	public List<SelectItem> getMarcha() {
		return SessionLoaders.Util.getInstance().getLOV("marcha");
	}
	
	public List<SelectItem> getEquilibrio() {
		return SessionLoaders.Util.getInstance().getLOV("equilibrio");
	}

	public List<SelectItem> getFlexibilidad() {
		return SessionLoaders.Util.getInstance().getLOV("flexibilidad");
	}

	public List<SelectItem> getNivelDependenciaVD() {
		return SessionLoaders.Util.getInstance().getLOV("nivelDependenciaVD");
	}

	public List<SelectItem> getNivelAcondicionamiento() {
		return SessionLoaders.Util.getInstance().getLOV("nivelAcondicionamiento");
	}

	public List<SelectItem> getFMMI() {
		return SessionLoaders.Util.getInstance().getLOV("FMMI");
	}

	public List<SelectItem> getFMMS() {
		return SessionLoaders.Util.getInstance().getLOV("FMMS");
	}

	public List<SelectItem> getValoracionCuello() {
		return SessionLoaders.Util.getInstance().getLOV("valoracionCuello");
	}

	public List<SelectItem> getValoracionPostura() {
		return SessionLoaders.Util.getInstance().getLOV("valoracionPostura");
	}

	public List<SelectItem> getAutoPercepcionSalud() {
		return SessionLoaders.Util.getInstance().getLOV("autoPercepcionSalud");
	}

	public List<SelectItem> getAutoPercepcionVida() {
		return SessionLoaders.Util.getInstance().getLOV("autoPercepcionVida");
	}

	public List<SelectItem> getAcondicionamiento() {
		return SessionLoaders.Util.getInstance().getLOV("acondicionamiento");
	}

	public List<SelectItem> getSituacionDuelo() {
		return SessionLoaders.Util.getInstance().getLOV("situacionDuelo");
	}

	public List<SelectItem> getSituacionTristeza() {
		return SessionLoaders.Util.getInstance().getLOV("situacionTristeza");
	}

	public List<SelectItem> getApoyoFamiliar() {
		return SessionLoaders.Util.getInstance().getLOV("apoyoFamiliar");
	}

	public List<SelectItem> getGrupoAmigos() {
		return SessionLoaders.Util.getInstance().getLOV("grupoAmigos");
	}

	public List<SelectItem> getRecuerdosRecientes() {
		return SessionLoaders.Util.getInstance().getLOV("recuerdosRecientes");
	}

	public List<SelectItem> getRecuerdosPasados() {
		return SessionLoaders.Util.getInstance().getLOV("recuerdosPasados");
	}

	public List<SelectItem> getRequiereApoyo() {
		return SessionLoaders.Util.getInstance().getLOV("requiereApoyo");
	}

	public List<SelectItem> getAbdominales() {
		return SessionLoaders.Util.getInstance().getLOV("abdominales");
	}

	public List<SelectItem> getAntecedentesClinicos() {
		return SessionLoaders.Util.getInstance().getLOV("antecedentesClinicos");
	}

	public List<SelectItem> getActividades() {
		return SessionLoaders.Util.getInstance().getLOV("actividades");
	}
	
	public List<SelectItem> getEstadoConsultoria() {
		return SessionLoaders.Util.getInstance().getLOV("estadoConsultoria");
	}
	
	public List<SelectItem> getTipoSangre() {
		return SessionLoaders.Util.getInstance().getLOV("tipoSangre");
	}
	
	public List<SelectItem> getTipoEstadoAsociado() {
		return SessionLoaders.Util.getInstance().getLOV("tipoEstadoAsociado");
	}
}
