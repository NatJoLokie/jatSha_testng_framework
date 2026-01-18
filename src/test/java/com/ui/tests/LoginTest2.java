package com.ui.tests;

import com.ui.pages.HomePage;

import static com.constants.Browser.CHROME;

public class LoginTest2 {
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(CHROME);

        String loggedInAccountName = homePage.goToLoginPage().doLoginWith("tester01@mail.com", "Next@Gen@123").getLoggedInAccountName();

        System.out.println(loggedInAccountName);

    }

}
