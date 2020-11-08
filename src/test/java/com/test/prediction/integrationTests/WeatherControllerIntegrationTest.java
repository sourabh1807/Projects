package com.test.prediction.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;



import com.test.prediction.service.WeatherService;
import com.test.prediction.vo.ForecastResponseVO;
import com.test.prediction.vo.forecastHoursData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@WithMockUser(username="APPUSER",password="sourabh0667")
@SpringBootTest
public class WeatherControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WeatherService weatherService;
	
	@Test
	public void getForecastTemp_zipCode_code_valid() throws Exception {
		
		ForecastResponseVO forecastResponseVO = createDummyResponse();
		
		String zipcode = "07096";
		when(weatherService.callWeatherApi(zipcode)).thenReturn(forecastResponseVO);
		
		
		
		this.mockMvc.perform(get("/forecastTemperature/{zipcode}",zipcode)
					.accept(MediaType.APPLICATION_JSON))
		            .andDo(print()).andExpect(status().isOk())
		            .andExpect(jsonPath("$.date").value(forecastResponseVO.getDate()))
		            .andExpect(jsonPath("$.city").value(forecastResponseVO.getCity()))
		            .andExpect(jsonPath("$.hoursData[0]").isNotEmpty())
		            .andExpect(jsonPath("$.hoursData[0].feelslike_c").value(forecastResponseVO.getHoursData()[0].getFeelsLikeTemp()))
		            .andExpect(jsonPath("$.hoursData[0].humidity").value(forecastResponseVO.getHoursData()[0].getHumidity()))
		            .andExpect(jsonPath("$.hoursData[0].temp_c").value(forecastResponseVO.getHoursData()[0].getTemp()))
		            .andExpect(jsonPath("$.hoursData[0].time").value(forecastResponseVO.getHoursData()[0].getTime()));
		
	}
	
	
	public void getForecastTemp_zipCode_code_not_valid() throws Exception {
		
		String zipcode = "0";
		this.mockMvc.perform(get("/forecastTemperature/{zipcode}",zipcode)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isBadRequest());
		
	}
	
	
	public ForecastResponseVO createDummyResponse() {
		
		ForecastResponseVO forecastResponseVO = new ForecastResponseVO();
		
		forecastResponseVO.setCity("New York");
		forecastResponseVO.setDate("08/11/2020");
		
		forecastHoursData[] hoursData = new forecastHoursData[1];
		
		forecastHoursData data1 =new forecastHoursData();
		data1.setFeelsLikeTemp(21.6);
		data1.setHumidity("56");
		data1.setTemp(20.6);
		data1.setTime("2020-11-09 00:00");
		
		hoursData[0]= data1;
		
		forecastResponseVO.setHoursData(hoursData);
		
		return forecastResponseVO;
	}
}
