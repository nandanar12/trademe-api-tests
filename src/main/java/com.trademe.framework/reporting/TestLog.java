package com.trademe.framework.reporting;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TestLog {
    private static final Logger LOG = LogManager.getLogger(TestLog.class);
    private TestLog() {}

    public static void info(String msg, Object... args) {
        LOG.info(msg, args);
        ExtentTest t = ExtentTestListener.currentTest();
        if (t != null) t.info(format(msg, args));
    }

    private static String format(String template, Object... args) {
        return org.apache.logging.log4j.message.ParameterizedMessage.format(template, args);
    }
}
