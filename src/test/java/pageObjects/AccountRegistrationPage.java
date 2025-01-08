package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']")     WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txttele;
	@FindBy(xpath="//input[@id='input-password']")  WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")   WebElement txtConPass;
    @FindBy(xpath="//label[normalize-space()='Yes']") WebElement btnSubscribe;
    @FindBy(xpath="//input[@name='agree']")          WebElement btnTerm;
    @FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
    
    public void setFirstName(String fname)
    {
    	txtFirstName.sendKeys(fname);
    }
    
    public void setLastName(String lname)
    {
    	txtLastName.sendKeys(lname);
    }
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    public void setTelephone(String tel)
    {
    	txttele.sendKeys(tel);
    }
    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }
    
    public void setConPassword(String conpwd)
    {
    	txtConPass.sendKeys(conpwd);
    }
    
    public void clickNewsletter()
    {
    	btnSubscribe.click();
    }
    public void clickTerm()
    {
    	btnTerm.click();
    }
    public void clickContinue()
    {
    	btnContinue.click();
    	//sol2
    	//btnContinue.submit();
    	//Sol3
    	//Actions act=new Actions(driver);
    	//act.moveToElement(btnContinue).click().perform();
    	//Sol4
    	//JavascriptExecutor js=(JavascriptExecutor)driver;
    	//js.executeScript("argument[0].click();", btnContinue);
    	//sol5
    	//btnContinue.sendKeys(Keys.RETURN);
    	//sol6
    	//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
    	
    }
    
    public String getConfirmationMsg()
    {
    	try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			
		return e.getMessage() ;
		}
    }
}
