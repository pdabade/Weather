Weather
=======
1.	Description
-	Weather: contains RMI server(computeEngine.java) and client(ComputeWeather.java)
The client needs to be run once a day to fetch the weather related data from yahoo for every zip code. Zip codes are read from the provided csv file, which is also included in the Weather folder.
-	WSWeather
The Weather Web Service that queries the database to obtain weather related data and processes the data to provide various information such as the average temperature of a city over a period of one week, a quick overview of weather for the next two days, minimum and maximum temperatures of a city over a week’s period, weather for a particular date and so on.
-	WSWeatherClient
This is the web based client that contains the jsps for the above mentioned services.
2.	Requirements
- mysql version 5 or above, with a database ‘weather’ and table ‘weather_info’ with the following columns: zip, city, region, country, day1, date1, low1, high1, text1, code1, sunrise, sunset, a_rising, a_pressure, a_visibility, a_humidity, u_distance, u_pressure, u_temperature, u_speed, w_chill, w_direction, w_speed, day2, date2, low2, high2, text2, code2, latit, longit, text, code, temp and date.
- the username and password should be “root and “root” respectively.
- apache tomcat version 6 or above
- rmiregistry should be run in the background
- the project has been done using eclipse as IDE, hence setting of environment variables are taken care of by eclipse.
3.	How to run
-	Run the RMI registry
-	Run the RMI server from Weather folder as a Java Application
-	Run the RMI client from Weather folder as Java Application, to fetch weather related data from yahoo and store in db. This is needs to be run once a day (However, running it more than once will not cause any problem)
-	For the above steps, the class files are located in bin directories and java files are in src directories
-	The jsps in WSWeatherClient named as TestClient.jsp under the folder WSWeatherClient/WebContent/<the service name> are run on the server.
