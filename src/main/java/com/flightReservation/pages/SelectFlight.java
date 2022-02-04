package com.flightReservation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlight {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SelectFlight(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="outFlight")
	private List<WebElement> departFlights;
	
	@FindBy(name="inFlight")
	private List<WebElement> returnFlights;
	
	@FindBy(name="reserveFlights")
	private WebElement reserveFlightContBtn;
	
	public void reserveFlights() {
		departFlights.get(1).click();
		returnFlights.get(2).click();
		reserveFlightContBtn.click();
	}
}
