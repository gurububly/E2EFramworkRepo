package com.guru.constants;

import com.guru.enums.ConfigProperties;
import com.guru.utils.PropertyUtil;

//here we are making class as final becoz i dont want people to extend to another class
public final class FrameworkConstants {

    // i dont want people to create object of this class thats y make private constructor
    private FrameworkConstants() {

    }


    private static final String RESOURCSEPATH = System.getProperty("user.dir") + "\\src\\test\\resources";

    //if there is variable better approach is to give private access if we give private access the to access that create getter method for that
    //without creating the getter method we wont be able to access the private varibles outside of class
    private static final String CHROMEDRIVERPATH = RESOURCSEPATH + "\\executables\\chromedriver.exe";

    private static final String CONFIGFILEPATH = RESOURCSEPATH + "\\config\\config.properties";

    private static final int EXPLICITWAIT = 10;

    private static final String EXTENTREPORTSFOLDERPATH = System.getProperty("user.dir") + "\\extent-test-output\\";
    private static String EXTENTREPORTSFILEPATH = "";

    public static String getExtentReportsFilePath() throws Exception {
        if (EXTENTREPORTSFILEPATH.isEmpty()) {
            EXTENTREPORTSFILEPATH = createReportPath();
        }
        return EXTENTREPORTSFILEPATH;
    }

    private static String createReportPath() throws Exception {
        if (PropertyUtil.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTSFOLDERPATH+System.currentTimeMillis()+"\\index.html";
        } else {
            return EXTENTREPORTSFOLDERPATH+"\\index.html";
        }

    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }


}
