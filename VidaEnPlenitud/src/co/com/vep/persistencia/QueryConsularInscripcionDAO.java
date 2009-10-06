/**
 * 
 */
package co.com.vep.persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.vep.modelo.VepAsociado;
import co.com.vep.modelo.VepAtributoAsociado;

/**
 * @author tobias.mosquera
 * 
 */
public class QueryConsularInscripcionDAO implements
		IQueryConsularInscripcionDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.vep.persistencia.IQueryConsularInscripcionDAO#ejecutarConsultaInscripcion(java.lang.String,
	 *      java.lang.Long, java.util.Date, java.util.Date, java.lang.String)
	 */

	@SuppressWarnings("unused")
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	private String conversionFechas(Date fecha) {

		try {
			Calendar cal = new GregorianCalendar();
			cal.setTimeInMillis(fecha.getTime());
			cal.add(Calendar.DATE, 1);
			fecha = new Date(cal.getTimeInMillis());

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String fechaString = dateFormat.format(fecha);
			return "='" + fechaString + "'";

		} catch (Exception err) {
			return "IS NULL";
		}

	}

}
