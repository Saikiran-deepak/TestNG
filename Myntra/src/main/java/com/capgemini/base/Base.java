package com.capgemini.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.capgemini.pom.LoginPom;
import com.capgemini.pom.ProfilePom;


public class Base {
	public static WebDriver driver;
	static ProfilePom p1;
	static LoginPom login;

	public static WebDriver startBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\CG_automation\\Sunil sir\\selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\jee-2019-09\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		p1 = new ProfilePom(driver);
		login=new LoginPom(driver);
		p1.profile();
		login.loginButton();
		long i=System.currentTimeMillis()/1000;
		String a=String.valueOf(i);
		login.enterMobileNumber(a);
		login.clickOnLoginToEnterPassword();
		login.loginWithPassword();
		login.clearEnterNumer();

		return driver;
	}
	
	
	

}
