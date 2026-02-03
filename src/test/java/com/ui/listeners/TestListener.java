package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
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
//        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
//        extentTest = ExtentReporterUtility.getTest();
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getMethod().getMethodName() + " " + "PASSED");
//        extentTest.log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName() + " " + "FAILED");
        logger.error("Reason: " + result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage() + " FAILED");

        Object testClass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
        logger.info("Taking screenshot for failed test: " + result.getMethod().getMethodName());

        String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Screenshot path: " + screenShotPath);
        ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenShotPath, "Failed Test Screenshot");
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Starting test suite: ");
        ExtentReporterUtility.setupSparkReporter("extentReport.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Finished test suite: ");
//        extentReports.flush();
        ExtentReporterUtility.flushReports();

    }


}
