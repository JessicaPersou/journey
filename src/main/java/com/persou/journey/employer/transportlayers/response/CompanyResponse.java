package com.persou.journey.employer.transportlayers.response;

import lombok.Builder;

@Builder(toBuilder = true)
public record CompanyResponse(
    String id,
    String name,
    String cnpj,
    AddressResponse address,
    String phone,
    String email
) {}
