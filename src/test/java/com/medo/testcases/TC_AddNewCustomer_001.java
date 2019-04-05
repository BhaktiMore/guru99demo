package com.medo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medo.pageObject.AddCustomer;
import com.medo.pageObject.LoginPage;
import com.medo.utilities.ReadExcel;

public class TC_AddNewCustomer_001 extends BaseClass {
	
	
	
	@Test(dataProvider = "cusdata")

	public void test3(String username, String password, String cusname, String cusgender, String cusdob, String cusaddr,
			String cuscity, String cusstate, String cuspin, String cusmobileno, String cusemail, String cuspwd)
			throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		AddCustomer cus = new AddCustomer(driver);
		cus.NewCustomerlink();
		cus.setcusName(cusname);
		logger.info("user name provided");
		cus.setcusgender(cusgender);
		cus.setcusdob(cusdob);
		cus.setcusaddr(cusaddr);
		cus.setcuscity(cuscity);
		cus.setcusstate(cusstate);
		cus.setcuspin(cuspin);
		cus.setcusmobile(cusmobileno);
		cus.setcusemail(cusemail);
		cus.setcuspwd(cuspwd);

		logger.info("password provided");
		cus.submit();

		Thread.sleep(3000);

		/*
		 * if (isAlertPresent() == true) { driver.switchTo().alert().accept();//
		 * close alert driver.switchTo().defaultContent();
		 * Assert.assertTrue(false); logger.warn("Login failed"); } else {
		 * Assert.assertTrue(true); logger.info("Login passed"); //
		 * lp.logoutlink(); Thread.sleep(3000);
		 * driver.switchTo().alert().accept();// close logout alert
		 * driver.switchTo().defaultContent(); }
		 */
	}
	/*
	 * public boolean isAlertPresent() // user defined method created to check
	 * // alert is present or not { try { driver.switchTo().alert(); return
	 * true; } catch (NoAlertPresentException e) { return false; }
	 */

	
	@DataProvider(name = "cusdata")
	public Object[][] getData2() {
		String excelpath = "C:\\Users\\Bhakti\\workspace\\Medoplus_Demo1\\src\\test\\java\\com\\medo\\testdata\\Excel.xlsx";

		Object data[][] = testData(excelpath, "Sheet2");
		return data;
	}

	public Object[][] testData(String excelpath, String sheetname) {
		ReadExcel excel = new ReadExcel(excelpath, sheetname);

		int rowcount = excel.getRowCount();
		int colcount = excel.getColCount();

		Object data[][] = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++)

		{
			for (int j = 0; j < colcount; j++) {
				String celldata = excel.getCellDataString(i, j);
				// System.out.println(celldata);
				data[i - 1][j] = celldata;

			}

		}
		return data;
	}

	
	

}
