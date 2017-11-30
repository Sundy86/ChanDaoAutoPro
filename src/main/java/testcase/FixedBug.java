package testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MyAction;
import utils.MyAssert;
import utils.ScreenshotTakes;
import utils.ThreadUtils;

public class FixedBug {
	WebDriver driver;
	MyAction myAction;
	private  Logger logger = Logger.getLogger(FixedBug.class);
	public FixedBug(WebDriver driver) {
		this.driver = driver;
		myAction = new MyAction(driver);
	}
	public void fixbug(String bugCode,String versionName){
		logger.info("解决bug");
		//点击解决图标
		driver.findElement(By.xpath("//td[@class='text-right']/a[contains(@title,'解决')]")).click();
		ThreadUtils.ThreadSleep(3);
		myAction.switchToFrame("modalIframe");
		//解决方案
		driver.findElement(By.xpath("//select[@id='resolution']/option[@value='fixed']")).click();
		//解决版本
		driver.findElement(By.xpath("//div[@id='resolvedBuild_chosen']")).click();
		driver.findElement(By.xpath("//div[@id='resolvedBuild_chosen']//ul[@class='chosen-results']/li[text()='"+versionName+"']")).click();

		ThreadUtils.ThreadSleep(1);
		WebElement remarkFrame=driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe']"));
		//切换iframe
		myAction.switchToFrame(remarkFrame);
		//输入备注
		WebElement remark = driver.findElement(By.xpath("//body[@class='article-content']"));
		myAction.actionSendKeys(remark, "已解决,指派给admin");
		ThreadUtils.ThreadSleep(1);
		myAction.switchToDefault();

		//重新定位modalIframe
		myAction.switchToFrame("modalIframe");
		//点击保存
		driver.findElement(By.xpath("//form[@class='form-condensed']//button[@id='submit' and contains(text(),'保存')]")).click();
		ThreadUtils.ThreadSleep(2);
		//跳出iFrame
		myAction.switchToDefault();
		ScreenshotTakes.screenShot(driver);
		String status = driver.findElement(By.xpath("//tr[@class='text-center']/td[@class='bug-resolved']")).getText();
		MyAssert assertBug = new MyAssert();
		assertBug.assertEquals("已解决", status,"检查当前bug的状态是否为已解决:");
	}
}
