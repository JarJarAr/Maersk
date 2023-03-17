package com.api.maersk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.maersk.entity.BookingEntity;
import com.api.maersk.service.BookingService;
import com.api.maersk.to.Booking;
import com.api.maersk.to.BookingResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private final BookingService bookingService;
	
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

	@PostMapping("/bookings")
	public BookingResponse bookOrder(@RequestBody Booking bookingDetails) {
		Mono<BookingEntity> response = bookingService.saveBookingDetails(bookingDetails);
		BookingResponse bookingResponse = new BookingResponse();
		bookingResponse.setBookingRef(String.valueOf(response.block().getBooking_id()));
		return bookingResponse;
	}

}
