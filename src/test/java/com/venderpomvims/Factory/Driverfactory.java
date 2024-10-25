package com.venderpomvims.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {

    private static WebDriver driver;

    public static WebDriver  DriverInitialisation(String browser){

        switch(browser.toLowerCase()){

            case "chrome":
                driver = new ChromeDriver();
            case "firefox":
                driver = new FirefoxDriver();
            break;
            // Add other cases for different browsers if needed
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        return driver;
    }
}
