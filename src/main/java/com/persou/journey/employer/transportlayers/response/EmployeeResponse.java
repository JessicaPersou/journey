package com.persou.journey.employer.transportlayers.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponse(
    String id,
    String name,
    LocalDate birthdate,
    String cpf,
    String phone,
    AddressResponse address,
    String email,
    BigDecimal salary,
    String position,
    DepartmentResponse department,
    CompanyResponse company
) {}
