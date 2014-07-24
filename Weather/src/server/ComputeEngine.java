package server;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute{
	public ComputeEngine() {
        super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }
    
    public String[] getWeatherData(String zip,String city,String date)
    {
    	String data[] = new String[15];
		Connection conn = null;
		Statement stmt = null;
		String er[] = new String[1];

    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  (Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/weather", "root","root");

			stmt = conn.createStatement();
			ResultSet results;
			String SQLString = null;
			
			if(zip==null || zip.isEmpty())
			{
				if(city==null || city.isEmpty())
				{
					er[0]="Zip and City Missing";
					return er;
				}
			}
			
			if(zip == null || zip.isEmpty())
			{
				System.out.println(city);
				SQLString = "Select zip from weather.weather_info where city = '"+city+"' and date1='"+date+"';";
				results = stmt.executeQuery(SQLString);
				if(results.next())
				{
					zip = results.getString(1);
					System.out.println(zip);
				}
				else
				{
					Format formatter = new SimpleDateFormat("dd MMM yyyy");
				    String s = formatter.format(new Date());
				    if(s.indexOf('0')==0)
				    	s=s.substring(1);
				    SQLString = "Select zip from weather.weather_info where city = '"+city+"' and date1='"+s+"';";
					results = stmt.executeQuery(SQLString);
					if(results.next())
					{
						zip = results.getString(1);
						System.out.println(zip);
					}
					else
					{
						er[0]="Data Unavailable";
						return er;
					}
				}
				if(zip==null || "".equalsIgnoreCase(zip)|| zip.isEmpty())
				{
					er[0]="Data Unavailable";
					return er;
				}
			}
			
			

			Format formatter = new SimpleDateFormat("dd MMM yyyy");
		    String s = formatter.format(new Date());
		    if(s.indexOf('0')==0)
		    	s=s.substring(1);
		    
			SQLString = "Select * from weather.weather_info where zip = '"+zip+"' and date1 ='"+s+"' ;";
			results = stmt.executeQuery(SQLString);
//			String address = "http://weather.yahooapis.com/forecastrss?p=%s";
//    		String addr = String.format(address, zip);
//    		URL myURL = new URL(addr);
//    		SAXReader xmlReader = new SAXReader();
//    		Document feed = xmlReader.read(myURL);
    		
    		if(results.next())
    		{
    			data[0] = zip+", "+results.getString(2)
        		+", "+results.getString(3)
        		+", "+results.getString(4);
    			data[1] = results.getString(9);
    			data[2] = results.getString(6);
    			data[3] = results.getString(34)
    			+" "+results.getString(18);
    			data[4] = "Sun Rise at    : "+results.getString(11);
    			data[5] = "Sun Set at     : "+results.getString(12);
    			
    			data[6] = "High           : "+results.getString(8)+" "+results.getString(18);
    			data[7] = "Low            : "+results.getString(7)+" "+results.getString(18);
    			data[8] = "Barometer      : "+results.getString(14)+" "+results.getString(20);
    			data[9] = "Visibility     : "+results.getString(15)+" "+results.getString(17);
    			data[10] ="Humidity       : "+results.getString(16)+" %";
    			data[11] ="Wind chill     : "+results.getString(21)+" "+results.getString(18);
    			data[12] ="Wind direction : "+results.getString(22)+" degrees";
    			data[13] ="Wind speed     : "+results.getString(23)+" "+results.getString(17);
    						
    			return data;
    		}
    		
//    		if(feed.valueOf("/rss/channel/item/yweather:condition/@temp")==null || feed.valueOf("/rss/channel/item/yweather:condition/@temp").equalsIgnoreCase("null")|| "".equals(feed.valueOf("/rss/channel/item/yweather:condition/@temp")))
//    		{
//    			er[0]=new String("Data Unavailable.");
//    			return er;
//    		}
//    		
//    		data[0] = zip+", "+feed.valueOf("/rss/channel/yweather:location/@city")
//    		+", "+feed.valueOf("/rss/channel/yweather:location/@region")
//    		+", "+feed.valueOf("/rss/channel/yweather:location/@country");
//			data[1] = feed.valueOf("/rss/channel/item/yweather:condition/@text");
//			data[2] = feed.valueOf("/rss/channel/item/yweather:forecast/@date");
//			data[3] = "Temperature    : "+feed.valueOf("/rss/channel/item/yweather:condition/@temp")
//			+" "+feed.valueOf("/rss/channel/yweather:units/@temperature");
//			data[4] = "Sun Rise at    : "+feed.valueOf("/rss/channel/yweather:astronomy/@sunrise");
//			data[5] = "Sun Set at     : "+feed.valueOf("/rss/channel/yweather:astronomy/@sunset");
//			
//			data[6] = "High           : "+feed.valueOf("/rss/channel/item/yweather:forecast/@high")+" "+feed.valueOf("/rss/channel/yweather:units/@temperature");
//			data[7] = "Low            : "+feed.valueOf("/rss/channel/item/yweather:forecast/@low")+" "+feed.valueOf("/rss/channel/yweather:units/@temperature");
//			data[8] = "Barometer      : "+feed.valueOf("/rss/channel/yweather:atmosphere/@pressure")+" "+feed.valueOf("/rss/channel/yweather:units/@pressure");
//			data[9] = "Visibility     : "+feed.valueOf("/rss/channel/yweather:atmosphere/@visibility")+" "+feed.valueOf("/rss/channel/yweather:units/@distance");
//			data[10] ="Humidity       : "+feed.valueOf("/rss/channel/yweather:atmosphere/@humidity")+" %";
//			data[11] ="Wind chill     : "+feed.valueOf("/rss/channel/yweather:wind/@chill")+" "+feed.valueOf("/rss/channel/yweather:units/@temperature");
//			data[12] ="Wind direction : "+feed.valueOf("/rss/channel/yweather:wind/@direction")+" degrees";
//			data[13] ="Wind speed     : "+feed.valueOf("/rss/channel/yweather:wind/@speed")+" "+feed.valueOf("/rss/channel/yweather:units/@distance");
//						
//			return data;

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// make sure that we are not wasting resources
				if (stmt != null)
					stmt.close();

				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
    	
    }
    
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
        	System.out.println("Starting Server");
        	Compute engine = new ComputeEngine();
	 
		    Registry registry = LocateRegistry.createRegistry(1011);
	            System.out.println("Created registry");
	 
		    Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
	            System.out.println("Exported Server");
	 
		    // Bind the remote object's stub in the registry
		    registry.rebind("Compute", stub);
	        System.out.println("Bound ComputeEngine to \"Compute\"");
	
        } catch (Exception e) {
            System.err.println("ComputeEngine exception: " +e);
            e.printStackTrace();
        }
    }

}
