package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wordpress.zapiskiprogramistki.CarDealer2.ApplicationConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = ApplicationConfig.class)
public class CarAcceptanceTest {

	private String carBrandAlfa = "Alfa Romeo";
	private String carBrandToyota = "Toyota";

	@InjectMocks
	CarController controller;

	@Autowired
	private CarFacade carFacade;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void shouldGetCar() throws Exception {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);

		ResultActions getCars = mockMvc.perform(MockMvcRequestBuilders
				.get("/cars"));

		getCars.andExpect(status().isOk());

	}

	static private CarDto createCarDto(String carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}
}
