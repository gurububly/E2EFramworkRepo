package com.guru.tests;

import Reports.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Test {

    ExtentReports extentReports;

    @org.testng.annotations.Test
    public void verifyTest() throws IOException {
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("index.html");
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Guru Automation Report");
        extentSparkReporter.config().setReportName("Automaion Tutorials");

        ExtentTest test = extentReports.createTest("first test1");
        test.pass("checking test1 logs");

        ExtentTest test1 = extentReports.createTest("first test2");
        test1.pass("checking test2 logs");

        extentReports.flush();

        Desktop.getDesktop().browse(new File("index.html").toURI());
    }
}
