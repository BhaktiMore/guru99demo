package com.medo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage2 {
	
	WebDriver driver;

	public EditCustomerPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement editaddress;

	@FindBy(xpath = "//input[@name='city']")
	WebElement editcity;

	@FindBy(xpath = "//input[@name='state']")
	WebElement editstate;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement editpin;

	@FindBy(name = "telephoneno")
	WebElement editnumber;

	@FindBy(name = "emailid")
	WebElement editemail;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement editsubmitbtn;


	public void editAdd(String addr) {
		editaddress.sendKeys(addr);
	}

	public void editCity(String city) {

		editcity.sendKeys(city);
		
	}
	
	

	public void editstate(String state) {
		editstate.sendKeys(state);

	}

	public void editpin(String pin) {
		editpin.sendKeys(pin);
	}

	public void editmobileno(String mobile) {
		editnumber.sendKeys(mobile);
	}

	public void editemail(String email) {
		editemail.sendKeys(email);
	}

	public void editsubmit() {
		editsubmitbtn.click();
	}

}
