package gridTest;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridTest {

	public static void main(String[] args) throws MalformedURLException {
		String gridUrl = "http://192.168.176.94:4444";
		ChromeOptions options = new ChromeOptions();

		WebDriver driver = new RemoteWebDriver(new URL(gridUrl), options);

		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		driver.quit();
	}


}
