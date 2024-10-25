package com.Listener;

import com.utils.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {



        // Capture screenshot
        String screenshot = ((TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER)).getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlimgage=String.format(htmlImageFormat,screenshot);
        Reporter.log(htmlimgage);

//        // Generate a unique file name
//        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
//        String screenshotName = result.getName() + "_" + timestamp + ".png";
//
//        // Define the destination where the screenshot will be saved
//        File destinationPath = new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
//
//        try {
//            // Copy the screenshot to the destination
//            FileHandler.copy(screenshot, destinationPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Add the screenshot to the TestNG report
//        String relativePath = "Screenshots/" + screenshotName;
//        String screenshotHtml = "<a href='" + relativePath + "' target='_blank'>" +
//                "<img src='" + relativePath + "' height='100' width='100'/>" +
//                "</a>";
//        Reporter.log(screenshotHtml);  // Add to TestNG report
    }
}
