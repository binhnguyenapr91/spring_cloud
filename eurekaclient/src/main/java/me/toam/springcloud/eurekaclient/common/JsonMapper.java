package me.toam.springcloud.eurekaclient.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class JsonMapper {
    private static final Logger log = (Logger) LoggerFactory.getLogger(JsonMapper.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public JsonMapper(){

    }

    public static <O> String write(O o) throws JsonProcessingException {
        return MAPPER.writeValueAsString(o);
    }
}
