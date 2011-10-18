/**
 * Khaled2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class Khaled2ServiceLocator extends org.apache.axis.client.Service implements ws.Khaled2Service {

    public Khaled2ServiceLocator() {
    }


    public Khaled2ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Khaled2ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Khaled2Port
    private java.lang.String Khaled2Port_address = "http://localhost:8080/CDStore/services";

    public java.lang.String getKhaled2PortAddress() {
        return Khaled2Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Khaled2PortWSDDServiceName = "Khaled2Port";

    public java.lang.String getKhaled2PortWSDDServiceName() {
        return Khaled2PortWSDDServiceName;
    }

    public void setKhaled2PortWSDDServiceName(java.lang.String name) {
        Khaled2PortWSDDServiceName = name;
    }

    public ws.Khaled2 getKhaled2Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Khaled2Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getKhaled2Port(endpoint);
    }

    public ws.Khaled2 getKhaled2Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.Khaled2ServiceSoapBindingStub _stub = new ws.Khaled2ServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getKhaled2PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setKhaled2PortEndpointAddress(java.lang.String address) {
        Khaled2Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.Khaled2.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.Khaled2ServiceSoapBindingStub _stub = new ws.Khaled2ServiceSoapBindingStub(new java.net.URL(Khaled2Port_address), this);
                _stub.setPortName(getKhaled2PortWSDDServiceName());
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
        if ("Khaled2Port".equals(inputPortName)) {
            return getKhaled2Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "Khaled2Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "Khaled2Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Khaled2Port".equals(portName)) {
            setKhaled2PortEndpointAddress(address);
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
