package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties properties;
	public ConfigReader() throws IOException {
		FileInputStream file = new FileInputStream("src/test/resources/config.properties");
		properties = new Properties();
		properties.load(file);
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getExecutionEnv() {
	    return properties.getProperty("execution_env");
	}
	
	public String getGridUrl() {
	    return properties.getProperty("grid_url");
	}
}
