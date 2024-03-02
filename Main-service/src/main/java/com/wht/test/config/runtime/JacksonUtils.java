package com.wht.test.config.runtime;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wanghongtao
 * @data 2023/12/29 21:27
 */
public class JacksonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJson(Object o) {
        String res = "";
        try {
            res = objectMapper.writeValueAsString(o);
        } catch (Exception e) {

        }
        return res;
    }
}
