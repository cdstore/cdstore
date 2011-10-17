/**
 * ProductCatalogWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class ProductCatalogWSServiceLocator extends org.apache.axis.client.Service implements ws.ProductCatalogWSService {

    public ProductCatalogWSServiceLocator() {
    }


    public ProductCatalogWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProductCatalogWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProductCatalogWS
    private java.lang.String ProductCatalogWS_address = "http://localhost:8080/DreamteamCDStore/services/ProductCatalogWS";

    public java.lang.String getProductCatalogWSAddress() {
        return ProductCatalogWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProductCatalogWSWSDDServiceName = "ProductCatalogWS";

    public java.lang.String getProductCatalogWSWSDDServiceName() {
        return ProductCatalogWSWSDDServiceName;
    }

    public void setProductCatalogWSWSDDServiceName(java.lang.String name) {
        ProductCatalogWSWSDDServiceName = name;
    }

    public ws.ProductCatalogWS getProductCatalogWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProductCatalogWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProductCatalogWS(endpoint);
    }

    public ws.ProductCatalogWS getProductCatalogWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.ProductCatalogWSSoapBindingStub _stub = new ws.ProductCatalogWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getProductCatalogWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProductCatalogWSEndpointAddress(java.lang.String address) {
        ProductCatalogWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.ProductCatalogWS.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.ProductCatalogWSSoapBindingStub _stub = new ws.ProductCatalogWSSoapBindingStub(new java.net.URL(ProductCatalogWS_address), this);
                _stub.setPortName(getProductCatalogWSWSDDServiceName());
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
        if ("ProductCatalogWS".equals(inputPortName)) {
            return getProductCatalogWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws", "ProductCatalogWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws", "ProductCatalogWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProductCatalogWS".equals(portName)) {
            setProductCatalogWSEndpointAddress(address);
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
