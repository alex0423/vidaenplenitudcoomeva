package co.com.vep.modelo.extension;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepProgramacion;

public class ListadoAsistencia {
	
	private VepProgramacion programacion;
	private VepAsistenteProg asistenteProg;
	private String nombreAsociado;
	private String nombreProfesor;
    private AsociadoVida asociado;
    private boolean si_no;
	/**
	 * @return the programacion
	 */
	public VepProgramacion getProgramacion() {
		return programacion;
	}
	/**
	 * @param programacion the programacion to set
	 */
	public void setProgramacion(VepProgramacion programacion) {
		this.programacion = programacion;
	}
	/**
	 * @return the asistenteProg
	 */
	public VepAsistenteProg getAsistenteProg() {
		return asistenteProg;
	}
	/**
	 * @param asistenteProg the asistenteProg to set
	 */
	public void setAsistenteProg(VepAsistenteProg asistenteProg) {
		this.asistenteProg = asistenteProg;
	}
	/**
	 * @return the nombreAsociado
	 */
	public String getNombreAsociado() {
		return nombreAsociado;
	}
	/**
	 * @param nombreAsociado the nombreAsociado to set
	 */
	public void setNombreAsociado(String nombreAsociado) {
		this.nombreAsociado = nombreAsociado;
	}
	/**
	 * @return the nombreProfesor
	 */
	public String getNombreProfesor() {
		return nombreProfesor;
	}
	/**
	 * @param nombreProfesor the nombreProfesor to set
	 */
	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}
	/**
	 * @return the asociado
	 */
	public AsociadoVida getAsociado() {
		return asociado;
	}
	/**
	 * @param asociado the asociado to set
	 */
	public void setAsociado(AsociadoVida asociado) {
		this.asociado = asociado;
	}
	/**
	 * @return the si_no
	 */
	public boolean isSi_no() {
		return si_no;
	}
	/**
	 * @param si_no the si_no to set
	 */
	public void setSi_no(boolean si_no) {
		this.si_no = si_no;
	}
}
