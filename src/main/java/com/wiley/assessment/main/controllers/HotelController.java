package com.wiley.assessment.main.controllers;

import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.dto.ResponseBody;
import com.wiley.assessment.main.services.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for Hotel related APIs
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * This API will return all hotels.
     * @return the list of Hotels
     */
    @RequestMapping(value = "/hotels")
    public ResponseEntity<?> getHotels(){
        ResponseBody response = hotelService.getHotels();
        return ResponseEntity.ok(response);
    }

    /**
     * Get a specific hotel for given hotel id.
     * @param id the hotel ID
     * @return the Hotel
     */
    @RequestMapping(value = "/hotels/hotel/{id}")
    public ResponseEntity<?> getHotel(@PathVariable("id") int id){
        ResponseBody response = hotelService.getHotel(id);
        return ResponseEntity.ok(response);
    }

    /**
     * API for validate hotel availability for given user request.
     * @param request the BookingRequest
     * @return True if available otherwise False.
     */
    @RequestMapping(value = "/hotels/availability", method = RequestMethod.POST)
    public ResponseEntity<?> checkAvailability(@RequestBody BookingRequest request){
        ResponseBody response = hotelService.checkAvailability(request);
        return ResponseEntity.ok(response);
    }
}
