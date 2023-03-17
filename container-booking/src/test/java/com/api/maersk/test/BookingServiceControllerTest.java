package com.api.maersk.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.api.maersk.entity.BookingEntity;
import com.api.maersk.service.BookingService;
import com.api.maersk.to.Booking;

import reactor.core.publisher.Mono;

public class BookingServiceControllerTest {

	@InjectMocks
	BookingService bookingService;

	@Test
	public Mono<BookingEntity> saveBookingDetails(Booking booking) {
		return bookingService.saveBookingDetails(booking);
	}
}
