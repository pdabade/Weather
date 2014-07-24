package tools;

public class ByDateProxy implements tools.ByDate {
  private String _endpoint = null;
  private tools.ByDate byDate = null;
  
  public ByDateProxy() {
    _initByDateProxy();
  }
  
  public ByDateProxy(String endpoint) {
    _endpoint = endpoint;
    _initByDateProxy();
  }
  
  private void _initByDateProxy() {
    try {
      byDate = (new tools.ByDateServiceLocator()).getByDate();
      if (byDate != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)byDate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)byDate)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (byDate != null)
      ((javax.xml.rpc.Stub)byDate)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.ByDate getByDate() {
    if (byDate == null)
      _initByDateProxy();
    return byDate;
  }
  
  public tools.WeatherInfo[] dataByDate(java.lang.String zip, java.lang.String city) throws java.rmi.RemoteException{
    if (byDate == null)
      _initByDateProxy();
    return byDate.dataByDate(zip, city);
  }
  
  
}