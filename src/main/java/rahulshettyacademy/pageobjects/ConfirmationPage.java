package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	public String CMessage;
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement ConfirmationMessage;

	public WebElement getConfirmationMessage() {
		String CMessage=ConfirmationMessage.getText();
		
		System.out.println(CMessage);
		
		Assert.assertTrue(CMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		return ConfirmationMessage;
	
		
	}
	
	
	
	
}



