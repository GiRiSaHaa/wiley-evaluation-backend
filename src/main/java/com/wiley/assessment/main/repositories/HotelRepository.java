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

@Repository
public class HotelRepository {

    // create Object Mapper
    ObjectMapper mapper = new ObjectMapper();

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

    public Optional<Hotel> getAllHotel(int id) {
        return getAllHotels().stream().filter( h -> h.getId() == id).findFirst();
    }

    public boolean checkAvailability(BookingRequest request) {
        return true;
    }
}
