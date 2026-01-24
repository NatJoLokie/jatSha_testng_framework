package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {
    private static final By LOCATOR_ENTER_EMAIL_ID = By.xpath("//input[@id='user-name']");
    private static final By LOCATOR_ENTER_PASSWORD = By.xpath("//input[@id='password']");
    private static final By LOCATOR_SUBMIT_LOGIN_BTN = By.xpath("//input[@id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String email, String password) {
        enterText(LOCATOR_ENTER_EMAIL_ID, email);
        enterText(LOCATOR_ENTER_PASSWORD, password);
        clickElement(LOCATOR_SUBMIT_LOGIN_BTN);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        return myAccountPage;

    }

}
