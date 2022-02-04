package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private String AUT="https://demo.guru99.com/test/newtours/index.php";
	private String registerConfirmationURL="https://demo.guru99.com/test/newtours/register_sucess.php";
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="REGISTER")
	private WebElement registerLink;
	
	@FindBy(name="firstName")
	private WebElement firstName;
	
	@FindBy(name="lastName")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	public void clickRegisterLink() {
		driver.get(AUT);
		wait.until(ExpectedConditions.visibilityOf(registerLink));
		registerLink.click();
	}
	
	public void completeRegistration(String fName,String lName,String uid,String pwd,String confirmPWD) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		userName.sendKeys(uid);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPWD);
		submitButton.click();
	}

}
