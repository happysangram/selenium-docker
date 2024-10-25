package com.venderpomvims.pages;

import com.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Loginpage extends BasePage {
    public Loginpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username") private WebElement uname;
    @FindBy(id="password") private WebElement password;
    @FindBy(id="login") private WebElement btn;

    public Loginpage enterCredential(String username, String pass){
        wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        return this;
    }
     public void invokeVendorUrl(String url){
        geturl(url);
     }

    public DashboardPage pressloginBtn(){
        wait.until(ExpectedConditions.visibilityOf(btn)).click();
        return new DashboardPage(driver);
    }

}
