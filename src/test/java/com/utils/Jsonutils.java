package com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venderpomvims.pojos.Root;

import java.io.InputStream;

public class Jsonutils {
    private static ObjectMapper objectMapper=new ObjectMapper();

    public static Root getObjectMapper(String path) throws Exception{
      InputStream stream= ResourceLoader.getResouce(path);
      return objectMapper.readValue(stream,Root.class);
    }
}
