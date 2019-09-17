package com.nopcommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	
	WebDriver ldriver;
	public Loginpage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath= "//input[@id='Email']") WebElement txtusername;
	
	@FindBy(xpath= "//input[@id='Password']") WebElement txtpassword;
	@FindBy(xpath=" //input[@class='button-1 login-button']") WebElement btnlogin;
	public void txtUsername(String uname)
	{
		txtusername.sendKeys(uname);
		
		
	}
	public void txtPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void btnLogin()
	{
		btnlogin.click();
	}
	
	
}
 