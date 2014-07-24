/**
 * AverageTempServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public class AverageTempServiceLocator extends org.apache.axis.client.Service implements tools.AverageTempService {

    public AverageTempServiceLocator() {
    }


    public AverageTempServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AverageTempServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AverageTemp
    private java.lang.String AverageTemp_address = "http://localhost:8080/WeatherWS/services/AverageTemp";

    public java.lang.String getAverageTempAddress() {
        return AverageTemp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AverageTempWSDDServiceName = "AverageTemp";

    public java.lang.String getAverageTempWSDDServiceName() {
        return AverageTempWSDDServiceName;
    }

    public void setAverageTempWSDDServiceName(java.lang.String name) {
        AverageTempWSDDServiceName = name;
    }

    public tools.AverageTemp getAverageTemp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AverageTemp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAverageTemp(endpoint);
    }

    public tools.AverageTemp getAverageTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tools.AverageTempSoapBindingStub _stub = new tools.AverageTempSoapBindingStub(portAddress, this);
            _stub.setPortName(getAverageTempWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAverageTempEndpointAddress(java.lang.String address) {
        AverageTemp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tools.AverageTemp.class.isAssignableFrom(serviceEndpointInterface)) {
                tools.AverageTempSoapBindingStub _stub = new tools.AverageTempSoapBindingStub(new java.net.URL(AverageTemp_address), this);
                _stub.setPortName(getAverageTempWSDDServiceName());
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
        if ("AverageTemp".equals(inputPortName)) {
            return getAverageTemp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tools", "AverageTempService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tools", "AverageTemp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AverageTemp".equals(portName)) {
            setAverageTempEndpointAddress(address);
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
