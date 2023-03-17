package com.api.maersk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.maersk.to.Availability;
import com.api.maersk.to.AvailabilityResponse;

@Service
public class AvailabilityService {
	
	@Autowired
	RestTemplate restTemplate;

	public AvailabilityResponse checkAvailability() {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		Availability response = restTemplate.getForObject("https://maersk.com/api/bookings/checkAvailable", Availability.class);
		if(response.getAvailableSpace() == 0) {
			availabilityResponse.setAvailable(false);
		}else
			availabilityResponse.setAvailable(true);
		return availabilityResponse;
	}
}
