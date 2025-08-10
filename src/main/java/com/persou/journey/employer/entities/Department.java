package com.persou.journey.employer.entities;

import com.persou.journey.employer.datasources.model.DepartmentSection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Department {
    private String id;
    private String name;
    private String description;
    private DepartmentSection section;
    private boolean active;
    private Company company;
}
