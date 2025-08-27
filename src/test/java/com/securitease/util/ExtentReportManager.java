package com.securitease.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report.html");
            sparkReporter.config().setDocumentTitle("API Test Report");
            sparkReporter.config().setReportName("SecuritEase QE Assessment");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void startTest(String testName) {
        ExtentTest test = getInstance().createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }
}