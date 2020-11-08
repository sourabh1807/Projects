package com.test.prediction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.prediction.service.WeatherService;
import com.test.prediction.util.Constants;
import com.test.prediction.vo.ForecastResponseVO;
import com.test.prediction.vo.WeatherResponseVO;
import com.test.prediction.vo.forecastDaysDataVO;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${key}")
	private String key;
	
	@Value("${api.endpoint}")
	private String apiEndpoint;

	@Override
	public ForecastResponseVO callWeatherApi(String zipcode) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		
		String url = apiEndpoint+Constants.FORECAST_API;
		int days = Constants.DEFAULT_DAYS;
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
		        .queryParam("key", key)
		        .queryParam("q", zipcode)
		        .queryParam("days",days );
	
		WeatherResponseVO weatherResponseVO =  restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, new HttpEntity(headers),
        WeatherResponseVO.class).getBody();
		
		return prepareResponse(weatherResponseVO);
		
	}
	
   private ForecastResponseVO prepareResponse(WeatherResponseVO weatherResponseVO) {
		
		ForecastResponseVO responseVO = new ForecastResponseVO(); 
		
		//taking tomorrow's data from api
		forecastDaysDataVO forecastData = weatherResponseVO.getForecast().getForecastDay()[1];
		
		responseVO.setDate(forecastData.getDate());
		responseVO.setCity(weatherResponseVO.getLocation().getName());
		responseVO.setHoursData(forecastData.getHoursData());
		
		return responseVO;
		
		
	}

}
