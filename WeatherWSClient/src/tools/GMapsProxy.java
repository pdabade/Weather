package tools;

public class GMapsProxy implements tools.GMaps {
  private String _endpoint = null;
  private tools.GMaps gMaps = null;
  
  public GMapsProxy() {
    _initGMapsProxy();
  }
  
  public GMapsProxy(String endpoint) {
    _endpoint = endpoint;
    _initGMapsProxy();
  }
  
  private void _initGMapsProxy() {
    try {
      gMaps = (new tools.GMapsServiceLocator()).getGMaps();
      if (gMaps != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)gMaps)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)gMaps)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (gMaps != null)
      ((javax.xml.rpc.Stub)gMaps)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tools.GMaps getGMaps() {
    if (gMaps == null)
      _initGMapsProxy();
    return gMaps;
  }
  
  public tools.WeatherInfo[] googleMap(java.lang.String ori, java.lang.String dest) throws java.rmi.RemoteException{
    if (gMaps == null)
      _initGMapsProxy();
    return gMaps.googleMap(ori, dest);
  }
  
  
}