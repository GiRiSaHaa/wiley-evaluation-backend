package com.wiley.assessment.main.services;

import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.dto.ResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    void checkAvailabilityTest() {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setCheckin(new Date(2021,6,7));
        bookingRequest.setCheckout(new Date(2021,6,8));
        bookingRequest.setNumberOfAdults(2);
        bookingRequest.setNumberOfRooms(1);
        bookingRequest.setNumberOfChildren(0);

        ResponseBody responseBody = hotelService.checkAvailability(bookingRequest);
        boolean isAvailable = (boolean) responseBody.getBody();
        assertTrue(isAvailable);
    }
}