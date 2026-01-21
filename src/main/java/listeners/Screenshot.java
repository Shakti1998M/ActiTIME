package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Screenshot implements ITestListener
{
	public WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result)
	{
		if(result.getStatus()==2)
			Reporter.log("test case is failed",true);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String methodName = result.getName();
		Date datetime = Calendar.getInstance().getTime();
		String date = datetime.toString().replaceAll(":", "-");
		try 
		{
			FileHandler.copy(srcFile, new File("./failedscreenshot/"+methodName+date+".png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}