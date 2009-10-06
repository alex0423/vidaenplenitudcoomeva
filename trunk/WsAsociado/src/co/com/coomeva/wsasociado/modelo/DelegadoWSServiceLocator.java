/**
 * DelegadoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.modelo;

import co.com.coomeva.wsasociado.configuration.LocalApplicationConfigurationWsAsociado;

public class DelegadoWSServiceLocator extends org.apache.axis.client.Service implements co.com.coomeva.wsasociado.modelo.DelegadoWSService {

    // Use to get a proxy class for admonAsociado
    private final java.lang.String admonAsociado_address = LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.admonAsociado");

    public java.lang.String getadmonAsociadoAddress() {
        return admonAsociado_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String admonAsociadoWSDDServiceName = "admonAsociado";

    public java.lang.String getadmonAsociadoWSDDServiceName() {
        return admonAsociadoWSDDServiceName;
    }

    public void setadmonAsociadoWSDDServiceName(java.lang.String name) {
        admonAsociadoWSDDServiceName = name;
    }

    public co.com.coomeva.wsasociado.modelo.DelegadoWS getadmonAsociado() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(admonAsociado_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getadmonAsociado(endpoint);
    }

    public co.com.coomeva.wsasociado.modelo.DelegadoWS getadmonAsociado(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.coomeva.wsasociado.modelo.AdmonAsociadoSoapBindingStub _stub = new co.com.coomeva.wsasociado.modelo.AdmonAsociadoSoapBindingStub(portAddress, this);
            _stub.setPortName(getadmonAsociadoWSDDServiceName());
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
            if (co.com.coomeva.wsasociado.modelo.DelegadoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.coomeva.wsasociado.modelo.AdmonAsociadoSoapBindingStub _stub = new co.com.coomeva.wsasociado.modelo.AdmonAsociadoSoapBindingStub(new java.net.URL(admonAsociado_address), this);
                _stub.setPortName(getadmonAsociadoWSDDServiceName());
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
        if ("admonAsociado".equals(inputPortName)) {
            return getadmonAsociado();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.admonAsociado"), "DelegadoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("admonAsociado"));
        }
        return ports.iterator();
    }

}
