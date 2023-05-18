package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Schemas.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    String bookTrain(List<Booking> bookings);

    Optional<Booking> getBookingsById(int user_id);
}
