package com.dockerpomvims.Pages;


import com.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class FlightSearchResultPage extends BasePage {
    protected FlightSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Confirm Flights']")
    private WebElement confirmBtn;
    @FindBy(xpath = "//input[@name='departure-flight']")
    private List<WebElement> flightdeptlist;
    @FindBy(xpath = "//input[@name='arrival-flight']")
    private List<WebElement> flightarrivallist;


    public boolean pageValidation() {
        return wait.until(ExpectedConditions.visibilityOf(confirmBtn)).isDisplayed();
    }

    public FlightSearchResultPage setDeparture() {
        Random random = new Random();
        Integer num = random.nextInt(flightdeptlist.size());
        System.out.println(num);
        wait.until(ExpectedConditions.visibilityOf(flightdeptlist.get(num))).click();
        return this;
    }

    public FlightSearchResultPage setArrival() {
        Random random = new Random();
        Integer num = random.nextInt(flightarrivallist.size());
        System.out.println(num);
        wait.until(ExpectedConditions.visibilityOf(flightarrivallist.get(num))).click();
        return this;
    }

    public FlightResultConfirmationPage btnclick() {
        wait.until(ExpectedConditions.visibilityOf(confirmBtn)).click();
        System.out.println("btn clicked");
        return new FlightResultConfirmationPage(driver);
    }

}
