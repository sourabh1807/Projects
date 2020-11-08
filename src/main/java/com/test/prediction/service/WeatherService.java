package com.test.prediction.service;

import com.test.prediction.vo.ForecastResponseVO;


public interface WeatherService {

	public ForecastResponseVO callWeatherApi(String zipcode);
}
