package com.guru.pages;

import com.guru.driver.DriverManager;
import com.guru.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage {


    private final By userNameText = By.name("username");
    private final By passwordText = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginPage enterUserName(String userName) {
        sendKeys(userNameText, userName,WaitStrategy.PRESENCE);
        return this;
    }

    //we can write like this as well but to acheive method chaining we need to return the objects of call using this;
//    public void enterPassword(String password) {
//        DriverManager.getDriver().findElement(passwordText).sendKeys(password);
//    }
    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(passwordText, password,WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(loginButton,WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }

}
