package com.persou.journey.employer.transportlayers.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
public record EmployeeRequest(
    String name,
    LocalDate birthdate,
    String cpf,
    String phone,
    AddressRequest address,
    String email,
    BigDecimal salary,
    String position,
    DepartmentRequest department,
    CompanyRequest company
) {}
