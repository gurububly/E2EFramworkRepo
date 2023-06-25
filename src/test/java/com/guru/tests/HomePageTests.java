package com.guru.tests;

import com.guru.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class HomePageTests extends BaseTest {


    private HomePageTests() {

    }

    @Test
    public void test1() {


        DriverManager.getDriver().findElement(By.name("q")).sendKeys("guru", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
// here we are seeing how effective way we have written the assertions using assertJ library
        Assertions.assertThat(title)
                .isEqualTo("guru - Google Search")
                .isNotNull()
                .isNotEmpty()
                .contains("guru")
                .hasSizeBetween(10, 20);

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3/a"));
        Assertions.assertThat(elements)
                .extracting(e -> e.getText())
                .contains("Sign Up");
    }

}
