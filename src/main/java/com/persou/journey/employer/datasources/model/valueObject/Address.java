package com.persou.journey.employer.datasources.model.valueObject;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String country;
}
