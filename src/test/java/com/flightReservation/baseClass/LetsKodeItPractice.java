package com.flightReservation.baseClass;

import org.testng.annotations.Test;

import com.flightReservation.pages.LoginPage;
import com.flightReservation.pages.PracticePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class LetsKodeItPractice extends BaseClass{
	
//	private WebDriver driver;
	private LoginPage lp;
	private PracticePage pp;
	private String expectedPracticePageURL="https://letskodeit.teachable.com/p/practice";

/*  @BeforeTest
  public void beforeMethod() {
	//  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }*/
  
  @Test
  public void clickPractice() {
	  lp=new LoginPage(driver);
	  lp.clickPracticeLink();
	  Assert.assertEquals(driver.getTitle(), "Practice | Let's Kode It");
  }
  
  @Test(dependsOnMethods="clickPractice")
  public void selectRadio() {
	  pp=new PracticePage(driver);
	  pp.selectRadioButtons();
	  
  }
  
  @Test(dependsOnMethods="selectRadio")
  public void selectCheckBx() {
	  pp=new PracticePage(driver);
	  pp.selectCheckBoxes();
  }
  
  @Test(dependsOnMethods="selectCheckBx")
  public void dropDown() {
	  pp=new PracticePage(driver);
	  pp.selectCarsFromDropDownBox();
  }
  
  @Test(dependsOnMethods="dropDown")
  @Parameters("name")
  public void hideshow(String name) throws InterruptedException {
	  pp=new PracticePage(driver);
	  pp.hideAndSeek(name);
  }
/*
  @AfterTest
  public void afterMethod() {
	  driver.quit();
	  
  }*/

}
