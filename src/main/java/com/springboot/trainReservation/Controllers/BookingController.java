package com.springboot.trainReservation.Controllers;

import com.springboot.trainReservation.Schemas.Booking;
import com.springboot.trainReservation.Schemas.Train;
import com.springboot.trainReservation.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/bookTrain")
    public String bookTrain(@RequestBody List<Booking> bookings){
        return bookingService.bookTrain(bookings);
    }

    @GetMapping("/getBooking/{user_id}")
    public Optional<Booking> getBookingsById(@PathVariable int user_id){
        return bookingService.getBookingsById(user_id);
    }
}
