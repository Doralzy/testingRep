package com.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class DriverUtils {
	public static String broswer = null;
	public static DriverService service;
	static {
		broswer = System.getProperty("broswer.type","firefox");
		if("firefox".equalsIgnoreCase(broswer)) {
			 service = new GeckoDriverService.Builder().usingFirefoxBinary(
					new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))
					.usingDriverExecutable(new File("C:/driver/geckodriver.exe")).usingAnyFreePort().build();
		}else if("chrome".equalsIgnoreCase(broswer)) {
			 service = new ChromeDriverService.Builder().usingAnyFreePort()
					.usingDriverExecutable(new File("C:/driver/chromedriver.exe")).build();
		}else if("ie".equalsIgnoreCase(broswer)) {
			 service = new InternetExplorerDriverService.Builder().usingAnyFreePort()
					.usingDriverExecutable(new File("C:/driver/IEDriverServer.exe")).build();
		}else {
			throw new RuntimeException("设置浏览器有误");
		}
		try {
			service.start();//service 三个要是一样的，不然找补到，并且要在静态里声明以下
		                	//DriverService是ChromeDriverServic，firefoxservice（GeckoDriverService）的父类
			                //同理driver也是一样的
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() { 
		WebDriver driver =null;
		if("firefox".equalsIgnoreCase(broswer)) {
			driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.firefox());
		}else if("chrome".equalsIgnoreCase(broswer)) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		}else if("ie".equalsIgnoreCase(broswer)) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.internetExplorer());
		}
		return driver;
	}	
	
	public static void stopservice() {
		service.stop();
	}
}
