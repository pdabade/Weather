package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxTemp {
	
	public WeatherInfo maxTemp(String zip,String city)
	{
		WeatherInfo wi = new WeatherInfo();
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","root","root");

			stmt = conn.createStatement();
			ResultSet results;
			
			if(zip == null && city == null)
			{
				wi.setErrorMsg("Zip/City Missing");
				return wi;
			}
			
			String SQLString = "SELECT max(temp),u_temperature,zip,city from weather_info where zip = '" + zip + "';";
			if(zip.isEmpty())
			{
				SQLString = "SELECT max(temp),u_temperature,zip,city from weather_info where city = '" + city + "';";
			}
			results = stmt.executeQuery(SQLString);
			if (results.next()) {
				wi.setTemp(results.getString(1));
				wi.setU_temperature(results.getString(2));
				wi.setZip(results.getString(3));
				wi.setCity(results.getString(4));
			}
			System.out.println("Max Temp @"+ wi.getCity()+": "+wi.getTemp()+ " " + wi.getU_temperature());
			
			return wi;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			wi.setErrorMsg("Error");
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
