package com.ui.tests;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import org.testng.annotations.BeforeMethod;

import static com.constants.Browser.CHROME;

public class TestBase {
    HomePage homePage;

    @BeforeMethod(description = "Setup before each test method")
    public void setUp() {
        homePage = new HomePage(CHROME);

    }

    public BrowserUtility getInstance() {
        return homePage;
    }


}