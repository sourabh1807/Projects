package com.test.prediction.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastVO {

	@JsonProperty("forecastday")
	private forecastDaysDataVO[] forecastDay;

	public forecastDaysDataVO[] getForecastDay() {
		return forecastDay;
	}

	public void setForecastDay(forecastDaysDataVO[] forecastDay) {
		this.forecastDay = forecastDay;
	} 
	
	
}
