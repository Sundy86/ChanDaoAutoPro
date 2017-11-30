package basecase;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.NumRandom;
import utils.ThreadUtils;

public class CreatProject {
	WebDriver driver;
	JavascriptExecutor jsExecutor  ;
	private  Logger logger = Logger.getLogger(CreatProject.class);
	public CreatProject(RemoteWebDriver driver,JavascriptExecutor jsExecutor) throws InterruptedException, IOException {
		this.driver = driver;
		this.jsExecutor=jsExecutor;
	}

	public String addProject(String productName){
		//点击项目菜单
		driver.findElement(By.xpath("//a[@id='menuproject']")).click();
		ThreadUtils.ThreadSleep(1);
		//点击  添加项目按钮
		driver.findElement(By.xpath("//a[@id='submenucreate']")).click();
		ThreadUtils.ThreadSleep(1);
		//添加项目名称

		String projectName="Prject1"+NumRandom.random();
		driver.findElement(By.xpath("//form[@class='form-condensed']//input[@id='name']")).sendKeys(projectName);
		//添加项目代码
		driver.findElement(By.xpath("//form[@class='form-condensed']//input[@id='code']")).sendKeys("Prjectcode1"+NumRandom.random());
		//选择结止日期 一年
		driver.findElement(By.xpath("//label[@class='radio-inline']//input[@id='delta365']")).click();
		ThreadUtils.ThreadSleep(1);
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		ThreadUtils.ThreadSleep(2);
		logger.info("添加项目成功，项目名称为："+projectName);
		driver.findElement(By.xpath("//a[text()='返回项目首页']")).click();
		ThreadUtils.ThreadSleep(1);

		//点击二级菜单产品
		driver.findElement(By.xpath("//a[@id='submenuproduct']")).click();
		ThreadUtils.ThreadSleep(1);
		//关联产品
		driver.findElement(By.xpath("//div[@id='productsBox']/label[contains(text(),'"+productName+"')]/input")).click();
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		ThreadUtils.ThreadSleep(1);
		return projectName;
	}


}
