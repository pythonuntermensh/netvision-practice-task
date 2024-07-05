package ru.blabla.netvision.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import ru.blabla.netvision.config.exception.DeserializationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomIntegerListDeserializer extends JsonDeserializer<List<Integer>> {

    public List<Integer> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            return null;
        } else {
            List<Integer> result = new ArrayList<>();
            JsonToken t;
            try {
                while ((t = p.nextToken()) != JsonToken.END_ARRAY) {
                    Integer value;

                    if (t == JsonToken.VALUE_NULL) {
                        value = null;
                    } else if (t == JsonToken.VALUE_NUMBER_INT) {
                        value = p.getIntValue();
                    } else {
                        throw new DeserializationException("Wrong list element");
                    }

                    result.add(value);
                }
            }
            catch (Exception exception) {
                System.out.println("hi");
            }
            return result;
        }
    }
}
