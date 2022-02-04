package com.flightReservation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public PracticePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="bmwradio")
	private WebElement bmwRadioBtn;
	
	@FindBy(xpath="//input[@type='radio']")
	private List<WebElement> radioButtons;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	@FindBy(id="carselect")
	private WebElement carSelect;
	
	@FindBy(id="displayed-text")
	private WebElement textBox;
	
	@FindBy(id="show-textbox")
	private WebElement showBtn;
	
	@FindBy(id="hide-textbox")
	private WebElement hideBtn;
	
	public void hideAndSeek(String name) throws InterruptedException {
		textBox.sendKeys(name);
		Thread.sleep(5000);
		hideBtn.click();
		Thread.sleep(5000);
		showBtn.click();
		Thread.sleep(5000);
		textBox.clear();
		Thread.sleep(5000);
	}
	
	public void selectRadioButtons() {
		for(WebElement radioButton:radioButtons) {
			radioButton.click();
			System.out.println("Selected Option --> " + radioButton.getAttribute("value"));
		}
	}
	
	public void selectCheckBoxes() {
		for(WebElement checkBox:checkBoxes) {
			checkBox.click();
			System.out.println("Selected Option --> " + checkBox.getAttribute("value"));
		}
	}
	
	public void selectCarsFromDropDownBox() {
		Select sel=new Select(carSelect);
		sel.selectByIndex(0);
		System.out.println("By Index --> "+carSelect.getAttribute("value"));
		sel.selectByValue("benz");
		System.out.println("By Value --> "+carSelect.getAttribute("value"));
	}

}
