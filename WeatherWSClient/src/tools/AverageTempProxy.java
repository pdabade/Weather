package tools;

public class AverageTempProxy implements tools.AverageTemp {
  private String _endpoint = null;
  private tools.AverageTemp averageTemp = null;
  
  public AverageTempProxy() {
    _initAverageTempProxy();
  }
  
  public AverageTempProxy(String endpoint) {
    _endpoint = endpoint;
    _initAverageTempProxy();
  }
  
  private void _initAverageTempProxy() {
    try {
      averageTemp = (new tools.AverageTempServiceLocator()).getAverageTemp();
      if (averageTemp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)averageTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)averageTemp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (averageTemp != null)
      ((javax.xml.rpc.Stub)averageTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.AverageTemp getAverageTemp() {
    if (averageTemp == null)
      _initAverageTempProxy();
    return averageTemp;
  }
  
  public tools.WeatherInfo avgTemp(java.lang.String zip, java.lang.String city) throws java.rmi.RemoteException{
    if (averageTemp == null)
      _initAverageTempProxy();
    return averageTemp.avgTemp(zip, city);
  }
  
  
}