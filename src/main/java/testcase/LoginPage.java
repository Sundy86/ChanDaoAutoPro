package testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utils.PropertiesUtils;
import utils.ThreadUtils;

public class LoginPage {

	WebDriver driver;
	private  Logger logger = Logger.getLogger(LoginPage.class);
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(java.lang.String account,java.lang.String password){
		driver.findElement(By.xpath(PropertiesUtils.getPropertyStr("account_XPATH"))).sendKeys(account);
		driver.findElement(By.xpath(PropertiesUtils.getPropertyStr("password_XPATH"))).sendKeys(password);
		driver.findElement(By.xpath(PropertiesUtils.getPropertyStr("submitBtn_XPATH"))).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void loginOut(){
		logger.info("退出当前用户");
		driver.findElement(By.xpath(PropertiesUtils.getPropertyStr("logout_XPATH"))).click();
		ThreadUtils.ThreadSleep(2);
	}
}
