package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver(
            String browser,
            String executionEnv,
            String gridUrl) {

        if (executionEnv.equalsIgnoreCase("local")) {

            if (browser.equalsIgnoreCase("chrome")) {

                driver.set(new ChromeDriver());

            }
            else if (browser.equalsIgnoreCase("edge")) {

                driver.set(new EdgeDriver());

            }
            else if (browser.equalsIgnoreCase("firefox")) {

                driver.set(new FirefoxDriver());

            }
            else {

                throw new IllegalArgumentException(
                        "Invalid browser: " + browser);
            }
        }

        else if (executionEnv.equalsIgnoreCase("remote")) {

            try {

                if (browser.equalsIgnoreCase("chrome")) {

                    ChromeOptions options =
                            new ChromeOptions();

                    driver.set(
                            new RemoteWebDriver(
                                    new URL(gridUrl),
                                    options));

                }
                else if (browser.equalsIgnoreCase("edge")) {

                    EdgeOptions options =
                            new EdgeOptions();

                    driver.set(
                            new RemoteWebDriver(
                                    new URL(gridUrl),
                                    options));

                }
                else if (browser.equalsIgnoreCase("firefox")) {

                    FirefoxOptions options =
                            new FirefoxOptions();

                    driver.set(
                            new RemoteWebDriver(
                                    new URL(gridUrl),
                                    options));

                }
                else {

                    throw new IllegalArgumentException(
                            "Invalid browser: " + browser);
                }

            }
            catch (MalformedURLException e) {

                throw new RuntimeException(
                        "Invalid Grid URL: " + gridUrl,
                        e);
            }
        }

        else {

            throw new IllegalArgumentException(
                    "Invalid execution environment: "
                    + executionEnv);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}