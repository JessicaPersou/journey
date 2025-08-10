package com.persou.journey.employer.transportlayers.request;

import lombok.Builder;

@Builder(toBuilder = true)
public record AddressRequest(
    String street,
    String number,
    String neighborhood,
    String zipcode,
    String city,
    String state,
    String country
) {
}
