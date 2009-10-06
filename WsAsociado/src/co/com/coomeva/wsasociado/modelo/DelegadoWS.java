/**
 * DelegadoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.modelo;

public interface DelegadoWS extends java.rmi.Remote {
    public co.com.coomeva.wsasociado.modelo.Asociado consultarAsociado(long identificacion) throws java.rmi.RemoteException;
    public java.lang.String actualizarAsociado(co.com.coomeva.wsasociado.modelo.Asociado infoAsociado) throws java.rmi.RemoteException;
}
