/**
 * ConsultarParametrosSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.ws.cliente.ciudad;

import co.com.parametros.configuration.LocalApplicationConfigurationWsParametrosBUC;

public class ConsultarParametrosSoapBindingStub extends org.apache.axis.client.Stub implements co.com.parametros.ws.cliente.ciudad.DelegadoWsParametros {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarParametrosXTipo");
        oper.addParameter(new javax.xml.namespace.QName("", "tipoParam"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "ParametrosWS"));
        oper.setReturnClass(co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultarParametrosXTipoReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTodosPaises");
        oper.setReturnType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "PaisesWS"));
        oper.setReturnClass(co.com.parametros.ws.cliente.ciudad.PaisesWS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultarTodosPaisesReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultaDepartamentosxPais");
        oper.addParameter(new javax.xml.namespace.QName("", "codPais"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "ParametrosWS"));
        oper.setReturnClass(co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultaDepartamentosxPaisReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCiudadxParametros");
        oper.addParameter(new javax.xml.namespace.QName("", "codPais"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "codDepto"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "CiudadesWS"));
        oper.setReturnClass(co.com.parametros.ws.cliente.ciudad.CiudadesWS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultarCiudadxParametrosReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCiudadesXNombre");
        oper.addParameter(new javax.xml.namespace.QName("", "nomCiudad"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "ParametrosWS"));
        oper.setReturnClass(co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultarCiudadesXNombreReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarCiudadxCodigo");
        oper.addParameter(new javax.xml.namespace.QName("", "codigo"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "consultarCiudadxCodigoReturn"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[5] = oper;

    }

    public ConsultarParametrosSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ConsultarParametrosSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ConsultarParametrosSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            qName = new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros"), "ArrayOf_tns1_Ciudad");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Ciudad[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Ciudad");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Ciudad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "ArrayOf_tns1_Parametros");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Parametros[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Parametros");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Parametros.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "PaisesWS");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.PaisesWS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "ParametrosWS");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.ParametrosWS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "ArrayOf_tns1_Pais");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Pais[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "CiudadesWS");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.CiudadesWS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Pais");
            cachedSerQNames.add(qName);
            cls = co.com.parametros.ws.cliente.ciudad.Pais.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultarParametrosXTipo(long tipoParam) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultarParametrosXTipo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(tipoParam)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
            }
        }
    }

    public co.com.parametros.ws.cliente.ciudad.PaisesWS consultarTodosPaises() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultarTodosPaises"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.parametros.ws.cliente.ciudad.PaisesWS) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.parametros.ws.cliente.ciudad.PaisesWS) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.parametros.ws.cliente.ciudad.PaisesWS.class);
            }
        }
    }

    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultaDepartamentosxPais(java.lang.String codPais) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultaDepartamentosxPais"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codPais});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
            }
        }
    }

    public co.com.parametros.ws.cliente.ciudad.CiudadesWS consultarCiudadxParametros(java.lang.String codPais, long codDepto) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultarCiudadxParametros"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codPais, new java.lang.Long(codDepto)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.parametros.ws.cliente.ciudad.CiudadesWS) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.parametros.ws.cliente.ciudad.CiudadesWS) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.parametros.ws.cliente.ciudad.CiudadesWS.class);
            }
        }
    }

    public co.com.parametros.ws.cliente.ciudad.ParametrosWS consultarCiudadesXNombre(java.lang.String nomCiudad) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultarCiudadesXNombre"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {nomCiudad});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) _resp;
            } catch (java.lang.Exception _exception) {
                return (co.com.parametros.ws.cliente.ciudad.ParametrosWS) org.apache.axis.utils.JavaUtils.convert(_resp, co.com.parametros.ws.cliente.ciudad.ParametrosWS.class);
            }
        }
    }

    public java.lang.String consultarCiudadxCodigo(long codigo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName(LocalApplicationConfigurationWsParametrosBUC.Util.getInstance().getProperty("wsParametrosBUC.consultarParametros.url"), "consultarCiudadxCodigo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(codigo)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
    }

}
