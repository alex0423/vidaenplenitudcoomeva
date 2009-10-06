/**
 * DelegadoWsParametros.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.modelo;

public interface DelegadoWsParametros extends java.rmi.Remote {
    public co.com.parametros.modelo.ParametrosWS consultarParametrosXTipo(long tipoParam) throws java.rmi.RemoteException;
    public co.com.parametros.modelo.ParametrosWS consultarCiudadesXNombre(java.lang.String nomCiudad) throws java.rmi.RemoteException;
    public co.com.parametros.modelo.PaisesWS consultarTodosPaises() throws java.rmi.RemoteException;
    public co.com.parametros.modelo.ParametrosWS consultaDepartamentosxPais(java.lang.String codPais) throws java.rmi.RemoteException;
    public co.com.parametros.modelo.CiudadesWS consultarCiudadxParametros(java.lang.String codPais, long codDepto) throws java.rmi.RemoteException;
}
