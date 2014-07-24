package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// to get a week's weather details for a zipcode
public class ByDate {
	
	public WeatherInfo[] dataByDate(String zip, String city, String day, String month,String year)
	{
		WeatherInfo[] wi = new WeatherInfo[10];
		if(zip.isEmpty() && city.isEmpty())
		{
			wi[0].setErrorMsg("Zip/City Missing");
			return wi;
		}
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","root","root");

			stmt = conn.createStatement();
			ResultSet results;
			String SQLString = new String();
			
			if(zip.isEmpty())
			{
				SQLString = "Select * from weather.weather_info where city = '"+city+"';";
			}
			else
				SQLString = "Select * from weather.weather_info where zip = '"+zip+"';";
			
			results = stmt.executeQuery(SQLString);
			int i=0;
			while (results.next()) {
				wi[i] = new WeatherInfo();
				wi[i].setZip(results.getString(1));
				wi[i].setCity(results.getString(2));
				wi[i].setRegion(results.getString(3));
				wi[i].setCountry(results.getString(4));

				wi[i].setU_temperature(results.getString(5));
				wi[i].setU_distance(results.getString(6));
				wi[i].setU_pressure(results.getString(7));
				wi[i].setU_speed(results.getString(8));

				wi[i].setW_chill(results.getString(9));
				wi[i].setW_direction(results.getString(10));
				wi[i].setW_speed(results.getString(11));

				wi[i].setA_humidity(results.getString(12));
				wi[i].setA_visibility(results.getString(13));
				wi[i].setA_pressure(results.getString(14));
				wi[i].setA_rising(results.getString(15));

				wi[i].setSunrise(results.getString(16));
				wi[i].setSunset(results.getString(17));

				wi[i].setDay1(results.getString(18));
				wi[i].setDate1(results.getString(19));
				wi[i].setLow1(results.getString(20));
				wi[i].setHigh1(results.getString(21));
				wi[i].setText1(results.getString(22));
				wi[i].setCode1(results.getString(23));

				wi[i].setDay2(results.getString(24));
				wi[i].setDate2(results.getString(25));
				wi[i].setLow2(results.getString(26));
				wi[i].setHigh2(results.getString(27));
				wi[i].setText2(results.getString(28));
				wi[i].setCode2(results.getString(29));

				wi[i].setLatit(results.getString(30));
				wi[i].setLongit(results.getString(31));

				wi[i].setText(results.getString(32));
				wi[i].setCode(results.getString(33));
				wi[i].setTemp(results.getString(34));
				wi[i].setDate(results.getString(35));
				i++;
			}
			//System.out.println("Temp @"+ wi.getCity()+": "+wi.getTemp()+ " " + wi.getU_temperature());
			
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
