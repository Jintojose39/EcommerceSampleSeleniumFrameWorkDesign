package rahulshettyacademy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import rahulshettyacademy.pageobjects.LoginPageErrorValidation;
import rahulshettyacademy.pageobjects.LoginPageFrameWork;
import resources.base;

public class LoginPageErrorValidationTest extends base {
	@BeforeTest

	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = prop1.getProperty("url");
		driver.get(URL);
	}
	
	@Test(priority=1)
	public void ErrormsgValidation() throws IOException{
		LoginPageErrorValidation EV = new LoginPageErrorValidation(driver);
		EV.ErrorCheck();
	}
	/*@Test()
	public void EmailIdErrorMsgCheck() throws InterruptedException {
		LoginPageErrorValidation EV = new LoginPageErrorValidation(driver);
		EV.EmailIdErrorCheck();
	}*/
	
	

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
