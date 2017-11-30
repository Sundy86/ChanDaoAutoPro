package basecase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ThreadUtils;

public class ProjectRelationUser {
	WebDriver driver;
	JavascriptExecutor jsExecutor  ;
	private  Logger logger = Logger.getLogger(CreatProject.class);
	public ProjectRelationUser(RemoteWebDriver driver,JavascriptExecutor jsExecutor) throws InterruptedException, IOException {
		this.driver = driver;
		this.jsExecutor=jsExecutor;
	}

	public void relationUser(String account,String projectName){
		//点击项目菜单
		driver.findElement(By.xpath("//a[@id='menuproject']")).click();
		ThreadUtils.ThreadSleep(1);

		//点击  团队菜单
		driver.findElement(By.xpath("//a[@id='submenuteam']")).click();
		ThreadUtils.ThreadSleep(1);
		//点击团队管理
		driver.findElement(By.xpath("//a[contains(text(),'团队管理')]")).click();
		//选择用户
		driver.findElement(By.xpath("//div[@id='accounts1_chosen']")).click();
		driver.findElement(By.xpath("//div[@id='accounts1_chosen']//ul[@class='chosen-results']/li[contains(text(),'"+account+"')]")).click();
		//点击保存
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
		logger.info("项目关联用户成功");
		ThreadUtils.ThreadSleep(1);
	}

}
