/**
 * MaxTempService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public interface MaxTempService extends javax.xml.rpc.Service {
    public java.lang.String getMaxTempAddress();

    public tools.MaxTemp getMaxTemp() throws javax.xml.rpc.ServiceException;

    public tools.MaxTemp getMaxTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
