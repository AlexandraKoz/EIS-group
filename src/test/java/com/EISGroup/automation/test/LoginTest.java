package com.EISGroup.automation.test;

import com.EISGroup.automation.driver.DriverSingleton;
import com.EISGroup.automation.pobj.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverSingleton.getInstance();
//        LoginPage loginPage = new LoginPage();
    }

    @Test
    public void loginSuccess() {
        String expectedURL = "https://mail.google.com/mail/#inbox";
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://www.gmail.com/");
        WebDriverWait wait=new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='identifierNext']")));
        loginPage.loginAs("pupkin.vasiliy8888@gmail.com","hello_world_88");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MM'/a]")));
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).isEqualTo(expectedURL);

    }
//        // given
//        String expectedTitle = "IBA BY";
//        // when
//        driver.get("https://www.google.com/");
//        WebElement searchField = driver.findElement(By.name("q"));
//        searchField.sendKeys("IBA");
//        searchField.sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//div[@class='rc']//a[1]")).click();
//        String actualTitle = driver.getTitle();
//        // then
//        assertThat(actualTitle).isEqualTo(expectedTitle);
//    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
