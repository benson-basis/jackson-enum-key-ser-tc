/******************************************************************************
 ** This data and information is proprietary to, and a valuable trade secret
 ** of, Basis Technology Corp.  It is given in confidence by Basis Technology
 ** and may only be used as permitted under the license agreement under which
 ** it has been distributed, and in no other way.
 **
 ** Copyright (c) 2014 Basis Technology Corporation All rights reserved.
 **
 ** The technical data and information provided herein are provided with
 ** `limited rights', and the computer software provided herein is provided
 ** with `restricted rights' as those terms are defined in DAR and ASPR
 ** 7-104.9(a).
 ******************************************************************************/

package org.fasterxml.tc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by benson on 11/5/14.
 */
public class EnumKeyBoomTest {
    @Test
    public void boom() throws Exception {
        ObjectMapper mapper = EnumModule.setupObjectMapper(new ObjectMapper());
        Map<TestEnum, String> map = Maps.newEnumMap(TestEnum.class);
        map.put(TestEnum.value1, "dumpling");
        Map<TestEnum, String> deser = mapper.readValue("{\"comment1\": \"dumpling\"}", new TypeReference<Map<TestEnum, String>>() {
        });
        assertEquals(map, deser);
        String json = mapper.writeValueAsString(map);
        assertTrue(json.contains("comment1")); // and not, by implication, value1.
    }
}
