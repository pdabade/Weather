package tools;

public class TempDateProxy implements tools.TempDate {
  private String _endpoint = null;
  private tools.TempDate tempDate = null;
  
  public TempDateProxy() {
    _initTempDateProxy();
  }
  
  public TempDateProxy(String endpoint) {
    _endpoint = endpoint;
    _initTempDateProxy();
  }
  
  private void _initTempDateProxy() {
    try {
      tempDate = (new tools.TempDateServiceLocator()).getTempDate();
      if (tempDate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tempDate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tempDate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tempDate != null)
      ((javax.xml.rpc.Stub)tempDate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.TempDate getTempDate() {
    if (tempDate == null)
      _initTempDateProxy();
    return tempDate;
  }
  
  public tools.WeatherInfo tempDate(java.lang.String zip, java.lang.String city, java.lang.String date) throws java.rmi.RemoteException{
    if (tempDate == null)
      _initTempDateProxy();
    return tempDate.tempDate(zip, city, date);
  }
  
  
}