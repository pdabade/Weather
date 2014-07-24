/**
 * TempDateService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tools;

public interface TempDateService extends javax.xml.rpc.Service {
    public java.lang.String getTempDateAddress();

    public tools.TempDate getTempDate() throws javax.xml.rpc.ServiceException;

    public tools.TempDate getTempDate(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
