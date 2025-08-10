package com.persou.journey.employer.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Company {
    private String id;
    private String name;
    private String cnpj;
    private Address address;
    private String phone;
    private String email;
}
