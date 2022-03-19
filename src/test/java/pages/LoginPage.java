package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test = BaseClass.test;
	
	//======================== Web Elements ============================
	
	@FindBy(className = "login")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	//default constructor
	public LoginPage() {
		
		PageFactory.initElements(driver, this);	
		//when we use @FindBy, use initElements to initialize the Webelements
	}
	
	//======================== Functions ============================
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
//		======= Removing all the Webelements as it is already declared above =========
//		WebElement LoginLink = driver.findElement(By.className("login"));
//		WebElement UserName = driver.findElement(By.name("user_login"));
//		WebElement Password = driver.findElement(By.id("password"));
//		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
//		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		
		//Thread.sleep(5000);
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login link","Login link clicked successfully");
		
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter User name","Name entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password","Password entered successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on RememberMe","RememberMe clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button","Login button clicked successfully");
	}
	
	

}
