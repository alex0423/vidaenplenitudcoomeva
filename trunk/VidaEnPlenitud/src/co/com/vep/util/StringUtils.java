package co.com.vep.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.vep.modelo.VepProgramacion;

public class StringUtils {

	public static String clean(String palabra) {

		String[] palabra1 = palabra.trim().split(" ");
		String resul = "";
		for (int i = 0; i < palabra1.length; i++) {
			resul = resul + palabra1[i];
		}
		return resul;
	}

	public static String generarFechaCorrecta(String fecha) {

		String anio = fecha.substring(0, 4);
		String mes = fecha.substring(4, 6);
		String dia = fecha.substring(6);

		return anio + "-" + mes + "-" + dia;
	}
	
	public static String generarFechaCorrecta1(String fecha) {

		String anio = fecha.substring(0, 4);
		String mes = fecha.substring(4, 6);
		String dia = fecha.substring(6);

		return anio + "/" + mes + "/" + dia;
	}

	public static Date cambiarFechaTexto_Date(String fecha) {
		Date fechaNacimiento = null;
		try {
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat(
					"yyyy-MM-dd");
			fechaNacimiento = formatoDelTexto.parse(fecha);
		} catch (ParseException ex) {
		}
		return fechaNacimiento;
	}

	public static void validarCruceHorarios(Date fechaInicio, Date fechaFinal,
			VepProgramacion vepProgramacion, Timestamp horaIni,
			Timestamp horaFin, String mensaje) throws Exception {

		if ((fechaInicio.getTime() >= vepProgramacion.getFechaInicio()
				.getTime() && fechaInicio.getTime() <= vepProgramacion
				.getFechaFin().getTime())
				|| (fechaFinal.getTime() >= vepProgramacion.getFechaInicio()
						.getTime() && fechaFinal.getTime() <= vepProgramacion
						.getFechaFin().getTime())
				|| (fechaInicio.getTime() < vepProgramacion.getFechaInicio()
						.getTime() && fechaFinal.getTime() > vepProgramacion
						.getFechaFin().getTime())) {

			Time tiempoIni = new Time(horaIni.getTime());
			Time tiempoFin = new Time(horaFin.getTime());
			Time tiempoIniBD = new Time(vepProgramacion.getHoraIni().getTime());
			Time tiempoFinBD = new Time(vepProgramacion.getHoraFin().getTime());

			long aIni = new Long(tiempoIni.toString().substring(0, 5).trim()
					.replaceFirst(":", "")).longValue();
			long bFin = new Long(tiempoFin.toString().substring(0, 5).trim()
					.replaceFirst(":", "")).longValue();
			long aIniBD = new Long(tiempoIniBD.toString().substring(0, 5)
					.trim().replaceFirst(":", "")).longValue();
			long bFinBD = new Long(tiempoFinBD.toString().substring(0, 5)
					.trim().replaceFirst(":", "")).longValue();

			if ((aIni > aIniBD && aIni < bFinBD)
					|| (bFin > aIniBD && bFin < bFinBD)
					|| (aIni < aIniBD && bFin > bFinBD)
					|| (aIni == aIniBD && bFin == bFinBD)) {
				try {
					if (mensaje.contains("ProgramacionActividades")) {
						throw new Exception(
								MessageBundleLoader
										.getMessage("labels.cuerpoProgramacion.excepcion20"));
					}else if (mensaje.contains("IncripcionActividades")) {
						throw new Exception(
								MessageBundleLoader
										.getMessage("labels.cuerpoProgramacion.excepcion22"));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					throw e;
				}
			}
		}
	}

}
