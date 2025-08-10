package com.persou.journey.employer.config.handler;

import com.persou.journey.employer.config.exception.ValidationErrorDetail;
import java.util.List;

public record ApiErrorResponse(
    String type,
    String message,
    List<ValidationErrorDetail> details
) {


}