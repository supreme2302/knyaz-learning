package ru.supreme.webdemo.errorMessages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class RomkaCustomExceptionAdvice {

    @ExceptionHandler (RomkaCustomException.class)
    public ResponseEntity<ErrorMessageDTO> handleException(RomkaCustomException ex) {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO("Page number must be > 0");
        return new ResponseEntity<>(errorMessageDTO, HttpStatus.NOT_FOUND);

    }
}
