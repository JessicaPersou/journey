package com.persou.journey.employer.datasources.model.valueObject;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder(toBuilder = true)
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    protected Address() {}

    public Address(String street, String number, String neighborhood, String zipcode, String city, String state, String country) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

}
