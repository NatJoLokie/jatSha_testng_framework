package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtility {


    private static final By LOCATOR_VERIFY_USER_ACCOUNT_NAME = By.xpath("//a[@title='View my customer account']/span");

    private static final By LOCATOR_WELCOME_MESSAGE = By.xpath("//diiv[@class='app_logo']");

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
