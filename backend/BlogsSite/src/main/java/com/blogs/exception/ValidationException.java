package com.blogs.exception;

import com.blogs.util.ApplicationUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationException extends Exception {

    private String message;
    private Errors errors;
    public ValidationException(String message) {
        this.message = message;
    }

    public ValidationException(Errors errors) {
        this.message = ApplicationUtils.extractErrorMessageFromError(errors);
    }
}
