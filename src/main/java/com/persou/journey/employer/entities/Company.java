package com.persou.journey.employer.entities;


public record Company(
    String id,
    String name,
    String cnpj,
    Address address,
    String phone,
    String email
){
}
