package com.example.fullstackdemosystem.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {EmployeeNotFoundException.class, HttpClientErrorException.NotFound.class})
    public ResponseEntity<Object> handleNotFoundException(EmployeeNotFoundException e) {
        //TODO() Create payload containing exception details
        ApiException exceptionPayload = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //TODO() Return ResponseEntity
        return new ResponseEntity<>(exceptionPayload,HttpStatus.BAD_REQUEST);
    }
}
