package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BrowserUtility {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void goToWebSite(String url) {
        driver.get(url);

    }

    public void maximizeWindow() {
        driver.manage().window().maximize();

    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();

    }

    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);

    }

    public String getVisibleText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
