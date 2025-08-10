package com.persou.journey.employer.transportlayers.request;

import com.persou.journey.employer.datasources.model.DepartmentSection;
import lombok.Builder;

@Builder(toBuilder = true)
public record DepartmentRequest(
    String name,
    String description,
    DepartmentSection section,
    boolean active
) {}
