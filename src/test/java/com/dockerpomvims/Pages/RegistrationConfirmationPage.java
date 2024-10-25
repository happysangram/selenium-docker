package com.dockerpomvims.Pages;


import com.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends BasePage {
    protected RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Go To Flights Search']")
    private WebElement flightBtn;

    @FindBy(tagName = "p")
    private WebElement confirmationPage;


    public boolean pageValidation() {
        return wait.until(ExpectedConditions.visibilityOf(flightBtn)).isDisplayed();
    }

    public String getConfirmation() {
        String ss=driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        return ss;
    }

    public FlightSearchPage regbtnclick() {
        wait.until(ExpectedConditions.visibilityOf(flightBtn)).click();
        return new FlightSearchPage(driver);
    }
}
