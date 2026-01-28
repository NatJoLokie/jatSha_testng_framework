package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By LOCATOR_SELECT_MY_ACCOUNT = By.xpath("//a[@title='My Account']");
    private static final By LOCATOR_SELECT_LOGIN = By.xpath("//a[contains(text(),'Login')]");
    private static final By LOCATOR_ENTER_EMAIL_ID = By.xpath("//input[@id='input-email']");
    private static final By LOCATOR_ENTER_PASSWORD = By.xpath("//input[@id='input-password']");
    private static final By LOCATOR_SUBMIT_LOGIN_BTN = By.xpath("//input[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String email, String password) {
        clickElement(LOCATOR_SELECT_MY_ACCOUNT);
        clickElement(LOCATOR_SELECT_LOGIN);

        enterText(LOCATOR_ENTER_EMAIL_ID, email);
        enterText(LOCATOR_ENTER_PASSWORD, password);

        clickElement(LOCATOR_SUBMIT_LOGIN_BTN);

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        return myAccountPage;

    }

}
