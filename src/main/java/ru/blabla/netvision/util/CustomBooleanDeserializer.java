package ru.blabla.netvision.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.io.IOException;

public class CustomBooleanDeserializer extends StdScalarDeserializer<Boolean> {
    public CustomBooleanDeserializer() {
        super(Boolean.class);
    }

    public LogicalType logicalType() {
        return LogicalType.Boolean;
    }

    public boolean isCachable() {
        return true;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return true;
    }

    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return null;
        }
        else if (p.hasToken(JsonToken.VALUE_TRUE) || p.hasToken(JsonToken.VALUE_FALSE)) {
            return p.getBooleanValue();
        } else {
            throw new DeserializationException("Invalid boolean value");
        }
    }
}
