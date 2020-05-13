package com.capgemini.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.base.Base;

public class LoginPom extends Base {

	public LoginPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mobileNumberPass")
	WebElement num;

	public void enterMail(String email) {
		num.sendKeys(email);
	}
	
	public void clearEnterNumer() {
		num.clear();
	}

	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement pass;
	
	public void password(String passw) {
		pass.sendKeys(passw);
	}	
	
	@FindBy(xpath="//button[text()=\"LOGIN\"]")
	WebElement log;
	public void loginToMyntra() {
		log.click();
	}
	//To click on login Button
		@FindBy(xpath="//a[@class=\"desktop-linkButton\"]")
		WebElement login;
		public void loginButton() {
			login.click();
		}
		
		//To enter mobile number
		@FindBy(xpath="//input[@class=\"form-control mobileNumberInput\"]")
		WebElement num1;
		public void enterMobileNumber(String num) {
			num1.sendKeys(num);;
		}
		//To click on login Button
		@FindBy(xpath="//div[@class=\"submitBottomOption\"]")
		WebElement login1;
		public void clickOnLoginToEnterPassword() {
			login1.click();
		}
		//To click on login using password
		@FindBy(xpath="//span[text()=' Password ']")
		WebElement logwithpass;
		public void loginWithPassword() {
			logwithpass.click();
		}


}
