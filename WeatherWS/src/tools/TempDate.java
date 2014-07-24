package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// to get weather details for a particular date of the week
public class TempDate {
	
	public WeatherInfo tempDate(String zip, String city,String date)
	{
		WeatherInfo wi = new WeatherInfo();
		
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","root","root");

			stmt = conn.createStatement();
			ResultSet results;
			
			if(date.isEmpty())
			{
				Calendar currentDate = Calendar.getInstance();
				  SimpleDateFormat formatter= 
				  new SimpleDateFormat("dd MMM yyyy");
				  String dateNow = formatter.format(currentDate.getTime());
				  date = ""+dateNow;
			}
			
			if(zip.isEmpty() && city.isEmpty())
			{
				wi.setErrorMsg("Zip/City Missing");
				return wi;
			}
			
			String SQLString = null;
			
			if(zip.isEmpty())
			{
				SQLString = "Select * from weather.weather_info where date = '"+date+"' and city = '"+city+"';";
			}
			else
				SQLString = "Select * from weather.weather_info where date = '"+date+"' and zip = '"+zip+"';";
			
			results = stmt.executeQuery(SQLString);
			if (results.next()) {
				wi.setZip(results.getString(1));
				wi.setCity(results.getString(2));
				wi.setRegion(results.getString(3));
				wi.setCountry(results.getString(4));

				wi.setU_temperature(results.getString(5));
				wi.setU_distance(results.getString(6));
				wi.setU_pressure(results.getString(7));
				wi.setU_speed(results.getString(8));

				wi.setW_chill(results.getString(9));
				wi.setW_direction(results.getString(10));
				wi.setW_speed(results.getString(11));

				wi.setA_humidity(results.getString(12));
				wi.setA_visibility(results.getString(13));
				wi.setA_pressure(results.getString(14));
				wi.setA_rising(results.getString(15));

				wi.setSunrise(results.getString(16));
				wi.setSunset(results.getString(17));

				wi.setDay1(results.getString(18));
				wi.setDate1(results.getString(19));
				wi.setLow1(results.getString(20));
				wi.setHigh1(results.getString(21));
				wi.setText1(results.getString(22));
				wi.setCode1(results.getString(23));

				wi.setDay2(results.getString(24));
				wi.setDate2(results.getString(25));
				wi.setLow2(results.getString(26));
				wi.setHigh2(results.getString(27));
				wi.setText2(results.getString(28));
				wi.setCode2(results.getString(29));

				wi.setLatit(results.getString(30));
				wi.setLongit(results.getString(31));

				wi.setText(results.getString(32));
				wi.setCode(results.getString(33));
				wi.setTemp(results.getString(34));
				wi.setDate(results.getString(35));
			}
			System.out.println("Temp @"+ wi.getCity()+": "+wi.getTemp()+ " " + wi.getU_temperature());
			
			return wi;

		} catch (Exception e) {
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
			}
		}		
		return null;
		
	}

}
