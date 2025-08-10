package com.persou.journey.employer.config.exception;

public record ValidationErrorDetail(
    String field,
    String message
) {

}