package testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ThreadUtils;

public class SearchBug {
	WebDriver driver;
	private  Logger logger = Logger.getLogger(SearchBug.class);
	public SearchBug(WebDriver driver) {
		this.driver = driver;
	}
	public void searchToBugSingle(String bugCode){
		logger.info("搜索bug，进入到bug页面");
		driver.findElement(By.xpath("//input[@id='searchQuery']")).sendKeys(bugCode);
		driver.findElement(By.xpath("//div[@id='objectSwitcher']/a")).click();
		ThreadUtils.ThreadSleep(2);
	}


	public void searchToBugList(String bugCode){
		logger.info("搜索bug,搜索完成后返回buglist");
		driver.findElement(By.xpath("//div[@id='featurebar']//li/a[contains(text(),'搜索')]")).click();
		driver.findElement(By.xpath("//select[@id='field1']")).click();
		driver.findElement(By.xpath("//select[@id='field1']/option[@value='id']")).click();
		ThreadUtils.ThreadSleep(1);
		driver.findElement(By.xpath("//td[@id='valueBox1']/input")).sendKeys(bugCode);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}
}
