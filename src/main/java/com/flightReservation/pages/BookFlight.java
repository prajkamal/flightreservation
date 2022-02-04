package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlight {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BookFlight(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="passFirst0")
	private WebElement passFN;
	
	@FindBy(name="passLast0")
	private WebElement passLN;
	
	@FindBy(name="creditnumber")
	private WebElement creditCard;
	
	@FindBy(name="buyFlights")
	private WebElement buyFlightBtn;
	
	@FindBy(xpath="//font[contains(text(), 'Total Price')]/parent::td//following-sibling::td//font//b")
	private WebElement totalPrice;
	
	public String secureFlight() {
		String totPrice=totalPrice.getText();
		System.out.println("Actual Price : "+totPrice);
		passFN.sendKeys("James");
		passLN.sendKeys("Bond");
		creditCard.sendKeys("2323223343123232");
		buyFlightBtn.click();
		return totPrice;
	}

}
