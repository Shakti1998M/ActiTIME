package pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import autoconstant.AutoConstant;
import basepage.BasePage;
import testdata.ExcelLibrary;

public class Login extends BasePage implements AutoConstant
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(id = "username")
	private WebElement usernameTextbox;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextbox;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void redirectToApp()
	{
		waitTitleContains(driver, "Login");
		validateTitle(driver, "actiTIME - Login");
	}
	
	public void loginToApp() throws IOException
	{
		waitElementVisibility(driver, usernameTextbox);
		usernameTextbox.sendKeys(ExcelLibrary.getStringValueFromCell(login_sheet, 1, 0));
		
		waitElementVisibility(driver, passwordTextbox);
		passwordTextbox.sendKeys(ExcelLibrary.getStringValueFromCell(login_sheet, 1, 1));
		
		waitElementVisibility(driver, loginButton);
		loginButton.click();
	}
}