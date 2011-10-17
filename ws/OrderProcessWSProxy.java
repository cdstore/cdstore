package ws;

public class OrderProcessWSProxy implements ws.OrderProcessWS {
  private String _endpoint = null;
  private ws.OrderProcessWS orderProcessWS = null;
  
  public OrderProcessWSProxy() {
    _initOrderProcessWSProxy();
  }
  
  public OrderProcessWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initOrderProcessWSProxy();
  }
  
  private void _initOrderProcessWSProxy() {
    try {
      orderProcessWS = (new ws.OrderProcessWSServiceLocator()).getOrderProcessWS();
      if (orderProcessWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)orderProcessWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)orderProcessWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (orderProcessWS != null)
      ((javax.xml.rpc.Stub)orderProcessWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.OrderProcessWS getOrderProcessWS() {
    if (orderProcessWS == null)
      _initOrderProcessWSProxy();
    return orderProcessWS;
  }
  
  public java.lang.String createOrder(java.lang.String str) throws java.rmi.RemoteException{
    if (orderProcessWS == null)
      _initOrderProcessWSProxy();
    return orderProcessWS.createOrder(str);
  }
  
  public java.lang.String createAccount(java.lang.String str) throws java.rmi.RemoteException{
    if (orderProcessWS == null)
      _initOrderProcessWSProxy();
    return orderProcessWS.createAccount(str);
  }
  
  public java.lang.String getAccount(int number) throws java.rmi.RemoteException{
    if (orderProcessWS == null)
      _initOrderProcessWSProxy();
    return orderProcessWS.getAccount(number);
  }
  
  
}