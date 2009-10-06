package co.com.coomeva.wsasociado.test;

import javax.swing.JOptionPane;

import co.com.coomeva.wsasociado.detalle.AsociadoDetalle;
import co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWS;
import co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWSServiceLocator;
import co.com.coomeva.wsasociado.modelo.Asociado;
import co.com.coomeva.wsasociado.modelo.DelegadoWS;
import co.com.coomeva.wsasociado.modelo.DelegadoWSServiceLocator;
import co.com.coomeva.wsasociado.vida.AsociadoVida;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS;
import co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSServiceLocator;



public class TestAsociado {
	public static void main(String[] args) {
		try {
			//consulta();
			//actualizar();
			//consultaDetalle();
			consultaAsoVida();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void consultaAsoVida() throws Exception{
		
		DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
		DelegadoAsociadoVidaWS delegado = delASoc.getdatosAsociadoVida();
		try {
			
			while(true)
			{
			   //long id=Long.parseLong(JOptionPane.showInputDialog("Ingrese su Cedula"));
			   AsociadoVida aso = delegado.consultarAsociadoVida(16614090, 1l);
			   
			   if(aso.getNombre1()!=null)
			   {   System.out.flush();
				   System.out.println(aso.getNombre1());
			   	   System.out.println(aso.getNombre2());
			       System.out.println(generarFechaCorrecta(new Long(aso.getFecNacimiento()).toString()));
			   }
			   else
			   {
				  System.out.println("No existe o el tipo de id no es Cedula");   				   
			   }
			}

			//AsociadoVida aso = delegado.consultarAsociadoVida(60256820l, 1l);
					}catch (Exception e) { e.printStackTrace();

		}
	}
	
	
	private static String generarFechaCorrecta(String fecha)
	{
		String anio=fecha.substring(0, 4);
		String mes=fecha.substring(4,6);
		String dia=fecha.substring(6);
		
		return anio+"-"+mes+"-"+dia;
		
	}
	
	public static void consulta() throws Exception{	
		DelegadoWSServiceLocator delAsoLoc = new DelegadoWSServiceLocator();
		DelegadoWS delWs = null;
		Asociado asociado = new Asociado();
		
		try {
			delWs = delAsoLoc.getadmonAsociado();
			asociado = delWs.consultarAsociado(14839032);
			
			System.out.println(asociado.getNombre1());
			System.out.println(asociado.getCelular());
			System.out.println(asociado.getNombre2());
			
		} catch (Exception e) {
			System.out.println("Exception ex :"+e.getMessage());
		}
	}
	
	
	public static void actualizarVida()throws Exception
	{
		DelegadoAsociadoVidaWSServiceLocator delASoc = new DelegadoAsociadoVidaWSServiceLocator();
		DelegadoAsociadoVidaWS delegado=null;
		AsociadoVida aso=new AsociadoVida();
		
		try{
			//delegado
			
			
			
		}catch(Exception err){}
		
	}
	
	
	public static void actualizar() throws Exception{

		DelegadoWSServiceLocator delAsoLoc = new DelegadoWSServiceLocator();
		DelegadoWS delWs = null;
		Asociado asociado = new Asociado();
		
		try {
			delWs = delAsoLoc.getadmonAsociado();
			//Consulto los datos
			asociado = delWs.consultarAsociado(14839032);
			
			asociado.setUsuario("15321");
			asociado.setSistema("MC");
			asociado.setEmail("CESARA_O@COOMEVA.COM.CO");
				
			//actualizo
			String mensaje = delWs.actualizarAsociado(asociado);
			System.out.println(mensaje);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void consultaDetalle(){
		
		DelegadoInfoAsoDetalleWSServiceLocator delDetaLoc = new DelegadoInfoAsoDetalleWSServiceLocator();
		
		try {
			DelegadoInfoAsoDetalleWS delDeta = delDetaLoc.getdetalleAsociado();
			AsociadoDetalle asoDetalle = new AsociadoDetalle();
			asoDetalle = delDeta.consultarDetalleAsociado(14839032);
			System.out.println(asoDetalle.getAsociado().getNombre1());
			System.out.println(asoDetalle.getDescEstAso());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
