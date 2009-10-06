/**
 * Ciudad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.parametros.modelo;

public class Ciudad  implements java.io.Serializable {
    private long codCiudad;
    private long codDepartamento;
    private java.lang.String codPais;
    private java.lang.String nombreCiudad;

    public Ciudad() {
    }

    public long getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(long codCiudad) {
        this.codCiudad = codCiudad;
    }

    public long getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public java.lang.String getCodPais() {
        return codPais;
    }

    public void setCodPais(java.lang.String codPais) {
        this.codPais = codPais;
    }

    public java.lang.String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(java.lang.String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ciudad)) return false;
        Ciudad other = (Ciudad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codCiudad == other.getCodCiudad() &&
            this.codDepartamento == other.getCodDepartamento() &&
            ((this.codPais==null && other.getCodPais()==null) || 
             (this.codPais!=null &&
              this.codPais.equals(other.getCodPais()))) &&
            ((this.nombreCiudad==null && other.getNombreCiudad()==null) || 
             (this.nombreCiudad!=null &&
              this.nombreCiudad.equals(other.getNombreCiudad())));
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
        _hashCode += new Long(getCodCiudad()).hashCode();
        _hashCode += new Long(getCodDepartamento()).hashCode();
        if (getCodPais() != null) {
            _hashCode += getCodPais().hashCode();
        }
        if (getNombreCiudad() != null) {
            _hashCode += getNombreCiudad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ciudad.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.parametrosBUC.modelo", "Ciudad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCiudad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codCiudad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codDepartamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codDepartamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codPais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codPais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreCiudad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreCiudad"));
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
