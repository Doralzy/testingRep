package com.selenium.day02;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaiduChromeService {
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort()
				.usingDriverExecutable(new File("C:/driver/chromedriver.exe")).build();//驱动
		service.start();
		/*若改变chrome默认存储路径
		 * ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");*/
		WebDriver driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		driver.get("http:\\www.baidu.com");
		Thread.sleep(1000);
		driver.quit();
		driver=new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		driver.get("http:www.51testing.com");
		service.stop();
		
	}
}
