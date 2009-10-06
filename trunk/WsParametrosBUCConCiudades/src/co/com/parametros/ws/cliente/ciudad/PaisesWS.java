/**
 * PaisesWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.ws.cliente.ciudad;

public class PaisesWS  implements java.io.Serializable {
    private co.com.parametros.ws.cliente.ciudad.Pais[] arrayPaises;
    private long codRetornoWS;
    private java.lang.String descRetornoWS;
    private co.com.parametros.ws.cliente.ciudad.Pais[] pais;

    public PaisesWS() {
    }

    public co.com.parametros.ws.cliente.ciudad.Pais[] getArrayPaises() {
        return arrayPaises;
    }

    public void setArrayPaises(co.com.parametros.ws.cliente.ciudad.Pais[] arrayPaises) {
        this.arrayPaises = arrayPaises;
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

    public co.com.parametros.ws.cliente.ciudad.Pais[] getPais() {
        return pais;
    }

    public void setPais(co.com.parametros.ws.cliente.ciudad.Pais[] pais) {
        this.pais = pais;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaisesWS)) return false;
        PaisesWS other = (PaisesWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayPaises==null && other.getArrayPaises()==null) || 
             (this.arrayPaises!=null &&
              java.util.Arrays.equals(this.arrayPaises, other.getArrayPaises()))) &&
            this.codRetornoWS == other.getCodRetornoWS() &&
            ((this.descRetornoWS==null && other.getDescRetornoWS()==null) || 
             (this.descRetornoWS!=null &&
              this.descRetornoWS.equals(other.getDescRetornoWS()))) &&
            ((this.pais==null && other.getPais()==null) || 
             (this.pais!=null &&
              java.util.Arrays.equals(this.pais, other.getPais())));
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
        if (getArrayPaises() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayPaises());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayPaises(), i);
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
        if (getPais() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPais());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPais(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaisesWS.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "PaisesWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayPaises");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayPaises"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Pais"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pais"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Pais"));
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
