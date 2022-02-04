package com.flightReservation.baseClass;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flightReservation.pages.BookFlight;
import com.flightReservation.pages.FlightConfirmationPage;
import com.flightReservation.pages.Flights;
import com.flightReservation.pages.RegistrationPage;
import com.flightReservation.pages.SelectFlight;

public class ReserveFlightsTest extends BaseClass {

	private String AUTURL = "http://newtours.demoaut.com/";
	private RegistrationPage rp;
	private String redgConfURL = "http://newtours.demoaut.com/create_account_success.php";
	private Flights flights;
	private SelectFlight sp;
	private BookFlight bf;
	private FlightConfirmationPage fcp;
	private String expectedPrice;
	private String actualPrice;

	@Test
	@Parameters({ "firstName", "lastName", "userName", "password", "confirmPassword" })
	public void registration(String firstName, String lastName, String uName, String pwd, String confPwd) {
		rp = new RegistrationPage(driver);
		this.driver.get(AUTURL);
		rp.clickRegisterLink();
		rp.completeRegistration(firstName, lastName, uName, pwd, confPwd);
		Assert.assertEquals(driver.getCurrentUrl(), redgConfURL);
	}

	@Test(dependsOnMethods = "registration")
	public void searchFlights() {
		flights = new Flights(driver);
		flights.findFlights();
	}

	@Test(dependsOnMethods = "searchFlights")
	public void selectFlight() {
		sp = new SelectFlight(driver);
		sp.reserveFlights();
	}

	@Test(dependsOnMethods = "selectFlight")
	public void bookFlight() {
		bf = new BookFlight(driver);
		expectedPrice = bf.secureFlight();
	}

	@Test(dependsOnMethods = "bookFlight")
	public void logOut() {
		fcp = new FlightConfirmationPage(driver);
		actualPrice = fcp.logout();
		Assert.assertEquals(actualPrice, expectedPrice);
	}

}
