package com.persou.journey.employer.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String country;
}
