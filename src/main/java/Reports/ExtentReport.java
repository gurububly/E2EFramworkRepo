package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.guru.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extentReports;
    public static ExtentTest test;

    private ExtentReport() {

    }

    public static void initReports() throws Exception {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportsFilePath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setDocumentTitle("Guru Automation Report");
            extentSparkReporter.config().setReportName("Automaion Tutorials");
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportsFilePath()).toURI());
    }

    public static void createTest(String testCaseName) {
        test = extentReports.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }
}
