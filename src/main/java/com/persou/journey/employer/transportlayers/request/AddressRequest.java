package com.persou.journey.employer.transportlayers.request;


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
