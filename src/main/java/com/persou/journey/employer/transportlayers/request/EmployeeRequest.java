package com.persou.journey.employer.transportlayers.request;

import java.math.BigDecimal;
import java.time.LocalDate;

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
