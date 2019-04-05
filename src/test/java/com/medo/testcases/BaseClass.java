package com.medo.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.medo.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	public String baseURl = rc.getApplicationURL();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//Driver//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
//driver.quit();
	}

}
