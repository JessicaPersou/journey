package com.persou.journey.employer.config.exception;


public enum ErrorType {

    BUSINESS("BusinessError"),
    VALIDATION("ValidationError"),
    RESOURCE_NOT_FOUND("ResourceNotFound"),
    RESOURCE_ALREADY_EXISTS("ResourceAlreadyExists"),
    INTERNAL_SERVER_ERROR("InternalError");

    private final String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}