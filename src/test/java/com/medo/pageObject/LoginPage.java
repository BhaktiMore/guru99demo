package com.medo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//elements of login page
	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement LoginButton		;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;

	//Action Methods
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
	LoginButton.click();
	}
	
	public void logoutlink(){
		logout.click();
	}

}
