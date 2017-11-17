package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
	private String carBrandFiat = "Fiat";

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

//Why shouldGetTwoCars runs before shouldGetOneCar regardless the code sequence?
	
	@Test
	public void shouldGetOneCar() throws Exception {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);

		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content().string(
								"[{\"id\":2,\"brand\":\"Alfa Romeo\"}]"));
		/*
		 * Why id=2 not id=0 for Alfa, as it is the only car in DB now? Even if
		 * Fiat and Toyota were deleted, their id's=0,1 were already used and
		 * cannot be "reused" for creating another car during the same test
		 * session
		 */
		carFacade.delete(carDtoAlfa.getId());
	}
	
	@Test
	public void shouldGetTwoCars() throws Exception {

		CarDto carDtoFiat = createCarDto(carBrandFiat);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoFiat = carFacade.add(carDtoFiat);
		carDtoToyota = carFacade.add(carDtoToyota);

		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("[{\"id\":0,\"brand\":\"Fiat\"},{\"id\":1,\"brand\":\"Toyota\"}]"));

		carFacade.delete(carDtoFiat.getId());
		carFacade.delete(carDtoToyota.getId());
	}

	static private CarDto createCarDto(String carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}
	
	
}
