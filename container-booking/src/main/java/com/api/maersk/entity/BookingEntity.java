package com.api.maersk.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.api.maersk.to.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

	@PrimaryKeyColumn(name="booking_id", ordinal=957000000, ordering = Ordering.ASCENDING)
	private long booking_id;
	private Booking obj;
	
	public long getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}
	public Booking getObj() {
		return obj;
	}
	public void setObj(Booking obj) {
		this.obj = obj;
	}
	
	
	
	
}
