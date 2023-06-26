package com.guru.utils;

import com.guru.constants.FrameworkConstants;
import com.guru.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtil {

    private PropertyUtil() {

    }

    private static Properties property = new Properties();

    // here we are using static block it loads at the time of class loading only once instead of doing object creation multiple times or opening filestream multiple times
    //thats why we have used static block here
    static {
        try {
            FileInputStream fis = fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(ConfigProperties key) throws Exception {
        //we are adding null check here if not null it just return the value of the key
        if (Objects.isNull(key) || Objects.isNull(property.getProperty(key.name().toLowerCase()))) {
            throw new Exception("Property name " + key + " is not found. please check config.properties file");
        }
        return property.getProperty(key.name().toLowerCase()).trim();
    }
}
