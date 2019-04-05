package com.medo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()

	{
		File src = new File("./Configuration/Config.properties");

		try {
			FileInputStream fls = new FileInputStream(src);
			pro = new Properties();
			pro.load(fls);

		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	// These method returns all values to the Base class
	public String getApplicationURL() {
		String URL = pro.getProperty("baseURL");
		return URL;
	}

	public String getUsername() {
		String USERNAME = pro.getProperty("username");
		return USERNAME;
	}

	public String getPassword() {
		String PASSWORD = pro.getProperty("password");
		return PASSWORD;

	}

	public String getChromepath() {
		String ChromePath = pro.getProperty("chromepath");
		return ChromePath;
	}

	public String getiepath() {
		String IEpath = pro.getProperty("iepath");
		return IEpath;
	}

}
