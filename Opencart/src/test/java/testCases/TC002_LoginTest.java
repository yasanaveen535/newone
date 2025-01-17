package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAcountPage;

public class TC002_LoginTest extends BaseTest{
	
	@Test
	public void verify_Login()
	{
		
		logger.info("***started TC002_LoginTest *****");
		try
		{
		HomePage hm=new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLgnbutton();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(p.getProperty("Email"));
		lp.pwd(p.getProperty("password"));
		lp.clklogin();
		
		MyAcountPage mcc=new MyAcountPage(driver);
		boolean targetpage=mcc.isMyAccountExist();
		
		Assert.assertTrue(targetpage);
		}
		 catch (Exception e) 
		{
			Assert.fail();
		}
		finally 
		{
			logger.info("***Finished TC002_LoginTest *****");
		}
		
		
		
		
	}

}
