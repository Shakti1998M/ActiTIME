package testcases;

import java.io.IOException;
import org.testng.annotations.Test;
import basetest.BaseTest;
import pages.Login;

public class TC_Login extends BaseTest
{
	@Test
	public void login() throws IOException
	{
		Login login=new Login(driver);
		login.redirectToApp();
		login.loginToApp();
	}
}