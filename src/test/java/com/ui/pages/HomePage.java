package com.ui.pages;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {

    public HomePage(Browser browserName) {
        super(browserName);
//        goToWebSite(PropertiesUtility.readProperty(Env.QA, "URL"));
        goToWebSite(JsonUtility.readJson(Env.DEV));


//        System.out.println("Home Page: "+JsonUtility.readJson(Env.QA).toString());
    }

    private static final By LOCATOR_LOGIN_BTN = By.id("customer_login_link");


    public LoginPage goToLoginPage() { // Page Functions --> void return type should not be used
//        clickElement(LOCATOR_LOGIN_BTN);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }


}
