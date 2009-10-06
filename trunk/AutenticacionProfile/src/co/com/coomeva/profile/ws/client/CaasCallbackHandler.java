
/**
 * CaasCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */

    package co.com.coomeva.profile.ws.client;

    /**
     *  CaasCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CaasCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CaasCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CaasCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
               // No methods generated for meps other than in-out
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for validate method
            * override this method for handling normal response from validate operation
            */
           public void receiveResultvalidate(
                    co.com.coomeva.profile.ws.client.CaasStub.ValidateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validate operation
           */
            public void receiveErrorvalidate(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getAplicacionBuscada method
            * override this method for handling normal response from getAplicacionBuscada operation
            */
           public void receiveResultgetAplicacionBuscada(
                    co.com.coomeva.profile.ws.client.CaasStub.GetAplicacionBuscadaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAplicacionBuscada operation
           */
            public void receiveErrorgetAplicacionBuscada(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateUser method
            * override this method for handling normal response from validateUser operation
            */
           public void receiveResultvalidateUser(
                    co.com.coomeva.profile.ws.client.CaasStub.ValidateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateUser operation
           */
            public void receiveErrorvalidateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getApplicationStructure method
            * override this method for handling normal response from getApplicationStructure operation
            */
           public void receiveResultgetApplicationStructure(
                    co.com.coomeva.profile.ws.client.CaasStub.GetApplicationStructureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getApplicationStructure operation
           */
            public void receiveErrorgetApplicationStructure(java.lang.Exception e) {
            }
                


    }
    