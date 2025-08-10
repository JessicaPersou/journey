package com.persou.journey.employer.entities;

import lombok.Builder;

@Builder(toBuilder = true)
public record Address(
    String street,
    String number,
    String neighborhood,
    String zipcode,
    String city,
    String state,
    String country
) {

}
