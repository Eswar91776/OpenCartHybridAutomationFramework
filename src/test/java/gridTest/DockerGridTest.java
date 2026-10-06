package gridTest;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerGridTest {

    public static void main(String[] args) throws Exception {

        String gridUrl = "http://localhost:4444";

        ChromeOptions options = new ChromeOptions();

        WebDriver driver =
                new RemoteWebDriver(
                        new URL(gridUrl),
                        options);

        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}