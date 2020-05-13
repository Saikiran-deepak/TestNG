package com.capgemini.myntra.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.capgemini.base.Base;
import com.capgemini.pom.LoginPom;
import com.capgemini.pom.MyntraCreditPom;
import com.capgemini.pom.MyntraCreditTopUpPom;
import com.capgemini.pom.MyntraInsiderPom;
import com.capgemini.pom.PaymentPagePom;
import com.capgemini.pom.ProfilePom;

public class CreditEndToEnd extends Base {

	ProfilePom p;
	LoginPom login;
	MyntraInsiderPom insider;

	MyntraCreditPom credit;
	MyntraCreditTopUpPom topup;
	PaymentPagePom payment;

	@Parameters({ "Email", "Password", "browser", "url" })
	@BeforeTest

	public void tests(String Email, String Password, String browser, String url) {

		driver = Base.startBrowser(browser, url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		login = new LoginPom(driver);
		p = new ProfilePom(driver);

		login.enterMail(Email);
		login.password(Password);
		login.loginToMyntra();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.getMessage();
		}

	}

	@Test
	public void Test() throws InterruptedException {
		p = new ProfilePom(driver);
		// WebDriverWait wait=new WebDriverWait(driver, 5);
		credit = new MyntraCreditPom(driver);
		topup = new MyntraCreditTopUpPom(driver);
		payment = new PaymentPagePom(driver);
		p.profile();
		p.myntraCredit();
		credit.myntraTopUP();
		Thread.sleep(5000);
		topup.enterAmount();
	
		topup.topUpAfterEnteringAmount();
		
		payment.selectUPI();
		payment.selectPaymentOrder();
		payment.selectPhonePe();
		Thread.sleep(5000);
		payment.payNow();

		payment.sendOTP();
		String actual = payment.OTPSentToNumber();
		String expected = "SENDING OTP";
		Assert.assertEquals(actual, expected);

	}

//	@AfterMethod
//	public static void closeBrowser() {
//		driver.quit();
//	}

}
