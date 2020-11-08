package com.test.prediction.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class forecastHoursData {

	private String time;
	
	@JsonProperty("temp_c")
	private double temp;

	private String humidity;
	
	@JsonProperty("feelslike_c")
	private double feelsLikeTemp;
	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public double getFeelsLikeTemp() {
		return feelsLikeTemp;
	}

	public void setFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp = feelsLikeTemp;
	}
	
	
}
