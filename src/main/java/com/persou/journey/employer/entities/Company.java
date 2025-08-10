package com.persou.journey.employer.entities;

import lombok.Builder;

@Builder(toBuilder = true)
public record Company(
    String id,
    String name,
    String cnpj,
    Address address,
    String phone,
    String email
){
}
