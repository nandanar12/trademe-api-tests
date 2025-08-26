package com.trademe.framework.reporting;

import com.aventstack.extentreports.*;
import org.testng.*;

public class ExtentTestListener implements ITestListener, ISuiteListener {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> CURRENT = new ThreadLocal<>();

    public static ExtentTest currentTest() { return CURRENT.get(); }

    @Override public void onStart(ISuite suite) {
        extent = ExtentManager.getInstance();
    }

    @Override public void onFinish(ISuite suite) {
        if (extent != null) extent.flush();
    }

    @Override public void onTestStart(ITestResult r) {
        ExtentTest t = extent.createTest(r.getMethod().getMethodName());
        CURRENT.set(t);
    }

    @Override public void onTestSuccess(ITestResult r) { CURRENT.get().pass("PASS"); }
    @Override public void onTestFailure(ITestResult r) { CURRENT.get().fail(r.getThrowable()); }
    @Override public void onTestSkipped(ITestResult r) { CURRENT.get().skip(r.getThrowable()); }
}