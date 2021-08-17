package ru.supreme.webdemo.errorMessages;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PSQLExceptionAdvice {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(PSQLException e) {
        ErrorMessageDTO errorMessage = new ErrorMessageDTO("Incorrect departmentId (department doesn't exist) " +
                "Please, go to http://localhost:8080/departments and try again with correct departmentId");
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
