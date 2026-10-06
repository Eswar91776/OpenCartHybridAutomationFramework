package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {

        if (extent == null) {
            ExtentSparkReporter sparkReporter =new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "OpenCart");
            extent.setSystemInfo("Tester", "Automation");
            extent.setSystemInfo("Environment", "Local");
        }

        return extent;
    }
}