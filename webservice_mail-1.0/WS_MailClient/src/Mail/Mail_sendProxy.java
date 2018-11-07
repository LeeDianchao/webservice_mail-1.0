package Mail;

public class Mail_sendProxy implements Mail.Mail_send {
  private String _endpoint = null;
  private Mail.Mail_send mail_send = null;
  
  public Mail_sendProxy() {
    _initMail_sendProxy();
  }
  
  public Mail_sendProxy(String endpoint) {
    _endpoint = endpoint;
    _initMail_sendProxy();
  }
  
  private void _initMail_sendProxy() {
    try {
      mail_send = (new Mail.Mail_sendServiceLocator()).getmail_send();
      if (mail_send != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mail_send)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mail_send)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mail_send != null)
      ((javax.xml.rpc.Stub)mail_send)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Mail.Mail_send getMail_send() {
    if (mail_send == null)
      _initMail_sendProxy();
    return mail_send;
  }
  
  public boolean sendEmailBatch(java.lang.String[] url, java.lang.String payload) throws java.rmi.RemoteException{
    if (mail_send == null)
      _initMail_sendProxy();
    return mail_send.sendEmailBatch(url, payload);
  }
  
  public boolean sendEmail(java.lang.String url, java.lang.String payload) throws java.rmi.RemoteException{
    if (mail_send == null)
      _initMail_sendProxy();
    return mail_send.sendEmail(url, payload);
  }
  
  public boolean validateEmailAddress(java.lang.String url) throws java.rmi.RemoteException{
    if (mail_send == null)
      _initMail_sendProxy();
    return mail_send.validateEmailAddress(url);
  }
  
  public boolean sendEmails(java.lang.String urls, java.lang.String payload) throws java.rmi.RemoteException{
    if (mail_send == null)
      _initMail_sendProxy();
    return mail_send.sendEmails(urls, payload);
  }
  
  
}