

package org.fasterxml.tc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

/**
 * Module for common enum types when not embedded in the rest of the ADM.
 */
public class EnumModule extends SimpleModule {

    public EnumModule() {
        super("test module");
    }

    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(TestEnum.class, TestEnumMixin.class);
        SimpleSerializers keySerializers = new SimpleSerializers();
        keySerializers.addSerializer(TestEnum.class, new TestEnumSerializer());
        context.addKeySerializers(keySerializers);
        // We don't need one for ISO15924.
        // We might want one some day for TextDomain?
    }

    /**
     * Register a Jackson module for Rosette's top-level enums an {@link com.fasterxml.jackson.databind.ObjectMapper}.
     * @param mapper the mapper.
     * @return the same mapper, for convenience.
     */
    public static ObjectMapper setupObjectMapper(ObjectMapper mapper) {
        final EnumModule module = new EnumModule();
        mapper.registerModule(module);
        return mapper;
    }
}
