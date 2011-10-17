package ws;
import java.rmi.*;

public class HabalProxy implements ws.Habal {
  private String _endpoint = null;
  private ws.Habal habal = null;
  
  public HabalProxy() {
    _initHabalProxy();
  }
  
  public HabalProxy(String endpoint) {
    _endpoint = endpoint;
    _initHabalProxy();
  }
  
  private void _initHabalProxy() {
    try {
      habal = (new ws.HabalServiceLocator()).getHabal();
      if (habal != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)habal)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)habal)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (habal != null)
      ((javax.xml.rpc.Stub)habal)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.Habal getHabal() {
    if (habal == null)
      _initHabalProxy();
    return habal;
  }
  
  public java.lang.String faflk(java.lang.String input) throws RemoteException{
    if (habal == null)
      _initHabalProxy();
    return habal.faflk(input);
  }
  
  public float farenheitToCelsius(float farenheit) throws RemoteException{
    if (habal == null)
      _initHabalProxy();
    return habal.farenheitToCelsius(farenheit);
  }
  
  
}