package co.com.vep.modelo.extension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.vep.modelo.VepBitacoraConsultoria;

public class Informe {

	private Date fecha;
	private String contenido;
	private String archivo;
	
	public Informe() {
		// TODO Auto-generated constructor stub
	}

	public Informe(VepBitacoraConsultoria bitacora) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		try {
			this.fecha = formato.parse(formato.format(bitacora.getFecha()));
			this.contenido = bitacora.getObservacion();
			this.archivo = bitacora.getArchivoUrl();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
}
