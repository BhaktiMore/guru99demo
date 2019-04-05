package com.medo.testcases;

import org.testng.annotations.Test;
import com.medo.pageObject.AddCustomer;
import com.medo.pageObject.LoginPage;

public class TC_AddCustomer_VerifyName_002 extends BaseClass {

	@Test
	public void test_blank() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		AddCustomer cus = new AddCustomer(driver);
		cus.NewCustomerlink();
		cus.setcusName("");
		cus.setcusgender("female");
		String error = cus.getnameerror();
		System.out.println(error);

	}

	@Test
	public void test_numeric() {

		AddCustomer cus = new AddCustomer(driver);
		cus.NewCustomerlink();
		cus.setcusName("1632764348");
		cus.setcusgender("female");
		String error = cus.getnameerror();
		System.out.println(error);

	}

	@Test
	public void test_splchar() {

		AddCustomer cus = new AddCustomer(driver);
		cus.NewCustomerlink();
		cus.setcusName("Tushar#$");
		cus.setcusgender("female");
		String error = cus.getnameerror();
		System.out.println(error);

	}

	@Test
	public void test_space() {

		AddCustomer cus = new AddCustomer(driver);
		cus.NewCustomerlink();
		cus.setcusName(" Tushar");
		cus.setcusgender("female");
		String error = cus.getnameerror();
		System.out.println(error);

	}

}