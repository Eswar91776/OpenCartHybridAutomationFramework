package testCases;

import org.testng.annotations.Test;

import utilities.DataProviderUtility;

public class DataProviderTest {
	
	@Test
	(dataProvider = "registrationData",dataProviderClass = DataProviderUtility.class)
	public void testData(String firstName,String lastName,String email,String password) {

		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
	}
}
