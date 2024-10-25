package com.venderpomvims.testcases;

import com.Base.BaseTest;
import com.utils.ConfigLoader;
import com.utils.Constants;
import com.venderpomvims.pages.DashboardPage;
import com.venderpomvims.pages.Loginpage;
import com.venderpomvims.pojos.Root;
import com.utils.Jsonutils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserDashboardsam extends BaseTest {

    private Root root;
    @BeforeTest
    @Parameters("jsonpath")
    public void BeforeTestfun(String jsonpath) throws Exception {
       this.root= Jsonutils.getObjectMapper(jsonpath);
    }

    @Test
    public void samdashboard() throws Exception {
        Loginpage loginpage=new Loginpage(driver);
        loginpage.geturl(ConfigLoader.getpropertiesvalue(Constants.VENDER_URL));
        DashboardPage dashboardPage= loginpage.enterCredential(root.getUname(),root.getPassword()).pressloginBtn();
        Assert.assertEquals(dashboardPage.annualyearingText(),root.getAnnualyearing());
        Assert.assertEquals(dashboardPage.availableInventoryText(),root.getAvailableInventory());
        Assert.assertEquals(dashboardPage.monthlyearingText(),root.getMonthlyearing());
        Assert.assertEquals(dashboardPage.profitmarginText(),root.getProfitmargin());
        dashboardPage.searchItem("Anna");
        Assert.assertEquals(dashboardPage.getresultCount(),3);
        dashboardPage.clickprofileicon();
        dashboardPage.logoutBtnclick();
        dashboardPage.logoutBtnclickModalWindow();

        loginpage.enterCredential("john","john").pressloginBtn();
        System.out.println(dashboardPage.annualyearingText());
        System.out.println(dashboardPage.availableInventoryText());
        System.out.println(dashboardPage.monthlyearingText());
        System.out.println(dashboardPage.profitmarginText());
        dashboardPage.searchItem("Andrew");
        Integer quanity=dashboardPage.getresultCount();
        System.out.println(quanity);
        dashboardPage.clickprofileicon();
        dashboardPage.logoutBtnclick();
        dashboardPage.logoutBtnclickModalWindow();

        loginpage.enterCredential("mike","mike").pressloginBtn();
        System.out.println(dashboardPage.annualyearingText());
        System.out.println(dashboardPage.availableInventoryText());
        System.out.println(dashboardPage.monthlyearingText());
        System.out.println(dashboardPage.profitmarginText());
        dashboardPage.searchItem("New");
        quanity=dashboardPage.getresultCount();
        System.out.println(quanity);
        dashboardPage.clickprofileicon();
        dashboardPage.logoutBtnclick();
        dashboardPage.logoutBtnclickModalWindow();
    }
}
