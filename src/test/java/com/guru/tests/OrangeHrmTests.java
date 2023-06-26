package com.guru.tests;

import Reports.ExtentReport;
import com.google.common.util.concurrent.Uninterruptibles;
import com.guru.pages.OrangeHRMHomePage;
import com.guru.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHrmTests extends BaseTest {

    protected OrangeHrmTests() {

    }

    //@Test(dataProvider = "verifyData")
    @Test
    public void loginLogoutVerify(String userName, String password) {

       // ExtentReport.createTest("This is a login and logut test case with data provider annotation");
       /* we can write like this as well
        OrangeHRMLoginPage orhml = new OrangeHRMLoginPage();
        orhml.enterPassword("Admin");
        orhml.enterPassword("admin123");
        orhml.clickLogin();

        */
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        // But if we want to acheive method chaining and clean code and readble then below approach is best
        OrangeHRMLoginPage orhml = new OrangeHRMLoginPage();
        String title = orhml.enterUserName(userName).enterPassword(password).clickLogin()
                .clickLogoutMenu().clickLogoutLink().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");

    }

    @Test
    public void newTestVerify(String userName, String password) {

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        // But if we want to acheive method chaining and clean code and readble then below approach is best
        OrangeHRMLoginPage orhml = new OrangeHRMLoginPage();
        String title = orhml.enterUserName(userName).enterPassword(password).clickLogin()
                .clickLogoutMenu().clickLogoutLink().getTitle();

        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");

    }

    @DataProvider(name = "verifyData",parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin", "admin1234"}
        };
    }
}
