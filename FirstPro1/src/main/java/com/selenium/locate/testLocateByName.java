package com.selenium.locate;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.DriverUtils;

public class testLocateByName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("broswer.type", "chrome");
		WebDriver driver = DriverUtils.getDriver();
		driver.get("http://localhost:8010/demo/survey/cybbbk/qdjcqk.htm");
		//driver.findElement(By.id("kw")).sendKeys("selenium");
		//driver.findElements(By.name("wd")).sendKeys("selenuim");
		List<WebElement> radios = driver.findElements(By.name("vcFf"));
		radios.get(1).click();
//		for(WebElement el:radios) {
//			el.click();
//			Thread.sleep(2000);
//		}
		for(int i=0;i<radios.size();i++) {
//			System.out.println(i+"个:"+radios.get(i).isSelected());
			WebElement element = radios.get(i);
			if (element.isSelected()) {
				System.out.println(element.getAttribute("value"));
			}
			
			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
