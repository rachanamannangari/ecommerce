package com.nopcommerce.utilities;
import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {
	Properties pro;
public Readconfig() 
{
	File src=new File("./configuration/config.properties");
	try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
	System.out.println("Exception is" +e.getMessage()); 	//File not found exception
	}
	
	
}
public String getApplicationurl() {
	String baseURL=pro.getProperty("baseURL");
	return baseURL;
	
}
public String getUsername() {
	String username=pro.getProperty("useremail");
	return username;
	
}
public String getPassword() {
	String password=pro.getProperty("password");
	return password;
}

public String getChrompath()
{
	String chrompath=pro.getProperty("chropath");
	return chrompath;
}

public String getGeckodriver()
{
	String firefox=pro.getProperty("firefox");
	return firefox;
}



}