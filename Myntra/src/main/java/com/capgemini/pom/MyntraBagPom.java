package com.capgemini.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyntraBagPom {
	
	
	public MyntraBagPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
// To click on Bag Icon
	
	@FindBy(xpath="//span[text()='Bag']")
	WebElement bagicon;

	public void clickOnBagIcon()  {
		
		bagicon.click();
	}
	
	//To Click on apply coupons
//	@FindBy(xpath="//button[text()='APPLY']")
//	WebElement coupon;
//
//	public void clickOnAddCoupons() throws InterruptedException {
//		
//		coupon.click();
//	}
	@FindBy(xpath="//button[@class=\"coupons-base-button\"]")
	WebElement coupon;
	
	public void clickOnAddCoupons() {
		
		coupon.click();
	}
	
	//To Add coupons details
	
	@FindBy(xpath="//input[@placeholder=\"Enter coupon code\"]")
	WebElement coupon1;

	public void addCoupons(String coupon) {
		
		coupon1.sendKeys(coupon);
	}
	
	//To click on Apply after entering on Coupon Code
	
	@FindBy(xpath="//button[@id=\"applyCoupon\"]")
	WebElement applyafterCoupon;

	public void applyAfterAddingCoupon() {
		
		applyafterCoupon.click();
	}
	//To click on Place order
	
	@FindBy(xpath="//div[text()='Place Order']")
	WebElement purchase;

	public void placeOrder()  {
		
		purchase.click();


}
}