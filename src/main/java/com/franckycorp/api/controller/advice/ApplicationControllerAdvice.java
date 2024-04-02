package com.franckycorp.api.controller.advice;

import com.franckycorp.api.dto.ErrorEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice()
public class ApplicationControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleNotFoundException(EntityNotFoundException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({RuntimeException.class})
    public @ResponseBody ErrorEntity handleRuntimeException(RuntimeException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }
}
