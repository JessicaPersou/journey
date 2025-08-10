package com.persou.journey.employer.datasources.model.enums;

public enum DepartmentSection {
    ADMINISTRATION("Administrativo"),
    FINANCE("Financeiro"),
    OPERATIONAL("Operacional"),
    RH("RH"),
    TI("TI");
    public String description;

    DepartmentSection(String description) {
        this.description = description;
    }
}
