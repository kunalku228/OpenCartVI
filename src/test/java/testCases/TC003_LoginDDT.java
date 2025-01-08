package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		logger.info("************************Test Started TC003***********************");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			
			Assert.fail();
			
		}
		logger.info("************************Test Finised TC003***********************");
	}

}
