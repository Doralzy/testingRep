package com.utils;

import org.openqa.selenium.WebDriver;

public class testBaidu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("broswer.type", "chrome");
		WebDriver driver = DriverUtils.getDriver();
		driver.get("http:\\www.baidu.com");
		driver.quit();	
	}

}
