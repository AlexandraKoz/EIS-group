package com.EISGroup.automation.test;

import com.EISGroup.automation.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFirst {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getInstance();
    }

    @Test
    public void example() {
        // given
        String expectedTitle = "IBA BY";
        // when
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("IBA");
        searchField.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='rc']//a[1]")).click();
        String actualTitle = driver.getTitle();
        // then
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }

}

