package com.flightReservation.baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flightReservation.pages.FlightFinderPage;
import com.flightReservation.pages.RegisterPage;
import com.flightReservation.pages.RegisterSuccessPage;

public class TestRegistration extends BrowserControl {
	//private WebDriver driver;
	RegisterPage rp;
	RegisterSuccessPage rsp;
	FlightFinderPage ffp;

/*	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}*/

	@Test
	@Parameters({"firstname","lastname","username","password","confirmpassword"})
	public void registration(String firstname,String lastname,String username,String password,String confirmpassword) {
		rp = new RegisterPage(driver);
		rp.clickRegisterLink();
		rp.enterDataForRegistration(firstname, lastname, username, password, confirmpassword);
	}

	@Test(dependsOnMethods = "registration")
	public void clickFlights() throws InterruptedException {
		rsp = new RegisterSuccessPage(driver);
		rsp.flightFinderpage();
	}

	@Test(dependsOnMethods = "clickFlights")
	public void findFlights() {
		ffp = new FlightFinderPage(driver);
		ffp.selectPassengers("2");
		ffp.departureCity("London");
		ffp.arrivalCity("Paris");
		ffp.findFlights();
	}

/*	@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
}
