package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageobjects.Loginpage;

public class Tc_001_login extends Baseclass {
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		Loginpage page=new Loginpage(driver);
		logger.info("login process is started");
		page.txtUsername(username);
		
		page.txtPassword(password);
		
		page.btnLogin();
		logger.info("clic login button");
		if(driver.getTitle().contains("Dashboard"))
		{
			Assert.assertTrue(true);
			System.out.println("test is passed");
			logger.info("logintest is passed");
			
		}
		else
		{
			captureScreen(driver,"Tc_001_login");
			Assert.assertTrue(false);
			System.out.println("test is failed");
			logger.info("login test is failed");
		}
	}
	
	
}
