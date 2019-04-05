package com.medo.pageObject;
//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage1 {
	WebDriver driver;

	public EditCustomerPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement editcuslink;

	@FindBy(xpath = "//input[@name='cusid']")
	WebElement customerid;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement editsubmit;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement editreset;

	@FindBy(xpath="//label[contains(text(),'Characters are not allowed')]")
	WebElement characterinvalid;
	
	public void setcustomerid(String cusid) {

		customerid.sendKeys(cusid);
	}

	public void submit_edit() {

		editsubmit.click();
	}

	public void reset_edit() {
		editreset.click();

	}

	public void editcuslink() {

		editcuslink.click();
	}
	
	public void ErrCharInvalid() {

		characterinvalid.getText();
	}

}
