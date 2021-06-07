package com.wiley.assessment.main.services;

import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.dto.ResponseBody;
import com.wiley.assessment.main.models.Hotel;
import com.wiley.assessment.main.repositories.HotelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public ResponseBody getHotels() {
        ResponseBody responseBody = new ResponseBody();
        List<Hotel> hotels = hotelRepository.getAllHotels();
        responseBody.setBody(hotels);
        return responseBody;
    }

    public ResponseBody getHotel(int id) {
        ResponseBody responseBody = new ResponseBody();
        Hotel hotel = hotelRepository.getAllHotel(id).get();
        responseBody.setBody(hotel);
        return responseBody;
    }

    public ResponseBody checkAvailability(BookingRequest request) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setBody(hotelRepository.checkAvailability(request));
        return responseBody;
    }
}
