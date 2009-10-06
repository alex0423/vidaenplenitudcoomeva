/**
 * DelegadoInfoAsoDetalleWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.detalle;

import co.com.coomeva.wsasociado.configuration.LocalApplicationConfigurationWsAsociado;

public class DelegadoInfoAsoDetalleWSServiceLocator extends org.apache.axis.client.Service implements co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWSService {

    // Use to get a proxy class for detalleAsociado
    private final java.lang.String detalleAsociado_address = LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.detalleAsociado");

    public java.lang.String getdetalleAsociadoAddress() {
        return detalleAsociado_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String detalleAsociadoWSDDServiceName = "detalleAsociado";

    public java.lang.String getdetalleAsociadoWSDDServiceName() {
        return detalleAsociadoWSDDServiceName;
    }

    public void setdetalleAsociadoWSDDServiceName(java.lang.String name) {
        detalleAsociadoWSDDServiceName = name;
    }

    public co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWS getdetalleAsociado() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(detalleAsociado_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getdetalleAsociado(endpoint);
    }

    public co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWS getdetalleAsociado(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.coomeva.wsasociado.detalle.DetalleAsociadoSoapBindingStub _stub = new co.com.coomeva.wsasociado.detalle.DetalleAsociadoSoapBindingStub(portAddress, this);
            _stub.setPortName(getdetalleAsociadoWSDDServiceName());
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
            if (co.com.coomeva.wsasociado.detalle.DelegadoInfoAsoDetalleWS.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.coomeva.wsasociado.detalle.DetalleAsociadoSoapBindingStub _stub = new co.com.coomeva.wsasociado.detalle.DetalleAsociadoSoapBindingStub(new java.net.URL(detalleAsociado_address), this);
                _stub.setPortName(getdetalleAsociadoWSDDServiceName());
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
        if ("detalleAsociado".equals(inputPortName)) {
            return getdetalleAsociado();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.detalleAsociado"), "DelegadoInfoAsoDetalleWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("detalleAsociado"));
        }
        return ports.iterator();
    }

}
