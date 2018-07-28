package com.selenium.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.DriverUtils;

public class testLocate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("broswer.type", "chrome");
		WebDriver driver = DriverUtils.getDriver();
		driver.get("http:\\www.baidu.com");
		//driver.findElement(By.id("kw")).sendKeys("selenium");
		driver.findElement(By.name("wd")).sendKeys("selenuim");
		Thread.sleep(1000);
		driver.quit();
	}

}
