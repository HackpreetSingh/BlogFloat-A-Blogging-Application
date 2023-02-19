package com.blogs.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

public final class ApplicationUtils {

    public static String extractErrorMessageFromError(Errors errors) {
        return errors.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("\n"));
    }
}
