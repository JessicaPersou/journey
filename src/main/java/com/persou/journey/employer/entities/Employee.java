package com.persou.journey.employer.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
public record Employee(
    String id,
    String name,
    LocalDate birthdate,
    String cpf,
    String phone,
    Address address,
    String email,
    BigDecimal salary,
    String position,
    Department department,
    Company company
) {

}

