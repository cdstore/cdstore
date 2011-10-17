/**
 * OrderProcessWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class OrderProcessWSServiceLocator extends org.apache.axis.client.Service implements ws.OrderProcessWSService {

    public OrderProcessWSServiceLocator() {
    }


    public OrderProcessWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OrderProcessWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OrderProcessWS
    private java.lang.String OrderProcessWS_address = "http://localhost:8080/DreamteamCDStore/services/OrderProcessWS";

    public java.lang.String getOrderProcessWSAddress() {
        return OrderProcessWS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OrderProcessWSWSDDServiceName = "OrderProcessWS";

    public java.lang.String getOrderProcessWSWSDDServiceName() {
        return OrderProcessWSWSDDServiceName;
    }

    public void setOrderProcessWSWSDDServiceName(java.lang.String name) {
        OrderProcessWSWSDDServiceName = name;
    }

    public ws.OrderProcessWS getOrderProcessWS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OrderProcessWS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOrderProcessWS(endpoint);
    }

    public ws.OrderProcessWS getOrderProcessWS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.OrderProcessWSSoapBindingStub _stub = new ws.OrderProcessWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getOrderProcessWSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOrderProcessWSEndpointAddress(java.lang.String address) {
        OrderProcessWS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.OrderProcessWS.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.OrderProcessWSSoapBindingStub _stub = new ws.OrderProcessWSSoapBindingStub(new java.net.URL(OrderProcessWS_address), this);
                _stub.setPortName(getOrderProcessWSWSDDServiceName());
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
        if ("OrderProcessWS".equals(inputPortName)) {
            return getOrderProcessWS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws", "OrderProcessWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws", "OrderProcessWS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OrderProcessWS".equals(portName)) {
            setOrderProcessWSEndpointAddress(address);
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
