/**
 * Pais.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.ws.cliente.ciudad;

public class Pais  implements java.io.Serializable {
    private java.lang.String codigoPais;
    private java.lang.String nombrePais;

    public Pais() {
    }

    public java.lang.String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(java.lang.String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public java.lang.String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(java.lang.String nombrePais) {
        this.nombrePais = nombrePais;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pais)) return false;
        Pais other = (Pais) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoPais==null && other.getCodigoPais()==null) || 
             (this.codigoPais!=null &&
              this.codigoPais.equals(other.getCodigoPais()))) &&
            ((this.nombrePais==null && other.getNombrePais()==null) || 
             (this.nombrePais!=null &&
              this.nombrePais.equals(other.getNombrePais())));
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
        if (getCodigoPais() != null) {
            _hashCode += getCodigoPais().hashCode();
        }
        if (getNombrePais() != null) {
            _hashCode += getNombrePais().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pais.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Pais"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoPais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombrePais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombrePais"));
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
