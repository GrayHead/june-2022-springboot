package ua.com.owu.june2022springboot.controllers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.owu.june2022springboot.models.dto.ErrorDTO;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO erroraVlidation(ConstraintViolationException e) {
        return new ErrorDTO(500, e.getMessage());

    }
}
