package com.trademe.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

public class ExtentTestListener implements ITestListener, ISuiteListener {

    private static final ThreadLocal<ExtentTest> tl = new ThreadLocal<>();
    private ExtentReports extent;

    @Override
    public void onStart(ISuite suite) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ISuite suite) {
        if (extent != null) extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String name = result.getMethod().getMethodName();
        String cls = result.getTestClass().getName();
        ExtentTest test = extent.createTest(name).assignCategory(cls);
        tl.set(test);
        test.info("Starting: " + cls + "#" + name);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        tl.get().pass("Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest t = tl.get();
        t.fail(result.getThrowable());
        Object respBody = result.getAttribute("respBody");
        if (respBody != null) t.info("<pre>" + respBody + "</pre>");
    }

}