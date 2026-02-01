package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public void onTestStart(ITestResult result) {
        logger.info("Starting test: " + result.getMethod().getMethodName());
        logger.info("Starting test: " + result.getMethod().getDescription());
        logger.info("Starting test: " + Arrays.toString(result.getMethod().getGroups()));
        extentTest = extentReports.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName() + " " + "PASSED");
        extentTest.log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName() + " " + "FAILED");
        logger.error("Reason: " + result.getThrowable().getMessage());
        extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getMethod().getMethodName() + " " + "SKIPPED");
        extentTest.log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Starting test suite: ");

        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public void onFinish(ITestContext context) {
        logger.info("Finished test suite: ");
        extentReports.flush();

    }


}
