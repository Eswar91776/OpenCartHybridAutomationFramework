package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		 String timeStamp = LocalDateTime.now().format(formatter);
		String path = "screenshots/" + testName+ "_" + timeStamp  + ".png";
		Files.createDirectories(Path.of("screenshots"));
		Files.copy(source.toPath(), Path.of(path));
		
		return path;
		
	}
	
}
