package com.persou.journey.employer.entities.enums;

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
