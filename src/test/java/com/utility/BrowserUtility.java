package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public abstract class BrowserUtility {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
//        super();
        this.driver = driver;
    }

    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // Initialize ChromeDriver
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize FirefoxDriver
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Initialize EdgeDriver
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            // Initialize ChromeDriver
            driver = new ChromeDriver();
            System.out.println("Chrome Browser is launched");
        } else if (browserName == Browser.FIREFOX) {
            // Initialize FirefoxDriver
            driver = new FirefoxDriver();
        } else if (browserName == Browser.EDGE) {
            // Initialize EdgeDriver
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public void goToWebSite(String url) {
        maximizeWindow();
        driver.get(url);

    }

    private void maximizeWindow() {
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

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + name;
        File screenshotFile = new File(path);

        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;

    }

}
