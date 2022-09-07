package rahulshettyacademy.pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	
	WebElement SelectCountry;
	
	@FindBy(xpath="//a[normalize-space()='Place Order']")
	WebElement Submit;
	
	By CountryName=By.xpath("//*[@placeholder='Select Country']");
	
	By results=By.cssSelector(".ta-results");

	public void goToCheckOut() throws IOException {
		
		Actions a = new Actions(driver);

		Properties prop5 = new Properties();
		FileInputStream fis6 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");
		
		prop5.load(fis6);
		String Country=prop5.getProperty("countryname");
		
		a.sendKeys(driver.findElement(CountryName),Country).build().perform();
		
		waitForElementToAppearBy(results);
		
		SelectCountry.click();
		
	
	}
	public void SubmitOrder() {
		Submit.click();
		return;
	}
	
	

}