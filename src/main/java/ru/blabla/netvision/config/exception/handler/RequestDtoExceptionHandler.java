package ru.blabla.netvision.config.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class RequestDtoExceptionHandler {

    @ExceptionHandler(value
            = { MethodArgumentNotValidException.class, DeserializationException.class}) //, HttpMessageNotReadableException.class })
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            Exception ex) {

        Map<String, String> result = new HashMap<>();
        result.put("ERROR", ex.getMessage());
        result.put("DESCRIPTION", "Invalid JSON or there is a lack of necessary data.");
        log.error("ERROR MSG: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
    }
}



