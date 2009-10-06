/**
 * DelegadoWsParametrosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.modelo;

import co.com.parametros.configuration.LocalApplicationConfigurationWsParametrosBUC;

public class DelegadoWsParametrosServiceLocator extends org.apache.axis.client.Service implements co.com.parametros.modelo.DelegadoWsParametrosService {

    // Use to get a proxy class for consultarParametros
    private final java.lang.String consultarParametros_address = LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros");

    public java.lang.String getconsultarParametrosAddress() {
        return consultarParametros_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String consultarParametrosWSDDServiceName = "consultarParametros";

    public java.lang.String getconsultarParametrosWSDDServiceName() {
        return consultarParametrosWSDDServiceName;
    }

    public void setconsultarParametrosWSDDServiceName(java.lang.String name) {
        consultarParametrosWSDDServiceName = name;
    }

    public co.com.parametros.modelo.DelegadoWsParametros getconsultarParametros() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(consultarParametros_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getconsultarParametros(endpoint);
    }

    public co.com.parametros.modelo.DelegadoWsParametros getconsultarParametros(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.com.parametros.modelo.ConsultarParametrosSoapBindingStub _stub = new co.com.parametros.modelo.ConsultarParametrosSoapBindingStub(portAddress, this);
            _stub.setPortName(getconsultarParametrosWSDDServiceName());
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
            if (co.com.parametros.modelo.DelegadoWsParametros.class.isAssignableFrom(serviceEndpointInterface)) {
                co.com.parametros.modelo.ConsultarParametrosSoapBindingStub _stub = new co.com.parametros.modelo.ConsultarParametrosSoapBindingStub(new java.net.URL(consultarParametros_address), this);
                _stub.setPortName(getconsultarParametrosWSDDServiceName());
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
        if ("consultarParametros".equals(inputPortName)) {
            return getconsultarParametros();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros"), "DelegadoWsParametrosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("consultarParametros"));
        }
        return ports.iterator();
    }

}
