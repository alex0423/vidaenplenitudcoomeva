/**
 * ParametrosWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.modelo;

public class ParametrosWS  implements java.io.Serializable {
    private co.com.parametros.modelo.Parametros[] arrayParametros;
    private long codRetornoWS;
    private java.lang.String descRetornoWS;
    private co.com.parametros.modelo.Parametros[] parametros;

    public ParametrosWS() {
    }

    public co.com.parametros.modelo.Parametros[] getArrayParametros() {
        return arrayParametros;
    }

    public void setArrayParametros(co.com.parametros.modelo.Parametros[] arrayParametros) {
        this.arrayParametros = arrayParametros;
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

    public co.com.parametros.modelo.Parametros[] getParametros() {
        return parametros;
    }

    public void setParametros(co.com.parametros.modelo.Parametros[] parametros) {
        this.parametros = parametros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametrosWS)) return false;
        ParametrosWS other = (ParametrosWS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arrayParametros==null && other.getArrayParametros()==null) || 
             (this.arrayParametros!=null &&
              java.util.Arrays.equals(this.arrayParametros, other.getArrayParametros()))) &&
            this.codRetornoWS == other.getCodRetornoWS() &&
            ((this.descRetornoWS==null && other.getDescRetornoWS()==null) || 
             (this.descRetornoWS!=null &&
              this.descRetornoWS.equals(other.getDescRetornoWS()))) &&
            ((this.parametros==null && other.getParametros()==null) || 
             (this.parametros!=null &&
              java.util.Arrays.equals(this.parametros, other.getParametros())));
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
        if (getArrayParametros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArrayParametros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArrayParametros(), i);
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
        if (getParametros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParametros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParametros(), i);
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
        new org.apache.axis.description.TypeDesc(ParametrosWS.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "ParametrosWS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arrayParametros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arrayParametros"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Parametros"));
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
        elemField.setFieldName("parametros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parametros"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Parametros"));
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
