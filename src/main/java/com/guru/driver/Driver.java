package com.guru.driver;

import com.guru.constants.FrameworkConstants;
import com.guru.utils.ConfigProperties;
import com.guru.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {

    }


    public static void initDriver() throws Exception {
        //by adding this null check by chance if any manual tester calls initDriver() method anywhere it wont
        //create  as first time default constructor comes with null but after it will have value so is null fails so it wont
        //open browser again but this will have problem in parallel runs which we can avoid by using threadsafety concept
        if (Objects.isNull(DriverManager.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtil.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            //driver = null;
            // so instead of making null we are using the method of threadlocal only which removes the driver
            DriverManager.unload();
        }
    }
}
