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

	private Brand carBrandAlfa = Brand.ALFA_ROMEO;
	private Brand carBrandToyota = Brand.TOYOTA;
	private Brand carBrandFiat = Brand.FIAT;

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

		// get "/cars" with no cars in DB
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("[]"));

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);

		// get "/cars" with one car in DB
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("[{\"id\":0,"
										+ "\"brand\":\"ALFA_ROMEO\","
										+ "\"kilometerRange\":0,"
										+ "\"registrationDate\":null,"
										+ "\"color\":null,"
										+ "\"fuelType\":null,"
										+ "\"gearBox\":null}]"));

		carFacade.delete(carDtoAlfa.getId());

		CarDto carDtoFiat = createCarDto(carBrandFiat);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoFiat = carFacade.add(carDtoFiat);
		carDtoToyota = carFacade.add(carDtoToyota);

		// get "/cars" with two cars in DB
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars").contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("[{\"id\":1,"
										+ "\"brand\":\"FIAT\","
										+ "\"kilometerRange\":0,"
										+ "\"registrationDate\":null,"
										+ "\"color\":null,"
										+ "\"fuelType\":null,"
										+ "\"gearBox\":null},"
										+ "{\"id\":2,"
										+ "\"brand\":\"TOYOTA\","
										+ "\"kilometerRange\":0,"
										+ "\"registrationDate\":null,"
										+ "\"color\":null,"
										+ "\"fuelType\":null,"
										+ "\"gearBox\":null}]"));

		// get "cars/{id} for id=1
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars/{id}", 1).contentType(
						MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("{\"id\":1,"
										+ "\"brand\":\"FIAT\","
										+ "\"kilometerRange\":0,"
										+ "\"registrationDate\":null,"
										+ "\"color\":null,"
										+ "\"fuelType\":null,"
										+ "\"gearBox\":null}"));

		// get "cars/{id}" for non-existent id=7
		mockMvc.perform(
				MockMvcRequestBuilders.get("/cars/{id}", 7).contentType(
						MediaType.APPLICATION_JSON)).andExpect(
				status().isNotFound());

		// post "cars" to add new car
		mockMvc.perform(
				MockMvcRequestBuilders.post("/cars")
						.content("{\"brand\":\"VOLVO\"}")
						.contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

		// delete "cars/{id}" for id = 1
		mockMvc.perform(MockMvcRequestBuilders.delete("/cars/{id}", 1))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("{\"id\":1,"
										+ "\"brand\":\"FIAT\","
										+ "\"kilometerRange\":0,"
										+ "\"registrationDate\":null,"
										+ "\"color\":null,"
										+ "\"fuelType\":null,"
										+ "\"gearBox\":null}"));

		// delete "cars/{id}" for id = 1 one more time
		mockMvc.perform(MockMvcRequestBuilders.delete("/cars/{id}", 1))
				.andExpect(status().isNotFound());

		carFacade.delete(carDtoToyota.getId());
	}

	static private CarDto createCarDto(Brand carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}

}
