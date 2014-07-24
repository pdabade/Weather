package server;

import java.io.Serializable;

public class WeatherInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String zip;
	private String city,region,country;	
	private String longit,latit;
	private String u_temperature,u_distance,u_pressure,u_speed;	
	private String w_chill,w_direction,w_speed;	
	private String a_humidity,a_visibility,a_pressure,a_rising;	
	private String sunrise,sunset;	
	private String day1,date1,low1,high1,text1,code1;
	private String day2,date2,low2,high2,text2,code2;
	private String text, code, temp,date;
	private String errorMsg;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLongit() {
		return longit;
	}
	public void setLongit(String longit) {
		this.longit = longit;
	}
	public String getLatit() {
		return latit;
	}
	public void setLatit(String latit) {
		this.latit = latit;
	}
	public String getU_temperature() {
		return u_temperature;
	}
	public void setU_temperature(String u_temperature) {
		this.u_temperature = u_temperature;
	}
	public String getU_distance() {
		return u_distance;
	}
	public void setU_distance(String u_distance) {
		this.u_distance = u_distance;
	}
	public String getU_pressure() {
		return u_pressure;
	}
	public void setU_pressure(String u_pressure) {
		this.u_pressure = u_pressure;
	}
	public String getU_speed() {
		return u_speed;
	}
	public void setU_speed(String u_speed) {
		this.u_speed = u_speed;
	}
	public String getW_chill() {
		return w_chill;
	}
	public void setW_chill(String w_chill) {
		this.w_chill = w_chill;
	}
	public String getW_direction() {
		return w_direction;
	}
	public void setW_direction(String w_direction) {
		this.w_direction = w_direction;
	}
	public String getW_speed() {
		return w_speed;
	}
	public void setW_speed(String w_speed) {
		this.w_speed = w_speed;
	}
	public String getA_humidity() {
		return a_humidity;
	}
	public void setA_humidity(String a_humidity) {
		this.a_humidity = a_humidity;
	}
	public String getA_visibility() {
		return a_visibility;
	}
	public void setA_visibility(String a_visibility) {
		this.a_visibility = a_visibility;
	}
	public String getA_pressure() {
		return a_pressure;
	}
	public void setA_pressure(String a_pressure) {
		this.a_pressure = a_pressure;
	}
	public String getA_rising() {
		return a_rising;
	}
	public void setA_rising(String a_rising) {
		this.a_rising = a_rising;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getLow1() {
		return low1;
	}
	public void setLow1(String low1) {
		this.low1 = low1;
	}
	public String getHigh1() {
		return high1;
	}
	public void setHigh1(String high1) {
		this.high1 = high1;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getLow2() {
		return low2;
	}
	public void setLow2(String low2) {
		this.low2 = low2;
	}
	public String getHigh2() {
		return high2;
	}
	public void setHigh2(String high2) {
		this.high2 = high2;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
}
