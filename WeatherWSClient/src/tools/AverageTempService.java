/**
 * AverageTempService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public interface AverageTempService extends javax.xml.rpc.Service {
    public java.lang.String getAverageTempAddress();

    public tools.AverageTemp getAverageTemp() throws javax.xml.rpc.ServiceException;

    public tools.AverageTemp getAverageTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
