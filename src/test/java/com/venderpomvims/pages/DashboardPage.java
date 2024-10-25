package com.venderpomvims.pages;

import com.Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="monthly-earning")
    private WebElement monthlyearing;

    @FindBy (id="annual-earning")
    private WebElement annualyearing;

    @FindBy (id="profit-margin")
    private WebElement profitmargin;

    @FindBy (id="available-inventory")
    private WebElement availableInventory;

    @FindBy(xpath="//div[@id='dataTable_filter']/descendant::input")
    private WebElement searchField;

    @FindBy(id = "dataTable_info")
    private WebElement searchResult;

    @FindBy(id = "userDropdown")
    private WebElement userprofileBtn;

    @FindBy(partialLinkText = "Logout")
    private WebElement logoutBtn;

    @FindBy(linkText = "Logout")
    private WebElement logoutbtnModalWindow;


    public String monthlyearingText(){
       return wait.until(ExpectedConditions.visibilityOf(monthlyearing)).getText();
    }

    public String annualyearingText(){
        return wait.until(ExpectedConditions.visibilityOf(annualyearing)).getText();
    }

    public String profitmarginText(){
        return wait.until(ExpectedConditions.visibilityOf(profitmargin)).getText();
    }

    public String availableInventoryText(){
        return wait.until(ExpectedConditions.visibilityOf(availableInventory)).getText();
    }

    public DashboardPage searchItem(String item){
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(item);
        this.searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public Integer getresultCount(){
        String msg= wait.until(ExpectedConditions.visibilityOf(searchResult)).getText();
        String[] li= msg.split("\\s");
        return Integer.parseInt(li[5]);
    }

    public DashboardPage clickprofileicon(){
        wait.until(ExpectedConditions.visibilityOf(userprofileBtn)).click();
        return this;
    }

    public DashboardPage logoutBtnclick() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(logoutBtn)).click();
        return this;
    }

    public Loginpage logoutBtnclickModalWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutbtnModalWindow)).click();
        return new Loginpage(driver);
    }



}
