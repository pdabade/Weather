package tools;

public class TwoDaysProxy implements tools.TwoDays {
  private String _endpoint = null;
  private tools.TwoDays twoDays = null;
  
  public TwoDaysProxy() {
    _initTwoDaysProxy();
  }
  
  public TwoDaysProxy(String endpoint) {
    _endpoint = endpoint;
    _initTwoDaysProxy();
  }
  
  private void _initTwoDaysProxy() {
    try {
      twoDays = (new tools.TwoDaysServiceLocator()).getTwoDays();
      if (twoDays != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)twoDays)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)twoDays)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (twoDays != null)
      ((javax.xml.rpc.Stub)twoDays)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.TwoDays getTwoDays() {
    if (twoDays == null)
      _initTwoDaysProxy();
    return twoDays;
  }
  
  public tools.WeatherInfo twoDaysData(java.lang.String zip, java.lang.String city) throws java.rmi.RemoteException{
    if (twoDays == null)
      _initTwoDaysProxy();
    return twoDays.twoDaysData(zip, city);
  }
  
  
}