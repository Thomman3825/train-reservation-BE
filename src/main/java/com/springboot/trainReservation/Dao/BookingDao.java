package com.springboot.trainReservation.Dao;

import com.springboot.trainReservation.Schemas.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
