package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseURL="https://letskodeit.teachable.com/";
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Practice")
	private WebElement practiceLink;
	
	public void clickPracticeLink() {
		 driver.get(baseURL);
		wait.until(ExpectedConditions.elementToBeClickable(practiceLink));
		practiceLink.click();
		wait.until(ExpectedConditions.titleContains("Practice"));
	}
}
