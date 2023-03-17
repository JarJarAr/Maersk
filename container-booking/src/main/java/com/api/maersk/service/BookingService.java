package com.api.maersk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.maersk.entity.BookingEntity;
import com.api.maersk.repository.BookingRepository;
import com.api.maersk.to.AvailabilityResponse;
import com.api.maersk.to.Booking;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Mono<BookingEntity> saveBookingDetails(Booking booking) {
		AvailabilityResponse response = restTemplate.getForObject("http://localhost:7080/api/bookings", AvailabilityResponse.class);
		Mono<BookingEntity> mono = new Mono<BookingEntity>() {
			@Override
			public void subscribe(CoreSubscriber<? super BookingEntity> actual) {
				if(response.getAvailable()) {
					BookingEntity bookEntity = new BookingEntity();
					bookEntity.setBooking_id(957000002);
					bookEntity.setObj(booking);
					bookingRepository.save(bookEntity);
				}

			}
		};
		return mono;
	}
		
	public boolean validateInput(Booking booking) {
		boolean flag = false;
		if(booking!=null && booking.getContainerSize() != null && (booking.getContainerSize()==20 || booking.getContainerSize()==40)) {
			if(booking.getContainerType()!=null && (booking.getContainerType().equalsIgnoreCase("dry") || booking.getContainerType().equalsIgnoreCase("reefer"))) {
				if(booking.getOrigin()!=null && booking.getOrigin().length() >= 5 && booking.getOrigin().length() <= 20) {
					if(booking.getDestination()!=null && booking.getDestination().length() >= 5 && booking.getDestination().length() <= 20) {{
						if(booking.getQuantity()!=null & booking.getQuantity() >=1 && booking.getQuantity() <=100) {
							flag = true;
						}
					}
				}
			}
		}
	}
		return flag;
	}
}