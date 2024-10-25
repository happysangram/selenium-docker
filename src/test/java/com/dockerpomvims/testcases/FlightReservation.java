package com.dockerpomvims.testcases;


import com.Base.BaseTest;
import com.dockerpomvims.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservation extends BaseTest {

    RegistrationPage page;
    RegistrationConfirmationPage RegconfirmPage;
    FlightSearchPage flightSearchPage;
    FlightSearchResultPage flightSearchResultPage;
    FlightResultConfirmationPage flightResultConfirmationPage;
    private String numberOfpassengers;
    private String priceval;
    @BeforeTest
    @Parameters({"numberOfpassengers" ,"priceval"})
    public void BeforeTest(String numberOfpassengers, String priceval){
        this.numberOfpassengers=numberOfpassengers;
        this.priceval=priceval;
    }

    @Test
    public void Registration() {
        page = new RegistrationPage(driver);
        if (page.pageValidation()) {
            page.firstName("Sangram Kumar")
                    .lastName("Das")
                    .city("Bangalore")
                    .email("Sangramdas1989@gmail.com")
                    .zip("1001")
                    .street("Shriram Greenfield")
                    .password("Cooper@123");
            System.out.println("Registration is successful");
        } else {
            System.out.println("Page is not loaded");

        }
        RegconfirmPage = page.registrationPageBtn();
        if (RegconfirmPage.pageValidation()) {
            String msg = RegconfirmPage.getConfirmation();
            Assert.assertTrue(msg.contains("Sangram Kumar"));
        }else{
            System.out.println("Page is not loaded");
        }

        flightSearchPage = RegconfirmPage.regbtnclick();
        if (flightSearchPage.pageValidation()) {
            flightSearchPage.selectflightsearchsection("One Way");
            flightSearchPage.selectPassengers(numberOfpassengers);
            flightSearchPage.selectDepartment("London");
            flightSearchPage.selectArriveIn("Paris");
            flightSearchPage.selectServiceClass("Economy");
            flightSearchResultPage = flightSearchPage.searchFlightbtn();
        } else {
            System.out.println("Flight Sreach Page not found");
        }
        if(flightSearchResultPage.pageValidation()) {

            flightSearchResultPage.setDeparture();
            flightSearchResultPage.setArrival();
        }
        flightResultConfirmationPage=  flightSearchResultPage.btnclick();
        if(flightResultConfirmationPage.pageValidation()){
            System.out.println("Inside");
            String price= flightResultConfirmationPage.getPrice();
            Assert.assertEquals(price,priceval);
        }
    }

}
