package basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import autoconstant.AutoConstant;

public class BaseTest implements AutoConstant
{	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		FileInputStream fis=new FileInputStream(properties_path);
		Properties properties=new Properties();
		properties.load(fis);
		driver.get(properties.getProperty("url"));
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}