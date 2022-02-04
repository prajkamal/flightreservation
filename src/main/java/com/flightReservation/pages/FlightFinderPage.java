package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FlightFinderPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='roundtrip']")
	private WebElement tripTypeRoundTrip;
	
	@FindBy(xpath="//input[@value='oneway']")
	private WebElement tripTypeOneWay;
	
	@FindBy(name="passCount")
	private WebElement passengerCount;
	
	@FindBy(name="fromPort")
	private WebElement departureCity;
	
	@FindBy(name="toPort")
	private WebElement arrivalCity;
	
	@FindBy(name="findFlights")
	private WebElement continueBtn;
	
	
	public void selectPassengers(String numOfPassengers) {
		this.wait.until(ExpectedConditions.elementToBeClickable(passengerCount));
		Select selPassenger = new Select(passengerCount);
		selPassenger.selectByValue(numOfPassengers);
	}
	
	public void departureCity(String fromCity) {
		this.wait.until(ExpectedConditions.visibilityOf(departureCity));
		Select depCity=new Select(departureCity);
		depCity.selectByValue(fromCity);
		
	}
	
	public void arrivalCity(String toCity) {
		this.wait.until(ExpectedConditions.visibilityOf(arrivalCity));
		Select arrCity=new Select (arrivalCity);
		arrCity.selectByValue(toCity);
	}
	
	public void findFlights() {
		this.wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		System.out.println("Found Continue Button");
		
		continueBtn.click();
	}

}
