package testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ThreadUtils;


public class HomePage {
	WebDriver driver;
	private  Logger logger = Logger.getLogger(HomePage.class);
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterHome(String productName){
		logger.info("进入禅道主页面");
		//点击测试菜单
		driver.findElement(By.xpath("//a[@id='menuqa']")).click();
		//点击测试菜单的子菜单---bug
		driver.findElement(By.xpath("//a[@id='submenubug']")).click();
		ThreadUtils.ThreadSleep(2);

		//切换当前所属项目
		driver.findElement(By.xpath("//a[@id='currentItem']/span")).click();
		ThreadUtils.ThreadSleep(2);
		driver.findElement(By.xpath("//div[@id='defaultMenu']//li/a[contains(text(),'"+productName+"')]/i")).click();

	}

	public void backToList(){
		//点击测试菜单的子菜单---bug
		logger.info("返回bug 列表");
		driver.findElement(By.xpath("//a[@id='submenubug']")).click();
		ThreadUtils.ThreadSleep(2);
	}
}
