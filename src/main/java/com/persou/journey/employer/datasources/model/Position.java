package com.persou.journey.employer.datasources.model;

public enum Position {
    JUNIOR("Junior"),
    MIDDLE("Pleno"),
    SENIOR("Senior");

    public String description;

    Position(String description) {
        this.description = description;
    }
}
