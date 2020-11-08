package com.test.prediction.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponseVO {
	
	@JsonProperty("forecast")
	private ForecastVO forecast;
	private CityVO location;

	public ForecastVO getForecast() {
		return forecast;
	}

	public void setForecast(ForecastVO forecast) {
		this.forecast = forecast;
	}

	public CityVO getLocation() {
		return location;
	}

	public void setLocation(CityVO location) {
		this.location = location;
	}
	
	
	
	
}


