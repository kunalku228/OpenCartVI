package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity", "Master"})
	public void verifyLogin()
	{
		logger.info("********************starting LoginTest002******************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**************Finised LoginTest002***************");
	}

}
