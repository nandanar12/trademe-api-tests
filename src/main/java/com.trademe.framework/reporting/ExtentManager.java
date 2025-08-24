package com.trademe.framework.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            try {
                String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
                Path outDir = Path.of("target", "extent");
                Files.createDirectories(outDir);
                String reportPath = outDir.resolve("ExtentReport_" + stamp + ".html").toString();

                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
                spark.config().setReportName("API Tests");
                spark.config().setDocumentTitle("Test Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(spark);
                extent.setSystemInfo("Suite", "TestNG");
                extent.setSystemInfo("Java", System.getProperty("java.version"));
            } catch (Exception e) {
                throw new RuntimeException("Failed to init ExtentReports", e);
            }
        }
        return extent;
    }
}
