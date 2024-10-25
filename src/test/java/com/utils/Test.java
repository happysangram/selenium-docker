package com.utils;

public class Test {
    public static void main(String[] args) throws Exception {


        ConfigLoader.initialise();
        System.out.println(ConfigLoader.getpropertiesvalue("browser"));
        System.setProperty("browser","firefox");
        ConfigLoader.initialise();
        System.out.println(ConfigLoader.getpropertiesvalue("browser"));
    }
}
