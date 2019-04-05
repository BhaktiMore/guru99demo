package com.medo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccount {
	
	WebDriver driver;

	public AddNewAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement cusid;
	
	@FindBy(xpath ="//select[@name='selaccount']")
	WebElement newacc;
	
    @FindBy(name="inideposit")
    WebElement depo;
    
    @FindBy(name="button2")
    WebElement submit_acc;
    
    @FindBy(name="reset")
    WebElement reset_acc;

    
    
    public void customerid(String cus) {

		cusid.sendKeys(cus);
	}

	public void acctype() {

		Select s=new Select(newacc);
		s.selectByIndex(1);
	}

	public void initdepo() {
		depo.sendKeys("3000");

	}

	public void submit_acc(){
	
		submit_acc.click();
	}
	
	public void reset_acc(){
		
		reset_acc.click();
	}
}
