/**
 * KhaledServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class KhaledServiceLocator extends org.apache.axis.client.Service implements ws.KhaledService {

    public KhaledServiceLocator() {
    }


    public KhaledServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public KhaledServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for KhaledPort
    private java.lang.String KhaledPort_address = "http://localhost:8080/CDStore/services";

    public java.lang.String getKhaledPortAddress() {
        return KhaledPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String KhaledPortWSDDServiceName = "KhaledPort";

    public java.lang.String getKhaledPortWSDDServiceName() {
        return KhaledPortWSDDServiceName;
    }

    public void setKhaledPortWSDDServiceName(java.lang.String name) {
        KhaledPortWSDDServiceName = name;
    }

    public ws.Khaled getKhaledPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(KhaledPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getKhaledPort(endpoint);
    }

    public ws.Khaled getKhaledPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.KhaledServiceSoapBindingStub _stub = new ws.KhaledServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getKhaledPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setKhaledPortEndpointAddress(java.lang.String address) {
        KhaledPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.Khaled.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.KhaledServiceSoapBindingStub _stub = new ws.KhaledServiceSoapBindingStub(new java.net.URL(KhaledPort_address), this);
                _stub.setPortName(getKhaledPortWSDDServiceName());
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
        if ("KhaledPort".equals(inputPortName)) {
            return getKhaledPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "KhaledService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "KhaledPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("KhaledPort".equals(portName)) {
            setKhaledPortEndpointAddress(address);
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
