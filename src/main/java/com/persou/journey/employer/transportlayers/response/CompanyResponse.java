package com.persou.journey.employer.transportlayers.response;

public record CompanyResponse(
    String id,
    String name,
    String cnpj,
    AddressResponse address,
    String phone,
    String email
) {}
