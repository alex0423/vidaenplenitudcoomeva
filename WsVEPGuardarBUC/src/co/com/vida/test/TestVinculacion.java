package co.com.vida.test;

import co.com.vida.modelo.DatosVinculacion;
import co.com.vida.modelo.DelegadoWSVinculacion;
import co.com.vida.modelo.DelegadoWSVinculacionServiceLocator;
import co.com.vida.properties.MessagesConfiguration;

public class TestVinculacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			vincular();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void vincular() {

		DelegadoWSVinculacionServiceLocator delVin = new DelegadoWSVinculacionServiceLocator();
		try {
			DelegadoWSVinculacion delegado = delVin.getvincularCliente();
			DatosVinculacion datVin = new DatosVinculacion();
			/*
			 * datVin.setCodProceso("12345"); datVin.setTipoCliente("2");
			 * datVin.setTipoDoc("1"); datVin.setPrimerApellido("ORTIZ");
			 * datVin.setSegundoApellido("VALENCIA");
			 * datVin.setPrimerNombre("VICTOR");
			 * datVin.setSegundoNombre("MANUEL");
			 * datVin.setNumIdentificacion("12345678");
			 * datVin.setFechaNac("19450520"); datVin.setLugarNac("76001000");
			 * datVin.setLugarExpDoc("76001000");
			 * datVin.setFechaExpDoc("19651010");
			 * datVin.setLugarReside("76001000"); datVin.setDirReside("CRA 67A N
			 * 34 70"); datVin.setNumTelReside("3161977");
			 * datVin.setBarrioReside("CIUDAD 2000"); datVin.setCodCiiu("11");
			 * datVin.setPerCargoAdulto("2"); datVin.setPerCargoMenor("0");
			 * datVin.setActLaboral("0"); datVin.setVlrIngresos("1000000");
			 * datVin.setOcupacion("0"); datVin.setSexo("1");
			 * datVin.setTipoVivienda("3"); datVin.setEstrato("4");
			 * datVin.setEstadoCivil("1"); datVin.setIndEstudio("4");
			 * datVin.setVlrComercialPatrim1("40000000");
			 * datVin.setCodError("0"); datVin.setNombreCajero("CLCXCR51");
			 * datVin = delegado.vincularCliente(datVin);
			 */

			DatosVinculacion datos = new DatosVinculacion();

			datos.setTipoDoc("1");
			datos.setNumIdentificacion("16614090");
			datos.setPrimerNombre("XXXXXXXXX");
			datos.setSegundoNombre("XXXXXXX");
			datos.setPrimerApellido("VVVVV");
			datos.setSegundoApellido("bbbbbb");
			datos.setFechaNac("19781210");
			datos.setSexo("1");
			datos.setDirReside("Cra 69 No 7-60");
			datos.setCodCiiu("11");
			datos.setNumTelReside("6677555");
			datos.setOcupacion("31");
			datos.setEstadoCivil("1");
			datos.setNombreCajero("CLCXCR51");// oblig
			datos.setTipoCliente("2");// oblig
			datos.setFechaExpDoc("19991110");// oblig
			datos.setBarrioReside("Lopez");// oblig
			datos.setVlrIngresos("1000000");// oblig
			datos.setTipoVivienda("3");// oblig
			datos.setEstrato("4");// oblig

			datos.setIndEstudio("4");// oblig
			datos.setVlrComercialPatrim1("40000000");// oblig
			datos.setLugarNac("76001000");
			datos.setLugarExpDoc("76001000");

			datVin = delegado.vincularCliente(datos);
			System.out.println("msg: "
					+ MessagesConfiguration.Util.getInstance().getProperty(
							datVin.getCodError()));
			System.out.println(datVin.getCodError());
			System.out.println(datVin.getMensajeError());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
