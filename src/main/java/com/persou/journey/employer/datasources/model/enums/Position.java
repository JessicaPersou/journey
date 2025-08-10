package com.persou.journey.employer.datasources.model.enums;

public enum Position {
    JUNIOR("Junior"),
    MIDDLE("Pleno"),
    SENIOR("Senior");

    public String description;

    Position(String description) {
        this.description = description;
    }
}
