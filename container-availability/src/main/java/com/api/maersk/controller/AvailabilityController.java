package com.api.maersk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.maersk.service.AvailabilityService;
import com.api.maersk.to.AvailabilityResponse;


@RestController
@RequestMapping("/api")
public class AvailabilityController {

	@Autowired
	AvailabilityService availabilityService;

	@GetMapping("/bookings")
	public AvailabilityResponse viewOrder() {
		return availabilityService.checkAvailability();
	}
}
