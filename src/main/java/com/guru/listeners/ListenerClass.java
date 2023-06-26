package com.guru.listeners;

import Reports.ExtentLogger;
import Reports.ExtentManager;
import Reports.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + "is Failed", true);
            //The below statement will add the logs for the failed case aswell
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "is Skipeed");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ISuite context) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onFinish(ISuite context) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


