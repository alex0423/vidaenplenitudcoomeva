/**
 * DelegadoAsociadoVidaWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.vida;

import co.com.coomeva.wsasociado.configuration.LocalApplicationConfigurationWsAsociado;

public class DelegadoAsociadoVidaWSServiceLocator extends org.apache.axis.client.Service implements co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWSService {

    // Use to get a proxy class for datosAsociadoVida
    private final java.lang.String datosAsociadoVida_address = LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.datosAsociadoVida");

    public java.lang.String getdatosAsociadoVidaAddress() {
        return datosAsociadoVida_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String datosAsociadoVidaWSDDServiceName = "datosAsociadoVida";

    public java.lang.String getdatosAsociadoVidaWSDDServiceName() {
        return datosAsociadoVidaWSDDServiceName;
    }

    public void setdatosAsociadoVidaWSDDServiceName(java.lang.String name) {
        datosAsociadoVidaWSDDServiceName = name;
    }

    public co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS getdatosAsociadoVida() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(datosAsociadoVida_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getdatosAsociadoVida(endpoint);
    }

    public co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS getdatosAsociadoVida(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.coomeva.wsasociado.vida.DatosAsociadoVidaSoapBindingStub _stub = new co.com.coomeva.wsasociado.vida.DatosAsociadoVidaSoapBindingStub(portAddress, this);
            _stub.setPortName(getdatosAsociadoVidaWSDDServiceName());
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
            if (co.com.coomeva.wsasociado.vida.DelegadoAsociadoVidaWS.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.coomeva.wsasociado.vida.DatosAsociadoVidaSoapBindingStub _stub = new co.com.coomeva.wsasociado.vida.DatosAsociadoVidaSoapBindingStub(new java.net.URL(datosAsociadoVida_address), this);
                _stub.setPortName(getdatosAsociadoVidaWSDDServiceName());
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
        if ("datosAsociadoVida".equals(inputPortName)) {
            return getdatosAsociadoVida();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(LocalApplicationConfigurationWsAsociado.Util.getInstance().getProperty("wsasociado.datosAsociadoVida"), "DelegadoAsociadoVidaWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("datosAsociadoVida"));
        }
        return ports.iterator();
    }

}
