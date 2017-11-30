package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;

public class BrowserEmulator {
    WebDriver driver;
	JavascriptExecutor javaScriptExecutor;
	public static Logger logger = Logger.getLogger(BrowserEmulator.class);

	public BrowserEmulator() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", GlobalSettings.chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);
		String threadName = String.valueOf(Thread.currentThread().getId());
 		logger.info("Using Chrome");
		driver.get(GlobalSettings.zentaoUrl);
		logger.info("current url:"+driver.getCurrentUrl());
		driver.manage().window().maximize();
		javaScriptExecutor = (JavascriptExecutor) driver;
	}


	public  WebDriver getDriver() {
		return driver;
	}
 	public JavascriptExecutor getJavaScriptExecutor() {
		return javaScriptExecutor;
	}

	public void quit() throws InterruptedException{
		driver.close();
		logger.info("Quitted BrowserEmulator");
	}	

}
