package com.persou.journey.employer.transportlayers.response;

import lombok.Builder;

@Builder(toBuilder = true)
public record AddressResponse(
    String street,
    String number,
    String neighborhood,
    String zipcode,
    String city,
    String state,
    String country
) {
}
