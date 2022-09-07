package rahulshettyacademy.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LoginPageFrameWork extends AbstractComponent {
	
	WebDriver driver;

	
	public LoginPageFrameWork(WebDriver driver) {
		
		
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	
	WebElement LoginEmail;
	
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement LoginPassword;
	
	
	@FindBy(xpath="//input[@id='login']")
	
	WebElement ConfirmLogin;
	
	
	public void LoginApplication() throws IOException {
		Properties prop2 = new Properties();
		FileInputStream fis3 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");
		prop2.load(fis3);
		
		String Username = prop2.getProperty("username");
		String Password = prop2.getProperty("password");
		LoginEmail.sendKeys(Username);
		LoginPassword.sendKeys(Password);
		ConfirmLogin.click();
	}
	
	
	
	}
