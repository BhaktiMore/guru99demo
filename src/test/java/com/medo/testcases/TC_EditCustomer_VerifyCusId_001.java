	package com.medo.testcases;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.medo.pageObject.EditCustomerPage1;
import com.medo.pageObject.LoginPage;

public class TC_EditCustomer_VerifyCusId_001 extends BaseClass {
	@Test
	public void edit_blank() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.submit_edit();

		Alert alert = driver.switchTo().alert();

		Thread.sleep(5);

		alert.accept();

	}

	@Test
	public void edit_numeric() throws InterruptedException {

		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("Ffg6765");
		edit.submit_edit();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(5);

		alert.accept();
		// alert.accept();// driver.switchTo().defaultContent();
	}

	@Test
	public void edit_splchar() throws InterruptedException {

		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("7875$#");
		edit.submit_edit();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(5);

		alert.accept();
		// alert.accept();// driver.switchTo().defaultContent();

	}

	@Test
	public void edit_valid() throws InterruptedException {

		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("33814");
		edit.submit_edit();
	
	}

}
