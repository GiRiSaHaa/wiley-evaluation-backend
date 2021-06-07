package com.wiley.assessment.main.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingRequest {
    private Date checkin;
    private Date checkout;
    private int numberOfRooms;
    private int numberOfAdults;
    private int numberOfChildren;
}
