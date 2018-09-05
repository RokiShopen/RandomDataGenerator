package com.random.people;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Ivan Milosavljevic (TheJavaGuy@yandex.com)
 */
public final class CustomDoubleSerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value == null) {
            jsonGenerator.writeNull();
        } else {
            final DecimalFormat format = new DecimalFormat(".##");
            final String output = format.format(value);
            jsonGenerator.writeNumber(output);
        }
    }
}
