package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
	Properties properties;
	public TestDataReader() throws IOException {
		properties = new Properties();
		FileInputStream file = new FileInputStream("src/test/resources/testData/RegistrationData.xlsx");
		properties.load(file);
	}
	
	public String getFirstName() {
		return properties.getProperty("firstName");
	}
	
	public String getLastName() {
		return properties.getProperty("lastName");
	}
	
	public String getEmailPrefix() {
		return properties.getProperty("emailPrefix");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
}
