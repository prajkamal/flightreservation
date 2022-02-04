package com.flightReservation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String AUT="https://demo.guru99.com/test/newtours/register.php";
	private String registerConfirmationURL="https://demo.guru99.com/test/newtours/register_sucess.php";
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, 30);
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
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitBtn;
	
	public void clickRegisterLink() {
		driver.get(AUT);
		this.wait.until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
	}
	
	public void enterDataForRegistration(String firstName,String lastName,String userName,String password,String confirmPassword) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.confirmPassword.sendKeys(confirmPassword);
		this.submitBtn.click();
	}

}
