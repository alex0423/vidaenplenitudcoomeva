package co.com.coomeva.profile.ws.client.app;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import co.com.coomeva.delegado.seguridad.DelegadoServicioAutenticacion;
import co.com.coomeva.profile.ws.client.CaasStub;
import co.com.coomeva.profile.ws.client.ExceptionException;
import co.com.coomeva.profile.ws.client.CaasStub.Application;
import co.com.coomeva.profile.ws.client.CaasStub.SetAplicacionBuscada;
import co.com.coomeva.profile.ws.client.CaasStub.UserVo;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateResponse;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUser;
import co.com.coomeva.profile.ws.client.CaasStub.ValidateUserResponse;

public class Client {

	/**
	 * @param args
	 * @throws ExceptionException 
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException, ExceptionException {
		// TODO Auto-generated method stub
		
		UserVo user;
        /*CaasStub caasStub = new CaasStub("http://192.1.2.26:9092/axis2/services/Caas");
        ValidateUser valUser = new ValidateUser();
        SetAplicacionBuscada aplicacionBuscada = new SetAplicacionBuscada();
        aplicacionBuscada.setAplicacionBuscada("Licitacion");
        valUser.setUserName("dnxapr06");
        valUser.setPassword(null);
        valUser.setDirectory(1);
        ValidateUserResponse resp;
        caasStub.setAplicacionBuscada(aplicacionBuscada);
       resp= caasStub.validateUser(valUser);
       user =  resp.get_return();
       Application[] app = user.getApplications();
       System.out.println(user);
        */
       DelegadoServicioAutenticacion delegado;
       delegado = new DelegadoServicioAutenticacion();
       try {
    	  user = delegado.validarUsuario("dnxapr02", null,"http://192.1.2.26:9092/axis2/services/Caas",0,"Licitaciones",1);
    	  System.out.println(user.getName());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        

	}

}
