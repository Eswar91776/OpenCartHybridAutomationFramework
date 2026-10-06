package utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name = "registrationData")

	public Object[][] registrationData() throws IOException {

		ExcelUtility excel = new ExcelUtility("src/test/resources/testData/RegistrationData.xlsx");
		int rowCount = excel.getRowCount("Registration");
		List<Object[]> data = new ArrayList<>();

		for (int i = 1; i < rowCount; i++) {

			String firstName =excel.getCellData("Registration", i, 0);
			String lastName =excel.getCellData("Registration", i, 1);
			String email =excel.getCellData("Registration", i, 2);
			String password =excel.getCellData("Registration", i, 3);

			if (!firstName.isEmpty()) {

				data.add(new Object[] {firstName,lastName,email,password});
			}
		}
		return data.toArray(new Object[0][]);
	}
		
		@DataProvider(name = "loginData")
		public Object[][] loginData() throws IOException {

		    ExcelUtility excel = new ExcelUtility("src/test/resources/testData/LoginData.xlsx");
		    int rowCount = excel.getRowCount("Login");
		    List<Object[]> data = new ArrayList<>();
		    
		    for (int i = 1; i < rowCount; i++) {
		        String email =excel.getCellData("Login", i, 0);
		        String password = excel.getCellData("Login", i, 1);

		        if (!email.isEmpty()) {

		            data.add(new Object[] {email,password });
		        }
		    }

		    return data.toArray(new Object[0][]);
	}
		
		@DataProvider(name = "loginInvalidData")
		public Object[][] loginInvalidData() throws IOException {

		    ExcelUtility excel = new ExcelUtility("src/test/resources/testData/LoginInvalidData.xlsx");
		    int rowCount = excel.getRowCount("LoginInvalid");
		    List<Object[]> data = new ArrayList<>();

		    for (int i = 1; i < rowCount; i++) {
		        String email =excel.getCellData("LoginInvalid", i, 0);
		        String password =excel.getCellData("LoginInvalid", i, 1);
		        String expectedMessage =excel.getCellData("LoginInvalid", i, 2);

		        if (!expectedMessage.isEmpty()) {
		            data.add(new Object[] {email,password,expectedMessage});
		        }
		    }

		    return data.toArray(new Object[0][]);
		}
		
}

