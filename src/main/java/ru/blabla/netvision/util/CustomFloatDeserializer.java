package ru.blabla.netvision.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.io.IOException;

public class CustomFloatDeserializer extends StdScalarDeserializer<Float> {
    public CustomFloatDeserializer() {
        super(Float.class);
    }

    public LogicalType logicalType() {
        return LogicalType.Float;
    }

    public boolean isCachable() {
        return true;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return 0;
    }

    public Float deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return null;
        }
        else if (p.hasToken(JsonToken.VALUE_NUMBER_FLOAT)) {
            return p.getFloatValue();
        }
        else if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return (float) p.getIntValue();
        }
        else {
            throw new DeserializationException("Invalid float value");
        }
    }
}
