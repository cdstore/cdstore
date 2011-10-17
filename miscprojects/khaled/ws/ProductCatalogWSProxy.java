package ws;

public class ProductCatalogWSProxy implements ws.ProductCatalogWS {
  private String _endpoint = null;
  private ws.ProductCatalogWS productCatalogWS = null;
  
  public ProductCatalogWSProxy() {
    _initProductCatalogWSProxy();
  }
  
  public ProductCatalogWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initProductCatalogWSProxy();
  }
  
  private void _initProductCatalogWSProxy() {
    try {
      productCatalogWS = (new ws.ProductCatalogWSServiceLocator()).getProductCatalogWS();
      if (productCatalogWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)productCatalogWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)productCatalogWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (productCatalogWS != null)
      ((javax.xml.rpc.Stub)productCatalogWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.ProductCatalogWS getProductCatalogWS() {
    if (productCatalogWS == null)
      _initProductCatalogWSProxy();
    return productCatalogWS;
  }
  
  public java.lang.String getCategories() throws java.rmi.RemoteException{
    if (productCatalogWS == null)
      _initProductCatalogWSProxy();
    return productCatalogWS.getCategories();
  }
  
  public java.lang.String getCDsByCategory(int category) throws java.rmi.RemoteException{
    if (productCatalogWS == null)
      _initProductCatalogWSProxy();
    return productCatalogWS.getCDsByCategory(category);
  }
  
  
}