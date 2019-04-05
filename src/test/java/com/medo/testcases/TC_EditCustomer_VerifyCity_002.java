package com.medo.testcases;

//import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.medo.pageObject.EditCustomerPage1;
import com.medo.pageObject.EditCustomerPage2;
import com.medo.pageObject.LoginPage;

public class TC_EditCustomer_VerifyCity_002 extends BaseClass {
	
	@Test
	public void edit_blank() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("33814");
		edit.submit_edit();
		
		EditCustomerPage2 edit2=new EditCustomerPage2(driver);
		edit2.editCity(" ");		
	
	}

	@Test
	public void edit_city_numeric() {
	
		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("33814");
		edit.submit_edit();
		
		EditCustomerPage2 edit2=new EditCustomerPage2(driver);
		edit2.editCity("12345 ");
	}
	
	@Test
	public void edit_city_splchar() {
	
		EditCustomerPage1 edit = new EditCustomerPage1(driver);
		edit.editcuslink();
		edit.setcustomerid("33814");
		edit.submit_edit();
		
		EditCustomerPage2 edit2=new EditCustomerPage2(driver);
		edit2.editCity("%$#@Ghgf ");
	}
	
}
