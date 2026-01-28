package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRY_ATTEMPT = 3;
    private static int CURRENT_ATTEMPT = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (CURRENT_ATTEMPT < MAX_RETRY_ATTEMPT) {

            CURRENT_ATTEMPT++;

            return true;


        }
        return false;
    }
}
