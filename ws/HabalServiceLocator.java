/**
 * HabalServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class HabalServiceLocator extends org.apache.axis.client.Service implements ws.HabalService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HabalServiceLocator() {
    }


    public HabalServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HabalServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Habal
    private java.lang.String Habal_address = "http://localhost:8080/DreamteamCDStore/services/Habal";

    public java.lang.String getHabalAddress() {
        return Habal_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HabalWSDDServiceName = "Habal";

    public java.lang.String getHabalWSDDServiceName() {
        return HabalWSDDServiceName;
    }

    public void setHabalWSDDServiceName(java.lang.String name) {
        HabalWSDDServiceName = name;
    }

    public ws.Habal getHabal() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Habal_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHabal(endpoint);
    }

    public ws.Habal getHabal(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.HabalSoapBindingStub _stub = new ws.HabalSoapBindingStub(portAddress, this);
            _stub.setPortName(getHabalWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHabalEndpointAddress(java.lang.String address) {
        Habal_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.Habal.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.HabalSoapBindingStub _stub = new ws.HabalSoapBindingStub(new java.net.URL(Habal_address), this);
                _stub.setPortName(getHabalWSDDServiceName());
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
        if ("Habal".equals(inputPortName)) {
            return getHabal();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws", "HabalService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws", "Habal"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Habal".equals(portName)) {
            setHabalEndpointAddress(address);
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
