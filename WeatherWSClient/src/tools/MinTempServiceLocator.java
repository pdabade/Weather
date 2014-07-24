/**
 * MinTempServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public class MinTempServiceLocator extends org.apache.axis.client.Service implements tools.MinTempService {

    public MinTempServiceLocator() {
    }


    public MinTempServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MinTempServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MinTemp
    private java.lang.String MinTemp_address = "http://localhost:8080/WeatherWS/services/MinTemp";

    public java.lang.String getMinTempAddress() {
        return MinTemp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MinTempWSDDServiceName = "MinTemp";

    public java.lang.String getMinTempWSDDServiceName() {
        return MinTempWSDDServiceName;
    }

    public void setMinTempWSDDServiceName(java.lang.String name) {
        MinTempWSDDServiceName = name;
    }

    public tools.MinTemp getMinTemp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MinTemp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMinTemp(endpoint);
    }

    public tools.MinTemp getMinTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tools.MinTempSoapBindingStub _stub = new tools.MinTempSoapBindingStub(portAddress, this);
            _stub.setPortName(getMinTempWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMinTempEndpointAddress(java.lang.String address) {
        MinTemp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tools.MinTemp.class.isAssignableFrom(serviceEndpointInterface)) {
                tools.MinTempSoapBindingStub _stub = new tools.MinTempSoapBindingStub(new java.net.URL(MinTemp_address), this);
                _stub.setPortName(getMinTempWSDDServiceName());
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
        if ("MinTemp".equals(inputPortName)) {
            return getMinTemp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tools", "MinTempService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tools", "MinTemp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MinTemp".equals(portName)) {
            setMinTempEndpointAddress(address);
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
