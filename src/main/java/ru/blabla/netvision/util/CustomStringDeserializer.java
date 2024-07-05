package ru.blabla.netvision.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.io.IOException;

public class CustomStringDeserializer extends StringDeserializer {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_STRING)) {
            return p.getText();
        } else {
            throw new DeserializationException("Invalid String value");
        }
    }
}
