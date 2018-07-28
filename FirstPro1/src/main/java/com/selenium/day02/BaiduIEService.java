package com.selenium.day02;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaiduIEService {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder().usingAnyFreePort()
				.usingDriverExecutable(new File("C:/driver/IEDriverServer.exe")).build();//驱动
		service.start();
		/*chrome地址不是默认存储路径
		 * ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");*/
		WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.internetExplorer());
		driver.get("http:\\www.baidu.com");
		driver.quit();
		driver=new RemoteWebDriver(service.getUrl(),DesiredCapabilities.internetExplorer());
		driver.get("http:www.51testing.com");
		service.stop();
	}

}
