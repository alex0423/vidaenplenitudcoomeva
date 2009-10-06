/**
 * AsociadoDetalle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.detalle;

public class AsociadoDetalle  implements java.io.Serializable {
    private long agcVin;
    private co.com.coomeva.wsasociado.detalle.Asociado asociado;
    private long codRegional;
    private long codRetornoWS;
    private long codZona;
    private java.lang.String descAgcVin;
    private java.lang.String descEstAso;
    private java.lang.String descRegional;
    private java.lang.String descRetornoWS;
    private java.lang.String descZona;
    private long estAso;

    public AsociadoDetalle() {
    }

    public long getAgcVin() {
        return agcVin;
    }

    public void setAgcVin(long agcVin) {
        this.agcVin = agcVin;
    }

    public co.com.coomeva.wsasociado.detalle.Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(co.com.coomeva.wsasociado.detalle.Asociado asociado) {
        this.asociado = asociado;
    }

    public long getCodRegional() {
        return codRegional;
    }

    public void setCodRegional(long codRegional) {
        this.codRegional = codRegional;
    }

    public long getCodRetornoWS() {
        return codRetornoWS;
    }

    public void setCodRetornoWS(long codRetornoWS) {
        this.codRetornoWS = codRetornoWS;
    }

    public long getCodZona() {
        return codZona;
    }

    public void setCodZona(long codZona) {
        this.codZona = codZona;
    }

    public java.lang.String getDescAgcVin() {
        return descAgcVin;
    }

    public void setDescAgcVin(java.lang.String descAgcVin) {
        this.descAgcVin = descAgcVin;
    }

    public java.lang.String getDescEstAso() {
        return descEstAso;
    }

    public void setDescEstAso(java.lang.String descEstAso) {
        this.descEstAso = descEstAso;
    }

    public java.lang.String getDescRegional() {
        return descRegional;
    }

    public void setDescRegional(java.lang.String descRegional) {
        this.descRegional = descRegional;
    }

    public java.lang.String getDescRetornoWS() {
        return descRetornoWS;
    }

    public void setDescRetornoWS(java.lang.String descRetornoWS) {
        this.descRetornoWS = descRetornoWS;
    }

    public java.lang.String getDescZona() {
        return descZona;
    }

    public void setDescZona(java.lang.String descZona) {
        this.descZona = descZona;
    }

    public long getEstAso() {
        return estAso;
    }

    public void setEstAso(long estAso) {
        this.estAso = estAso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsociadoDetalle)) return false;
        AsociadoDetalle other = (AsociadoDetalle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.agcVin == other.getAgcVin() &&
            ((this.asociado==null && other.getAsociado()==null) || 
             (this.asociado!=null &&
              this.asociado.equals(other.getAsociado()))) &&
            this.codRegional == other.getCodRegional() &&
            this.codRetornoWS == other.getCodRetornoWS() &&
            this.codZona == other.getCodZona() &&
            ((this.descAgcVin==null && other.getDescAgcVin()==null) || 
             (this.descAgcVin!=null &&
              this.descAgcVin.equals(other.getDescAgcVin()))) &&
            ((this.descEstAso==null && other.getDescEstAso()==null) || 
             (this.descEstAso!=null &&
              this.descEstAso.equals(other.getDescEstAso()))) &&
            ((this.descRegional==null && other.getDescRegional()==null) || 
             (this.descRegional!=null &&
              this.descRegional.equals(other.getDescRegional()))) &&
            ((this.descRetornoWS==null && other.getDescRetornoWS()==null) || 
             (this.descRetornoWS!=null &&
              this.descRetornoWS.equals(other.getDescRetornoWS()))) &&
            ((this.descZona==null && other.getDescZona()==null) || 
             (this.descZona!=null &&
              this.descZona.equals(other.getDescZona()))) &&
            this.estAso == other.getEstAso();
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
        _hashCode += new Long(getAgcVin()).hashCode();
        if (getAsociado() != null) {
            _hashCode += getAsociado().hashCode();
        }
        _hashCode += new Long(getCodRegional()).hashCode();
        _hashCode += new Long(getCodRetornoWS()).hashCode();
        _hashCode += new Long(getCodZona()).hashCode();
        if (getDescAgcVin() != null) {
            _hashCode += getDescAgcVin().hashCode();
        }
        if (getDescEstAso() != null) {
            _hashCode += getDescEstAso().hashCode();
        }
        if (getDescRegional() != null) {
            _hashCode += getDescRegional().hashCode();
        }
        if (getDescRetornoWS() != null) {
            _hashCode += getDescRetornoWS().hashCode();
        }
        if (getDescZona() != null) {
            _hashCode += getDescZona().hashCode();
        }
        _hashCode += new Long(getEstAso()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsociadoDetalle.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.wsasociado.modelo.asociado", "AsociadoDetalle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agcVin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "agcVin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asociado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asociado"));
        elemField.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.wsasociado.modelo.asociado", "Asociado"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codRegional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codRegional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codRetornoWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codRetornoWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codZona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codZona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descAgcVin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descAgcVin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descEstAso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descEstAso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descRegional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descRegional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descRetornoWS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descRetornoWS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descZona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descZona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estAso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estAso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
