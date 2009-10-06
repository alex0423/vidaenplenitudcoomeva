package co.com.vep.modelo.extension;

import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.vep.modelo.VepAsistenteProg;
import co.com.vep.modelo.VepParametroActividad;

public class VepAsistenteProgAsociado {
	
	private VepAsistenteProg asistenteProg;
	private VepParametroActividad parametroActividad;
	private AsociadoVida asociado;
	private String formatoFecha;
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
	public String getFormatoFecha() {
		return formatoFecha;
	}
	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}
	public VepParametroActividad getParametroActividad() {
		return parametroActividad;
	}
	public void setParametroActividad(VepParametroActividad parametroActividad) {
		this.parametroActividad = parametroActividad;
	}
}
