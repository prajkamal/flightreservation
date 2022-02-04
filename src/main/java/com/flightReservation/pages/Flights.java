package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flights {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Flights(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Flights")
	private WebElement flightLink;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	private WebElement roundTripRadioBtn;
	
	@FindBy(xpath="//input[@value='oneway']")
	private WebElement oneWayRadioBtn;
	
	@FindBy(name="passCount")
	private WebElement passengers;
	
	@FindBy(name="fromPort")
	private WebElement depatureCity;
	
	@FindBy(name="fromMonth")
	private WebElement fromMonth;
	
	@FindBy(name="fromDay")
	private WebElement fromDay;
	
	@FindBy(name="toPort")
	private WebElement arrivalCity;
	
	@FindBy(name="toMonth")
	private WebElement toMonth;
	
	@FindBy(name="toDay")
	private WebElement toDay;
	
	@FindBy(xpath="//input[@value='Coach']")
	private WebElement economyClass;
	
	@FindBy(xpath="//input[@value='Business']")
	private WebElement businessClass;
	
	@FindBy(xpath="//input[@value='First']")
	private WebElement firstClass;
	
	@FindBy(name="airline")
	private WebElement selectAirline;
	
	@FindBy(name="findFlights")
	private WebElement continueBtn;
	
	public void findFlights() {
		flightLink.click();
		roundTripRadioBtn.click();
		Select passenger=new Select(passengers);
		passenger.selectByIndex(1);
		
		Select depart=new Select(depatureCity);
		depart.selectByIndex(3);
		Select frmMonth=new Select(fromMonth);
		frmMonth.selectByIndex(9);
		Select depDate=new Select(fromDay);
		depDate.selectByValue("23");
		
		Select arrive=new Select(arrivalCity);
		arrive.selectByIndex(2);
		Select toMon=new Select(toMonth);
		toMon.selectByIndex(10);
		Select arrDate=new Select(toDay);
		arrDate.selectByValue("23");
		
		Select airline =new Select(selectAirline);
		airline.selectByIndex(2);
		
		continueBtn.click();
		
		
	}
	
	
}
