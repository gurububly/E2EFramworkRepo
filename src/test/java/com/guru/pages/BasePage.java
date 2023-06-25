package com.guru.pages;

import Reports.ExtentLogger;
import com.guru.driver.DriverManager;
import com.guru.enums.WaitStrategy;
import com.guru.factories.ExplicityWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {


    protected void click(By by, WaitStrategy waitStrategy) {
//        ExplicityWaitFactory.performExplicitWait(waitStrategy,by);
//        DriverManager.getDriver().findElement(by).click();
        // we can use like above and below is alternative

        WebElement element = ExplicityWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
        try {
            ExtentLogger.pass("element clicked successfully", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
        WebElement element = ExplicityWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass("value entered successfully", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}

