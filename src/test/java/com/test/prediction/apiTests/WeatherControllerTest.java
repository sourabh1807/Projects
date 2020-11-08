package com.test.prediction.apiTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.test.prediction.api.WeatherController;
import com.test.prediction.exception.InvalidInputException;
import com.test.prediction.service.WeatherService;
import com.test.prediction.vo.ForecastResponseVO;
import static org.mockito.Mockito.when;

public class WeatherControllerTest {

	@InjectMocks
	private WeatherController weatherController;

	@Mock
	private WeatherService weatherService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getForecastTemp_zipcode_not_valid_RaiseException() {
		assertThrows(InvalidInputException.class, () -> weatherController.getForecastTemp("0"));
	}

	@Test
	public void getForecastTemp_zipcode_valid() throws InvalidInputException {

		when(weatherService.callWeatherApi("07096")).thenReturn(new ForecastResponseVO());
		ForecastResponseVO response = weatherController.getForecastTemp("07096");
		assertNotNull(response);

	}

}
