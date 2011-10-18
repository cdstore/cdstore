package ws;

public class Khaled2Proxy implements ws.Khaled2 {
  private String _endpoint = null;
  private ws.Khaled2 khaled2 = null;
  
  public Khaled2Proxy() {
    _initKhaled2Proxy();
  }
  
  public Khaled2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initKhaled2Proxy();
  }
  
  private void _initKhaled2Proxy() {
    try {
      khaled2 = (new ws.Khaled2ServiceLocator()).getKhaled2Port();
      if (khaled2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)khaled2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)khaled2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (khaled2 != null)
      ((javax.xml.rpc.Stub)khaled2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.Khaled2 getKhaled2() {
    if (khaled2 == null)
      _initKhaled2Proxy();
    return khaled2;
  }
  
  public java.lang.String get(java.lang.String arg0) throws java.rmi.RemoteException{
    if (khaled2 == null)
      _initKhaled2Proxy();
    return khaled2.get(arg0);
  }
  
  
}