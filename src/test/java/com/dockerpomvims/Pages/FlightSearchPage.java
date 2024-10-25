package com.dockerpomvims.Pages;


import com.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends BasePage {
    protected FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='flight-search-section']/descendant::input[@id='oneway']")
    private WebElement oneway;
    @FindBy(xpath = "//*[@id='flight-search-section']/descendant::input[@id='twoway']")
    private WebElement twoway;
    @FindBy(xpath = "//select[@id='passengers']")
    private WebElement passenger;
    @FindBy(xpath = "//select[@id='depart-from']")
    private WebElement departform;
    @FindBy(xpath = "//select[@id='arrive-in']")
    private WebElement arrivein;
    @FindBy(xpath = "//input[@id='service-class1']")
    private WebElement serviceclass1;
    @FindBy(xpath = "//input[@id='service-class2']")
    private WebElement serviceclass2;
    @FindBy(xpath = "//input[@id='service-class3']")
    private WebElement serviceclass3;
    @FindBy(xpath = "//button[@id='search-flights']")
    private WebElement searchflight;


    public boolean pageValidation() {
        return wait.until(ExpectedConditions.visibilityOf(searchflight)).isDisplayed();
    }

    public FlightSearchPage selectflightsearchsection(String way) {
        if (way == "One Way") {
            wait.until(ExpectedConditions.visibilityOf(oneway)).click();
        } else
            wait.until(ExpectedConditions.visibilityOf(twoway)).click();

        return this;
    }

    public FlightSearchPage selectPassengers(String numberOfPassengers) {

        wait.until(ExpectedConditions.visibilityOf(passenger)).isDisplayed();
        Select select = new Select(passenger);
        select.selectByValue(numberOfPassengers);
        return this;
    }

    public FlightSearchPage selectDepartment(String nameOfDept) {

        wait.until(ExpectedConditions.visibilityOf(departform)).isDisplayed();
        Select select = new Select(departform);
        select.selectByValue(nameOfDept);
        return this;
    }

    public FlightSearchPage selectArriveIn(String AriveIn) {

        wait.until(ExpectedConditions.visibilityOf(arrivein)).isDisplayed();
        Select select = new Select(arrivein);
        select.selectByValue(AriveIn);
        return this;
    }

    public FlightSearchPage selectServiceClass(String serviceclass) {
        if (serviceclass == "Economy") {
            wait.until(ExpectedConditions.visibilityOf(serviceclass1)).click();
        } else if (serviceclass == "First") {
            wait.until(ExpectedConditions.visibilityOf(serviceclass2)).click();
        } else
            wait.until(ExpectedConditions.visibilityOf(serviceclass3)).click();

        return this;
    }

    public FlightSearchResultPage searchFlightbtn() {
        wait.until(ExpectedConditions.visibilityOf(searchflight)).click();
        return new FlightSearchResultPage(driver);
    }


}
