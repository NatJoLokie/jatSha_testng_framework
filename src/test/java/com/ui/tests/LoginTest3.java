package com.ui.tests;

import com.dto.UserDTO;
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

    @Test(description = "Verify if a valid user is able to login to the application using Json file",
            groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "loginDataProvider")
    public void LoginTest(User user) {

//        String loggedInAccountName = homePage.goToLoginPage().doLoginWith("tester01@mail.com", "Next@Gen@123").getLoggedInAccountName();
//        Assert.assertEquals(loggedInAccountName, "Test User", "Logged in account name does not match expected value.");

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getLoggedInAccountName(), "Next Gen Tester", "Logged in account name does not match expected value.");

    }

    @Test(description = "Verify if a valid user is able to login to the application using Csv file",
            groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "loginTestCsvDataProvider")
    public void LoginTestCsv(User user) {
        System.out.println("dob from csv : " + user.getDob());
//        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getLoggedInAccountName(), "Next Gen Tester", "Logged in account name does not match expected value.");
        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).verifyUserPage(), "Welcome to your account. Here you can manage all of your personal information and orders.", "User welcome message does not match expected value.");

    }


    @Test(description = "Verify if a valid user is able to login to the application using Excel file",
            groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "loginTestExcelDataProvider")
    public void LoginTestExcel(User user) {
//        System.out.println("dob from csv : " + user.getDob());
//        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getLoggedInAccountName(), "Next Gen Tester", "Logged in account name does not match expected value.");
        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).verifyUserPage(), "Swag Labs", "Swag Labs Page not loaded");

    }


    @Test(description = "Verify if a valid user is able to login to the application using Csv Dto file",
            groups = {"regression", "sanity"},
            dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "loginTestCsvDtoDataProvider")
    public void LoginTestCsvDto(UserDTO user) {
        System.out.println("Test Login Verify : " + user.getLoginVerify());
        System.out.println("Test date of Birth : " + user.get("dob"));
        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).verifyUserPage(), "Swag Labs", "Swag Labs Page not loaded");

    }


}
