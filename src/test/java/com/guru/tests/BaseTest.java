package com.guru.tests;

import Reports.ExtentReport;
import com.guru.constants.FrameworkConstants;
import com.guru.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    //private,protected,default, publics
    protected BaseTest() {
        //here we made protected constructor to avaible for the child classes cant make private here

    }
//These we are removing here and adding in listeners clas to make our tests loosly coupled instead of tight coupling
//    @BeforeSuite
//    public void beforeSuite() {
//        ExtentReport.initReports();
//    }
//
//    @AfterSuite
//    public void afterSuite() throws IOException {
//        ExtentReport.flushReports();
//    }

    @BeforeMethod
    protected void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
