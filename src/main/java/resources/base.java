package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;

	public Properties prop1;
	
	public WebElement prop;
	
	public WebDriver IntilializeDriver() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");

		prop.load(fis1);
		String BrowserName = prop.getProperty("browser");

		prop1 = new Properties();

		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceSampleFrameworkDesign\\src\\main\\java\\resources\\data.properties");

		prop1.load(fis2);

		String URL = prop1.getProperty("url");

		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		else {
			System.out.println("Browser not Found ,Make sure that browser is added");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}
	
	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source,new File(destinationFile));

}
}