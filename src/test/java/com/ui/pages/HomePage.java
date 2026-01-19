package com.ui.pages;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {

    public HomePage(Browser browserName) {
        super(browserName);
        goToWebSite(PropertiesUtility.readProperty(Env.QA, "URL"));
    }

    private static final By LOCATOR_LOGIN_BTN = By.xpath("//a[@class='login']");


    public LoginPage goToLoginPage() { // Page Functions --> void return type should not be used
        clickElement(LOCATOR_LOGIN_BTN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }


}
