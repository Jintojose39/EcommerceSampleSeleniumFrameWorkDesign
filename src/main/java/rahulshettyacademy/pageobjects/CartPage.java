package rahulshettyacademy.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public String ProductName;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	@FindBy(xpath = "//*[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	public Boolean VerifyProductToDisplay() throws IOException {

		Properties prop4 = new Properties();
		FileInputStream fis5 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");

		prop4.load(fis5);

		String ProductName = prop4.getProperty("productname");
		
		System.out.println(ProductName);

		Boolean match = cartProducts.stream()
				.anyMatch(carproduct -> carproduct.getText().equalsIgnoreCase(ProductName));
		System.out.println(match);
		Assert.assertTrue(match);
		
		
		return match;
	}

	public CheckOutPage goToCheckOut() {

		checkOut.click();

		return new CheckOutPage(driver);
	}
	
	
	
	
}