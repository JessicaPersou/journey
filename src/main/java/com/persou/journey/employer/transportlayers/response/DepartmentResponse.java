package com.persou.journey.employer.transportlayers.response;

import com.persou.journey.employer.entities.enums.DepartmentSection;
import lombok.Builder;

@Builder(toBuilder = true)
public record DepartmentResponse (
    String id,
    String name,
    String description,
    DepartmentSection section,
    boolean active,
    CompanyResponse company) {
}

