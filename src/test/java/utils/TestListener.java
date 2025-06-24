package utils;

import core.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;

public class TestListener implements ITestListener {

    public void onTestStart(ITestListener listener) {
        WebDriver driver = DriverFactory.getDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "target/screenshots/" + result.getMethod().getMethodName() + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                Allure.addAttachment("Screenshot", new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("WebDriver is null in onTestFailure");
        }
    }
}

