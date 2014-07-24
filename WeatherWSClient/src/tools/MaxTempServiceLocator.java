/**
 * MaxTempServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public class MaxTempServiceLocator extends org.apache.axis.client.Service implements tools.MaxTempService {

    public MaxTempServiceLocator() {
    }


    public MaxTempServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MaxTempServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MaxTemp
    private java.lang.String MaxTemp_address = "http://localhost:8080/WeatherWS/services/MaxTemp";

    public java.lang.String getMaxTempAddress() {
        return MaxTemp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MaxTempWSDDServiceName = "MaxTemp";

    public java.lang.String getMaxTempWSDDServiceName() {
        return MaxTempWSDDServiceName;
    }

    public void setMaxTempWSDDServiceName(java.lang.String name) {
        MaxTempWSDDServiceName = name;
    }

    public tools.MaxTemp getMaxTemp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MaxTemp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMaxTemp(endpoint);
    }

    public tools.MaxTemp getMaxTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tools.MaxTempSoapBindingStub _stub = new tools.MaxTempSoapBindingStub(portAddress, this);
            _stub.setPortName(getMaxTempWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMaxTempEndpointAddress(java.lang.String address) {
        MaxTemp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tools.MaxTemp.class.isAssignableFrom(serviceEndpointInterface)) {
                tools.MaxTempSoapBindingStub _stub = new tools.MaxTempSoapBindingStub(new java.net.URL(MaxTemp_address), this);
                _stub.setPortName(getMaxTempWSDDServiceName());
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
        if ("MaxTemp".equals(inputPortName)) {
            return getMaxTemp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tools", "MaxTempService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tools", "MaxTemp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MaxTemp".equals(portName)) {
            setMaxTempEndpointAddress(address);
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
