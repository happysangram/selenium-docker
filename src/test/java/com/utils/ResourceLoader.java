package com.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLoader  {

    public static InputStream getResouce(String path) throws Exception{
        InputStream stream=ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if(stream!=null){
            return stream;
        }
        return Files.newInputStream(Path.of(path));
    }
}
