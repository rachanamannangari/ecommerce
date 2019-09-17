package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mongodb.MapReduceCommand.OutputType;
import com.nopcommerce.utilities.Readconfig;

public class Baseclass {
	Readconfig con=new  Readconfig();
	public WebDriver driver;
	public static Logger logger;
	public String username=con.getUsername();
	
		public String password=con.getPassword();	
	public	String baseURL=con.getApplicationurl();
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("set up method");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",con.getChrompath());
		 driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",con.getGeckodriver());
			 driver=new FirefoxDriver();
		}
	//String URL=	 "http://admin-demo.nopcommerce.com";
	driver.get(baseURL);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		logger.info("login test is closed");
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
