package rahulshettyacademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LoginPageFrameWork;
import rahulshettyacademy.pageobjects.ProductPage;
import resources.base;

public class ProductErrorValidationTest extends base{
	
	
	WebDriver driver;
	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = prop1.getProperty("url");
		driver.get(URL);
}
	@Test
	public void ProductErrorValidation() throws IOException {
		LoginPageFrameWork LP = new LoginPageFrameWork(driver);
		LP.LoginApplication();
		ProductPage PC = new ProductPage(driver);
		List<WebElement> products = PC.getProductList();
		CartPage Cpg=new CartPage(driver);
		Boolean match=Cpg.VerifyProductToDisplay();

		Assert.assertTrue(match);
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

/*@AfterTest
public void tearDown() {
	driver.close();*/
}
