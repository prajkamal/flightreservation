package com.flightReservation.baseClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BrowserControl {
	
	public WebDriver driver ;
	
	@BeforeClass
	  public void beforeClass() throws MalformedURLException {
		
		String host = "localhost";
		DesiredCapabilities dc;
		/*ChromeOptions optionsChrome=new ChromeOptions();
		optionsChrome.addArguments("start-maximized");
		optionsChrome.addExtensions(new File("C:\\Users\\prajk\\Documents\\Rajkamal\\Selenium\\AdBlocker\\extension_4_42_0_0.crx"));
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
		optionsChrome.merge(dc);*/
		//driver=new ChromeDriver(optionsChrome);
		
		if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
			dc=DesiredCapabilities.firefox();
		}else {
			ChromeOptions optionsChrome=new ChromeOptions();
			optionsChrome.addArguments("start-maximized");
			//optionsChrome.addExtensions(new File("C:\\Users\\prajk\\Documents\\Rajkamal\\Selenium\\AdBlocker\\extension_4_42_0_0.crx"));
			dc = DesiredCapabilities.chrome();
			dc.setCapability(ChromeOptions.CAPABILITY, optionsChrome);
			optionsChrome.merge(dc);
		}
		
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
		}
		
		String gridURL="http://" + host + ":4444/wd/hub";
		this.driver=new RemoteWebDriver(new URL(gridURL),dc);
		
	  }
	
	  @AfterClass
	  public void afterMethod() {
		 driver.quit();
	  }

}
