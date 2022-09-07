package rahulshettyacademy;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LoginPageFrameWork;
import rahulshettyacademy.pageobjects.ProductPage;
import resources.base;
public class FrameworkFullPageTest extends base {
	public WebDriver driver;
	
	@BeforeTest
	public void SetBrowser() throws IOException {
		driver = IntilializeDriver();
	}
	@Test(priority = 1)
	public void BasePageNavigation() {
		String URL = prop1.getProperty("url");
		System.out.println(URL);
		driver.get(URL);
	}
	@Test(priority = 2)
	public void EnterLoginData() throws IOException {
		LoginPageFrameWork LP = new LoginPageFrameWork(driver);
		LP.LoginApplication();
	}
	@Test(priority = 3)
	public void ClickProduct() throws IOException {
		ProductPage PC = new ProductPage(driver);
		List<WebElement> products = PC.getProductList();
		PC.addProductToCart();
	}
	@Test(priority = 4)
	public void CartSection() throws IOException {
		CartPage CP = new CartPage(driver);
		CP.gotoCart();
		CP.VerifyProductToDisplay();
		CP.goToCheckOut();
	}
	@Test(priority = 5)
	public void CheckOutSection() throws IOException {
		CheckOutPage CPG = new CheckOutPage(driver);
		CPG.goToCheckOut();
		CPG.SubmitOrder();
	}
	@Test(priority = 6)
	public void ConfirmationSection() {
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		confirmationpage.getConfirmationMessage();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}