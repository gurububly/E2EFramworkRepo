package com.guru.pages;

import Reports.ExtentLogger;
import Reports.ExtentManager;
import Reports.ExtentReport;
import com.google.common.util.concurrent.Uninterruptibles;
import com.guru.driver.DriverManager;
import com.guru.enums.WaitStrategy;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage extends BasePage {

    private final By logoutMenu = By.xpath("//span[@class='oxd-userdropdown-tab']/img");
    private final By logoutLink = By.xpath("//li[.='Logout']");

    public OrangeHRMHomePage clickLogoutMenu() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        click(logoutMenu, WaitStrategy.CLICKABLE);
        //The below statement is for logs
        ExtentLogger.pass("clicked on logoutMenu");
        return this;
    }

    public OrangeHRMLoginPage clickLogoutLink() {
        click(logoutLink, WaitStrategy.CLICKABLE);
        //The below statement is for logs
        ExtentLogger.pass("clicked on logoutLink");
        return new OrangeHRMLoginPage();
    }


}
