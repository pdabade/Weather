package tools;


import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class GMaps {
	
	public WeatherInfo[] googleMap(String ori,String dest) {
		
		
		String addr = "http://maps.googleapis.com/maps/api/directions/xml?origin=" + ori + "&destination=" + dest + "&sensor=false&key=ABQIAAAASFD5LjpDObhr9xiig6X7QhSj7k5dki0B2TgSCxPjMq1BqYTXWhTvWZSm6MuataeP1oImNPxOCzoqaw";
		
		WeatherInfo[] wi = new WeatherInfo [50] ;
		
		boolean flag=false;
		int i=1,k=0;
		
		URL myURL;		
		
		try 
		{			
			myURL = new URL(addr);
			SAXReader xmlReader = new SAXReader();
			Document dfeed = xmlReader.read(myURL);
			
			while(true)
			{				
				String latit=dfeed.valueOf("/DirectionsResponse/route/leg/step["+i+"]/start_location/lat");
				String longit=dfeed.valueOf("/DirectionsResponse/route/leg/step["+i+"]/start_location/lng");
				
				if(latit == null || "".equalsIgnoreCase(latit))
					break;
				
				// Reverse Geocoding
				Thread.sleep(100);
				String reverseGeo = "http://maps.googleapis.com/maps/api/geocode/xml?"
					+ "latlng=" + latit + "," + longit + "&sensor=false&key=ABQIAAAASFD5LjpDObhr9xiig6X7QhSj7k5dki0B2TgSCxPjMq1BqYTXWhTvWZSm6MuataeP1oImNPxOCzoqaw";
				
				URL geo = new URL(reverseGeo);
				SAXReader geoXmlReader = new SAXReader();
				Document geoFeed = geoXmlReader.read(geo);
				String[] result = geoFeed.valueOf("/GeocodeResponse/result/formatted_address").split(",");
				
				if(result[1].charAt(0)==' ')
					result[1]=result[1].substring(1);
				String[] zip=result[2].split(" ");
				
				//System.out.println(latit+"   "+longit+"   "+result[1]+"   "+result[2]+"--"+zip[1]+"---"+zip[2]);
				
				for(int j=0;j<k;j++)
					if(wi[j].getCity().equalsIgnoreCase(result[1]))
						flag =true;
				
				if(flag==false)
				{
					wi[k] = new WeatherInfo();
					
					wi[k].setZip(zip[2]);
					wi[k].setCity(result[1]);
					wi[k].setLatit(latit);
					wi[k].setLongit(longit);
										
					String yahooaddress = "http://weather.yahooapis.com/forecastrss?p=%s";
					String address = String.format(yahooaddress, zip[2]);
					URL yahooURL = new URL(address);
					SAXReader yxmlReader = new SAXReader();
					Document feed = yxmlReader.read(yahooURL);
					
					//wi[k].setCity(feed.valueOf("/rss/channel/yweather:location/@city"));
					wi[k].setRegion(feed.valueOf("/rss/channel/yweather:location/@region"));
					wi[k].setCountry(feed.valueOf("/rss/channel/yweather:location/@country"));

					wi[k].setU_temperature(feed.valueOf("/rss/channel/yweather:units/@temperature"));
					wi[k].setU_distance(feed.valueOf("/rss/channel/yweather:units/@distance"));
					wi[k].setU_pressure(feed.valueOf("/rss/channel/yweather:units/@pressure"));
					wi[k].setU_speed(feed.valueOf("/rss/channel/yweather:units/@speed"));

					wi[k].setW_chill(feed.valueOf("/rss/channel/yweather:wind/@chill"));
					wi[k].setW_direction(feed.valueOf("/rss/channel/yweather:wind/@direction"));
					wi[k].setW_speed(feed.valueOf("/rss/channel/yweather:wind/@speed"));

					wi[k].setA_humidity(feed.valueOf("/rss/channel/yweather:atmosphere/@humidity"));
					wi[k].setA_visibility(feed.valueOf("/rss/channel/yweather:atmosphere/@visibility"));
					wi[k].setA_pressure(feed.valueOf("/rss/channel/yweather:atmosphere/@pressure"));
					wi[k].setA_rising(feed.valueOf("/rss/channel/yweather:atmosphere/@rising"));

					wi[k].setSunrise(feed.valueOf("/rss/channel/yweather:astronomy/@sunrise"));
					wi[k].setSunset(feed.valueOf("/rss/channel/yweather:astronomy/@sunset"));

					wi[k].setDay1(feed.valueOf("/rss/channel/item/yweather:forecast/@day"));
					wi[k].setDate1(feed.valueOf("/rss/channel/item/yweather:forecast/@date"));
					wi[k].setLow1(feed.valueOf("/rss/channel/item/yweather:forecast/@low"));
					wi[k].setHigh1(feed.valueOf("/rss/channel/item/yweather:forecast/@high"));
					wi[k].setText1(feed.valueOf("/rss/channel/item/yweather:forecast/@text"));
					wi[k].setCode1(feed.valueOf("/rss/channel/item/yweather:forecast/@code"));

					wi[k].setDay2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@day"));
					wi[k].setDate2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@date"));
					wi[k].setLow2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@low"));
					wi[k].setHigh2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@high"));
					wi[k].setText2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@text"));
					wi[k].setCode2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@code"));

					wi[k].setLatit(feed.valueOf("/rss/channel/item/geo:lat"));
					wi[k].setLongit(feed.valueOf("/rss/channel/item/geo:long"));

					wi[k].setText(feed.valueOf("/rss/channel/item/yweather:condition/@text"));
					wi[k].setCode(feed.valueOf("/rss/channel/item/yweather:condition/@code"));
					wi[k].setTemp(feed.valueOf("/rss/channel/item/yweather:condition/@temp"));
					wi[k].setDate(feed.valueOf("/rss/channel/item/yweather:condition/@date"));
					
					k++;
				}
				
				flag=false;
				i++;
			}
			
			wi[k-1].setExt("1");
			return wi;
		
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

}

