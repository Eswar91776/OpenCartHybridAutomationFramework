package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testBase.TestBase;
import utilities.ExtentReportUtility;
import utilities.ScreenshotUtility;

public class MyTestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportUtility.getExtentReport();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        WebDriver driver = TestBase.getDriver();

        if (driver == null) {
            return;
        }

        try {

            String screenshotPath =
                    ScreenshotUtility.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName());

            test.get().addScreenCaptureFromPath(
                    screenshotPath);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        // Generate / save the HTML report
        extent.flush();

        // Do NOT open the HTML report automatically.
        // Jenkins runs in a headless environment,
        // so Desktop.getDesktop() can cause HeadlessException.

        test.remove();
    }
}