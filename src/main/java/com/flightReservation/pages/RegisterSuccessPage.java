package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSuccessPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public RegisterSuccessPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='sign-in']")
	private WebElement signinLink;
	
	@FindBy(linkText="Flights")
	private WebElement flightsLink;
	
	public void flightFinderpage() throws InterruptedException {
		this.wait.until(ExpectedConditions.visibilityOf(this.signinLink));
		flightsLink.click();
		
	}
}
