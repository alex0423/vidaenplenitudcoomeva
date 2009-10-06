/**
 * AsociadoVida.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package co.com.coomeva.wsasociado.vida;

public class AsociadoVida  extends co.com.coomeva.wsasociado.vida.Asociado  implements java.io.Serializable {
    private long codAsociado;
    private java.lang.String corte;
    private long cuotaVencida;
    private long estado;
    private long fecEstado;
    private long fecIngreso;
    private long fecNacimiento;
    private java.lang.String ocupacion;
    private java.lang.String profesion;

    public AsociadoVida() {
    }

    public long getCodAsociado() {
        return codAsociado;
    }

    public void setCodAsociado(long codAsociado) {
        this.codAsociado = codAsociado;
    }

    public java.lang.String getCorte() {
        return corte;
    }

    public void setCorte(java.lang.String corte) {
        this.corte = corte;
    }

    public long getCuotaVencida() {
        return cuotaVencida;
    }

    public void setCuotaVencida(long cuotaVencida) {
        this.cuotaVencida = cuotaVencida;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long estado) {
        this.estado = estado;
    }

    public long getFecEstado() {
        return fecEstado;
    }

    public void setFecEstado(long fecEstado) {
        this.fecEstado = fecEstado;
    }

    public long getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(long fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public long getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(long fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public java.lang.String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(java.lang.String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public java.lang.String getProfesion() {
        return profesion;
    }

    public void setProfesion(java.lang.String profesion) {
        this.profesion = profesion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsociadoVida)) return false;
        AsociadoVida other = (AsociadoVida) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.codAsociado == other.getCodAsociado() &&
            ((this.corte==null && other.getCorte()==null) || 
             (this.corte!=null &&
              this.corte.equals(other.getCorte()))) &&
            this.cuotaVencida == other.getCuotaVencida() &&
            this.estado == other.getEstado() &&
            this.fecEstado == other.getFecEstado() &&
            this.fecIngreso == other.getFecIngreso() &&
            this.fecNacimiento == other.getFecNacimiento() &&
            ((this.ocupacion==null && other.getOcupacion()==null) || 
             (this.ocupacion!=null &&
              this.ocupacion.equals(other.getOcupacion()))) &&
            ((this.profesion==null && other.getProfesion()==null) || 
             (this.profesion!=null &&
              this.profesion.equals(other.getProfesion())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += new Long(getCodAsociado()).hashCode();
        if (getCorte() != null) {
            _hashCode += getCorte().hashCode();
        }
        _hashCode += new Long(getCuotaVencida()).hashCode();
        _hashCode += new Long(getEstado()).hashCode();
        _hashCode += new Long(getFecEstado()).hashCode();
        _hashCode += new Long(getFecIngreso()).hashCode();
        _hashCode += new Long(getFecNacimiento()).hashCode();
        if (getOcupacion() != null) {
            _hashCode += getOcupacion().hashCode();
        }
        if (getProfesion() != null) {
            _hashCode += getProfesion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsociadoVida.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("co.com.coomeva.wsasociado.modelo.asociado", "AsociadoVida"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codAsociado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codAsociado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cuotaVencida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cuotaVencida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecIngreso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecIngreso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecNacimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecNacimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ocupacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ocupacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profesion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profesion"));
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
