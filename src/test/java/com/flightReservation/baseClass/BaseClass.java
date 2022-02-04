package com.flightReservation.baseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;

	@BeforeTest
	public void beforeMethod() throws MalformedURLException {
		
		//DesiredCapabilities dc;
		MutableCapabilities dc;
		String host;
		//System.setProperty("BROWSER", "chrome");
		
		if(System.getProperty("BROWSER")!=null &&
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			//dc=DesiredCapabilities.firefox();
			dc = new FirefoxOptions();
		}else {
			//dc=DesiredCapabilities.chrome();
			dc=new ChromeOptions();
			System.out.println("Else");
		}
/*		
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			System.out.println("Docker Grid");
		} else {
			host="localhost";
			System.out.println("Local Host");
		}
		
		String hubURL="http://"+host+":4444/wd/hub";
		System.out.println(hubURL);
		driver=new RemoteWebDriver(new URL(hubURL), dc);
		// driver =new ChromeDriver();
*/		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	  @AfterTest
	  public void afterMethod() {
		 driver.quit();
	  }

}
