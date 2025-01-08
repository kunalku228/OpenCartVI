package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression", "Master"})
	public void verify_Account_Registration() throws InterruptedException
	{
		try{
			
		
		logger.info("*************Starting TCOO1 Account Registration*****************");
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer detail");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName("kumar");
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumberic();
		regpage.setPassword(password);
		Thread.sleep(5000);
		regpage.setConPassword(password);
		Thread.sleep(5000);
		regpage.clickNewsletter();
		regpage.clickTerm();
		regpage.clickContinue();
		Thread.sleep(5000);
		logger.info("Clicked on My Account");
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	catch(Exception e) {
		
		Assert.fail(); 
	}
		logger.info("*****Finised TCOO1 Account Registration*****************");
	}
}
