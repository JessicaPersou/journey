package com.persou.journey.employer.transportlayers.request;

import com.persou.journey.employer.entities.enums.DepartmentSection;
import lombok.Builder;

@Builder(toBuilder = true)
public record DepartmentRequest(
    String name,
    String description,
    DepartmentSection section,
    boolean active
) {}
