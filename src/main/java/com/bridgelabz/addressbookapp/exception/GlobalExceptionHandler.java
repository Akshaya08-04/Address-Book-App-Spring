package com.bridgelabz.addressbookapp.exception;

import com.bridgelabz.addressbookapp.util.ResponseDTO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errorMap.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseDTO("Validation Exception while processing REST Request", errorMap);
    }

    @ExceptionHandler(AddressBookException.class)
    public ResponseDTO handleAddressBookException(AddressBookException ex) {
        return new ResponseDTO("Exception while processing REST Request", ex.getMessage());
    }
}