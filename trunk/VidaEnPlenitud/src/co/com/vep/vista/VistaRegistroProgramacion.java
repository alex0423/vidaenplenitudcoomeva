package co.com.vep.vista;

import java.util.List;

import javax.faces.model.SelectItem;

import co.com.vep.logica.IProgramacionActividad;
import co.com.vep.logica.ProgramacionActividadesLogica;
import co.com.vep.modelo.VepLugar;
import co.com.vep.modelo.VepParametroActividad;
import co.com.vep.modelo.VepProfesor;
import co.com.vep.modelo.VepProfesorPlusBuc;
import co.com.vep.modelo.VepProgramacion;
import co.com.vep.persistencia.IQueryVepProfesorPlusBucDAO;
import co.com.vep.persistencia.QueryVepProfesorPlusBucDAO;
import co.com.vep.persistencia.VepLugarDAO;
import co.com.vep.persistencia.VepParametroActividadDAO;
import co.com.vep.util.FacesUtils;

public class VistaRegistroProgramacion {

	private String idProgramacion;
	private String nombreProfesor;
	private String nombreRegional;
	private String descripcionActividad;
	private String lugar;

	public VistaRegistroProgramacion() {
	}

	public void mostrarRegistro(Integer idActividad, String grupo)
			throws Exception {
		try {
			IProgramacionActividad logica = new ProgramacionActividadesLogica();
			VepProgramacion rs = logica.obtenerByActividadGrupo(idActividad,
					grupo);
			VepParametroActividad vpa = new VepParametroActividad();
			vpa = new VepParametroActividadDAO().findById(rs
					.getIdActividadPar());
			VepLugar vl = new VepLugar();
			vl = new VepLugarDAO().findById(rs.getIdLugar());

			idProgramacion = rs.getIdProgramacion().toString();
			descripcionActividad = vpa.getNombre();
			lugar = vl.getNombre();

			List<SelectItem> lst = ((LOVsVista) FacesUtils
					.getManagedBean("LOVs")).getRegionales();
			for (SelectItem item : lst) {
				if (item.getValue().equals(
						new Long(rs.getIdRegional()))) {
					nombreRegional = item.getDescription();
					break;
				}
			}

			// IQueryVepProfesorPlusBucDAO profesor = new
			// QueryVepProfesorPlusBucDAO();
			// VepProfesor vp = profesor.obtenerByAsociado(rs
			// .getVepProfesor().getIdProfesor());
			// if (vp != null) {
			// nombreProfesor = (vp.getNombre1Asociado() + " " + vp
			// .getNombre2Asociado()).trim()
			// + " "
			// + (vp.getApellido1Asociado() + " " + vp
			// .getApellido2Asociado()).trim();
			// }

		} catch (Exception e) {
			throw e;
		}
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getNombreRegional() {
		return nombreRegional;
	}

	public void setNombreRegional(String nombreRegional) {
		this.nombreRegional = nombreRegional;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(String idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

}
