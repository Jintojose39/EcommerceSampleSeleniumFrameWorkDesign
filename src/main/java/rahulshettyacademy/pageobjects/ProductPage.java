package rahulshettyacademy.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent {

	WebDriver driver;

	public String ProductName;
	
	public String InvalidProductName;
	
	public WebElement prod;

	public ProductPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement Spinner;
	By productsBy = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {

		waitForElementToAppearBy(productsBy);
		return products;
	}

	public WebElement getProductName() throws IOException {

		Properties prop3 = new Properties();
		FileInputStream fis4 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");

		prop3.load(fis4);

		String ProductName = prop3.getProperty("productname");
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);

		return prod;

	}

	public void addProductToCart() throws IOException {

		WebElement prod = getProductName();

		prod.findElement(addtoCart).click();

		waitForElementToAppearBy(toastMessage);

		waitForElementToDisappear(Spinner);
	}
	
	public WebElement ErrorProductCheck() throws IOException {
		Properties prop6 = new Properties();
		FileInputStream fis7 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");

		prop6.load(fis7);
		
		String InvalidProductName = prop6.getProperty("invalidproductname");
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(InvalidProductName)).findFirst()
				.orElse(null);
		

		return prod;
	}
	
	public void addErrorProductCart() throws IOException {
		WebElement prod = ErrorProductCheck();
		
		prod.findElement(addtoCart).click();

		waitForElementToAppearBy(toastMessage);

		waitForElementToDisappear(Spinner);
		
	}
	
	
	
	

}
