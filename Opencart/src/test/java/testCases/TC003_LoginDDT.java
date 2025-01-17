package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAcountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseTest {

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email,String pwd,String exp) {

		logger.info("*****Starting TC003_LoginDDT ******");
		try
		{
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		hm.clickLgnbutton();

		LoginPage lp = new LoginPage(driver);
		lp.username(email);
		lp.pwd(pwd);
		lp.clklogin();

		MyAcountPage mcc = new MyAcountPage(driver);
		boolean targetPage = mcc.isMyAccountExist();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				mcc.clickonlogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				mcc.clickonlogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch (Exception e) 
		{
			Assert.fail();
		}
			
		logger.info("****Finished TC003_LoginDDT *****");


		

	}

}
