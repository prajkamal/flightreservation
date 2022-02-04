package com.flightReservation.baseClass;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CoursesSearch extends BrowserControl{
	
	//private WebDriver driver;
	private SearchPage sp;
	
/*  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }*/
  
  @Test
  @Parameters({"keyword"})
  public void search(String keyword) {
	  sp=new SearchPage(driver);
	  sp.goTo();
      sp.doSearch(keyword);
      sp.goToVideos();
      int size = sp.getResult();
      Assert.assertTrue(size > 0);
  }
/*
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }*/

}
