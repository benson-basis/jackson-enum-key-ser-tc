

package org.fasterxml.tc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = TestEnumSerializer.class)
@JsonDeserialize(using = TestEnumDeserializer.class)
public enum TestEnumMixin {
}
