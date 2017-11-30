package basecase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.NumRandom;
import utils.ThreadUtils;

public class AddUserandPower {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	private  Logger logger = Logger.getLogger(CreatProject.class);
	public AddUserandPower(RemoteWebDriver driver,JavascriptExecutor jsExecutor) throws InterruptedException, IOException {
		this.driver = driver;
		this.jsExecutor=jsExecutor;
	}

	public String addUser(){
		//点击组织菜单
		driver.findElement(By.xpath("//a[@id='menucompany']")).click();
		//点击用户
		driver.findElement(By.xpath("//a[@id='submenubrowseUser']")).click();
		ThreadUtils.ThreadSleep(1);
		//点击  添加用户按钮
		driver.findElement(By.xpath("//a[@id='submenuaddUser']")).click();
		ThreadUtils.ThreadSleep(1);
		String account="user"+NumRandom.random();
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys(account);
		driver.findElement(By.xpath("//input[@id='realname']")).sendKeys(account);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("123456");
		driver.findElement(By.xpath("//select[@id='role']/option[text()='项目经理']")).click();
		driver.findElement(By.xpath("//input[@id='verifyPassword']")).sendKeys("123456");
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		logger.info("新增用户及权限关联成功,账号为："+account);
		ThreadUtils.ThreadSleep(1);
		return account;
	}
}
