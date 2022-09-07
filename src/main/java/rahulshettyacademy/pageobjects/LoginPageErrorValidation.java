package rahulshettyacademy.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

import resources.base;

public class LoginPageErrorValidation extends AbstractComponent {

	public WebDriver driver;

	public String ErrMsg;

	public LoginPageErrorValidation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='userEmail']")

	WebElement LoginEmail;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement LoginPassword;

	@FindBy(xpath = "//input[@id='login']")
	WebElement ConfirmLogin;

	@FindBy(xpath = "//div[contains(text(),'*Enter Valid Email')]")
	WebElement EmailIdErrorMsg;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")

	WebElement ErrorMsg;

	public void ErrorCheck() throws IOException {

		Properties prop6 = new Properties();
		FileInputStream fis5 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\"
						+ "main\\java\\resources\\data.properties");
		prop6.load(fis5);
		String InvalidUsername = prop6.getProperty("invaliduser");
		String InvalidPassword = prop6.getProperty("invalidpassword");

		LoginEmail.sendKeys(InvalidUsername);
		LoginPassword.sendKeys(InvalidPassword);
		ConfirmLogin.click();
		waitForWebElementToAppearBy(ErrorMsg);
		String ErrMsg = ErrorMsg.getText();
		System.out.println(ErrMsg);
		// Incorrect email or password.
		Assert.assertEquals("Incorrect email or password.", ErrMsg);

	}

	/*public void EmailIdErrorCheck() throws InterruptedException {
		LoginEmail.sendKeys("fddsfds");
		LoginPassword.sendKeys("Jintojose1996");
		ConfirmLogin.click();

		waitForWebElementToAppearBy(EmailIdErrorMsg);

		String EmailIdErrMsg = EmailIdErrorMsg.getText();

		System.out.println(EmailIdErrMsg);

		Assert.assertEquals("*Enter Valid Email", EmailIdErrMsg);

	}*/

}
