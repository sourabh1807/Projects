package com.test.prediction.vo;



public class ForecastResponseVO {

	private String date;
	private forecastHoursData[] hoursData;
	private String city;
	private String errorMessage;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public forecastHoursData[] getHoursData() {
		return hoursData;
	}
	public void setHoursData(forecastHoursData[] hoursData) {
		this.hoursData = hoursData;
	}

	
	
}
