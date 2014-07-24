package tools;

public class TempConvertProxy implements tools.TempConvert {
  private String _endpoint = null;
  private tools.TempConvert tempConvert = null;
  
  public TempConvertProxy() {
    _initTempConvertProxy();
  }
  
  public TempConvertProxy(String endpoint) {
    _endpoint = endpoint;
    _initTempConvertProxy();
  }
  
  private void _initTempConvertProxy() {
    try {
      tempConvert = (new tools.TempConvertServiceLocator()).getTempConvert();
      if (tempConvert != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tempConvert)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tempConvert)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tempConvert != null)
      ((javax.xml.rpc.Stub)tempConvert)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.TempConvert getTempConvert() {
    if (tempConvert == null)
      _initTempConvertProxy();
    return tempConvert;
  }
  
  public float CToF(java.lang.String c) throws java.rmi.RemoteException{
    if (tempConvert == null)
      _initTempConvertProxy();
    return tempConvert.CToF(c);
  }
  
  public float FToC(java.lang.String f) throws java.rmi.RemoteException{
    if (tempConvert == null)
      _initTempConvertProxy();
    return tempConvert.FToC(f);
  }
  
  
}