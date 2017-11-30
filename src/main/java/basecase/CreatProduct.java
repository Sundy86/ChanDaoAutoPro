package basecase;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.NumRandom;
import utils.ThreadUtils;

public class CreatProduct {

	WebDriver driver;
	JavascriptExecutor jsExecutor;
	private  Logger logger = Logger.getLogger(CreatProduct.class);
	public CreatProduct(RemoteWebDriver driver,JavascriptExecutor jsExecutor ) throws InterruptedException, IOException
	{
		this.driver = driver;
		this.jsExecutor = jsExecutor;
	}

	public String addPro(){
		//点击产品菜单
		driver.findElement(By.xpath("//a[@id='menuproduct']")).click();
		ThreadUtils.ThreadSleep(1);
		//点击  添加产品按钮
		driver.findElement(By.xpath("//a[@id='submenucreate']")).click();
		ThreadUtils.ThreadSleep(1);
		//添加产品名称
		String productName="Product2"+NumRandom.random();
		driver.findElement(By.xpath("//form[@class='form-condensed']//input[@id='name']")).sendKeys(productName);
		//添加产品代码
		driver.findElement(By.xpath("//form[@class='form-condensed']//input[@id='code']")).sendKeys("Productcode2"+NumRandom.random());
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		ThreadUtils.ThreadSleep(2);
		logger.info("添加产品成功，产品名称为："+productName);
		return productName;
	}
}
