package com.persou.journey.employer.entities;


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
