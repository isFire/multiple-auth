package com.dtstack.multiple.auth.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description JSON工具类
 * @date 2019/10/5 23:19
 */
@Slf4j
public class JsonUtils {

    private static ObjectMapper json = new ObjectMapper();

    public static String toJsonString(Object o) {
        try {
            return json.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            if (log.isErrorEnabled()) {
                log.error("Json Convert Exception", e);
            }
        }
        return null;
    }
}
