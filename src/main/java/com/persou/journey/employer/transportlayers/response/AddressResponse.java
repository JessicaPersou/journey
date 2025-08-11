package com.persou.journey.employer.transportlayers.response;

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
