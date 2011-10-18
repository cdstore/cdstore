package ws;

public class KhaledProxy implements ws.Khaled {
  private String _endpoint = null;
  private ws.Khaled khaled = null;
  
  public KhaledProxy() {
    _initKhaledProxy();
  }
  
  public KhaledProxy(String endpoint) {
    _endpoint = endpoint;
    _initKhaledProxy();
  }
  
  private void _initKhaledProxy() {
    try {
      khaled = (new ws.KhaledServiceLocator()).getKhaledPort();
      if (khaled != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)khaled)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)khaled)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (khaled != null)
      ((javax.xml.rpc.Stub)khaled)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.Khaled getKhaled() {
    if (khaled == null)
      _initKhaledProxy();
    return khaled;
  }
  
  public java.lang.String get(java.lang.String arg0) throws java.rmi.RemoteException{
    if (khaled == null)
      _initKhaledProxy();
    return khaled.get(arg0);
  }
  
  
}