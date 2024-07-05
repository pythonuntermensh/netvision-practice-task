package ru.blabla.netvision.config.exception;

import java.io.IOException;

public class DeserializationException extends IOException {
    public DeserializationException(String message) {
        super(message);
    }
}
