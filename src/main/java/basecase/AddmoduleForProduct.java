package basecase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.NumRandom;
import utils.ThreadUtils;

public class AddmoduleForProduct {
	WebDriver driver;
	JavascriptExecutor jsExecutor  ;
	private  Logger logger = Logger.getLogger(CreatProject.class);
	public AddmoduleForProduct(RemoteWebDriver driver,JavascriptExecutor jsExecutor) throws InterruptedException, IOException {
		this.driver = driver;
		this.jsExecutor=jsExecutor;
	}

	public String  addModule(String productName){
		//点击产品菜单
		driver.findElement(By.xpath("//a[@id='menuproduct']")).click();
		ThreadUtils.ThreadSleep(1);
		//切换当前所属产品
		driver.findElement(By.xpath("//a[@id='currentItem']/span")).click();
		ThreadUtils.ThreadSleep(2);
		driver.findElement(By.xpath("//div[@id='defaultMenu']//li/a[contains(text(),'"+productName+"')]/i")).click();
		ThreadUtils.ThreadSleep(2);
		driver.findElement(By.xpath("//a[@id='submenumodule']")).click();
		String moduleName="module"+NumRandom.random();
		driver.findElement(By.xpath("(//div[@id='sonModule']/span/input)[1]")).sendKeys(moduleName);
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='submit' and text()='保存']")));
		logger.info("成功新增模块"+moduleName);
		ThreadUtils.ThreadSleep(2);
		return moduleName;
	}

}
