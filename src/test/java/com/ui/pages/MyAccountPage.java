package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {


    private static final By LOCATOR_VERIFY_USER_ACCOUNT_NAME = By.xpath("//div[@id='content']/h2[contains(text(),'My Account')]");

    private static final By LOCATOR_WELCOME_MESSAGE = By.xpath("//div[@id='content']/h2[contains(text(),'My Account')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInAccountName() {
        return getVisibleText(LOCATOR_VERIFY_USER_ACCOUNT_NAME);
    }

    public String verifyUserPage() {
        return getVisibleText(LOCATOR_WELCOME_MESSAGE);
    }

}
