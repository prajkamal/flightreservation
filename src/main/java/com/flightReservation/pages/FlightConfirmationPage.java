package com.flightReservation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FlightConfirmationPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//font[contains(text(), 'USD')]")
	private List<WebElement> ticketPrice;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement logout;
	
	public String logout() {
		String actualPrice=ticketPrice.get(1).getText().substring(0, 5);
		System.out.println("Actual Ticket Price :"+actualPrice);
		logout.click();
		return actualPrice;
	}

}
