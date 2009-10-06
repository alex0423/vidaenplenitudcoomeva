package co.com.parametros.test;

import co.com.parametros.modelo.Ciudad;
import co.com.parametros.modelo.CiudadesWS;
import co.com.parametros.modelo.DelegadoWsParametros;
import co.com.parametros.modelo.DelegadoWsParametrosServiceLocator;
import co.com.parametros.modelo.Pais;
import co.com.parametros.modelo.PaisesWS;
import co.com.parametros.modelo.Parametros;
import co.com.parametros.modelo.ParametrosWS;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//parametros();
		//parametrosCiu();
		//  paises();
		//departamentos();
	     ciudades();
	}

	public static void parametros() {
		
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			ParametrosWS param = delegado.consultarParametrosXTipo(42);
			for (int i = 0; i < param.getParametros().length; i++) {
				Parametros array_element = param.getParametros()[i];
				System.out.print(array_element.getCodigoParam());
				System.out.println(array_element.getDescripcionParam());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void parametrosCiu() {
		
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			ParametrosWS param = delegado.consultarCiudadesXNombre("CALI");
			for (int i = 0; i < param.getParametros().length; i++) {
				Parametros array_element = param.getParametros()[i];
				System.out.print(array_element.getCodigoParam());
				System.out.println(" - " + array_element.getDescripcionParam());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void paises(){
		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			PaisesWS paisesWS = delegado.consultarTodosPaises();
			
			for (int i = 0; i < paisesWS.getPais().length; i++) {
				Pais array_element = paisesWS.getPais()[i];
				System.out.print(array_element.getCodigoPais());
				System.out.println(" - " + array_element.getNombrePais());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void departamentos(){
			DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
			try {
				DelegadoWsParametros delegado = delLoc.getconsultarParametros();
				ParametrosWS parametrosWS = delegado.consultaDepartamentosxPais("COL");
				
				for (int i = 0; i < parametrosWS.getParametros().length; i++) {
					Parametros array_element = parametrosWS.getParametros()[i];
					System.out.print(array_element.getCodigoParam());
					System.out.println(" - " + array_element.getDescripcionParam());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void ciudades(){

		DelegadoWsParametrosServiceLocator delLoc = new DelegadoWsParametrosServiceLocator();
		try {
			DelegadoWsParametros delegado = delLoc.getconsultarParametros();
			//CiudadesWS ciudadesWS = delegado.consultarCiudadxParametros("COL", 0) ;
			CiudadesWS ciudadesWS = delegado.consultarCiudadxParametros("COL",76) ;
			for (int i = 0; i < ciudadesWS.getCiudad().length; i++) {
				Ciudad array_element = ciudadesWS.getCiudad()[i];
				System.out.print(array_element.getCodPais());
				System.out.print(" - " + array_element.getCodDepartamento());
				System.out.print(" - " + array_element.getCodCiudad());
				System.out.println(" - " + array_element.getNombreCiudad());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
