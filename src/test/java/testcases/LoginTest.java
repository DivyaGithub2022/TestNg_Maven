package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void LoginPositiveTest() {
		test  =report.startTest("LoginPositiveTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("divya.testgr@ymail.com", "Simplilearn@2022");
		
		report.endTest(test);
	}

	@Test
	public void LoginNegativeTest() {
		test  =report.startTest("LoginNegativeTest");
				
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com", "Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		//OR
//		if(ActualMsg.equals(ExpMsg)) {
//			System.out.println("TC Passed");
//		}else {
//			System.out.println("TC Failed");
//		}
		
		report.endTest(test);
				
	}
	
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedString(String UserNameVal, String PasswordVal) {
		test = report.startTest("Parameterized String Test");
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		report.endTest(test);
		
		// Donald gave this in chat for waiting - 
		//wait.until(ExpectedConditions.elementToBeClickable(login));
	}
	
	@Test
	public void ExternalDataSet() {
		test = report.startTest("External Data Set");
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
				
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		report.endTest(test);
	}


}
