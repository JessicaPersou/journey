package com.persou.journey.employer.entities;

import lombok.Builder;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Employee {
    private String id;
    private String name;
    private LocalDate birthdate;
    private String cpf;
    private String phone;
    private Address address;
    private String email;
    private BigDecimal salary;
    private String position;
    private Department department;
    private Company company;
}

