package com.ui.tests;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        BrowserUtility browserUtility = new BrowserUtility(driver);
//        browserUtility.goToWebSite("http://www.automationpractice.pl/index.php");
//        browserUtility.maximizeWindow();

        By locator_BtnLogin = By.xpath("//a[@class='login']");
        By locator_EnterEmailId = By.xpath("//input[@id='email']");
        By locator_EnterPassword = By.xpath("//input[@id='passwd']");
        By locator_BtnSubmitLogin = By.xpath("//button[@id='SubmitLogin']");

//        browserUtility.clickElement(locator_BtnLogin);
//
//        browserUtility.enterText(locator_EnterEmailId, "tester01@mail.com");
//
//        browserUtility.enterText(locator_EnterPassword, "Next@Gen@123");
//
//        browserUtility.clickElement(locator_BtnSubmitLogin);

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.goToLoginPage();

        loginPage.doLoginWith("tester01@mail.com", "Next@Gen@123");




    }

}
