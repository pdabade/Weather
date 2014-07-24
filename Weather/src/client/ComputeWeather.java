package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import server.Weather;
import server.WeatherInfo;

import compute.Compute;

public class ComputeWeather {

	public static void main(String args[])
	{
		if (System.getSecurityManager()==null) 
		{
			System.setSecurityManager(new SecurityManager());
		}
		String host = (args.length < 1)? null:args[0];
		try
		{
			Registry registry = LocateRegistry.getRegistry(host,1011);
			//System.out.println("Registry located");
			Compute comp = (Compute)registry.lookup("Compute");
			//System.out.println("Compute looked up");
			
			//File CSVFile = new File("ZipCodes.csv");

			BufferedReader CSVFile  = new BufferedReader(new FileReader("ZipCodes.csv"));
			
			// Read first line, but it will contain the Header, so read the next line
			// immediately
			String dataRow = CSVFile.readLine();  
			dataRow = CSVFile.readLine();
			
			ArrayList<String> zips= new ArrayList<String>();
			
			while (dataRow != null)
			{
				String[] dataArray = dataRow.split(",");
				zips.add(dataArray[0]);
				dataRow = CSVFile.readLine();
			}
			// Close the file once all data has been read.
			CSVFile.close();

			Weather task = new Weather(zips);
			ArrayList  <WeatherInfo> all = comp.executeTask(task);
			/*for(WeatherInfo wi : all)
			{
				System.out.println(wi.getZip()+"\t"+wi.getCity()+"\t"+wi.getTemp()+wi.getU_temperature()+"\t\t"+wi.getLatit()+"\t"+wi.getLongit());
			}*/
			System.out.println("Do you wish to check today's weather? (y/n) ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if(br.readLine().equalsIgnoreCase("y"))
			{
				int n =1;
				while(n==1)
				{
					System.out.println("\n1.Enter Zip & Date \n2.Enter City & Date\n3.Exit");
					System.out.println("Enter your choice: ");
					BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
					String ch=br1.readLine();
					if(ch.equalsIgnoreCase("1"))
					{
						System.out.println("Enter zip code: ");
						BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
						String zip = br2.readLine();
						System.out.println("Enter date code (dd MMM yyyy): ");
						BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
						String date = br3.readLine();
						String response[] = comp.getWeatherData(zip,null,date);
			            if(response == null)
			            {
			            	System.out.println("Data Unavailable");
			            }
			            else if(response.length == 1)
			            {
			            	System.out.println(response[0]);
			            }
			            else
			            {
			            	System.out.println("Conditions at "+response[0]+" as of "+response[2]+"\n"+response[1]);
			            	for(int i=3;i<response.length;i++)
			            	{
			            		if(response[i]!=null)
			            		{
			            			System.out.println(response[i]);
			            		}
			            	}
			            }
					}
					else if(ch.equalsIgnoreCase("2"))
					{
						System.out.println("Enter city: ");
						BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
						String city = br4.readLine();
						System.out.println("Enter date code (dd MMM yyyy): ");
						BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
						String date = br5.readLine();
						System.out.println("city = "+city);
						String response[] = comp.getWeatherData(null,city,date);
			            if(response == null)
			            {
			            	System.out.println("Data Unavailable");
			            }
			            else if(response.length == 1)
			            {
			            	System.out.println(response[0]);
			            }
			            else
			            {
			            	System.out.println("Conditions at "+response[0]+" as of "+response[2]+"\n"+response[1]);
			            	for(int i=3;i<response.length;i++)
			            	{
			            		if(response[i]!=null)
			            		{
			            			System.out.println(response[i]);
			            		}
			            	}
			            }
					}
					else 
					{
						if(!(ch.equalsIgnoreCase("3")))
						{
							System.out.println("Incorrect input. Please try again.");
						}
						else
						{
							n=2;
							System.out.println("Have a good day!");
						}
					}
				}
				
			}

		}catch(Exception e)
		{
			 //e.printStackTrace();
		}
	}

}
