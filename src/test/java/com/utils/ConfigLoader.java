package com.solarready.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final String DEFAULT_PROPERTIES="config/default.properties";
    private static Properties properties;
    //Load Properties File
    private static Properties loadProperties() throws Exception {
        Properties properties=new Properties();
        InputStream stream= ResourceLoader.getResouce(DEFAULT_PROPERTIES);
        properties.load(stream);
        return properties;
    }

    //Initialise Properties file and overwright if in case
    public static void initialise() throws Exception {
        properties=loadProperties();
        for(String key: properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                 properties.setProperty(key,System.getProperty(key));
            }
        }
        //Print Config file values
        for(String k: properties.stringPropertyNames()){
            System.out.println(k+"---------"+ properties.getProperty(k));
        }
    }

    //get the property values by passing the key
    public static String getpropertiesvalue(String key) {
        return properties.getProperty(key);
    }
}

