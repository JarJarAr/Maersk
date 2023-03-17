package com.api.maersk;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.api.maersk.controller.AvailabilityController;
import com.api.maersk.service.AvailabilityService;
import com.api.maersk.to.AvailabilityResponse;

@RunWith(SpringRunner.class)
@WebFluxTest(AvailabilityController.class)
class ContainerAvailabilityApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private AvailabilityService availabilityService;
	
	@Test
	public void getAvailabilityTest() {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		availabilityResponse.setAvailable(true);
		when(availabilityService.checkAvailability()).thenReturn(availabilityResponse);
		
		webTestClient.get().uri("/api/bookings").exchange()
		.expectStatus().isOk().returnResult(AvailabilityResponse.class)
		.getResponseBodyContent();
		
	}
	
	@Test
	public void getAvailabilityTestForNonAvailability() {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		availabilityResponse.setAvailable(false);
		when(availabilityService.checkAvailability()).thenReturn(availabilityResponse);
		
		webTestClient.get().uri("/api/bookings").exchange()
		.expectStatus().isOk().returnResult(AvailabilityResponse.class)
		.getResponseBodyContent();
		
	}

}
