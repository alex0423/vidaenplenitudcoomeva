/**
 * DelegadoWSVinculacionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.ws.tipoasociado.client;

import co.com.coomeva.wsasociado.configuration.LocalApplicationConfigurationWsVinculacion;

public class DelegadoWSVinculacionServiceLocator extends org.apache.axis.client.Service implements co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacionService {

    // Use to get a proxy class for vincularCliente
    private final java.lang.String vincularCliente_address = LocalApplicationConfigurationWsVinculacion.Util.getInstance().getProperty("wsVidaPlenitud.vincularCliente");

    public java.lang.String getvincularClienteAddress() {
        return vincularCliente_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String vincularClienteWSDDServiceName = "vincularCliente";

    public java.lang.String getvincularClienteWSDDServiceName() {
        return vincularClienteWSDDServiceName;
    }

    public void setvincularClienteWSDDServiceName(java.lang.String name) {
        vincularClienteWSDDServiceName = name;
    }

    public co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacion getvincularCliente() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(vincularCliente_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getvincularCliente(endpoint);
    }

    public co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacion getvincularCliente(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.coomeva.ws.tipoasociado.client.VincularClienteSoapBindingStub _stub = new co.com.coomeva.ws.tipoasociado.client.VincularClienteSoapBindingStub(portAddress, this);
            _stub.setPortName(getvincularClienteWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.com.coomeva.ws.tipoasociado.client.DelegadoWSVinculacion.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.coomeva.ws.tipoasociado.client.VincularClienteSoapBindingStub _stub = new co.com.coomeva.ws.tipoasociado.client.VincularClienteSoapBindingStub(new java.net.URL(vincularCliente_address), this);
                _stub.setPortName(getvincularClienteWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("vincularCliente".equals(inputPortName)) {
            return getvincularCliente();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(LocalApplicationConfigurationWsVinculacion.Util.getInstance().getProperty("wsVidaPlenitud.vincularCliente"), "DelegadoWSVinculacionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("vincularCliente"));
        }
        return ports.iterator();
    }

}
