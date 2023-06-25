package Reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.guru.driver.DriverManager;
import com.guru.utils.ConfigProperties;
import com.guru.utils.PropertyUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {


    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);

    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);

    }

    public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else {
            skip(message);
        }
    }


    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
