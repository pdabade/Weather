package tools;

public class MinTempProxy implements tools.MinTemp {
  private String _endpoint = null;
  private tools.MinTemp minTemp = null;
  
  public MinTempProxy() {
    _initMinTempProxy();
  }
  
  public MinTempProxy(String endpoint) {
    _endpoint = endpoint;
    _initMinTempProxy();
  }
  
  private void _initMinTempProxy() {
    try {
      minTemp = (new tools.MinTempServiceLocator()).getMinTemp();
      if (minTemp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)minTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)minTemp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (minTemp != null)
      ((javax.xml.rpc.Stub)minTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.MinTemp getMinTemp() {
    if (minTemp == null)
      _initMinTempProxy();
    return minTemp;
  }
  
  public tools.WeatherInfo minTemp(java.lang.String zip, java.lang.String city) throws java.rmi.RemoteException{
    if (minTemp == null)
      _initMinTempProxy();
    return minTemp.minTemp(zip, city);
  }
  
  
}