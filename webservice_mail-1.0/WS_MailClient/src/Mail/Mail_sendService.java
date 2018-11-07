/**
 * Mail_sendService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Mail;

public interface Mail_sendService extends javax.xml.rpc.Service {
    public java.lang.String getmail_sendAddress();

    public Mail.Mail_send getmail_send() throws javax.xml.rpc.ServiceException;

    public Mail.Mail_send getmail_send(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
