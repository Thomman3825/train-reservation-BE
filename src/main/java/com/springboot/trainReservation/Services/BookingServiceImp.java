package com.springboot.trainReservation.Services;

import com.springboot.trainReservation.Dao.BookingDao;
import com.springboot.trainReservation.Schemas.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class BookingServiceImp implements BookingService{
    @Autowired
    private BookingDao bookingDao;
    @Override
    public String bookTrain(List<Booking> bookings) {
        bookingDao.saveAll(bookings);
        return "Booking Successful";
    }

    @Override
    public Optional<Booking> getBookingsById(int user_id) {

        return bookingDao.findById(user_id);
    }
}
