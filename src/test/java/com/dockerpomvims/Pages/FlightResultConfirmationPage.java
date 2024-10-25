package com.dockerpomvims.Pages;


import com.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlightResultConfirmationPage extends BasePage {

   // private static final Logger log = (Logger) LoggerFactory.getLogger(FlightResultConfirmationPage.class);

    private static final Logger logger = LoggerFactory.getLogger(FlightResultConfirmationPage.class);


    protected FlightResultConfirmationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//*[@id=\"flights-confirmation-section\"]/descendant::p[6]") private WebElement finalPrice;

    @FindBy(xpath = "//*[@id=\"flights-confirmation-section\"]/descendant::p[4]") private WebElement confirmation_number;


    public boolean pageValidation() {
      String title=  this.driver.getTitle();
      System.out.println(title);
      if(title.equals("Book Your Flights"))
          return true;

      return false;
    }

    public String getPrice(){

        logger.info("Confirmation number is : " + wait.until(ExpectedConditions.visibilityOf(confirmation_number)).getText());
        logger.info("Final price is : " + wait.until(ExpectedConditions.visibilityOf(finalPrice)).getText());
       return wait.until(ExpectedConditions.visibilityOf(finalPrice)).getText();
    }
}
