package com.EISGroup.automation.pobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

   private By userEmailLocator = By.name("identifier");
   private By userPasswordLocator = By.name("password");
   private By loginEmailButtonLocator = By.xpath("//div[@id='identifierNext']");
   private By loginPasswordButtonLocator = By.xpath("//div[@id='passwordNext']");


    WebDriver driver;

    public void typeUsername(String username) {
        driver.findElement(userEmailLocator).sendKeys(username);
    }

    public void submitUsername() {
        driver.findElement(loginEmailButtonLocator).click();
    }

    public void typePassword(String password) {
        driver.findElement(userPasswordLocator).sendKeys(password);
    }

    public void submitPassword() {
        driver.findElement(loginPasswordButtonLocator).click();
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        submitUsername();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='passwordNext']")));
        typePassword(password);
        submitPassword();
    }
}
