package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Browser.CHROME;

public class LoginTest3 {

    HomePage homePage;

    @BeforeMethod(description = "Setup before each test method")
    public void setUp() {
        homePage = new HomePage(CHROME);   // Setup code if needed
    }

    @Test(description = "Verify if a valid user is able to login to the application",
            groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "loginDataProvider")
    public void LoginTest(User user) {

//        String loggedInAccountName = homePage.goToLoginPage().doLoginWith("tester01@mail.com", "Next@Gen@123").getLoggedInAccountName();
//        Assert.assertEquals(loggedInAccountName, "Test User", "Logged in account name does not match expected value.");

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getLoggedInAccountName(), "Next Gen Tester", "Logged in account name does not match expected value.");

    }

}
