package com.persou.journey.employer.entities;

import com.persou.journey.employer.entities.enums.DepartmentSection;
import lombok.Builder;

@Builder(toBuilder = true)
public record Department(
    String id,
    String name,
    String description,
    DepartmentSection section,
    boolean active,
    Company company
) {
}
