package com.api.maersk.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.api.maersk.entity.BookingEntity;

public interface BookingRepository extends ReactiveCassandraRepository<BookingEntity, Long>{

}
