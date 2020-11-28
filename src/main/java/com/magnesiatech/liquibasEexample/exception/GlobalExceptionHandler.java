package com.magnesiatech.liquibasEexample.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
    logException(exception);
    return new ResponseEntity<>(createError("E-001", "UNEXPECTED_ERROR", exception),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public final ResponseEntity<Error> handleAllExceptions(
      DataIntegrityViolationException exception) {
    logException(exception);

    return new ResponseEntity<>(createError("D-001", "DATA_INTEGRITY_ERROR", exception),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<Error> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    logException(exception);

    FieldError error = exception.getBindingResult().getFieldErrors().get(0);

    Error response = Error.builder().title("INVALID-FIELD")
        .code("F-001")
        .details(error.getField() + "-" + error.getDefaultMessage())
        .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


  private void logException(Exception exception) {
    log.error("An error occurred and got an exception. Exception Type: {}, Exception: {}",
        exception.getClass(), exception.getMessage());
  }

  private Error createError(String code, String tittle, Exception e) {
    return Error.builder().code(code).title(tittle).details(e.getMessage()).build();
  }

}