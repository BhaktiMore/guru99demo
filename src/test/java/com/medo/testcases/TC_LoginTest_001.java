package com.medo.testcases;

//import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.medo.pageObject.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void logintest() {

		driver.get(baseURl);
		logger.info("URL is opened");
		LoginPage log = new LoginPage(driver);

		log.setUserName(username);
		logger.info("enter username");

		log.setPassword(password);
		logger.info("enter password");

		log.clickSubmit();
		logger.info("click login");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login successful");
		}

		else {
			Assert.assertTrue(false);
			logger.info("login failed");

		}
	}

}
