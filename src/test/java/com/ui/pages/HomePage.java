package com.ui.pages;

import com.constants.Browser;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {

    public HomePage(Browser browserName) {
        super(browserName);
        goToWebSite("http://www.automationpractice.pl/index.php");
    }

    private static final By LOCATOR_LOGIN_BTN = By.xpath("//a[@class='login']");


    public LoginPage goToLoginPage() { // Page Functions --> void return type should not be used
        clickElement(LOCATOR_LOGIN_BTN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }


}
