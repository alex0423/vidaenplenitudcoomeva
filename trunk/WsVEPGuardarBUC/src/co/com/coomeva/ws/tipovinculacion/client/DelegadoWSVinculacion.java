/**
 * DelegadoWSVinculacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.ws.tipovinculacion.client;

public interface DelegadoWSVinculacion extends java.rmi.Remote {
    public co.com.coomeva.ws.tipovinculacion.client.DatosVinculacion vincularCliente(co.com.coomeva.ws.tipovinculacion.client.DatosVinculacion datosVinculacion) throws java.rmi.RemoteException;
    public java.lang.String registrarTitulo(long nitCli, long tipDoc, java.lang.String indreg, java.lang.String nomtit, long instit, long titulo, long fecha, java.lang.String indgra, java.lang.String usruac) throws java.rmi.RemoteException;
}
