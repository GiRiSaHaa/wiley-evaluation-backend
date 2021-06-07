package com.wiley.assessment.main.controllers;

import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.dto.ResponseBody;
import com.wiley.assessment.main.services.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/hotels")
    public ResponseEntity<?> getHotels(){
        ResponseBody response = hotelService.getHotels();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/hotels/hotel/{id}")
    public ResponseEntity<?> getHotel(@PathVariable("id") int id){
        ResponseBody response = hotelService.getHotel(id);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/hotels/availability", method = RequestMethod.POST)
    public ResponseEntity<?> checkAvailability(@RequestBody BookingRequest request){
        ResponseBody response = hotelService.checkAvailability(request);
        return ResponseEntity.ok(response);
    }
}
