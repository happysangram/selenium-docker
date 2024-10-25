package com.dockerpomvims.Pages;


import com.Base.BasePage;
import com.utils.ConfigLoader;
import com.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//*[contains(@id,'lastName')]")
    private WebElement lastName;
    @FindBy(xpath = "//*[starts-with(@placeholder,'selenium')]")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(name = "street")
    private WebElement street;
    @FindBy(name = "city")
    private WebElement city;
    @FindBy(id = "inputState")
    private WebElement state;
    @FindBy(name = "zip")
    private WebElement zip;
    @FindBy(xpath = "//*[text()='Register']")
    private WebElement registerbtn;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageValidation() {
        geturl(ConfigLoader.getpropertiesvalue(Constants.FLIGHT_URL));
        return wait.until(ExpectedConditions.visibilityOf(firstName)).isDisplayed();
    }

    public RegistrationPage firstName(String name)  {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(name);
        return this;
    }

    public RegistrationPage lastName(String name) {
        wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(name);
        return this;
    }

    public RegistrationPage email(String mail) {
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(mail);
        return this;
    }

    public RegistrationPage password(String pass) {
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        return this;
    }

    public RegistrationPage street(String name) {
        wait.until(ExpectedConditions.visibilityOf(street)).sendKeys(name);
        return this;
    }

    public RegistrationPage city(String name) {
        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(name);
        return this;
    }

    //Alabama
    public RegistrationPage state(String name) {
        wait.until(ExpectedConditions.visibilityOf(state));
        Select select = new Select(state);
        select.selectByValue(name);
        return this;
    }

    public RegistrationPage zip(String name) {
        wait.until(ExpectedConditions.visibilityOf(zip)).sendKeys(name);
        return this;
    }

    public RegistrationConfirmationPage registrationPageBtn() {
        wait.until(ExpectedConditions.visibilityOf(registerbtn)).click();
        return new RegistrationConfirmationPage(driver);
    }
}
