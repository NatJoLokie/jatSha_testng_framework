package com.ui.listeners;

import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

//    private static final int MAX_RETRY_ATTEMPT = Integer.parseInt(PropertiesUtility.readProperty(Env.DEV, "MAX_RETRY_ATTEMPT"));
    private static final int MAX_RETRY_ATTEMPT = JsonUtility.readJson(Env.DEV).getMAX_RETRY_ATTEMPT();
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
