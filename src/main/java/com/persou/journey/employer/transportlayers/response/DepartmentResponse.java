package com.persou.journey.employer.transportlayers.response;

import com.persou.journey.employer.entities.enums.DepartmentSection;

public record DepartmentResponse (
    String id,
    String name,
    String description,
    DepartmentSection section,
    boolean active,
    CompanyResponse company) {
}

