package com.persou.journey.employer.transportlayers.request;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record CompanyRequest(
    String name,
    String cnpj,
    String fantasyName,
    AddressRequest address,
    String phone,
    String email,
    List<DepartmentRequest> departmentRequestList
) {
}
