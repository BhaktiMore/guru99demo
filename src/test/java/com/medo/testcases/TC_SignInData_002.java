package com.medo.testcases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medo.pageObject.LoginPage;
import com.medo.utilities.ReadExcel;

public class TC_SignInData_002 extends BaseClass {

	@Test(dataProvider = "testdata1")
	public void test1(String username, String password) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.logoutlink();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() // user defined method created to check
									// alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "testdata1")
	public Object[][] getData() {
		String excelpath = "C:\\Users\\Bhakti\\workspace\\Medoplus_Demo1\\src\\test\\java\\com\\medo\\testdata\\Excel.xlsx";

		Object data[][] = testData(excelpath, "Sheet1");
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