package com.test.prediction.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class forecastDaysDataVO {

	private String date;
	
	@JsonProperty("hour")
	private forecastHoursData[] hoursData;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public forecastHoursData[] getHoursData() {
		return hoursData;
	}

	public void setHoursData(forecastHoursData[] hoursData) {
		this.hoursData = hoursData;
	} 
	
	
}
