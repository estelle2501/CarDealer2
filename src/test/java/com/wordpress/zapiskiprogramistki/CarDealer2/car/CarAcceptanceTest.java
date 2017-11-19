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

	@Test
	public void testCarController() throws Exception {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);
//Test with one car in DB
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content().string(
								"[{\"id\":0,\"brand\":\"Alfa Romeo\"}]"));

		carFacade.delete(carDtoAlfa.getId());

		CarDto carDtoFiat = createCarDto(carBrandFiat);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoFiat = carFacade.add(carDtoFiat);
		carDtoToyota = carFacade.add(carDtoToyota);
//Test with two cars in DB
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("[{\"id\":1,\"brand\":\"Fiat\"},{\"id\":2,\"brand\":\"Toyota\"}]"));

		carFacade.delete(carDtoFiat.getId());
		carFacade.delete(carDtoToyota.getId());
	}

	static private CarDto createCarDto(String carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}

}
