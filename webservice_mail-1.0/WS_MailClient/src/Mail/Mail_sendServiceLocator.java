/**
 * Mail_sendServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Mail;

public class Mail_sendServiceLocator extends org.apache.axis.client.Service implements Mail.Mail_sendService {

    public Mail_sendServiceLocator() {
    }


    public Mail_sendServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Mail_sendServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for mail_send
    private java.lang.String mail_send_address = "http://localhost:8080/WS_Mail/services/mail_send";

    public java.lang.String getmail_sendAddress() {
        return mail_send_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String mail_sendWSDDServiceName = "mail_send";

    public java.lang.String getmail_sendWSDDServiceName() {
        return mail_sendWSDDServiceName;
    }

    public void setmail_sendWSDDServiceName(java.lang.String name) {
        mail_sendWSDDServiceName = name;
    }

    public Mail.Mail_send getmail_send() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(mail_send_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getmail_send(endpoint);
    }

    public Mail.Mail_send getmail_send(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Mail.Mail_sendSoapBindingStub _stub = new Mail.Mail_sendSoapBindingStub(portAddress, this);
            _stub.setPortName(getmail_sendWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setmail_sendEndpointAddress(java.lang.String address) {
        mail_send_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Mail.Mail_send.class.isAssignableFrom(serviceEndpointInterface)) {
                Mail.Mail_sendSoapBindingStub _stub = new Mail.Mail_sendSoapBindingStub(new java.net.URL(mail_send_address), this);
                _stub.setPortName(getmail_sendWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("mail_send".equals(inputPortName)) {
            return getmail_send();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Mail", "mail_sendService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Mail", "mail_send"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("mail_send".equals(portName)) {
            setmail_sendEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
