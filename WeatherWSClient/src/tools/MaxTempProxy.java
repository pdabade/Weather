package tools;

public class MaxTempProxy implements tools.MaxTemp {
  private String _endpoint = null;
  private tools.MaxTemp maxTemp = null;
  
  public MaxTempProxy() {
    _initMaxTempProxy();
  }
  
  public MaxTempProxy(String endpoint) {
    _endpoint = endpoint;
    _initMaxTempProxy();
  }
  
  private void _initMaxTempProxy() {
    try {
      maxTemp = (new tools.MaxTempServiceLocator()).getMaxTemp();
      if (maxTemp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)maxTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)maxTemp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (maxTemp != null)
      ((javax.xml.rpc.Stub)maxTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.MaxTemp getMaxTemp() {
    if (maxTemp == null)
      _initMaxTempProxy();
    return maxTemp;
  }
  
  public tools.WeatherInfo maxTemp(java.lang.String zip, java.lang.String city) throws java.rmi.RemoteException{
    if (maxTemp == null)
      _initMaxTempProxy();
    return maxTemp.maxTemp(zip, city);
  }
  
  
}