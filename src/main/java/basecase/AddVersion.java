package basecase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ThreadUtils;

public class AddVersion {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	private  Logger logger = Logger.getLogger(CreatProject.class);
	public AddVersion(RemoteWebDriver driver,JavascriptExecutor jsExecutor) throws InterruptedException, IOException {
		this.driver = driver;
		this.jsExecutor=jsExecutor;
	}

	public String addVersion(){
		//点击项目的二级菜单版本
		driver.findElement(By.xpath("//a[@id='submenubuild']")).click();
		ThreadUtils.ThreadSleep(1);
		driver.findElement(By.xpath("//a[contains(text(),'创建版本')]")).click();
		String versionName="V1.0.0";
		driver.findElement(By.xpath("//form[@class='form-condensed']//input[@id='name']")).sendKeys(versionName);
		//点击保存
		jsExecutor.executeScript("arguments[0].click();",driver.findElement(By.id("submit")));
		ThreadUtils.ThreadSleep(1);
		logger.info("添加版本成功，版本名称为："+versionName);
		return versionName;
	}
}
