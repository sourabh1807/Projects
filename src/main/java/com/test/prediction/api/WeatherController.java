package com.test.prediction.api;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.prediction.exception.InvalidInputException;
import com.test.prediction.service.WeatherService;
import com.test.prediction.util.Constants;
import com.test.prediction.vo.ForecastResponseVO;


@RestController
public class WeatherController {
	
    @Autowired
	private WeatherService weatherService;
   	

	@GetMapping("/forecastTemperature/{zipcode}")
	public ForecastResponseVO getForecastTemp(@PathVariable String zipcode ) throws InvalidInputException {
		
		 Pattern pattern = Pattern.compile(Constants.US_ZIPCODE_REGEX);
		 
		 Matcher matcher = pattern.matcher(zipcode); 
		
		 if(!matcher.find()) {
			 throw new InvalidInputException("incorrect zipcode");
		 }
		
		return weatherService.callWeatherApi(zipcode);
		
	}

	
}
