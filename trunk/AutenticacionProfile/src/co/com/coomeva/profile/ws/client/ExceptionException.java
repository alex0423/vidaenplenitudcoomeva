
/**
 * ExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */

package co.com.coomeva.profile.ws.client;

public class ExceptionException extends java.lang.Exception{
    
    private co.com.coomeva.profile.ws.client.CaasStub.ExceptionE faultMessage;

    
        public ExceptionException() {
            super("ExceptionException");
        }

        public ExceptionException(java.lang.String s) {
           super(s);
        }

        public ExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.com.coomeva.profile.ws.client.CaasStub.ExceptionE msg){
       faultMessage = msg;
    }
    
    public co.com.coomeva.profile.ws.client.CaasStub.ExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    