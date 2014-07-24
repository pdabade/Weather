/**
 * GMapsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public class GMapsServiceLocator extends org.apache.axis.client.Service implements tools.GMapsService {

    public GMapsServiceLocator() {
    }


    public GMapsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GMapsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GMaps
    private java.lang.String GMaps_address = "http://localhost:8080/WeatherWS/services/GMaps";

    public java.lang.String getGMapsAddress() {
        return GMaps_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GMapsWSDDServiceName = "GMaps";

    public java.lang.String getGMapsWSDDServiceName() {
        return GMapsWSDDServiceName;
    }

    public void setGMapsWSDDServiceName(java.lang.String name) {
        GMapsWSDDServiceName = name;
    }

    public tools.GMaps getGMaps() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(GMaps_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGMaps(endpoint);
    }

    public tools.GMaps getGMaps(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tools.GMapsSoapBindingStub _stub = new tools.GMapsSoapBindingStub(portAddress, this);
            _stub.setPortName(getGMapsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGMapsEndpointAddress(java.lang.String address) {
        GMaps_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tools.GMaps.class.isAssignableFrom(serviceEndpointInterface)) {
                tools.GMapsSoapBindingStub _stub = new tools.GMapsSoapBindingStub(new java.net.URL(GMaps_address), this);
                _stub.setPortName(getGMapsWSDDServiceName());
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
        if ("GMaps".equals(inputPortName)) {
            return getGMaps();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tools", "GMapsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tools", "GMaps"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("GMaps".equals(portName)) {
            setGMapsEndpointAddress(address);
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
