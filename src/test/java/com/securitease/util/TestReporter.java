package com.securitease.util;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestReporter implements TestWatcher, AfterAllCallback {

    @Override
    public void testSuccessful(ExtensionContext context) {
        ExtentReportManager.getTest().pass("Test passed");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentReportManager.getTest().fail(cause);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        ExtentReportManager.getInstance().flush();
    }
}