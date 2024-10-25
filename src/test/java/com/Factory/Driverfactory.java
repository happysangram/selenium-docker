package com.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {

    private static WebDriver driver;

    public static WebDriver DriverInitialisation(String browser){
        if(browser=="chrome"){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }
        return driver;

    }
}
