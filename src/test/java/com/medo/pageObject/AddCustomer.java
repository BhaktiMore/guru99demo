package com.medo.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver driver;

	public AddCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement newcustomer;

	@FindBy(name = "name")
	WebElement customername;

	@FindBy(how = How.NAME, using = "rad1")
	List<WebElement> customergender;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement customerdob;

	@FindBy(name = "addr")
	WebElement customeraddress;

	@FindBy(name = "city")
	WebElement customercity;

	@FindBy(name = "state")
	WebElement customerstate;

	@FindBy(name = "pinno")
	WebElement customerpin;

	@FindBy(name = "telephoneno")
	WebElement customernumber;

	@FindBy(name = "emailid")
	WebElement customeremail;

	@FindBy(name = "password")
	WebElement customerpwd;

	@FindBy(name = "sub")
	WebElement customersubmit;

	@FindBy(name = "res")
	WebElement customerreset;
	
	@FindBy(xpath="//label[@id='message']")
	WebElement nameerror;

	// Action Methods

	public void NewCustomerlink() {
		newcustomer.click();
	}

	public void setcusName(String cusname) {
		customername.sendKeys(cusname);
	}

	public void setcusgender(String cusgender) {

		customergender.get(1).click();

		// customergender.get(0).click();

	}

	public void setcusdob(String cusdob) {
		String day = cusdob.substring(1, 2);
		String month = cusdob.substring(4, 5);
		String year = cusdob.substring(6, 10);
		customerdob.sendKeys(day);
		customerdob.sendKeys(month);
		customerdob.sendKeys(year);

	}

	public void setcusaddr(String cusaddr) {
		customeraddress.sendKeys(cusaddr);
	}

	public void setcuscity(String cuscity) {
		customercity.sendKeys(cuscity);
	}

	public void setcusstate(String cusstate) {
		customerstate.sendKeys(cusstate);
	}

	public void setcuspin(String cuspin) {
		customerpin.sendKeys(cuspin);
	}

	public void setcusmobile(String cusmobileno) {
		customernumber.sendKeys(cusmobileno);
	}

	public void setcusemail(String cusemail) {
		customeremail.sendKeys(cusemail);
	}

	public void setcuspwd(String cuspwd) {
		customerpwd.sendKeys(cuspwd);
	}

	public void submit() {
		customersubmit.click();
	}

	public void reset() {
		customerreset.click();
	}
	
	public String getnameerror(){
		return nameerror.getText();
	}
}