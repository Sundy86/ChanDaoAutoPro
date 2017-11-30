package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyAction {
	 WebDriver driver;
	 Actions action ;
	public MyAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void switchToFrame(WebElement frameName){
		driver.switchTo().frame(frameName);
	}
	public  void switchToFrame(String  frameId){
		driver.switchTo().frame(frameId);
	}
	
	public  void actionSendKeys(WebElement step,String str){
		 action = new Actions(driver);
		 action.sendKeys(step, str).perform();
		 ThreadUtils.ThreadSleep(1);
	}
	public  void switchToDefault(){
		driver.switchTo().defaultContent();
	}
	
}
