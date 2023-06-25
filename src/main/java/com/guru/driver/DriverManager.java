package com.guru.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){

    }
    // ThreadLocal consists of 3 methods so we are using those method
    // the threadlocal make sures the methods and variables access to the same thread only
    private static ThreadLocal<WebDriver> tr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tr.get();
    }

    public static void setDriver(WebDriver driverRef) {
        tr.set(driverRef);
    }

    public static void unload() {
        tr.remove();
    }
}
