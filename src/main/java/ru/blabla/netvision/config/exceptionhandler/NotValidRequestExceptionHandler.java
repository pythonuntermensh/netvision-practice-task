package ru.blabla.netvision.config.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class NotValidRequestExceptionHandler {

    @ExceptionHandler(value
            = { MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            Exception ex) {

        Map<String, String> result = new HashMap<>();
        result.put("ERROR", ex.getMessage());
        result.put("DESCRIPTION", "Invalid JSON or there is a lack of necessary data.");
        return ResponseEntity.badRequest().body(result);
    }
}



