package testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MyAction;
import utils.MyAssert;
import utils.ScreenshotTakes;
import utils.ThreadUtils;

public class CloseBug {
	WebDriver driver;
	MyAction myAction;
	private  Logger logger = Logger.getLogger(CloseBug.class);
	public CloseBug(WebDriver driver) {
		this.driver = driver;
		myAction = new MyAction(driver);
	}

	public void closeBug(){
		logger.info("关闭bug");
		ThreadUtils.ThreadSleep(5);
		driver.findElement(By.xpath("//td[@class='text-right']/a[contains(@title,'关闭')]")).click();
		ThreadUtils.ThreadSleep(5);
		//切换到关闭bug的主iframe
		myAction.switchToFrame("modalIframe");
		//切换到备注iframe
		WebElement remarkFrame=driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
		myAction.switchToFrame(remarkFrame);
		//输入备注
		WebElement remark = driver.findElement(By.xpath("//body[@class='article-content']"));
		myAction.actionSendKeys(remark, "当前已解决，admin关闭bug");
		ThreadUtils.ThreadSleep(1);
		myAction.switchToDefault();

		//重新定位modalIframe
		myAction.switchToFrame("modalIframe");
		//点击保存
		driver.findElement(By.xpath("//form[@class='form-condensed']//button[@id='submit' and contains(text(),'保存')]")).click();
		ThreadUtils.ThreadSleep(2);
		myAction.switchToDefault();
		ScreenshotTakes.screenShot(driver);
		String status = driver.findElement(By.xpath("//tr[@class='text-center']/td[@class='bug-closed']")).getText();
		MyAssert assertBug = new MyAssert();
		assertBug.assertEquals("已关闭", status,"检查当前bug的状态是否为已关闭:");

	}
}
