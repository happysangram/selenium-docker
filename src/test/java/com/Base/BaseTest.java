package com.Base;

import com.Listener.TestListener;
import com.utils.ConfigLoader;
import com.venderpomvims.Factory.Driverfactory;
import com.utils.Constants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void Beforesuite() throws Exception {
        ConfigLoader.initialise();

    }

    //WebDriver for Selenium Grid
    private WebDriver RemoteWebDriver() throws Exception{
        System.out.println("Running on Grid");
        Capabilities capabilities;
        if(Constants.FIREFOX.equalsIgnoreCase(ConfigLoader.getpropertiesvalue(Constants.BROWSER))){
            capabilities=new FirefoxOptions();
        }else{
             capabilities=new ChromeOptions();
        }
        String urlformat=ConfigLoader.getpropertiesvalue(Constants.GRID_URL_FORMAT);
        String host=ConfigLoader.getpropertiesvalue(Constants.GRID_HUB_HOST);
        System.out.println(urlformat+"***************************");
        System.out.println(host+"***************************");
        String url= String.format(urlformat,host);
        System.out.println(host+"***************************");

        System.out.println(url+"-------------------------------------");
        this.driver=new RemoteWebDriver(new URL(url),capabilities);
        return driver;
    }

    //WebDriver for Testing in Local Machine
    private WebDriver LocalWebDriver() throws Exception{
        if(Constants.FIREFOX.equalsIgnoreCase(ConfigLoader.getpropertiesvalue(Constants.BROWSER))){
           return new FirefoxDriver();
        }else{
            return new ChromeDriver();
        }
    }

    @BeforeMethod
    public WebDriver SetDriver(ITestContext context) throws Exception{
        if(Boolean.parseBoolean(ConfigLoader.getpropertiesvalue(Constants.GRID_ENABLED))){
            this.driver= RemoteWebDriver();
        }else{
            this.driver=LocalWebDriver();
        }
        context.setAttribute(Constants.DRIVER,this.driver);
        return this.driver;
    }

    @AfterMethod
    public void AfterTest(){
        this.driver.quit();
    }

}
