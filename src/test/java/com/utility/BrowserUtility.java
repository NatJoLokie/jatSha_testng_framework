package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    Logger logger = LoggerUtility.getLogger(this.getClass());


    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
//        super();
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            // Initialize ChromeDriver
            this.driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Initialize FirefoxDriver
            this.driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Initialize EdgeDriver
            this.driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public BrowserUtility(Browser browserName) {
        if (browserName == Browser.CHROME) {
            // Initialize ChromeDriver
            this.driver.set(new ChromeDriver());
            System.out.println("Chrome Browser is launched");
        } else if (browserName == Browser.FIREFOX) {
            // Initialize FirefoxDriver
            this.driver.set(new FirefoxDriver());
        } else if (browserName == Browser.EDGE) {
            // Initialize EdgeDriver
            this.driver.set(new EdgeDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }

    public void goToWebSite(String url) {
        maximizeWindow();
        driver.get().get(url);

    }

    private void maximizeWindow() {
        driver.get().manage().window().maximize();
    }

    public void clickElement(By locator) {
        WebElement element = driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator, String text) {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timeStamp = formatter.format(date);
        String path = System.getProperty("user.dir") + "/screenshots/" + name + "-" + timeStamp + ".png";
        File screenshotFile = new File(path);

        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;

    }

}
