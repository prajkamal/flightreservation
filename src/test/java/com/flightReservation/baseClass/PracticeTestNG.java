package com.flightReservation.baseClass;

import org.testng.annotations.Test;

import com.flightReservation.pages.BookFlight;
import com.flightReservation.pages.FlightConfirmationPage;
import com.flightReservation.pages.Flights;
import com.flightReservation.pages.RegistrationPage;
import com.flightReservation.pages.SelectFlight;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PracticeTestNG {

	private WebDriver driver;
	private String baseURL = "https://demo.guru99.com/test/newtours/register.php";
	private String redgConfURL="https://demo.guru99.com/test/newtours/register_sucess.php";
	RegistrationPage rp;
	Flights flights;
	SelectFlight sp;
	BookFlight bf;
	FlightConfirmationPage fcp;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		rp=new RegistrationPage(driver);
		flights=new Flights(driver);
		sp=new SelectFlight(driver);
		bf=new BookFlight(driver);
		fcp=new FlightConfirmationPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		rp.clickRegisterLink();
		rp.completeRegistration("Test1", "Test2", "test@gmail.com", "123456", "123456");
		Assert.assertEquals(driver.getCurrentUrl(), redgConfURL);
		flights.findFlights();
		sp.reserveFlights();
		String expectedPrice=bf.secureFlight();
		String actualPrice=fcp.logout();
		Assert.assertEquals(actualPrice, expectedPrice);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
