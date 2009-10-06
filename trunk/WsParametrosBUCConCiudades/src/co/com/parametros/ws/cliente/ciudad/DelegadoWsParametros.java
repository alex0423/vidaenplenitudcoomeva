/**
 * DelegadoWsParametros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.ws.cliente.ciudad;

public interface DelegadoWsParametros extends java.rmi.Remote {
    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultarParametrosXTipo(long tipoParam) throws java.rmi.RemoteException;
    public co.com.parametros.ws.cliente.ciudad.PaisesWS consultarTodosPaises() throws java.rmi.RemoteException;
    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultaDepartamentosxPais(java.lang.String codPais) throws java.rmi.RemoteException;
    public co.com.parametros.ws.cliente.ciudad.CiudadesWS consultarCiudadxParametros(java.lang.String codPais, long codDepto) throws java.rmi.RemoteException;
    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultarCiudadesXNombre(java.lang.String nomCiudad) throws java.rmi.RemoteException;
    public java.lang.String consultarCiudadxCodigo(long codigo) throws java.rmi.RemoteException;
}
