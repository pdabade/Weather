package server;

import java.io.Serializable;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import compute.Task;

public class Weather implements Task<ArrayList <WeatherInfo> >, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ArrayList<String> zipcode;

	public Weather(ArrayList<String> zips) {
		// TODO Auto-generated constructor stub
		this.zipcode = zips;
	}

	@Override
	public ArrayList<WeatherInfo> execute() {
		// TODO Auto-generated method stub
		return getFullWeather(zipcode);
	}

	private ArrayList<WeatherInfo> getFullWeather(ArrayList<String> zipcode) {
		// TODO Auto-generated method stub
		ArrayList<WeatherInfo> weather_data = new ArrayList<WeatherInfo> ();
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		//String CONN_STRING = "jdbc:mysql://localhost/mysql?user=root&password=root";
		try{
		Class.forName(driver);
		//conn = DriverManager.getConnection(CONN_STRING);
		//conn = DriverManager.getConnection ("jdbc:mysql://localhost/weather","root","root");
		conn= DriverManager.getConnection( "jdbc:mysql://localhost:3306/weather","root","root");
		System.out.println("Connection done!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		WeatherInfo wi = new WeatherInfo();
		
		System.out.println("1");
		int count=0;
		// get rss feed from yahoo for every zip code
		try {
		for(int i=0;i<zipcode.size();i++)
		{
			System.out.println("2");
			String address = "http://weather.yahooapis.com/forecastrss?p=%s";
			String addr = String.format(address, zipcode.get(i));
			//System.out.println("3 " +addr);
			URL myURL;
			try {
				System.out.println("4");
				myURL = new URL(addr);
				SAXReader xmlReader = new SAXReader();
				Document feed = xmlReader.read(myURL);
				
				int val=0;
				float fval=0;				

				wi.setZip(zipcode.get(i));
				wi.setCity(feed.valueOf("/rss/channel/yweather:location/@city"));
				wi.setRegion(feed.valueOf("/rss/channel/yweather:location/@region"));
				wi.setCountry(feed.valueOf("/rss/channel/yweather:location/@country"));

				wi.setU_temperature(feed.valueOf("/rss/channel/yweather:units/@temperature"));
				wi.setU_distance(feed.valueOf("/rss/channel/yweather:units/@distance"));
				wi.setU_pressure(feed.valueOf("/rss/channel/yweather:units/@pressure"));
				wi.setU_speed(feed.valueOf("/rss/channel/yweather:units/@speed"));

				if(feed.valueOf("/rss/channel/yweather:wind/@chill")==null || (feed.valueOf("/rss/channel/yweather:wind/@chill")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/yweather:wind/@chill"));
				
				wi.setW_chill(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/yweather:wind/@direction")==null || (feed.valueOf("/rss/channel/yweather:wind/@direction")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/yweather:wind/@direction"));
				
				wi.setW_direction(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/yweather:wind/@speed")==null || (feed.valueOf("/rss/channel/yweather:wind/@speed")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/yweather:wind/@speed"));
				
				wi.setW_speed(Integer.toString(val));
				
				
				if(feed.valueOf("/rss/channel/yweather:atmosphere/@humidity")==null || (feed.valueOf("/rss/channel/yweather:atmosphere/@humidity")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/yweather:atmosphere/@humidity"));
				
				wi.setA_humidity(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/yweather:atmosphere/@visibility")==null || (feed.valueOf("/rss/channel/yweather:atmosphere/@visibility")).isEmpty())
					fval = 0;
				else
					fval = Float.parseFloat(feed.valueOf("/rss/channel/yweather:atmosphere/@visibility"));
				
				wi.setA_visibility(Float.toString(fval));
				
				
				if(feed.valueOf("/rss/channel/yweather:atmosphere/@pressure")==null || (feed.valueOf("/rss/channel/yweather:atmosphere/@pressure")).isEmpty())
					fval = 0;
				else
					fval = Float.parseFloat(feed.valueOf("/rss/channel/yweather:atmosphere/@pressure"));
				wi.setA_pressure(Float.toString(fval));
				
				if(feed.valueOf("/rss/channel/yweather:atmosphere/@rising")==null || (feed.valueOf("/rss/channel/yweather:atmosphere/@rising")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/yweather:atmosphere/@rising"));
				
				wi.setA_rising(Integer.toString(val));

				wi.setSunrise(feed.valueOf("/rss/channel/yweather:astronomy/@sunrise"));
				wi.setSunset(feed.valueOf("/rss/channel/yweather:astronomy/@sunset"));

				wi.setDay1(feed.valueOf("/rss/channel/item/yweather:forecast/@day"));
				wi.setDate1(feed.valueOf("/rss/channel/item/yweather:forecast/@date"));
				
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast/@low")==null || (feed.valueOf("/rss/channel/item/yweather:forecast/@low")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast/@low"));
				
				wi.setLow1(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast/@high")==null || (feed.valueOf("/rss/channel/item/yweather:forecast/@high")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast/@high"));
				
				wi.setHigh1(Integer.toString(val));				
				
				wi.setText1(feed.valueOf("/rss/channel/item/yweather:forecast/@text"));
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast/@code")==null || (feed.valueOf("/rss/channel/item/yweather:forecast/@code")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast/@code"));
				
				wi.setCode1(Integer.toString(val));
				
				wi.setDay2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@day"));
				wi.setDate2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@date"));
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@low")==null || (feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@low")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@low"));
				
				wi.setLow2(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@high")==null || (feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@high")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@high"));
				
				wi.setHigh2(Integer.toString(val));
				
				wi.setText2(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@text"));
				
				if(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@code")==null || (feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@code")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:forecast[last()]/@code"));
				wi.setCode2(Integer.toString(val));
				
				
				if(feed.valueOf("/rss/channel/item/geo:lat")==null || (feed.valueOf("/rss/channel/item/geo:lat")).isEmpty())
					fval = 0;
				else
					fval = Float.parseFloat(feed.valueOf("/rss/channel/item/geo:lat"));
				wi.setLatit(Float.toString(fval));
				
				if(feed.valueOf("/rss/channel/item/geo:long")==null || (feed.valueOf("/rss/channel/item/geo:long")).isEmpty())
					fval = 0;
				else
					fval = Float.parseFloat(feed.valueOf("/rss/channel/item/geo:long"));
				wi.setLongit(Float.toString(fval));
				
				wi.setText(feed.valueOf("/rss/channel/item/yweather:condition/@text"));
				
				if(feed.valueOf("/rss/channel/item/yweather:condition/@code")==null || (feed.valueOf("/rss/channel/item/yweather:condition/@code")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:condition/@code"));
				wi.setCode(Integer.toString(val));
				
				if(feed.valueOf("/rss/channel/item/yweather:condition/@temp")==null || (feed.valueOf("/rss/channel/item/yweather:condition/@temp")).isEmpty())
					val = 0;
				else
					val = Integer.parseInt(feed.valueOf("/rss/channel/item/yweather:condition/@temp"));
				wi.setTemp(Integer.toString(val));
				
				String date = feed.valueOf("/rss/channel/item/yweather:condition/@date");
				wi.setDate(date);
				weather_data.add(wi);
				System.out.println("5");
				// put all the information in the database
				
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Insert into weather.weather_info values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,wi.getZip());
				ps.setString(2,wi.getCity());
				ps.setString(3,wi.getRegion());
				ps.setString(4,wi.getCountry());
				ps.setString(5,wi.getDay1());
				ps.setString(6,wi.getDate1());
				ps.setString(7,wi.getLow1());
				ps.setString(8,wi.getHigh1());
				ps.setString(9,wi.getText1());
				ps.setString(10,wi.getCode1());
				ps.setString(11,wi.getSunrise());
				ps.setString(12,wi.getSunset());
				ps.setString(13,wi.getA_rising());
				ps.setString(14,wi.getA_pressure());
				ps.setString(15,wi.getA_visibility());
				ps.setString(16,wi.getA_humidity());
				ps.setString(17,wi.getU_distance());
				ps.setString(18,wi.getU_temperature());
				ps.setString(19,wi.getU_speed());
				ps.setString(20,wi.getU_pressure());
				ps.setString(21,wi.getW_chill());
				ps.setString(22,wi.getW_direction());
				ps.setString(23,wi.getW_speed());
				ps.setString(24,wi.getDay2());
				ps.setString(25,wi.getDate2());
				ps.setString(26,wi.getLow2());
				ps.setString(27,wi.getHigh2());
				ps.setString(28,wi.getText2());
				ps.setString(29,wi.getCode2());
				ps.setString(30,wi.getLatit());
				ps.setString(31,wi.getLongit());
				ps.setString(32,wi.getText());
				ps.setString(33,wi.getCode());
				ps.setString(34,wi.getTemp());
				ps.setString(35,wi.getDate());
				ps.executeUpdate();
					
				ps.close();
				count++;
				System.out.println("6");
			}catch(Exception e)
			{
				// TODO Auto-generated catch block
				System.out.println("error1 -- "+wi.getZip());
				System.out.println("error1 humid "+ wi.getA_humidity());
				System.out.println("error1 pressure "+ wi.getA_pressure());
				System.out.println("error1 rising "+ wi.getA_rising());
				System.out.println("error1 visibility "+ wi.getA_visibility());
				e.printStackTrace();
				Statement stmt;
				try {
					stmt = (Statement) conn.createStatement();

					stmt.executeUpdate("UPDATE weather.weather_info " +
							"SET city = '"+ wi.getCity()+ 
							"',region = '"+wi.getRegion()+
							"',country = '"+wi.getCountry()+
							"',day1 = '"+wi.getDay1()+
							"',date1 = '"+wi.getDate1()+
							"',low1 = "+wi.getLow1()+
							",high1 = "+wi.getHigh1()+
							",text1 = '"+wi.getText1()+
							"',code1 = "+wi.getCode1()+
							",sunrise = '"+wi.getSunrise()+
							"',sunset = '"+wi.getSunset()+
							"',a_rising = "+wi.getA_rising()+
							",a_pressure = "+wi.getA_pressure()+
							",a_visibility = "+wi.getA_visibility()+
							",a_humidity = "+wi.getA_humidity()+
							",u_distance = '"+wi.getU_distance()+
							"',u_temperature = '"+wi.getU_temperature()+
							"',u_speed = '"+wi.getU_speed()+
							"',u_pressure = '"+wi.getU_pressure()+
							"',w_chill = "+wi.getW_chill()+
							",w_direction = "+wi.getW_direction()+
							",w_speed = "+wi.getW_speed()+
							",day2 = '"+wi.getDay2()+
							"',date2 = '"+wi.getDate2()+
							"',low2 = "+wi.getLow2()+
							",high2 = '"+wi.getHigh2()+
							"',text2 = '"+wi.getText2()+
							"',code2 = "+wi.getCode2()+
							",latit = "+wi.getLatit()+
							",longit = '"+wi.getLongit()+
							"',text = '"+wi.getText()+
							"',code = "+wi.getCode()+
							",temp = "+wi.getTemp()+
							",date = '"+wi.getDate()+
							"' WHERE zip = '"+wi.getZip()+"' AND date = '"+wi.getDate()+"' ");
					stmt.close();
					count++;
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		weather_data.add(wi);
		System.out.println("Count = "+count);
		return weather_data;
	}
}
