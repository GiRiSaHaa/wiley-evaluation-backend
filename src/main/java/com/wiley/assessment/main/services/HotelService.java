package com.wiley.assessment.main.services;

import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.dto.ResponseBody;
import com.wiley.assessment.main.models.Hotel;
import com.wiley.assessment.main.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for manage hotel related services.
 */
@Service
public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Return all hotels.
     * @return the List of Hotel
     */
    public ResponseBody getHotels() {
        ResponseBody responseBody = new ResponseBody();
        List<Hotel> hotels = hotelRepository.getAllHotels();
        responseBody.setBody(hotels);
        return responseBody;
    }

    /**
     * Return a Hotel for given hotel ID
     * @param id the HotelID
     * @return the Hotel
     */
    public ResponseBody getHotel(int id) {
        ResponseBody responseBody = new ResponseBody();
        Hotel hotel = hotelRepository.getAllHotel(id).get();
        responseBody.setBody(hotel);
        return responseBody;
    }

    /**
     * Check availability for given user request
     * @param request the BookingRequest.
     * @return True if available otherwise False
     */
    public ResponseBody checkAvailability(BookingRequest request) {
        System.out.println(request.toString());
        ResponseBody responseBody = new ResponseBody();
        responseBody.setBody(hotelRepository.checkAvailability(request));
        return responseBody;
    }
}
