package testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MyAction;
import utils.ScreenshotTakes;
import utils.ThreadUtils;

public class AssignBug {
	WebDriver driver;
	MyAction myAction;
	public static Logger logger = Logger.getLogger(AssignBug.class);
	public AssignBug(WebDriver driver) {
		this.driver = driver;
		myAction = new MyAction(driver);
	}
	public void assign(String account){
		//点击指派按钮
		driver.findElement(By.xpath("//div[@class='main']//a[contains(text(),'指派')]")).click();
		ThreadUtils.ThreadSleep(2);
		myAction.switchToFrame("modalIframe");

		//点击指派给下拉拉框
		driver.findElement(By.xpath("//div[@id='assignedTo_chosen']/a/span")).click();
		driver.findElement(By.xpath("//div[@id='assignedTo_chosen']//ul[@class='chosen-results']/li[contains(text(),'"+account+"')]")).click();
		//点击抄送给下拉拉框
		driver.findElement(By.xpath("//div[@id='mailto_chosen']//input")).click();
		driver.findElement(By.xpath("//div[@id='mailto_chosen']//ul[@class='chosen-results']/li[text()='A:admin']")).click();


		WebElement remarkFrame=driver.findElement(By.xpath("//iframe[@class='ke-edit-iframe'][last()]"));
		//切换iframe
		myAction.switchToFrame(remarkFrame);
		//输入备注
		WebElement remark = driver.findElement(By.xpath("//body[@class='article-content']"));
		myAction.actionSendKeys(remark, "指派给"+account+",抄送给admin");
		ThreadUtils.ThreadSleep(1);
		myAction.switchToDefault();

		//重新定位modalIframe
		myAction.switchToFrame("modalIframe");
		//点击保存
		driver.findElement(By.xpath("//form[@class='form-condensed']//button[@id='submit']")).click();
		ThreadUtils.ThreadSleep(2);
		//跳出iFrame
		myAction.switchToDefault();
		ScreenshotTakes.screenShot(driver);

	}
}
