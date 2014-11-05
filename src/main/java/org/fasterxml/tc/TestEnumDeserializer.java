
package org.fasterxml.tc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 *
 */
class TestEnumDeserializer extends StdDeserializer<TestEnum> {

    public TestEnumDeserializer() {
        super(TestEnum.class);
    }

    @Override
    public TestEnum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String code = jp.getText();
        return TestEnum.lookupByComment(code);
    }
}
