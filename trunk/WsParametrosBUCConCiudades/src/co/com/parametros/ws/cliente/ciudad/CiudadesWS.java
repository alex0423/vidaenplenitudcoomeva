/**
 * CiudadesWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.ws.cliente.ciudad;

public class CiudadesWS  implements java.io.Serializable {
    private co.com.parametros.ws.cliente.ciudad.Ciudad[] arrayCiudad;
    private co.com.parametros.ws.cliente.ciudad.Ciudad[] ciudad;
    private long codRetornoWS;
    private java.lang.String descRetornoWS;

    public CiudadesWS() {
    }

    public co.com.parametros.ws.cliente.ciudad.Ciudad[] getArrayCiudad() {
        return arrayCiudad;
    }

    public void setArrayCiudad(co.com.parametros.ws.cliente.ciudad.Ciudad[] arrayCiudad) {
        this.arrayCiudad = arrayCiudad;
    }

    public co.com.parametros.ws.cliente.ciudad.Ciudad[] getCiudad() {
        return ciudad;
    }

    public void setCiudad(co.com.parametros.ws.cliente.ciudad.Ciudad[] ciudad) {
        this.ciudad = ciudad;
    }

    public long getCodRetornoWS() {
        return codRetornoWS;
    }

    public void setCodRetornoWS(long codRetornoWS) {
        this.codRetornoWS = codRetornoWS;
    }

    public java.lang.String getDescRetornoWS() {
        return descRetornoWS;
    }

    public void setDescRetornoWS(java.lang.String descRetornoWS) {
        this.descRetornoWS = descRetornoWS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CiudadesWS)) return false;
        CiudadesWS other = (CiudadesWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayCiudad==null && other.getArrayCiudad()==null) || 
             (this.arrayCiudad!=null &&
              java.util.Arrays.equals(this.arrayCiudad, other.getArrayCiudad()))) &&
            ((this.ciudad==null && other.getCiudad()==null) || 
             (this.ciudad!=null &&
              java.util.Arrays.equals(this.ciudad, other.getCiudad()))) &&
            this.codRetornoWS == other.getCodRetornoWS() &&
            ((this.descRetornoWS==null && other.getDescRetornoWS()==null) || 
             (this.descRetornoWS!=null &&
              this.descRetornoWS.equals(other.getDescRetornoWS())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArrayCiudad() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayCiudad());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayCiudad(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCiudad() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCiudad());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCiudad(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getCodRetornoWS()).hashCode();
        if (getDescRetornoWS() != null) {
            _hashCode += getDescRetornoWS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CiudadesWS.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "CiudadesWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayCiudad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayCiudad"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Ciudad"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciudad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciudad"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Ciudad"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codRetornoWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codRetornoWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descRetornoWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descRetornoWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
