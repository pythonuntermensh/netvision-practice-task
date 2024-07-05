package ru.blabla.netvision.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.io.IOException;

public class CustomIntegerDeserializer extends StdScalarDeserializer<Integer> {
    private static final long serialVersionUID = 1L;
    public static final StringDeserializer instance = new StringDeserializer();

    public CustomIntegerDeserializer() {
        super(Integer.class);
    }

    public LogicalType logicalType() {
        return LogicalType.Textual;
    }

    public boolean isCachable() {
        return true;
    }

    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return 0;
    }

    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            return null;
        }
        else if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
            return p.getIntValue();
        } else {
            throw new DeserializationException("Invalid int value");
        }
    }
}
