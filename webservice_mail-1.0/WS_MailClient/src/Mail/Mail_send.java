/**
 * Mail_send.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Mail;

public interface Mail_send extends java.rmi.Remote {
    public boolean sendEmailBatch(java.lang.String[] url, java.lang.String payload) throws java.rmi.RemoteException;
    public boolean sendEmail(java.lang.String url, java.lang.String payload) throws java.rmi.RemoteException;
    public boolean validateEmailAddress(java.lang.String url) throws java.rmi.RemoteException;
    public boolean sendEmails(java.lang.String urls, java.lang.String payload) throws java.rmi.RemoteException;
}
