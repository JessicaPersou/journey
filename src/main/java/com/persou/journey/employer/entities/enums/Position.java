package com.persou.journey.employer.entities.enums;

public enum Position {
    JUNIOR("Junior"),
    MIDDLE("Pleno"),
    SENIOR("Senior");

    public String description;

    Position(String description) {
        this.description = description;
    }
}
