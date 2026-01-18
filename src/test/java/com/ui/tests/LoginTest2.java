package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();

        HomePage homePage = new HomePage(Browser.CHROME);

        String loggedInAccountName = homePage.goToLoginPage().doLoginWith("tester01@mail.com", "Next@Gen@123").getLoggedInAccountName();

        System.out.println(loggedInAccountName);

    }

}
