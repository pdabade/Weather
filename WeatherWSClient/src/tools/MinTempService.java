/**
 * MinTempService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public interface MinTempService extends javax.xml.rpc.Service {
    public java.lang.String getMinTempAddress();

    public tools.MinTemp getMinTemp() throws javax.xml.rpc.ServiceException;

    public tools.MinTemp getMinTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
