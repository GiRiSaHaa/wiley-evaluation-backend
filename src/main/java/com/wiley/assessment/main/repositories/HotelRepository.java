package com.wiley.assessment.main.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.assessment.main.dto.BookingRequest;
import com.wiley.assessment.main.models.Hotel;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for manage hotel related queries.
 */
@Repository
public class HotelRepository {

    // create Object Mapper
    ObjectMapper mapper = new ObjectMapper();

    /**
     * Return all hotels.
     * @return the list of Hotels
     */
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = null;

        // read JSON file and map/convert to java POJO
        try {
            File file = ResourceUtils.getFile("classpath:./static/hotel-list.json");
            hotels = Arrays.asList(mapper.readValue(file, Hotel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hotels;
    }

    /**
     * Return hotel for given ID
     * @param id the Hotel ID
     * @return the Hotel
     */
    public Optional<Hotel> getAllHotel(int id) {
        return getAllHotels().stream().filter( h -> h.getId() == id).findFirst();
    }

    /**
     * Check availability of hotel for given request.
     * @param request the BookingRequest.
     * @return True if available otherwise False
     */
    public boolean checkAvailability(BookingRequest request) {
        // TODO: validation to be happen here, returning true for happy path
        return true;
    }
}
