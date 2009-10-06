package co.com.vep.vista;

import co.com.parametros.modelo.Parametros;
import co.com.vep.logica.RegionalLogica;
import co.com.vep.seguridad.Session;

public class VistaConsultarBancoExpertosPdf extends VistaConsultarBancoExpertos {

	private String regionalNombre;

	public VistaConsultarBancoExpertosPdf() {
		try {
			if (Session.isSessionAlive()) {
				String selectedRegion = String.valueOf(Session
						.getSessionAttribute("REGIONALACTIVA"));
				if (selectedRegion != null
						&& !selectedRegion.equals(new String("null"))) {

					RegionalLogica regional = new RegionalLogica();
					Parametros param = regional
							.obtenerRegionalAsParametro(new Integer(
									selectedRegion));
					regionalNombre = param.getDescripcionParam();
					mostrarBancoExpertos(new Long(selectedRegion));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the regionalNombre
	 */
	public String getRegionalNombre() {
		return regionalNombre;
	}

	/**
	 * @param regionalNombre
	 *            the regionalNombre to set
	 */
	public void setRegionalNombre(String regionalNombre) {
		this.regionalNombre = regionalNombre;
	}

}
