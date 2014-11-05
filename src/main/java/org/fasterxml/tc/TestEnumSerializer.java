
package org.fasterxml.tc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Jackson serializer for LanguageCode.
 */
public class TestEnumSerializer extends JsonSerializer<TestEnum> {
    @Override
    public void serialize(TestEnum value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(value.getComment());
    }
}
